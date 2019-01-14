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
            this.params.deferred = $.Deferred();
                //获取页面传输参数
            var stateParams = route_config.getStateParams();
            this.params.pageType = route_config.getStateParams()['pageType'];
            var This=this;
            this.params.deferred.done(function()  { 
                This.initAjaxEdit();
                This.bindEvent();
                This.params.$fm = $('#form');
                $(".form_date").datetimepicker({
                    //language:  'fr',
                    language:  'fr',
                    weekStart: 1,
                    todayBtn:  1,
                    autoclose: 1,
                    todayHighlight: 1,
                    startView: 2,
                    minView: 2,
                    forceParse: 0
                });
                //如果是查看页面，则readonly所有输入与域
                if (This.params.pageType == 'view') {
                    util_service._readonlyInput(This.params.$fm);
                } else { 
                    $('#btn-submit').show();
                }
            });
            if (this.params.pageType != 'add'&& this.params.pageType != undefined) { //如果此页面不是新增，则请求服务端数据
                var id = route_config.getStateParams()['id'];
                service.find_task(id, $.proxy(this.render, this)); 
            } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
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
                // 如果页面的参数是setting，关闭模态框
                if(route_config.getStateParams()['pageType']=='update'){
                  $(".close").click();
                }else{
                  parent.jy_menu(2);
                }
            });
        },
        ajaxSuccess:function() {
            dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
                    
                    if(page.params.pageType=='update'){
                        var treeObj = $.fn.zTree.getZTreeObj("taskTree");
                        var node = treeObj.getNodeByParam("id",route_config.getStateParams()['pId'], null); 
                        treeObj.reAsyncChildNodes(node, "refresh");
                    }
                    else if(page.params.pageType=='addChildren'){
                        var treeObj = $.fn.zTree.getZTreeObj("taskTree");
                        var node = treeObj.getNodeByParam("id",route_config.getStateParams()['id'], null); 
                        treeObj.reAsyncChildNodes(node, "refresh");
                    }
                    
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
                myTemplate.link("#task-edit",{pageType:this.params.pageType,task:{taskCode:"",level:"System"}});
            }
            else{
                var myTemplate = $.templates("#queryFormTmpl");
                if(this.params.pageType=='update'){
                   myTemplate.link("#task-edit",{pageType:this.params.pageType,task: data}); 
                }
                else{
                  var level = data.level;
                  switch(level){
                    case "System":
                        level="Package"
                        break;
                    case "Package":
                        level="Module"
                        break;
                    case "Module":
                        level="Task"
                        break;
                    case "Task":
                        break;
                  }
                  myTemplate.link("#task-edit",{pageType:this.params.pageType,task:{taskCode:"",upperTaskCode:data.taskCode,level:level}});  
                }
            }
            this.params.deferred.resolve('ok');
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                taskCode :"required",
                taskCName:"required",
                url:"required"
            }
            let messages={
                taskCode :"必录项",
                taskCName:"必录项",
                url:"必录项"
            }
            ajax_form.init({
                $fm: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'add_saa_task' : 'add_saa_task',
                messages:messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});