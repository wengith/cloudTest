define(['jquery','widget/dialog', 'widget/ajax_form','widget/http','../../service', 'service/util_service', 'route_config','bootbox','widget/ajax_table'], function($,dialog, ajax_form,http,service, util_service,route_config,bootbox,ajax_table)  {
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
            dataModel: null,
            fmObject:null,
            ajax_table: null
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.params.deferred = $.Deferred();
                //获取页面传输参数
            var stateParams = route_config.getStateParams();
            this.params.pageType = route_config.getStateParams()['pageType'];
            var This=this;
            this.params.deferred.done(function()  { 
                This.params.$fm = $('#form');
                This.initAjaxEdit();
                This.bindEvent();
                //如果是查看页面，则readonly所有输入与域
                if (This.params.pageType == 'view') {
                    util_service._readonlyInput(This.params.$fm);
                } else { 
                    $('#btn-submit').show();
                }
            });
            if (this.params.pageType != 'add'&& this.params.pageType != undefined) { //如果此页面不是新增，则请求服务端数据
                var id = route_config.getStateParams()['id'];
                service.select_quartz(id, $.proxy(this.render, this)); 
            } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
                this.render(null, true);
                this.params.deferred.resolve('ok');
            }
        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
            util_service._closeDialog($('#btn-close'), true); //绑定关闭按钮
        },
        /**
        * 模板渲染
        */
        render:function(data, flag){
            if (!data && !flag)
                    return;
            if (flag) {
                var myTemplate = $.templates("#quartzFormTmpl");
                myTemplate.link("#quartz-edit",{quartz:{},pageType:this.params.pageType});
                myTemplate.link("#quartz-edit", {quartz:{conCurrent:1,validStatus:1,userCode:localStorage.getItem("username")}});
                $("#userCode").attr("readOnly","true");
                this.params.deferred.resolve('ok');
            }
            else{
                var myTemplate = $.templates("#quartzFormTmpl");
                myTemplate.link("#quartz-edit",{quartz: data,pageType:this.params.pageType});
                this.params.deferred.resolve('ok');
            }
        },
        rowCallback:function(row, data, displayIndex, displayIndexFull) {
            
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                jobCode :"required",
                targetObject : "required",
                targetMethod:"required",
                conCurrent:"required",
                validStatus:"required",
                jobDescription:"required"
            }
            let messages={
                jobCode :"请输入作业代码",
                targetObject : "请输入目标对象",
                targetMethod:"目标方法",
                conCurrent:"请选择是否同步",
                validStatus:"请选择效力状态",
                jobDescription:"请填写作业描述"
            }
            fmObject = ajax_form.init({
                $form: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'create_quartz' : 'update_quartz',
                messages:messages,
                beforeSubmit:$.proxy(this.beforeSubmit, this),
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        },
        beforeSubmit:function() {

        },
        ajaxSuccess:function(data) {
            if(data.data==null){
                 dialog.confirm({
                content: '提交失败，请检查作业代码是否重复',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
                    /*customer_list && customer_list.search();*/
                }
            });
            }else{
                 dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
                    /*customer_list && customer_list.search();*/
                }
            });
            }
        },
        ajaxTable:function(){
            var factorCode = $("#factorCode").val();
            http.get({
                apiName:'saa_factor_field_List',
                urlParams: {factorCode:factorCode},
                success:function(data) {
                    var table = $("#list-table");
                    page.params.ajax_table = ajax_table._showTable(table,data.data,page.columns,page.rowCallback);
                    //page.bindEvent();
                }
            });
        }   
    };

    return {
        refreshTable:$.proxy(page.ajaxTable, page),
        initPage: $.proxy(page.initPage, page)
    };
});