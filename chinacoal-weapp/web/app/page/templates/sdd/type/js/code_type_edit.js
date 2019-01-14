define(['jquery','widget/dialog', 'widget/ajax_form', '../../service', 'service/util_service', 'route_config','bootbox','./type_edit'], function($,dialog, ajax_form, service, util_service, route_config,bootbox,type_edit)  {
	var page = {

        /**
         * 模块参数
         */
        params: {
              /**
             * 模块参数
             */
            deferred: null,
            $fm: null,
            pageType: 'add', //默认新增
            id:null
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.params.deferred = $.Deferred();
                //获取页面传输参数
            var stateParams = route_config.getStateParams();
            this.params.pageType = route_config.getStateParams()['pageType'];
            this.params.id = route_config.getStateParams()['id'];
            var This=this;
            this.params.deferred.done(function()  { 
                    This.params.$fm = $('#form-codetype');
                    This.initAjaxEdit();
                    This.bindEvent();
                    //如果是查看页面，则readonly所有输入与域
                    $(".form_date").datetimepicker({
                        //language:  'fr',
                        format: 'yyyy-mm-dd',
                        language:  'fr',
                        weekStart: 1,
                        todayBtn:  1,
                        autoclose: 1,
                        todayHighlight: 1,
                        startView: 2,
                        minView: 2,
                        forceParse: 0
                    });
                });
                if (this.params.pageType != 'add'&& this.params.pageType != undefined) { //如果此页面不是新增，则请求服务端数据
                    var id = route_config.getStateParams()['id'];
                    service.find_code_type(id, $.proxy(this.render, this)); 
                } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
                    this.render(null, true);
                }
            },
        /**
         * 事件绑定
         */
        bindEvent:function() {
        	util_service._closeDialog($('#btn-close-userrole'), true); //绑定关闭按钮
        },
        ajaxSuccess:function() {
            dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    type_edit.refreshTable();
                    page.params.$fm.find('button.btn-close').trigger('click');
                    /*customer_list && customer_list.search();*/
                }
            });
        },
        /**
        * 模板渲染
        */
        render:function(data, flag){
            if (!data && !flag)
                    return;
            if (flag) {
                var myTemplate = $.templates("#codeTypeFormTmpl");
                myTemplate.link("#code-type-edit",{codeType:{id:this.params.id}});
            }
            else{
                var myTemplate = $.templates("#codeTypeFormTmpl");
                myTemplate.link("#code-type-edit",{codeType:data});
           
            }
            this.params.deferred.resolve('ok');
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                code :"required",
            }
            let messages={
                code :"请输入代码",
            }
            ajax_form.init({
                $form: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' ? 'add_code_type' : 'upd_code_type',
                messages:messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});