/**
 * 示例
 */
 define(['jquery','widget/http','route_config','bootstrap-tab'], function($,http,route_config)  {
  var page = {

        /**
         * 模块参数
         */
        params: {
          navMenusData:null,
          deferred: null,
          tabCounter : '2'
        },
        /**
         * 模块入口
         */
         initPage:function() {
          this.params.deferred = $.Deferred();
          this.params.deferred.done(function()  {
            page.bindEvent();
          })
            //通过获取的数据请求页面的基本信息
            service._queryAllTask($.proxy(this.render,this));
            this.params.deferred.resolve('ok');    
          },
          render:function(data){
            page.params.navMenusData = JSON.parse(data.navMenusData);
            $.templates({
              navMenusTmpl: "#navMenusTml"
            });
            $.templates.navMenusTmpl.link("#moreMenu",page.params.navMenusData);
          },
        /**
         * 事件绑定
         */
         bindEvent:function() {
          menu_service._create();
          $('.js-activated').dropdownHover().dropdown();
          $(".sidebar").on("mouseover",function(e){
            $("body").removeClass("sidebar-collapse");
          })
          $(".sidebar").on("mouseleave",function(e){
            $("body").addClass("sidebar-collapse");
          })
          //放开二级标题
          $(".drawer-menu i.fc-outdent").on('click',function(e){
            $(".drawer-menu").css("width",0);
            $(".level2-menus").css("width",0);
            $(".level2-menus").css('display','none');
            $(this).css('display','none');
            $(".drawer-menu i.fc-indent").css('display','block');
            $(".sidebar-collapse .content-wrapper").removeClass("coll");
          });
          //收缩二级标题
          $(".drawer-menu i.fc-indent").on('click',function(e){
            $(".drawer-menu").css("width","150px");
            $(".level2-menus").css("width","150px");
            $(".level2-menus").css('display','block');
            $(this).css('display','none');
            $(".drawer-menu i.fc-outdent").css('display','block');
            $(".content-wrapper").addClass("coll");
          });
          //点击一级菜单的标题
          $("li.treeview").on("click",function(e){
            var id = $(this).data("index");
            $(".level2-menus").html($("#"+id).html());
            $(".drawer-menu i.fc-indent").click();
            $("li.treeview").each(function(){
              $(this).removeClass("active");
            });
            $(this).addClass("active");
            //点击二级菜单的标题(总标题)
            $(".level2-menus .level2-menu .level2-title").on("click",function(e){
              var index = $(this).data("index");
              $(".level2-menus .level2-menu ul.level2-content.item-"+index).toggleClass("hide");
              $(this).children("p").children("i").toggle2Classes("fc-down","fc-right");
            });
            //点击二级菜单(页面标题)
            $(".level2-menus .level2-menu .level2-content li a").on("click",function(e){
              $(".level2-content li .item").each(function(){
                $(this).removeClass("active");
              })
              $(this).parent().addClass("active");
            });
          });
        }
      };
      var service = {
        _queryAllTask:function(callBack){
          http.get({
            apiName: 'queryallmenu',
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
              callBack && typeof (callBack) == 'function' && callBack(data.data);
            },
            error:function(data){
              $("#moreMenu").empty();
              $("#moreMenu").html("");
            }
          })
        }
      };
      var menu_service = {

        options: {
          animationSpeed: 300,
          sidebar: '.level2-menus',
        },

        _create:function(callLayout) {
          window.$.sidebar_menu = $(".level2-menus")
          this._bindEvent();
        },
        _bindEvent:function() {
          $(document).on('click', this.options.sidebar + ' li a',
            $.proxy(this._handleClickMenu, this));
        },
        _handleClickMenu:function(event) {
          event.preventDefault();
          var _this = this,
          $this = $(event.currentTarget);
          var url = $this.attr("router");
          var title = $this.attr("title");
          this._handleUrl(url,title);
        },
        _handleUrl:function(url,title) {
          top.tabPages(url,title);
        }
      };
      return {
        initPage: $.proxy(page.initPage, page)
      };
    });
