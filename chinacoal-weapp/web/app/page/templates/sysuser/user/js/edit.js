define(['jquery','widget/dialog', 'widget/ajax_form', '../../service', 'service/util_service', 'route_config','bootbox'], function($,dialog, ajax_form, service, util_service, route_config,bootbox)  {
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
            var params = route_config.getParams();//route_config中获取id中参数的方法
            this.params.deferred = $.Deferred();
            //获取页面传输参数
            //var stateParams = top.getStateParamsLocal();
            this.params.pageType = params['pageType'];
            //this.params.pageType = top.getStateParamsLocal()['pageType'];
            this.params.deferred.done(function()  { 
                page.initAjaxEdit();
                page.bindEvent();
                page.params.$fm = $('#form');
                //如果是查看页面，则readonly所有输入与域
                if (page.params.pageType == 'view') {
                    util_service._readonlyInput(page.params.$fm);
                } else { 
                    $('#btn-submit').show();
                }
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
            if (page.params.pageType != 'add'&& page.params.pageType != undefined) { //如果此页面不是新增，则请求服务端数据
                var id = params['id'];
                service.select_user(id, $.proxy(page.render, page)); 
            } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
                page.render(null, true);
                page.params.deferred.resolve('ok');
            }
        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
            //绑定关闭按钮
            $("#btn-close").on('click',function(e){
                parent.jy_menu(2);
            });
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
        render:function(data, flag){
            if (!data && !flag)
                    return;
            if (flag) {
                var myTemplate = $.templates("#queryFormTmpl");
                myTemplate.link("#main-content",{user:{userCode:""}});
            }
            else{
                var myTemplate = $.templates("#queryFormTmpl");
                myTemplate.link("#user-edit",{ user: data});
           
            }
            this.params.deferred.resolve('ok');
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                //需要多种校验时使用
                userCode :{
                    required:true,
                    maxlength:10
                },
                userName : {
                    required:true,
                    minlength:5
                },
                password:{
                    required:true,
                    minlength:5
                },
                email:{
                    required:true,
                    checkEmail:true
                },
                passwordExpireDate:"required",
                passwordSetDate:"required"
            }
            let messages={
                userCode :{
                    required:"请输入代码",
                    minlength:"输入最大长度为10"
                },
                userName :{
                    required:"请输入名称",
                    minlength:"最少要输入5个字符"
                },
                password:{
                    required:"请输入密码",
                    minlength:"最少要输入5个字符"
                },
                email:{
                    required:"请输入邮箱",
                },
                passwordExpireDate:"请选择密码失效时间",
                passwordSetDate:"请选择密码生效时间"
            }
            //使用正则表达式的校验方式
            //更多校验属性参照：http://www.runoob.com/jquery/jquery-plugin-validate.html
            $.validator.addMethod("checkEmail",function(value,element,params){  
                var checkEmail = /^[a-z0-9]+@([a-z0-9]+\.)+[a-z]{2,4}$/i;  
                return this.optional(element)||(checkEmail.test(value));
            },"*请输入正确的邮箱！");  
            ajax_form.init({
                $fm: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'create_user' : 'create_user',
                messages:messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});