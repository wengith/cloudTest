/**
 * 启动器
 */
 define([
    'jquery',
    'route_config',
    'fileinput',
    'theme',
    'dropdowns',
    'jsviews',
    'messages',
    'require',
    'domReady',
    'jquery-placeholder',
    'jquery_validate',
    'bootstrapui',
    'bootstrap-suggest',
    'icheck',
    'index',
    'zTree',
    'select2',
    //'templates/main/demo/router', //测试模块
    'templates/sysuser/router',
    'templates/layout/router',
    'templates/saa/router',
    'templates/sdd/router',
    'templates/monitor/router',
    'templates/zuul/router',
    'templates/sys/router',
    'templates/testexcel/router',
    'templates/quartz/router',
    'templates/select2/router',
    'templates/autoCompleteDemo/router',
    'templates/gateway/router',
    'templates/sms/router',
    'templates/demo/router',
    ], function($,route_config)  {
     var new_page = {
        _initPage:function() {
            window.$.body = $('body'),
            window.$.wrapper = $(window, "#wrapper"),
            window.$.content_wrapper = $('#content-wrapper'),
            window.$.window = $(window),
            window.$.main_header = $('#main-header'),
            window.$.main_footer = $('#main-footer'),
            window.$.main_content = $('#main-content')
        },
        dealUrlToObj:function(){
            var url = location.search; //该方法获取url中"?"符后的字符串
            var theRequest = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                var strs = str.split("&");
                for(var i = 0; i < strs.length-1; i ++) {
                    theRequest[strs[i].split("=")[0]]=decodeURIComponent((strs[i].split("=")[1]));
                }
            }
            return theRequest;
        },
        loadNewPage:function(){//组织新页面中的参数调用route_config中的loadData
            this._initPage();
            var theRequest=this.dealUrlToObj();
            var key = theRequest.url;
            for(var item in theRequest){
                if(item == "url"){
                    delete theRequest.url;
                }
            }
            var stateParams=theRequest;
            var opt={
                $container: $('#main-content'), //指定的容器；$.main_content已保存在全局变量，可以参考global_param.js
                isInitPage: true
            }
            route_config.loadNewPageData(key,stateParams,opt)
        },
    };
    return new_page;
});