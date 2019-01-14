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
            pageType: '', //默认新增
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
                }else {
					if(_this.params.pageType == 'update'){
						$('#templateCode').attr("readOnly",true);
					}
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
                var id = route_config.getStateParams()['templateCode'];
                service.select_template(id, $.proxy(this.render, this));
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
            util_service._closeDialog($('#btn-close'), true); //绑定关闭按钮
        },
        ajaxSuccess:function() {
            dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
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
                var myTemplate = $.templates("#templateFormTmpl");
                 myTemplate.link("#main-content", {smsTemplate:{version:""}});
            } else {
                var myTemplate = $.templates("#templateFormTmpl");
                myTemplate.link("#template-edit", { smsTemplate: data });
            }
            this.params.deferred.resolve('ok');
        },

        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            var rules = {
				comCode: "required",
				sysCode: "required",
                theme: "required",
                templateCode: "required",
                templateContent: "required"
            };
            var messages = {
				comCode: "请输入公司名称",
				sysCode: "请输入系统名称",
                theme: "请输入模板主题",
                templateCode: "请输入调用ID",
                templateContent: "输入模板内容"
            };
            ajax_form.init({
                $fm: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' ? 'create_template' : 'update_template',
                messages: messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});