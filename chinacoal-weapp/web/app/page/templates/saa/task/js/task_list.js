/**
 * 功能管理模块
 */
define(['jquery', 'widget/table_data', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service','bootbox'],
 function($, table_data, dialog, route_config, http, util_service,bootbox)  {

    var page = {

        /**
         * 模块参数
         */
        params: {
            table_data: null, //数据表格引用
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.initData();
            //初始化数据表格
            this.params.table_data = table_data.show({
                view: {
                    apiName: 'search_saa_task',
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
                    name: "taskCode",
                    showname:"taskCode",
                    placeholder: "功能代码"
                },
                {
                    name: "taskCName",
                    showname:"taskCName",
                    placeholder: "功能名称"
                },
            ];
            var app = {
                title: "客户信息",
                queryConditions: queryConditions,
            };
            myTemplate.link("#main-content", app);
        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
            this.params.table_data._getTbody().on('click','i.delete',$.proxy(this.deletesClick, this));
            this.params.table_data._getTbody().on('click','i.setting',$.proxy(this.settingClick, this));
            this.params.table_data._getTbody().on('click','i.select',$.proxy(this.selectClick, this));
            $("#toolbar").on('click','#task_add',$.proxy(this.addClick, this));
        },
        addClick:function(event) {
            let $this = $(event.target);
            route_config.tabs("/saa/task/edit","功能添加",{ pageType: 'add'},"localTabs")
        },
        deletesClick:function(event) {
            let $this = $(event.target),
                id = $this.data('id');
            dialog.confirm({
                content: '确定删除吗?',
                onSuerBefore:function() {
                    http.post({
                        apiName: 'delete_saa_task_system',
                        isMask: true,
                        urlParams: { taskCodes: id },
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
        settingClick:function(event) {
             let $this = $(event.target),
                id = $this.data('id');
                /*route_config.go('/customer/add', { pageType: 'add', id: id }, {
                    $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                    isInitPage: true
                });*/
                //打开一个新页面
                dialog.page({
                    title: '配置',
                    stateParams: { pageType: 'setting', id: id }, //传输给新页面的数据；pageType比传；update,add,view
                    loadUrl: '/saa/task/setting'
                });
        },
        selectClick:function(event) {
            let $this = $(event.target),id = $this.data('id');
                //打开一个新页面
            bootbox.confirm({
                buttons: {  
                    confirm: {  
                        label: '确认'   
                    },  
                    cancel: {  
                        label: '取消' 
                    }  
                },  
                message: '确认使用系统'+id+'吗？',  
                callback: function(result) {  
                    if(result) {  
                        localStorage.setItem('systemCode',id);
                        page.params.table_data._showPage(null, null, true)
                    } else {  
                        return; 
                    }  
                }, 
            });
        },
        bts: [],
        /*bts: [{
            dataRouter: "/saa/task/edit", //跳转路由
            dataType: "create", //按钮类型
            label: UtilMsg.btCreate, //按钮标题:新增
            isSelect: false, //是否选中才允许点击；
            isCustom: false //是否自定义按钮
        }],*/
        /**
         * table的模板
         */
        columns: [{
            label: "功能代码",
            data: 'taskCode'
        }, {
            label: "功能名称",
            data: 'taskCName'
        }, {
            label:"上级功能代码",
            data: 'upperTaskCode'
        }, {
            label:"功能级别",
            data: 'level'
        }, {
            label:"映射URL",
            data: 'url'
        }, {
            label: "备注" ,
            data: 'remark'
        },{
            label: "创建时间",
            data: 'insertTimeForHis'
        },{
            label: "操作",
            data: 'taskCode',
            render:function(data, row) {
                var systemCode = localStorage.getItem('systemCode');
                let str =""
                str+= '<a href="#" title="模板配置" ><i class="fa fa fa-cogs fa-lg setting" data-id="'+data+'"></i></a>&nbsp;'
                if(systemCode==row.taskCode){
                    str+= '<a href="#" title="选择模板" ><i class="fa fa-flag fa-lg select" data-id="'+data+'"></i></a>&nbsp;'
                }
                else{
                    str+= '<a href="#" title="选择模板" ><i class="fa fa-flag-o fa-lg select" data-id="'+data+'"></i></a>&nbsp;'
                }
                str += '<a href="#" title="删除" ><i class="fa fa-trash-o fa-lg delete" data-id="'+data+'"></i></a>&nbsp;';
                return str;
            }
        }],
    };

    return {
        initPage: $.proxy(page.initPage, page),
        search:function() {
            page && page.params && page.params.table_data && page.params.table_data._showPage(null, null, true);
        }
    };
});
