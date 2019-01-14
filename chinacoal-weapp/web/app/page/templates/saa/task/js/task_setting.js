define(['jquery','widget/dialog','widget/ajax_form','widget/http','../../service', 'service/util_service', 'route_config','bootbox','zTree'], function($,dialog, ajax_form,http,service, util_service, route_config,bootbox,zTree)  {
	var page = {

        /**
         * 模块参数
         */
        params: {
              /**
             * 模块参数
             */
            deferred: null,
            pageType: 'setting', //默认新增
            zTreeObj: null,//ztree对象
            setting : null,//ztree设置
            zNodes : null  //ztree节点
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.params.deferred = $.Deferred();
            //获取页面传输参数
            var stateParams = route_config.getStateParams();
            this.params.pageType = route_config.getStateParams()['pageType'];
            var taskCode = route_config.getStateParams()['id'];
            this.render(null,true);
            this.initTree(taskCode);
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
        render:function(data, flag){
            var myTemplate = $.templates("#taskTreeTmpl");
            myTemplate.link("#task-setting");
        },
        /**
             * 初始化校验框架
             */
        initTree:function(taskCode) {
            this.params.setting={
                edit : {
                    enable : true,
                    isMove : true,
                    showRemoveBtn : true,
                    showRenameBtn : false,
                    // removeTitle:"删除",
                    // renameTitle:"重命名",
                    editNameSelectAll : true,

                },
                view : {
                    selectedMulti : false,
                    fontCss : this.setFontCss,
                    addHoverDom : this.addHoverDom,
                    removeHoverDom : this.removeHoverDom,
                },
                async : {
                    enable : true,
                    url : this.getAsyncUrl,
                    autoParam : [ "id=pId" ],
                    dataFilter : this.filter,
                    type:"get"
                },
                data : {
                    /*
                     * keep: { parent:true, leaf:true },
                     */
                    simpleData : {
                        enable : true
                    }
                },
                check : {
                // enable: true
                },
                callback : { 
                    onClick : this.zTreeOnClick,
                    onDrop : this.zTreeOnDrop,
                    onRemove : this.onRemove
                }
            };
            http.get({
                apiName:'saa_task_set_node',
                urlParams: {systemCode:taskCode},
                success:function(data) {
                    page.params.zNodes = data.data;
                    page.params.zTreeObj = $.fn.zTree.init($("#taskTree"), page.params.setting,page.params.zNodes);
                }
            });
        },
        getAsyncUrl:function(treeId, treeNode) {
            return  "/api/misc/saa/task/show/"+treeNode.id;
        },
        filter:function(treeId, parentNode, childNodes) {
            if (!childNodes)
                return null;
            for (var i = 0, l = childNodes.length; i < l; i++) {
            }
            return childNodes;
        }, 
        addHoverDom:function(treeId, treeNode) {
            lastTreeNode = treeNode;
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
                return;
            var addStr = "<img src='./img/tree/add.png' id='addBtn_" + treeNode.tId
                    + "' title='add' onfocus='this.blur();'/>";
            sObj.after(addStr);
            var btn = $("#addBtn_" + treeNode.tId);
            var newCount = 1;
            btn.bind("click", function() {
                $("#addBtn_" + treeNode.tId).unbind().remove();
                var zTree = $.fn.zTree.getZTreeObj("taskTree");
                if(treeNode.level<3){
                   dialog.page({
                        title: '新增节点',
                        stateParams: { pageType: 'addChildren', id: treeNode.id }, //传输给新页面的数据；pageType比传；update,add,view
                        loadUrl: '/saa/task/edit'
                    }); 
                }
                else{
                    bootbox.alert("不能再添加下级功能");
                }
            });
        },
        removeHoverDom:function(treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
            // var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        },
        setFontCss:function(treeId, treeNode) {
            if (!treeNode.isParent)
                return {
                    'color' :'blue',
                    'font-weight' : 'bold'
                };
            else
                return {
                    'font-weight' : 'bold',
                    'font-size' : '20px'
                };
        },
        zTreeOnClick:function(event, treeId, treeNode) {
            $("#addBtn_" + treeNode.tId).unbind().remove();
            $("#" + treeNode.tId + "_remove").unbind().remove();
            dialog.page({
                title: '编辑节点',
                stateParams: { pageType: 'update', id: treeNode.id,pId:treeNode.pId}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/saa/task/edit'
            });
        },
        zTreeOnDrop:function(event, treeId, treeNodes, targetNode, moveType, isCopy) {
            var task={
                "taskCode": treeNodes[0].id,
                "upperTaskCode":treeNodes[0].pId,
                "taskCName":treeNodes[0].name,
                "url":treeNodes[0].url,
                "level":treeNodes[0].level,
                "flag":"1"
            };
            http.post({
                apiName: 'add_saa_task',
                data:JSON.stringify(task),
                success:function(data) {
                }
            });
        },
        onRemove:function(e, treeId, treeNode) {
            http.post({
                apiName: 'delete_saa_task_system',
                isMask: true,
                urlParams: { taskCodes: treeNode.id},
                success:function(data) {
                    dialog.alert({
                        content: '删除成功。'
                    });
                }
            });
        }
    };
    return {
        initPage: $.proxy(page.initPage, page)
    };
});