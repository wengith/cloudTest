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
                     if (This.params.pageType != 'add'&&This.params.pageType != undefined&&This.params.pageType != 'addMenuTree'){
                        document.getElementById("upperId").readOnly=true;
                        document.getElementById("menuLevel").readOnly=true;
                     }
                }
            });
            if (this.params.pageType == 'addChildren') { //添加子节点
                var id = route_config.getStateParams()['id'];
                service.select_menu(id, $.proxy(this.render, this)); 
            } 
            else if (this.params.pageType == 'edit') { //编辑当前节点
                var id = route_config.getStateParams()['id'];
                service.load_menu(id, $.proxy(this.render, this)); 
            } 
            else if (this.params.pageType != undefined) { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
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
        /**
        * 模板渲染
        */
        render:function(data, flag){
            if (!data && !flag)
                    return;
            if (flag) {
                var myTemplate = $.templates("#menuFormTmpl");
                myTemplate.link("#menu-edit", { menu: "" });
            }
            else{
                var myTemplate = $.templates("#menuFormTmpl");
                myTemplate.link("#menu-edit", { menu: data });
            }
            this.params.deferred.resolve('ok');
        },
         ajaxSuccess:function() {
            dialog.confirm({
                content: '提交成功,确定要返回吗?',
                onSuerBefore:function() {
                    page.params.$fm.find('button.btn-close').trigger('click');
                    /*customer_list && customer_list.search();*/

                 if(page.params.pageType=='edit'){
                                    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
                                    var node = treeObj.getNodeByParam("id",route_config.getStateParams()['pId'], null); 
                                    treeObj.reAsyncChildNodes(node, "refresh");
                  }
                  else if(page.params.pageType=='addChildren'){
                                    var treeObj = $.fn.zTree.getZTreeObj("menuTree");
                                    var node = treeObj.getNodeByParam("id",route_config.getStateParams()['id'], null); 
                                    treeObj.reAsyncChildNodes(node, "refresh");
                  }
                 else if(page.params.pageType== 'addMenuTree'){
                        var treeObj = $.fn.zTree.getZTreeObj("menuTree");//报错原因页面中没有树所以treeObj为null
                        var id= $('#id1').val();
                        var pid= $('#upperId').val();
                        var node = treeObj.getNodeByParam(id,route_config.getStateParams()[pid], null); 
                        treeObj.reAsyncChildNodes(node, "refresh");
                    }
                else if(page.params.pageType== 'add'){
                       
                    }
                }
            });
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                id1 :"required",
                upperId :"required",
                menuLevel :"required",
                displayNo :"required",
                menuCname:"required"
            }
            let messages={
                id1 :"必录项",
                upperId :"必录项",
                menuLevel :"必录项",
                displayNo :"必录项",
                menuCname:"必录项"
            }
            ajax_form.init({
                $fm: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'create_menu' : 'create_menu',
                messages:messages,
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        }
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});