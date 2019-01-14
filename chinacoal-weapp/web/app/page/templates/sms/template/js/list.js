/**
 * 用户查询模块
 */
define(['jquery', 'widget/table_data', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service', 'bootbox'], 
function ($, table_data, dialog, route_config, http, util_service, bootbox) {

    var page = {

        /**
         * 模块参数
         */
        params: {
            table_data: null //数据表格引用
        },

        /**
         * 模块入口
         */
       initPage:function() {
            this.initData();
            //初始化数据表格
            this.params.table_data = table_data.show({
                view: {
                    apiName: 'search_template', //本模块service.js中定义的apiName
                    columns: this.columns,
                    bts: this.bts,
                },
                callback: {
                    callSearch:function() {
                        return page.callSearch();//返回true才会执行查询，可以进行查询前校验，比如日期大小等
                    }
                }
            });
            this.bindEvent();
        },
        callSearch:function() {
            return true;
        },

       //初始化表格数据
        initData:function(){
            var myTemplate = $.templates("#queryFormTmpl");

            var queryConditions = [
                 {
                    name: "theme",
                    showname:"theme",
                    placeholder: "模板主题"
                },
                {
                    name: "templateCode",
                    showname:"templateCode",
                    placeholder: "调用ID"
                }
            ];
            var app = {
                title: "短信模板",
                queryConditions: queryConditions
            };
            myTemplate.link("#main-content", app);
        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
            //this.params.table_data._getTbody().on('click','i.view',$.proxy(this.viewClick, this));
            this.params.table_data._getTbody().on('click','i.update',$.proxy(this.updateClick, this));
            this.params.table_data._getTbody().on('click','i.delete',$.proxy(this.deletesClick, this));
            $("#toolbar").on('click','#template_add',$.proxy(this.addClick, this));
        },
        addClick:function(event) {
            let $this = $(event.target);
            route_config.go('/sms/template/edit', { pageType: 'add'}, {
                $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                isInitPage: true
            });
        },
        updateClick:function(event) {
            let $this = $(event.target),
            templateCode = $this.data('id');
            dialog.page({
                title: '更新',
                stateParams: { pageType: 'update', templateCode: templateCode }, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/sms/template/edit'
            });
        },
         viewClick:function(event) {
                let $this = $(event.target),
                templateCode = $this.data('id');
                //打开一个新页面
                dialog.page({
                    title: '查看',
                    stateParams: { pageType: 'view', templateCode: templateCode }, //传输给新页面的数据；pageType比传；update,add,view
                    loadUrl: '/sms/template/edit'
                });
        },
        deletesClick:function(event) {
            let $this = $(event.target),
                templateCode = $this.data('id');
            dialog.confirm({
                content: '确定删除吗?',
                onSuerBefore:function() {
                    http.post({
                        apiName: 'delete_template',
                        isMask: true,
                        urlParams: { ids: templateCode },
                        success:function(data) {
                            dialog.alert({
                                content: '删除成功。'
                            });
                            //删除成功后继续查找第一页
                            page.params.table_data._showPage(0);
                        }
                    });
                }
            });
        },

        bts: [],
        /**
         * table的模板
         */

        columns: [{
            label: "调用ID",
            data: 'templateCode'
        },{
            label: "分公司名称",
            data: 'comCode'
        },{
            label: "系统名称",
            data: 'sysCode'
        },{
            label: "模板主题",
            data: 'theme'
        },{
            label: "模板内容",
            data: 'templateContent'
        },{
            label: "操作",
            data: 'templateCode',
            render:function(data, row) {
                var str = '';
                str += '<a href="#" title="修改"> <i class="fa fa-pencil-square-o fa-lg update" data-id="' + data + '"></i></a>&nbsp;';
                str += '<a href="#" title="删除" ><i class="fa fa-trash-o fa-lg delete" data-id="' + data + '"></i></a>&nbsp;';
                return str;
            }
        }]
    };

    return {
        initPage: $.proxy(page.initPage, page),
        search:function() {
            page && page.params && page.params.table_data && page.params.table_data._showPage(null, null, true);
        }
    };
});