define(['jquery','widget/dialog', 'widget/ajax_form','widget/http','../../service', 'service/util_service', 'route_config','bootbox','widget/ajax_table'], function($,dialog, ajax_form,http,service, util_service,route_config,bootbox,ajax_table)  {
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
            dataModel: null,
            fmObject:null,
            ajax_table: null
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
                This.params.$fm = $('#form');
                This.initAjaxEdit();
                This.bindEvent();
                //如果是查看页面，则readonly所有输入与域
                if (This.params.pageType == 'view') {
                    util_service._readonlyInput(This.params.$fm);
                } else { 
                    $('#btn-submit').show();
                }
            });
            if (this.params.pageType != 'add'&& this.params.pageType != undefined) { //如果此页面不是新增，则请求服务端数据
                var id = route_config.getStateParams()['id'];
                service.find_factor(id, $.proxy(this.render, this)); 
            } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
                this.render(null, true);
                this.params.deferred.resolve('ok');
            }
        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
            if(page.params.ajax_table!=null){
                $("#addFactorField").on('click',$.proxy(this.addFactorField, this));
                var table = $("#list-table");
                table.find('tbody').on('click','i.delete',$.proxy(this.deleteFactorFieldClick, this));
                table.find('tbody').on('click','i.update',$.proxy(this.editFactorFieldClick, this));
            }
            // 绑定关闭按钮
            $("#btn-close").on('click',function(e){
                // 如果页面的参数是setting，关闭模态框
                if(route_config.getStateParams()['pageType']=='setting'){
                  $(".close").click();
                }else{
                  parent.jy_menu(2);
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
                var myTemplate = $.templates("#factorFormTmpl");
                myTemplate.link("#factor-edit",{factor:{},pageType:this.params.pageType});
                this.params.deferred.resolve('ok');
            }
            else{
                var myTemplate = $.templates("#factorFormTmpl");
                myTemplate.link("#factor-edit",{factor: data.saaFactor,pageType:this.params.pageType});
                var table = $("#list-table");
                page.params.ajax_table = ajax_table._showTable(table,data.saaFactor.saaFactorFiledVoList,page.columns,page.rowCallback);
                page.params.deferred.resolve('ok');
            }
        },
        columns: [
        {
            title: "字段名称",
            width: "30%",
            data: 'fieldCode'
        }, {
            title:"归属表",
            width: "30%",
            data: 'entityCode'
        },{
            title: "操作",
            width: "10%",
            data: 'id',
            render:function(data, row) {
                let str = '';
                str += '<a href="#" title="删除" ><i class="fa fa-trash-o fa-lg delete" data-id="'+data+'"></i></a>&nbsp;';
                return str;
            }
        }],
        rowCallback:function(row, data, displayIndex, displayIndexFull) {
            
        },
        addFactorField:function(){
            let $this = $(event.target),
                factorCode = $("#factorCode").val();
            //alert(roleCode);
            dialog.page({
                title: '字段增加',
                stateParams: { pageType: 'add',factorCode:factorCode}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/saa/factorfield/edit'
            });
        },
        deleteFactorFieldClick:function(event){
            let $this = $(event.target),
                factorFieldId = $this.data('id');
            dialog.confirm({
                content: '确定移除吗?',
                onSuerBefore:function() {
                    http.post({
                       apiName:'delete_saa_factor_field',
                       urlParams:{ids:factorFieldId},
                       success:function(data) {
                            dialog.alert({
                                content: '移除成功。'
                            });
                            //删除成功后继续查找第一页
                            page.params.ajax_table
                                .row($this.parents('tr'))
                                .remove()
                                .draw();
                        }
                    });
                }
            });
        },
        editFactorFieldClick:function(event){
            let $this = $(event.target),
                factorField = $this.data('id'),
                factorCode = $("#factorCode").val();
            //alert(roleCode);
            dialog.page({
                title: '字段编辑',
                stateParams: { pageType: 'edit', id: factorField,factorCode:factorCode}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/saa/factorfield/edit'
            });
        },
        /**
             * 初始化校验框架
             */
        initAjaxEdit:function() {
            let rules={
                factorCode :"required",
                factorDesc : "required",
                dataType:"required"
            }
            let messages={
                factorCode :"请输入业务权限代码",
                factorDesc : "请输入业务权限名称",
                dataType:"请选择数据类型"
            }
            page.params.fmObject = ajax_form.init({
                $form: this.params.$fm,
                rules: rules,
                type: 'POST',
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'add_saa_factor' : 'add_saa_factor',
                messages:messages,
                beforeSubmit:$.proxy(this.beforeSubmit, this),
                afterSuccess: $.proxy(this.ajaxSuccess, this)
            });
        },
        beforeSubmit:function() {

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
        ajaxTable:function(){
            var factorCode = $("#factorCode").val();
            http.get({
                apiName:'saa_factor_field_List',
                urlParams: {factorCode:factorCode},
                success:function(data) {
                    var table = $("#list-table");
                    page.params.ajax_table = ajax_table._showTable(table,data.data,page.columns,page.rowCallback);
                    //page.bindEvent();
                }
            });
        }   
    };

    return {
        refreshTable:$.proxy(page.ajaxTable, page),
        initPage: $.proxy(page.initPage, page)
    };
});