/**
 * 示例
 */
 define(['jquery','widget/http','widget/dialog','widget/ajax_table','qrcode','jquery-qrcode'], function($,http,dialog,ajax_table)  {


  var page = {

        /**
         * 模块参数
         */
         params: {
          deferred: null,
          user:{
            code:null,
            name:null
          }
        },

        /**
         * 模块入口
         */
         initPage:function() {
          this.params.deferred = $.Deferred();
          this.params.deferred.done(function()  {
            /*****************************dashboard***********************/
            $.views.converters("format", function(val) {  
              return new Date(val).Format("yyyy-MM-dd hh:mm:ss");  
            });
            $.views.converters("formatDay", function(val) {  
              return new Date(val).Format("yyyy-MM-dd");  
            });
            $.views.converters("byteToG", function(val) {  
              return Math.round((parseInt(val))/(1024*1024*1024));  
            });
            page.render();
            page.bindEvent();
            page.autoHeight();
          });
            //通过获取的数据请求页面的基本信息
            this.params.deferred.resolve('ok');
          },
          render:function(){
            $.templates({
              indexContentTml: "#indexContentTml",
              //instanceDataTml:"#instanceDataTml",
              toDoListDataTml:"#toDoListDataTml"
            });
            $.templates.indexContentTml.link("#main-content");
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
                ajax_table._showSimpleTablePage($("#clients"),data.data,page.columns,null);
              }
            });
            $.templates.toDoListDataTml.link("#toDoList",null);

          },
          autoHeight:function(){
            var h = document.documentElement.clientHeight;
            $(".register").each(function(index,element){
              if(h>800){
                element.style.height=h*0.63+"px"
              }
              else{
                element.style.height=h*0.81+"px"
              }
            });
            $(".box.infos").each(function(index,element){
              if(h>800){
                element.style.height=h*0.255+"px"
              }
              else{
                element.style.height=h*0.34+"px"
              }
            });
            /*$(".box.helpers").each(function(index,element){
              element.style.height=h*0.38+"px"
            });
            $(".box.toDoList").each(function(index,element){
              element.style.height=h*0.20+"px"
            });
            $(".box.stars").each(function(index,element){
              element.style.height=h*0.50+"px"
            });
            $(".box.infos").each(function(index,element){
              element.style.height=h*0.21+"px"
            });*/
          },
          columns: [{
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
        /**
         * 事件绑定
         */
         bindEvent:function() {
          $("#toggleContent").on("click",function(e){
            var helpers = $("#helpers");
            if(helpers.height()!="240"){
              helpers.height(240);
              $("#toggleContent").html('展开更多资源 <i class="fa fa-caret-down"></i>');
            }
            else{
              helpers.height("auto");
              $("#toggleContent").html('收起更多资源 <i class="fa fa-caret-up"></i>'); 
            }

          });
          $('input').placeholder();
          /******生成二维码*****/
          $("#barCode").qrcode({
            render  : "canvas",
            text    : "http://jsptz.com",
            width: 100,
            height: 100
          });
          var tbody = $("a.info");
          tbody.on('click',$.proxy(this.monitorDetail, this));
        },
      };
      return {
        initPage: $.proxy(page.initPage, page)
      };
    });
