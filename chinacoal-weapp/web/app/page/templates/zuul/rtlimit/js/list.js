
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
                    apiName: 'search_limit1', //本模块service.js中定义的apiName
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
                    name: "method",
                    showname:"method",
                    placeholder: "方案"
                },
                {
                    name: "type",
                    showname:"type",
                    placeholder: "类型"
                },
            ];
            var app = {
                title: "限流方案信息",
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
            $("#toolbar").on('click','#rt_add',$.proxy(this.addClick, this));
            $("#toolbar").on('click','#power_config',$.proxy(this.powerConfigClick, this));
            $("#toolbar").on('click','#power_copy',$.proxy(this.powerCopyClick, this));
        },
        addClick:function(event) {
            let $this = $(event.target);
            route_config.go('/zuul/rtlimit/edit', { pageType: 'add'}, {
                $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                isInitPage: true
            });
        },
       powerConfigClick:function(event) {
            let $this = $(event.target);
            let obj = $('input[name="checkCode"]:checked');
            if(obj.length>1){
                bootbox.alert("只能选择一条记录！");
            }else if(obj.length==0){
                bootbox.alert("请选择一条记录！");
            }
            else{
                let data = new Map();
                obj.each(function(i){
                    data.set(obj[i].value,obj[i].dataset.id);
                });
                route_config.go('/saa/user/power/config', { pageType: 'add',userData:data}, {
                    $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                    isInitPage: true
                });
            }
           
        },
       powerCopyClick:function(event) {
            let $this = $(event.target);
            let obj = $('input[name="checkCode"]:checked');
            if(obj.length>1){
                bootbox.alert("只能选择一条记录！");
            }else if(obj.length==0){
                bootbox.alert("请选择一条记录！");
            }
            else{
                let data = new Map();
                obj.each(function(i){
                    data.set(obj[i].value,obj[i].dataset.id);
                });
                route_config.go('/saa/user/power/copy', { pageType: 'add',userData:data}, {
                    $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                    isInitPage: true
                });
            }
        },
        updateClick:function(event) {
            let $this = $(event.target),
            id = $this.data('id');
            dialog.page({
                title: '编辑',
                stateParams: { pageType: 'update', id: id }, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/zuul/rtlimit/edit'
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
                    loadUrl: '/zuul/rtlimit/edit'
                });
        },
        deletesClick:function(event) {
            let $this = $(event.target),
                id = $this.data('id');
            dialog.confirm({
                content: '确定删除吗?',
                onSuerBefore:function() {
                    http.post({
                        apiName: 'delete_limit1',
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
            label: "方案",
            data: 'method'
        }, {
            label: "类型",
            data: 'type',
            render:function(data) {
                if (data=='1') {
                    return '限流';
                }
                else if(data=='2'){
                    return '配额';
                }
                else{
                    return '';
                }
            }
        }, {
            label: "次数",
            data: 'limits'
        }, {
            label: "单位时间",
            data: 'timeUnit',
            render:function(data) {
                if (data=='60') {
                    return '分';
                }
                else if(data=='3600'){
                    return '时';
                }
                else if(data=='86400'){
                    return '天';
                }
                else if(data=='2592000'){
                    return '月';
                }
                else{
                    return '';
                }
            }
        }, {
            label: "名称",
            data: 'name'
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