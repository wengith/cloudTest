/**
 * 用户查询模块
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
                    apiName: 'search_quartz', //本模块service.js中定义的apiName
                    columns: this.columns,
                    bts: this.bts,
                },
                callback: {
                    callSearch:function() {
                        return page.callSearch();//返回true才会执行查询，可以进行查询前校验，比如日期大小等
                    },
                    rowCallback:this.rowCallback
                }
            });
            this.bindEvent();
        },
        callSearch:function() {
            return true;
        },
        rowCallback:function(row,data,index){
            row.on("click",function(){
                page.trClick(data);
            });
        },
        trClick:function(data){
            alert(JSON.stringify(data));
        },
        //初始化表格数据
        initData:function(){
            var myTemplate = $.templates("#queryFormTmpl");

            var queryConditions = [
                {
                    name: "userCode",
                    showname:"userCode",
                    placeholder: "用户代码"
                },
                {
                    name: "jobCode",
                    showname:"jobCode",
                    placeholder: "作业代码（不能为汉字）"
                },
                {
                    name: "jobDescription",
                    showname:"jobDescription",
                    placeholder: "作业描述"
                },
            ];
            var app = {
                title: "任务信息",
                queryConditions: queryConditions
            };
            myTemplate.link("#main-content", app);
        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
            //this.params.table_data._getTbody().on('click','i.view',$.proxy(this.viewClick, this));
             this.params.table_data._getTbody().on('click','i.runState',$.proxy(this.runStateClick, this));
            this.params.table_data._getTbody().on('click','i.update',$.proxy(this.updateClick, this));
            this.params.table_data._getTbody().on('click','i.delete',$.proxy(this.deletesClick, this));
        },
        runStateClick:function(event) {
            let $this = $(event.target),
            id = $this.data('id'); 
            http.post({
                        apiName: 'changeRunStatus_quartz',
                        isMask: true,
                        urlParams: { id: id },
                        success:function(data) {
                            //暂停成功后继续查找第一页
                            page.params.table_data._showPage(0);
                        }
                    });
        },
        updateClick:function(event) {
            let $this = $(event.target),
            id = $this.data('id');
            dialog.page({
                title: '编辑',
                stateParams: { pageType: 'update', id:id}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/quartz/quartzPage/edit'
            });
        },
        deletesClick:function(event) {
            let $this = $(event.target),
                id = $this.data('id');
            dialog.confirm({
                content: '确定删除吗?',
                onSuerBefore:function() {
                    http.post({
                        apiName: 'delete_quartz',
                        isMask: true,
                        urlParams: { id: id },
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
        bts: [{
            dataRouter: "/quartz/quartzPage/edit", //跳转路由
            dataType: "create", //按钮类型
            label: UtilMsg.btCreate, //按钮标题:新增
            isSelect: false, //是否选中才允许点击；
            isCustom: false //是否自定义按钮
        }],
        /**
         * table的模板
         */
        columns: [{
            data: "id",
            label: 'ID' , //table显示的标题 国际化内容：序号
            
        },{
            label: "作业代码（不能为汉字）",
            orderSequence:true,
            data: 'jobCode'
        },{
            label: "运行状态",
            data: 'runStatus',
            render:function(data) {
                if (data=='Nonexistent') {
                    return '未在定时计划中';
                }
                else if(data=='NORMAL'){
                    return '正在执行';
                }
                else if(data=='PAUSED'){
                    return '已暂停';
                }
                else if(data=='NONE'){
                    return '计划中未执行';
                }
                else if(data=='ERROR'){
                    return '错误';
                }
                else if(data=='COMPLETE'){
                    return '完成';
                }
                else if(data=='BLOCKED'){
                    return '阻塞';
                }
            }
        }, {
            label: "效力状态",
            data: 'validStatus',
            render:function(data) {
                if (data=='1') {
                    return '有效';
                }
                else if(data=='0'){
                    return '无效';
                }
            }
        }, {
            label: "作业描述",
            data: 'jobDescription'
        },{
            label: "操作",
            data: 'id',
            render:function(data, row) {
                let str = '';
                str += '<a href="#" title="运行状态"> <i class="fa fa-retweet fa-lg runState" data-id='+data+'></i></a>&nbsp;';
                str += '<a href="#" title="修改"> <i class="fa fa-pencil-square-o fa-lg update" data-id='+data+'></i></a>&nbsp;';
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
