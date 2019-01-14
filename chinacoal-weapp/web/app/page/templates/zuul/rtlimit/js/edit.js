define(['jquery', 'widget/dialog', 'widget/ajax_form', '../../service', 'service/util_service', 'route_config', 'bootbox'], function ($, dialog, ajax_form, service, util_service, route_config, bootbox) {
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
            dataModel: null //数据表格引用
             
        },

        /**
         * 模块入口
         */
        initPage:function() {
            var _this = this;

            this.params.deferred = $.Deferred();
            //获取页面传输参数
            var stateParams = route_config.getStateParams();
            this.params.pageType = route_config.getStateParams()['pageType'];

            this.params.deferred.done(function () {
                _this.initAjaxEdit();
                _this.bindEvent();
                _this.params.$fm = $('#form');
                //如果是查看页面，则readonly所有输入与域
                if (_this.params.pageType == 'view') {
                    util_service._readonlyInput(_this.params.$fm);
                } else {
                    $('#btn-submit').show();
                }
                $(".form_date").datetimepicker({
                    //language:  'fr',
                    format: 'yyyy-mm-dd',
                    language: 'fr',
                    weekStart: 1,
                    todayBtn: 1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    minView: 2,
                    forceParse: 0
                });
            });
            if (this.params.pageType != 'add' && this.params.pageType != undefined) {
                //如果此页面不是新增，则请求服务端数据
                var id = route_config.getStateParams()['id'];
                service.select_limit(id, $.proxy(this.render, this));
            } else {
                //如果页面是新增，则不请求服务端数据，立即执行延迟加载
                this.render(null, true);
                this.params.deferred.resolve('ok');
            }
        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
            // 绑定关闭按钮
            $("#btn-close").on('click',function(e){
                parent.jy_menu(2);
            });
        },
        ajaxSuccess:function() {
            dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
                  //   page.params.table_data._showPage(0);
                    /*customer_list && customer_list.search();*/
                }
            });
        },

        /**
        * 模板渲染
        */
        render:function(data, flag) {
            if (!data && !flag) return;
            if (flag) {
                var myTemplate = $.templates("#rtFormTmpl");
                myTemplate.link("#rt-edit", {rt:{timeUnit:1,type:1}});
            } else {
                var myTemplate = $.templates("#rtFormTmpl");
                myTemplate.link("#rt-edit", { rt: data });
            }
            this.params.deferred.resolve('ok');
        },

        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {

     var tp=$('#type0 option:selected').val();    
            var mySelect=$("#timeUnit option");
            mySelect.each(function (i,el) {
                if(tp==1){
                     if($(el).val()==tp){
                             $(this).show();
                            this.selected=true;
                       }
                       else {
                           $(this).hide();
                       }
                }else{
                    if($(el).val()==tp){
                        $(this).show();
                        this.selected=true;
                        }else if($(el).val()>tp){
                              $(this).show();
                        }
                        else{
                            $(this).hide();
                        }
                 }
            });


            $("#type0").change(function(){
            var tp=$('#type0 option:selected').val();    
                var mySelect=$("#timeUnit option");
                mySelect.each(function (i,el) {
                    if(tp==1){
                        if($(el).val()==tp){
                            $(this).show();
                            this.selected=true;
                        }else{
                            $(this).hide();
                        }
                   }
                   else if(tp==2){
                    if($(el).val()==tp){
                        $(this).show();
                        this.selected=true;
                        }else if($(el).val()>tp){
                              $(this).show();
                        }
                        else{
                            $(this).hide();
                        }
                   }
                });
            });

            var rules = {
                method: "required",
                type: "required",
                limits: "required",
                timeUnit: "required",
                name: "required"
            };
            var messages = {
                method: "请输入方案",
                type: "请选择类型",
                limits: "请输入次数",
                timeUnit: "请选择单位时间",
                name: "请输入名称"
            };

           ajax_form.init({
                $fm: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType == undefined ? 'create_limit1' : 'create_limit1',
                messages: messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });

        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});