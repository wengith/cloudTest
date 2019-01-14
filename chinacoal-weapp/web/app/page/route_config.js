/**
 * 路由配置模块
 * @author
 * @time
 */
define(['jquery', 'widget/http'], function($, http)  {
    var api = new Array(0);
    var api_service = {};
    var temps_service = {};
    var route_config = {
        api_service: api_service,
        temps_service: temps_service,
        router: {},
        defacltKey: null,
        state:function(obj) {
            if (obj) {
                var r = {};
                if(obj.viewNode==null){
                    obj.viewNode='main-content';
                }
                var pos = obj.path.lastIndexOf("/");
                if(pos>0){ //对于符合规则的自动进行惯例生成
                    var strModule = obj.path.substring(0,pos);
                    var strPage = obj.path.substring(pos+1);
                    if(obj.name==null)
                    {
                        obj.name=obj.path.replace(/\//g, "_");
                        if(/*obj.name.startsWith("_")*/obj.name.slice(0, 1) === "_"){
                            obj.name=obj.name.substring(1);
                        }
                    }
                    if(obj.templateUrl==null)
                    {
                        obj.templateUrl='../page/templates' + obj.path+'.html';
                    }
                    if(obj.component==null)
                    {
                        obj.component='../page/templates' + strModule + '/js/'+strPage;
                    }
                }
                r[obj.path] = obj;
                obj.name && (r[obj.name] = obj); 
                /*Object.assign(this.router, r);*/
                for (var item in r){
                    this.router[item]=r[item]
                    /*if(sessionStorage.getItem(item)==null){
                        sessionStorage.setItem(item,JSON.stringify(r[item]));
                    }*/
                }
            }
            return this;
        },

        api:function(obj) {
            api_service.setApi(obj);
        },
        setStateParams:function(key, stateParams) {
            if (key && this.router[key]) {
                this.router[key].stateParams = stateParams
                if (key == this.router[key].name) {
                    this.router[this.router[key].path].stateParams = stateParams;
                } else {
                    this.router[key].name && (this.router[this.router[key].name].stateParams = stateParams);
                }

            }
        },
        getRouter:function(key) {
            var obj = null;
            if (this.router[key]) {
                obj = {
                    name: this.router[key].name,
                    dom: '#' + this.router[key].viewNode,
                    templateUrl: this.router[key].templateUrl,
                    component: this.router[key].component
                }
            }
            return obj;
        },

        go:function(key, stateParams, opt) {
            if (key && key != '' && key!='undefined') {
                var obj = this.getRouter(key);
                this.defacltKey = key;
                if (obj) {
                    this.setStateParams(key, stateParams);
                    var tempsCount = 0;
                    var $thisDeffered = $.Deferred();
                    if (obj.templates) {
                        for (var i = 0; i < obj.templates.length; i++) {
                            this.innerInTemplate(obj.templates[i], function () {
                                tempsCount++;
                                if (tempsCount == obj.templates.length) {
                                    $thisDeffered.resolve();
                                }
                            });
                        }
                    } else {
                        $thisDeffered.resolve();
                    }
                    $thisDeffered.done(function () {
                        http.loadPage($.extend({
                            pageUrl: obj.templateUrl,
                            isInitPage: true,
                            type: 'GET',
                            async: true,
                            defacltKey: key,
                            $container: obj.dom == 'main-content' ? null : $(obj.dom),
                            component: obj.component
                        }, opt || {}));
                    })
                } else {
                    console.log('-----异常：key值为' + key + '的路由不存在------');
                }
            } else {
                console.log('-----异常：key值为' + key + '------');
            }
        },
        findTempFileNameInUrl(urlString){
            if (!urlString) return "";
            return urlString.substring(urlString.lastIndexOf("/") + 1, urlString.lastIndexOf("."));
        },
        innerInTemplate(tempUrl, callBack){
            if ($("#div" + tempName).length > 0) {
                callBack();
            }
            var tempName = this.findTempFileNameInUrl(tempUrl);
            $("body").append("<div id='div" + tempName + "'></div>");
            http.loadPage({
                pageUrl: tempUrl,
                isInitPage: false,
                type: 'GET',
                async: true,
                $container: $("#div" + tempName),
                component: false,
                success: callBack
            });
        },
        /**
         * 执行window.open方法打开新的页面
         */
        goNewPage:function(stateParams) {
            var realUrl = this.dealParams("../new_page.html",stateParams);
            window.open(realUrl);
        },
        /**
         * 加载新页面时访问ajax的方法
         */
        loadNewPageData:function(key, stateParams, opt){
            if (key && key != '') {
                var obj = this.getRouter(key);
                console.log($(obj.dom))
                this.defacltKey = key;
                if (obj) {
                    this.setStateParams(key, stateParams);
                    http.loadPage($.extend({
                        pageUrl: obj.templateUrl,
                        isInitPage: true,
                        type: 'GET',
                        defacltKey: key,
                        $container: obj.dom == 'newMain-content' ? null : $(obj.dom),
                        component: obj.component
                    }, opt || {}));
                } else {
                    console.log('-----异常：key值为' + key + '的路由不存在------');
                }
            } else {
                console.log('-----异常：key值为' + key + '------');
            }
        },
        /**
         * 处理参数将参数和路径拼接在一起
         */
        dealParams:function(url,params){
            var realUrl = url+"?";
            for(var i in params){
                realUrl += i + "=" + params[i] + "&";
            }
            realUrl.slice(0,realUrl.length-1)
            return realUrl
        },
        innerRouterPage:function(routerKey,viewNode,params) {
            var _params = $.extend(this.getStateParams(routerKey) || {},params || {});
            this.go(routerKey, _params, {
                $container: viewNode,
                isInitPage: true
            });
        },
        innerTemplate(tempName, callBack) {
            $("body").append("<div id='div" + tempName + "'></div>");
            http.loadPage({
                pageUrl: temps_service.getTemp(tempName),
                isInitPage: false,
                type: 'GET',
                async: true,
                $container: $("#div" + tempName),
                component: false,
                success: callBack
            });
        },
        /**
         * 获取页面传输参数对像
         */
        getStateParams:function(key) {
            var params = {};
            if (!key || key == '') {
                key = this.defacltKey;
            }
            var obj = this.router[key];
            if (obj) {
                params = obj.stateParams || {};
            }
            return params;
        },
        /**
         * 首页标签页跳转判断方法，是当前页面跳转还是打开新的标签页
         */
        tabs:function(router,title,params,openWay) {
            //var obj = this.getRouter(router);
            if (openWay != "localTabs") {
                top.tabPages(router,title,params);
            } else {
                this.go(router,params, {
                    $container: $.main_content, //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                    isInitPage: true
                });
            }
        },
        /**
         * 首页标签页获取id中的参数的方法
         */
        getParams:function(){
            var params = {};
            var frameId = window.frameElement && window.frameElement.id || '';//获取当前iframe的id值
            params = JSON.parse(localStorage.getItem(frameId));
            if (jQuery.isEmptyObject(params)) {
                params = this.getStateParams()
            }
            return params;
        },
        /**
         * 首页标签页获取iframe标签中的src属性中的参数的方法
         */
        getIframeSrcParams:function(){
            var url = $("iframe").context.URL;
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.split("?")[1];
                strs = str.split("&");
                for(var i = 0; i < strs.length; i ++) {
                    theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
                }
            }
            return theRequest;
            
        }
    }



    /**
     * 获取api
     * @method get
     * @param {String} cgi_name cgi名
     * @param {Object} params 参数 optional
     * @param {Bool} cache 是否使用cache, 默认false optional
     * @param {String} domain 域名  optional
     * @return {String} url地址
     */
    api_service.get = function(api_name, params, cache, url_params, domain)  {
        var configUrl = api[api_name];
        var url = new Array(0);

        //通过Nginx代理转发，所有请求添加前缀"/api"
        url[0] = "/api" + configUrl; 
        if (!url) {
            console.log('请求的cgi：' + api_name + ' 不存在');
            return '';
        }
        //console.log(url);
        if (url_params && typeof url_params == "object") {
            var re;
            for (var name in url_params) {
                re = new RegExp('{' + name + '}', 'g');
                url[0] = url[0].replace(re, url_params[name]);
            }
        }
        if (params && url[0].indexOf("?") === -1) {
            url.push("?");
        }
        if (typeof params == "string") {
            url.push(params);
        } else if (typeof params == "object") {
            for (var key in params) {
                var temp = url.join("");
                if(temp.substring(temp.length-1,temp.length)=="?"){
                    url.push(key + "=" + params[key]);
                }
                else{
                    url.push("&" + key + "=" + params[key]);
                }
            }
        }
        /*if (cache) {
            if (url.join("").indexOf("?") === -1) {
                url.push("?t=" + new Date().getTime())
            } else {
                url.push("&t=" + new Date().getTime());
            }

        }*/
        var realUrl = url.join("");
        //console.log("Request URL="+realUrl);

        return realUrl;
    };

    api_service.setApi = function(obj)  {
        for (var item in obj){
            api[item]=obj[item]
        }
        //api = Object.assign(api, obj || {});(IE不支持该方法)

    }
    temps_service.getTemp = (tempName) => {
        return temps[tempName] || "";
    };
    temps_service.setTemp = (obj) => {
        temps = Object.assign(temps, obj || {});
    };
    return route_config;
});
