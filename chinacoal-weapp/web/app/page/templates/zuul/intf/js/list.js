
/**
 * 用户查询模块
 */
define(['jquery', 'widget/table_data', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service', 'bootbox'], function ($, table_data, dialog, route_config, http, util_service, bootbox) {

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
                    apiName: 'search_zuul', //本模块service.js中定义的apiName
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
                    name: "apiName",
                    showname:"apiName",
                    placeholder: "接口名称"
                },
                {
                    name: "path",
                    showname:"path",
                    placeholder: "接口路径"
                },
            ];
            var app = {
                title: "用户信息",
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
            $("#toolbar").on('click','#intf_add',$.proxy(this.addClick, this));
        },
        addClick:function(event) {
            let $this = $(event.target);
            route_config.go('/zuul/intf/edit', { pageType: 'add'}, {
                $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                isInitPage: true
            });
        },
        updateClick:function(event) {
            let $this = $(event.target),
            id = $this.data('id');
            dialog.page({
                title: '编辑',
                stateParams: { pageType: 'update', id: id }, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/zuul/intf/edit'
            });
        },
         viewClick:function(event) {
                let $this = $(event.target),
                id = $this.data('id');
                /*route_config.go('/customer/add', { pageType: 'add', id: id }, {
                    $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                    isInitPage: true
                });*/
                //打开一个新页面
                dialog.page({
                    title: '查看',
                    stateParams: { pageType: 'view', id: id }, //传输给新页面的数据；pageType比传；update,add,view
                    loadUrl: '/zuul/intf/edit'
                });
        },
        deletesClick:function(event) {
            let $this = $(event.target),
                id = $this.data('id');
            dialog.confirm({
                content: '确定删除吗?',
                onSuerBefore:function() {
                    http.post({
                        apiName: 'delete_zuul',
                        isMask: true,
                        urlParams: { ids: id },
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
            data: "id",
            label: '<input id="checkAll" name="checkAll" type="checkbox" class="checkAll">&nbsp;&nbsp;' + UtilMsg.tableNumber, //table显示的标题 国际化内容：序号
            render:function(data, row, displayIndex) {
                return '&nbsp;&nbsp;<input name="checkCode" type="checkbox" value="' + data + '" data-id="' + row.userCode + '" />';
            }
        }, {
            label: "路径",
            data: 'path'
        }, {
            label: "服务器id",
            data: 'serviceId'
        }, {
            label: "url",
            data: 'url'
        }, {
            label: "是否可重复操作",
            data: 'retryable',
            render:function(data) {
                if (data=='1') {
                    return '是';
                }
                else if(data=='2'){
                    return '否';
                }
                else{
                    return '';
                }
            }
        }, {
            label: "是否开启",
            data: 'enabled',
            render:function(data) {
                if (data=='1') {
                    return '是';
                }
                else if(data=='2'){
                    return '否';
                }
                else{
                    return '';
                }
            }
        }, {
            label: "前缀",
            data: 'stripPrefix'
        }, {
            label: "接口名称",
            data: 'apiName'
        },{
            label: "操作",
            data: 'id',
            render:function(data, row) {
                var str = '';
                //str += '<a href="#" title="权限配置"> <i class="fa fa-eye fa-lg view" data-id="'+data+'"></i></a>&nbsp;';
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