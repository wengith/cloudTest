/**
 * Bootstrap tab组件封装
 * @author billjiang  qq:475572229
 * @created 2017/7/24
 *
 */
(function ($, window, document, undefined) {
    'use strict';

    var pluginName = 'tabs';

    //入口方法
    $.fn[pluginName] = function (options) {
        var self = $(this);
        if (this == null)
            return null;
        var data = this.data(pluginName);
        if (!data) {
            data = new BaseTab(this, options);
            self.data(pluginName, data);
        }
        return data;
    };


    var BaseTab = function (element, options) {
        this.$element = $(element);
        this.options = $.extend(true, {}, this.default, options);
        this.init();
    }
    //默认配置
    BaseTab.prototype.default = {
        showIndex: 0, //默认显示页索引
        loadAll: true,//true=一次全部加在页面,false=只加在showIndex指定的页面，其他点击时加载，提高响应速度

    }

    //结构模板
    BaseTab.prototype.template = {
        ul_window: '<div style="float:left;width:94%;overflow:hidden;position: relative;" id="ulWindow"></div>',
        ul_nav: '<ul style="width:10000px;position:relative;left:0px" id="myTab" class="nav nav-tabs"></ul>',
        ul_li: '<li style="text-align:center"><a href="#{0}" data-toggle="tab"><span>{1}</span></a></li>',
        ul_li_close: '<i class="fa fa-remove closeable" title="关闭"></i>',
        div_content: '<div class="tab-content"></div>',
        div_content_panel: '<div class="tab-pane fade" id="{0}"></div>'
    }

    //初始化
    BaseTab.prototype.init = function () {
        if (!this.options.data || this.options.data.length == 0) {
            console.error("请指定tab页数据");
            return;
        }
        //当前显示的显示的页面是否超出索引
        if (this.options.showIndex < 0 || this.options.showIndex > this.options.data.length - 1) {
            console.error("showIndex超出了范围");
            //指定为默认值
            this.options.showIndex = this.default.showIndex;
        }
        //清除原来的tab页
        this.$element.html("");
        this.builder(this.options.data);
    }

    //使用模板搭建页面结构
    BaseTab.prototype.builder = function (data) {
        var ul_nav = $(this.template.ul_nav);
        var div_content = $(this.template.div_content);
        var ul_window = $(this.template.ul_window);
        for (var i = 0; i < data.length; i++) {
            //nav-tab
            var ul_li = $(this.template.ul_li.format(data[i].id, data[i].text));
            //如果可关闭,插入关闭图标，并绑定关闭事件
            if (data[i].closeable) {
                var ul_li_close = $(this.template.ul_li_close);

                ul_li.find("a").append(ul_li_close);
                ul_li.find("a").append("&nbsp;");
            }

            ul_nav.append(ul_li);
            ul_window.append(ul_nav);
            //div-content
            var div_content_panel = $(this.template.div_content_panel.format(data[i].id));


            div_content.append(div_content_panel);
        }

        this.$element.append(ul_window);
        this.$element.append(div_content);
        $("#ulWindow").before('<span id="tabLeft" style="border-radius:5px;cursor:pointer;float:left;width:3%;height:40px;display:block;line-height:40px;font-size:25px;text-align:center" aria-hidden="true">&laquo;</span>');
        $("#ulWindow").after('<span id="tabRight" style="border-radius:5px;cursor:pointer;float:left;width:3%;height:40px;display:block;line-height:40px;font-size:25px;text-align:center" aria-hidden="true">&raquo;</span>');
        this.loadData();
        //标签页向左箭头鼠标滑过变色事件
        $("#tabLeft").hover(function (){  
            $("#tabLeft").css("background-color","white");  
        },function (){  
            $("#tabLeft").css("background-color","");  
        });
        $("#tabRight").hover(function (){  
            $("#tabRight").css("background-color","white");  
        },function (){  
            $("#tabRight").css("background-color","");  
        });
        //标签页向左箭头点击事件
        var This=this;
        $("#tabLeft").on("click",function(){
            var ulWindowWidth = parseInt($("#ulWindow").width());
            var ulWidth = parseInt($("#myTab").width());
            var liWidth = parseInt($("#myTab li").width());
            var liLength = parseInt($("#myTab li").length);
            var liTotalWidth = This.countLiTotalWidth();
            var left = parseInt($("#myTab").css("left"));
            var leftMove = left+ulWindowWidth;
            if(leftMove <=0){
                //$("#myTab").css("left",leftMove);
                $("#myTab").animate({left:leftMove});
            }else{
                //$("#myTab").css("left",0);
                $("#myTab").animate({left:0});
            }
            
        });
        //标签页向右箭头点击事件
        $("#tabRight").on("click",function(){
            //alert("left")
            var ulWindowWidth = parseInt($("#ulWindow").width());
            var ulWidth = parseInt($("#myTab").width());
            var liWidth = parseInt($("#myTab li").width());
            var liLength = parseInt($("#myTab li").length);
            var liTotalWidth = This.countLiTotalWidth();
            var left = parseInt($("#myTab").css("left"));
            var rightMove = left-ulWindowWidth;
            if (ulWindowWidth-liTotalWidth < 0) {
                if(rightMove > ulWindowWidth-liTotalWidth){
                    //$("#myTab").css("left",rightMove);
                    $("#myTab").animate({left:rightMove});
                }else{
                    //$("#myTab").css("left",ulWindowWidth-liTotalWidth);
                    $("#myTab").animate({left:ulWindowWidth-liTotalWidth});
                }
            }  
        });
        this.$element.find(".nav-tabs li:eq(" + this.options.showIndex + ") a").tab("show");

    }

    BaseTab.prototype.loadData = function () {
        var self = this;

        //tab点击即加载事件
        //设置一个值，记录每个tab页是否加载过
        this.stateObj = {};
        var data = this.options.data;
        //如果是当前页或者配置了一次性全部加载，否则点击tab页时加载
        for (var i = 0; i < data.length; i++) {
            if (this.options.loadAll || this.options.showIndex == i) {
                if (data[i].url) {
                    $("#" + data[i].id).load(data[i].url,data[i].param);
                    this.stateObj[data[i].id] = true;
                } else {
                    console.error("id=" + data[i].id + "的tab页未指定url");
                    this.stateObj[data[i].id] = false;
                }
            } else {
                this.stateObj[data[i].id] = false;
                (function (id, url,paramter) {
                    self.$element.find(".nav-tabs a[href='#" + id + "']").on('show.bs.tab', function () {
                        if (!self.stateObj[id]) {
                            $("#" + id).load(url,paramter);
                            self.stateObj[id] = true;
                        }
                    });
                }(data[i].id, data[i].url, data[i].paramter))
            }
        }

        //关闭tab事件
        this.$element.find(".nav-tabs li a i.closeable").each(function (index, item) {
            $(item).click(function () {
                var href = $(this).parents("a").attr("href").substring(1);
                if(self.getCurrentTabId()==href){
                    self.$element.find(".nav-tabs li:eq(0) a").tab("show");
                }
                $(this).parents("li").remove();
                $("#" + href).remove();
            })
        });

    }

    //新增一个tab页
    BaseTab.prototype.addTab=function (obj) {
        var self=this;
        //nav-tab
        var ul_li = $(this.template.ul_li.format(obj.id, obj.text));
        //如果可关闭,插入关闭图标，并绑定关闭事件
        if (obj.closeable) {
            var ul_li_close = $(this.template.ul_li_close);

            ul_li.find("a").append(ul_li_close);
            ul_li.find("a").append("&nbsp;");
        }
        
        this.$element.find(".nav-tabs:eq(0)").append(ul_li);
        //div-content
        var div_content_panel = $(this.template.div_content_panel.format(obj.id));
        this.$element.find(".tab-content:eq(0)").append(div_content_panel);
        $("#" + obj.id).load(obj.url,obj.paramter);
        this.stateObj[obj.id] = true;

        if(obj.closeable){
            this.$element.find(".nav-tabs li a[href='#" + obj.id + "'] i.closeable").click(function () {
                var href = $(this).parents("a").attr("href").substring(1);
                var activeNumber = self.getCurrentTabNumber();
                var currentNumber = $(this).parents("a").parents("li").index();
                var currentLiWidth = $(".nav-tabs li")[currentNumber].offsetWidth;
                var cssLeft = parseInt($("#myTab").css("left"));
                if (cssLeft < -currentLiWidth) {
                    $("#myTab").animate({left:cssLeft+currentLiWidth});
                }else{
                    $("#myTab").animate({left:0});
                }
                var showNumber = currentNumber-1;
                if(activeNumber == currentNumber){
                    $(this).parents("li").remove();
                    $("#" + href).remove();
                    localStorage.removeItem(obj.id);
                    self.$element.find(".nav-tabs li:eq("+showNumber+") a").tab("show"); 
                }else{
                    $(this).parents("li").remove();
                    $("#" + href).remove();
                    localStorage.removeItem(obj.id);
                }
            })
        }
        //标签页新增标签时的换页事件
        var ulWindowWidth = parseInt($("#ulWindow").width());
        var ulWidth = parseInt($("#myTab").width());
        //var liWidth = parseInt($("#myTab li").width());
        var liLength = parseInt($("#myTab li").length);
        var liTotalWidth = this.countLiTotalWidth();
        var currentUlLeft = parseInt($("#myTab").css("left"));
        if (liTotalWidth >= ulWindowWidth) {
            var leftMove = ulWindowWidth-liTotalWidth;
            $("#myTab").css("left",leftMove);
        }
        this.$element.find(".nav-tabs a[href='#" + obj.id + "']").tab("show");
    }

    //根据id获取活动也标签名
    BaseTab.prototype.find=function (tabId) {
        return this.$element.find(".nav-tabs li a[href='#" + tabId + "']").text();
    }
    
    // 删除活动页
    BaseTab.prototype.remove=function (tabId) {
    	var self=this;
        $("#" + tabId).remove();
        this.$element.find(".nav-tabs li a[href='#" + tabId + "']").parents("li").remove();
    }
    
    // 重新加载页面
    BaseTab.prototype.reload=function (obj) {
    	var self=this;
    	if(self.find(obj.id)!=null){
    		$("#" + obj.id).remove();
    		this.$element.find(".nav-tabs li a[href='#" + obj.id + "']").parents("li").remove();
    		self.addTab(obj);
    	}else{
    		self.addTab(obj);
    	}
    }

    //根据id设置活动tab页
    BaseTab.prototype.showTab=function (tabId) {
        this.$element.find(".nav-tabs li a[href='#" + tabId + "']").tab("show");
    }

    //获取当前活动tab页的ID
    BaseTab.prototype.getCurrentTabId=function () {
        var href=this.$element.find(".nav-tabs li.active a").attr("href");
        href=href.substring(1);
        return href;
    }
    //获取当前活动tab页的序号
    BaseTab.prototype.getCurrentTabNumber=function () {
        var number=this.$element.find(".nav-tabs li.active").index();
        return number;
    }
    //获取当前li全部宽度的方法
     BaseTab.prototype.countLiTotalWidth=function () {
        var sumWidth =0;
        var liList = $("#myTab li")
        for (var i = 0; i < liList.length; i++) {
            sumWidth += parseInt(liList[i].offsetWidth);
        }
        return sumWidth;
    }
    String.prototype.format = function () {
        if (arguments.length == 0) return this;
        for (var s = this, i = 0; i < arguments.length; i++)
            s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
        return s;
    };
})(jQuery, window, document)
