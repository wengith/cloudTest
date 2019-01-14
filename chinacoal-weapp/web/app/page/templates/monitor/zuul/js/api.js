/**
 * api展示模块
 */
 define(['jquery', 'widget/dialog', 'route_config', 'widget/http','bootbox','../../service','echarts','echarts-gl'],
   function($, dialog, route_config, http,bootbox,service,echarts)  {

    var page = {
        /**
         * 模块参数
         */
         params: {
          deferred: null,
          apiTemplate:null,
          serviceId:null,
          swaggerData:null
        },

        /**
         * 模块入口
         */
         initPage:function() {
          var stateParams = route_config.getStateParams();
          this.params.serviceId = route_config.getStateParams()['serviceId'];
          this.params.deferred = $.Deferred();
          var This=this;
          this.params.deferred.done(function()  {
            This.initData();
            This.bindEvent();
          });
          service.api_detail(this.params.serviceId,$.proxy(this.render, this));
        },
        callSearch:function() {
          return true;
        },
        render:function(data){
          this.params.apiTemplate = $.templates("#apiInfoTml");
          this.params.apiTemplate.link("#main-content",{instances:data.instances,apis:data.swagger.paths});
          this.params.swaggerData = data;
          this.params.deferred.resolve('ok');
        },
        //初始化hystrix数据
        initData:function(){

        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
          $("table").on("click","i.setting",$.proxy(this.settingClick, this));
        },
        settingClick:function(event){
          let $this = $(event.target),
              url = $this.data('id');
          let instances = this.params.swaggerData.instances;
          let apiDetail = this.params.swaggerData.swagger.paths[url];
          dialog.page({
              title: '接口设置',
              modal_width:1200,
              stateParams: { instances:instances, apiDetail:apiDetail,url:url}, //传输给新页面的数据；pageType比传；update,add,view
              loadUrl: '/monitor/zuul/api/operate'
          });
        }
      };
      return {
        initPage: $.proxy(page.initPage, page),
        search:function() {
          page && page.params && page.params.table_data && page.params.table_data._showPage(null, null, true);
        }
      };
    });
