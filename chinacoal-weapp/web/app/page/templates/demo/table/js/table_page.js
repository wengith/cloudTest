/**
 * 用户查询模块
 */
define(['jquery', 'widget/table_data', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service','bootbox','widget/ajax_table','bootstrap-tab'],
 function($, table_data, dialog, route_config, http, util_service,bootbox,ajax_table)  {

    var page = {

        /**
         * 模块参数
         */
        params: {
            table_data: null, //数据表格引用
            pageNum:0,//滚动加载分页的页码
            pageListcount:5//滚动加载每页显示的条数
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.initData();
            //初始化数据表格
            this.params.table_data = table_data.show({
                view: {
                    apiName: 'search_user',
                    //本模块service.js中定义的apiName
                    isRightAway: true,
                    columns: this.columns,
                    bts: this.bts,
                },
                jq_object: {
                    $pan: $('#tableDataPage'),
                    $tablepager: null,
                    $table: null,
                    $tbody: null,
                    $toolbar: null,
                    $form: null,
                    $search: null,
                    $all_checkbox: null,
                    $ck: null
                },
                callback: {
                    callSearch:function() {
                        return true;//返回true才会执行查询，可以进行查询前校验，比如日期大小等
                    },
                    //rowCallback:this.rowCallback
                },
            });
            this.bindEvent();
        },
        callSearch:function() {
            return false;
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
                    name: "userName",
                    showname:"userName",
                    placeholder: "用户名称"
                },
            ];
            var app = {
                title: "用户信息",
                queryConditions: queryConditions
            };
            myTemplate.link("#main-content", app);

            http.get({
              apiName: 'findEurekaInstances',
              cache:false,
              async:false,
              type: 'get',
              headers: {
                Authorization: "Arch6WithCloud "+localStorage.getItem("jwt")
              }, 
              xhrFields: {
                withCredentials: true
              },
              success:function(data) {
                //$.templates.instanceDataTml.link("#clients",{instances:data.data});
                ajax_table._showSimpleTablePage($("#clients"),data.data,page.localColumns,null);
              }
            });
            
            $.ajax({
                url: "api/misc/sdd/code/queryPageListAuotComplete",
                type: "post",
                dataType: "json",
                data: {
                    pageNumber:page.params.pageNum,
                    pageCount:page.params.pageListcount

                },
                beforeSend: function(request) {
                  request.setRequestHeader("Authorization", "Arch6WithCloud " + localStorage.getItem("jwt"));
                },
                success: function(data) {
                  ajax_table._showTable($("#rollPage"),data.data,page.rollPageColumns,null);
                }
              });
        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
            //滚动加载分页的滚动条事件
            $("#rollOutSide").on("scroll",function(){
                //表格的高度
                var tableHeight = parseInt($("#rollPage").css("height"))+20;
                //框的高度
                var outHeight = parseInt($("#rollOutSide").css("height"));
                //滚动条出去的高度
                var rollHeight = $("#rollOutSide").scrollTop();
                //计算出的框的高度
                var culOutHeight = tableHeight-rollHeight
                //判断滚动条是否到底
                if(culOutHeight<=outHeight){
                    //滚动条到底后增加页码，进行下一次查询
                    ++page.params.pageNum;
                    $.ajax({
                        url: "api/misc/sdd/code/queryPageListAuotComplete",
                        type: "post",
                        dataType: "json",
                        data: {
                            pageNumber:page.params.pageNum,
                            pageCount:page.params.pageListcount
                        },
                        beforeSend: function(request) {
                          request.setRequestHeader("Authorization", "Arch6WithCloud " + localStorage.getItem("jwt"));
                        },
                        success: function(data) {
                            //将查询结果放入table中
                            var table = $('#rollPage').DataTable();
                            table.rows.add(data.data).draw();
                        }
                    });
                }
            })
        },
        bts: [],
        /**
         * table的模板
         */
        columns: [{
            data: "id",
            label: '<input id="checkAll" name="checkAll" type="checkbox" class="checkAll">&nbsp;&nbsp;' + UtilMsg.tableNumber, //table显示的标题 国际化内容：序号
            render:function(data, row, displayIndex) {
                return '&nbsp;&nbsp;<input name="checkCode" type="checkbox" value="' + data + '" data-id="'+row.userCode+'" />';
            }
        },{
            label: "用户代码",
            orderSequence:true,
            data: 'userCode'
        }, {
            label: "用户名称",
            data: 'userName'
        }, {
            label:"邮箱",
            data: 'email'
        }, {
            label:"性别",
            data: 'sex'
        }, {
            label:"密码生效时间",
            orderSequence:true,
            data: 'passwordSetDate',
            render:function(data) {
                return new Date(data).Format("yyyy-MM-dd");
            }
        }, {
            label: "密码失效时间" ,
            data: 'passwordExpireDate',
            render:function(data) {
                return new Date(data).Format("yyyy-MM-dd");
            }
        },{
            label: "操作",
            data: 'id',
            render:function(data, row) {
                let str = '';
                //str += '<a href="#" title="权限配置"> <i class="fa fa-eye fa-lg view" data-id="'+data+'"></i></a>&nbsp;';
                str += '<a href="#" title="增加详细信息"> <i class="fa fa-address-card-o fa-lg detail" data-id='+JSON.stringify(row)+'></i></a>&nbsp;';
                str += '<a href="#" title="修改"> <i class="fa fa-pencil-square-o fa-lg update" data-id='+JSON.stringify(row)+'></i></a>&nbsp;';
                str += '<a href="#" title="删除" ><i class="fa fa-trash-o fa-lg delete" data-id="'+data+'"></i></a>&nbsp;';
                return str;
            }
        }],
        localColumns: [{
            "title": "服务名称",
            "width":"25%",
            "data": 'serviceName'
          },{
            "title": "服务名称",
            "width":"25%",
            "data": 'address'
          },{
            "title": "服务端口",
            "width":"25%",
            "data": 'port'
          },{
            "title": "服务状态",
            "width":"25%",
            "data": 'status',
            render: function ( data, type, row, meta ) {
              if(data=='PASSING'){
                return '<span class="label label-success">'+data+'</span>';
              }else if(data=='WARING'){
                return '<span class="label label-warning">'+data+'</span>';
              }else if(data=='CRITICAL'){
                return '<span class="label label-danger">'+data+'</span>';
              }else{
                return '<span class="label label-default">'+data+'</span>';
              }
            }
          }],
          rollPageColumns: [{
            "title": "编码",
            "width":"9%",
            "data": 'code'
          },{
            "title": "编码排序方式",
            "width":"9%",
            "data": 'codeDesc'
          },{
            "title": "判断标志",
            "width":"9%",
            "data": 'flag'
          },{
            "title": "序号",
            "width":"9%",
            "data": 'id'
          },{
            "title": "插入时间",
            "width":"9%",
            "data": 'insertTimeForHis'
          },{
            "title": "语言",
            "width":"9%",
            "data": 'language'
          },{
            "title": "操作时间",
            "width":"9%",
            "data": 'operateTimeForHis'
          },{
            "title": "类型编码",
            "width":"9%",
            "data": 'typeId'
          },{
            "title": "校验状态",
            "width":"9%",
            "data": 'validStatus'
          },{
            "title": "名称",
            "width":"9%",
            "data": 'value'
          },{
            "title": "服务状态",
            "width":"9%",
            "data": 'version'
          }],
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});
