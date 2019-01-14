define(['jquery','widget/dialog', 'widget/ajax_form','widget/http','../../service', 'service/util_service', 'route_config','bootbox','zTree','widget/ajax_table','widget/multi_line'], function($,dialog, ajax_form,http,service, util_service,route_config,bootbox,zTree,ajax_table,multi_line)  {
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
            setting : null,
            fmObject:null,
            ajax_table: null,
            id:null
          },

        /**
         * 模块入口
         */
         initPage:function() {
          this.params.deferred = $.Deferred();
                //获取页面传输参数
                var stateParams = route_config.getStateParams();
                this.params.pageType = route_config.getStateParams()['pageType'];
                this.params.id = route_config.getStateParams()['id'];
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
              service.find_type(id, $.proxy(this.render, this)); 
            } else { //如果页面是新增，则不请求服务端数据，立即执行延迟加载
              this.render(null, true);
            }
          },
        /**
         * 事件绑定
         */
         bindEvent:function() {
          /*if(page.params.ajax_table!=null){
            $("#addTypeCode").on('click',$.proxy(this.addTypeCode, this));
            var table = $("#list-table");
            //table.find('tbody').on('click','i.delete',$.proxy(this.deleteCodeTypeClick, this));
            //table.find('tbody').on('click','i.update',$.proxy(this.editCodeTypeClick, this));
          }*/
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
            var myTemplate = $.templates("#sddTypeFormTmpl");
            myTemplate.link("#sdd-type-edit",{sddType:{},pageType:this.params.pageType});
            this.params.deferred.resolve('ok');
          }
          else{
            var myTemplate = $.templates("#sddTypeFormTmpl");
            myTemplate.link("#sdd-type-edit",{sddType:data.sddType,sddCode:data.sddCodes,pageType:this.params.pageType});
            http.get({
              apiName:'sdd_type_code',
              urlParams: {id:data.sddType.id},
              success:function(data) {
                var table = $("#list-table");
                page.params.ajax_table = multi_line.show({
                  'table':table,
                  'data':data.data.sddCodes,
                  'columns':page.columns,
                  'rowCallback':page.rowCallback,
                  '$addButton':$("#addTypeCode")
                });
                page.params.deferred.resolve('ok');
              }
            }); 
          }
        },
        columns: [{
          title: "代码Id",
          width: "20%",
          data: 'id',
          name:"sddTypeVo.sddCodes[form].id"
        },{
          title: "代码类型Id",
          width: "20%",
          data: 'typeId',
          name:"sddTypeVo.sddCodes[form].typeId"
        }, {
          title:"代码Code",
          width: "25%",
          data: 'code',
          type:'select',
          name:"sddTypeVo.sddCodes[form].code"
        }, {
          title:"代码值",
          width: "25%",
          data: 'value',
          name:"sddTypeVo.sddCodes[form].value"
        },{
          title: "操作",
          width: "10%",
          data: 'id'
          /*render:function(data, row) {
            let str = '';
            str += '<a href="#" title="增加"> <i class="fa fa-plus fa-lg update" data-id="'+data+'"></i></a>&nbsp;';
            str += '<a href="#" title="删除" ><i class="fa fa-times fa-lg delete" data-id="'+data+'"></i></a>&nbsp;';
            return str;
          }*/
        }],
        addTypeCode:function(){
          let $this = $(event.target);
            //  type = $("#type").val();
            //alert(roleCode);
            dialog.page({
              title: '用户角色编辑',
                stateParams: { pageType: 'add',id:this.params.id}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/sdd/codetype/edit'
              });
          },
          deleteCodeTypeClick:function(event) {
            let $this = $(event.target),
            id = $this.data('id');
            dialog.confirm({
              content: '确定移除吗?',
              onSuerBefore:function() {
                http.post({
                  apiName:'delete_code_type',
                  urlParams:{id:id},
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

          editCodeTypeClick:function(event){
            let $this = $(event.target),
            id = $this.data('id');
            dialog.page({
              title: '用户角色编辑',
                stateParams: { pageType: 'edit', id: id}, //传输给新页面的数据；pageType比传；update,add,view
                loadUrl: '/sdd/codetype/edit'
              });
          },
        /**
             * 初始化校验框架
             */
             initAjaxEdit:function() {
              let rules={
                type :"required",
                typeDesc :"required"
              }
              let messages={
                type :"请输入代码类型",
                typeDesc :"请输入代码描述"
              }
            page.params.fmObject = ajax_form.init({
                $form: this.params.$fm,
                //data: JSON.stringify(this.params.$fm.serializeObject()),
                rules: rules,
                type: 'POST',
                contentType:"application/json",  //缺失会出现URL编码，无法转成json对象
                apiName: this.params.pageType == 'add' || this.params.pageType==undefined ? 'add_sdd_type' : 'add_sdd_type',
                messages:messages,
                beforeSubmit:$.proxy(this.beforeSubmit, this),
                afterSuccess: $.proxy(this.ajaxSuccess, this)
              });
            },
            beforeSubmit:function() {
                page.params.fmObject.options.data = JSON.stringify(this.params.$fm.serializeObject());
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
              var typeId = $("#typeId").val();
              http.get({
                apiName:'sdd_type_code',
                urlParams: {id:typeId},
                success:function(data) {
                  var table = $("#list-table");
                  page.params.ajax_table = ajax_table._showTable(table,data.data.sddCodes,page.columns,page.rowCallback);
                }
              }); 
            }   
          };

          return {
            refreshTable:$.proxy(page.ajaxTable, page),
            initPage: $.proxy(page.initPage, page)
          };
        });