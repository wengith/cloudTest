/**
 * service展示模块
 */
 define(['jquery', 'widget/dialog', 'route_config', 'widget/http','bootbox','../../service','echarts','echarts-gl'],
   function($, dialog, route_config, http,bootbox,service,echarts)  {

    var page = {
        /**
         * 模块参数
         */
         params: {
          deferred: null,
          serviceTemplate:null
        },

        /**
         * 模块入口
         */
        initPage:function() {
          this.render();
        },
        callSearch:function() {
          return true;
        },
        render:function(){
          this.params.serviceTemplate = $.templates("#zipkinInfoTml");
          let uri = "/api/zipkin";
          this.params.serviceTemplate.link("#main-content",{url:uri});
        },
        //初始化hystrix数据
        initData:function(){

        },

        /**
         * 事件绑定
         */
        bindEvent:function() {
        }
      };
      return {
        initPage: $.proxy(page.initPage, page)
      };
    });
