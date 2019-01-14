var _international = null;
Date.prototype.Format = function(fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份   
        "d+": this.getDate(), //日   
        "h+": this.getHours(), //小时   
        "m+": this.getMinutes(), //分   
        "s+": this.getSeconds(), //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds() //毫秒   
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
if (!Array.prototype.indexOf) {
    Array.prototype.indexOf = function(elt /*, from*/ ) {
        var len = this.length >>> 0;

        var from = Number(arguments[1]) || 0;
        from = (from < 0) ? Math.ceil(from) : Math.floor(from);
        if (from < 0)
            from += len;
        for (; from < len; from++) {
            if (from in this && this[from] === elt)
                return from;
        }
        return -1;
    };
}!window.console && (window.console = {
    log: function() {
        window.console.log();
    },

    info: function() {
        window.console.info();
    }
});
window.system = {
    println: function(msg, mou) {
        return console.info(mou + ':', msg);
    }
};
//iframe标签的id
var num = 1;//用于使id中的最后一位的计数，不重复
function productId(router){
    var id = router.replace(/\//g, "_")+"-"+num;
    num++;
    return id;

}
//判断该标签页是否已经存在，通过id去寻找参数进行比对，没有参数的通过id进行比对只能存在一个
function isExistInTabs(router,stateParams){
    var result = "";
    var shortId = router.replace(/\//g, "_");
    var url = "new_page.html?url="+router+"&";
    var iframeList = $(".tab-content iframe[src='new_page.html?url=" + router + "&']")
    if(iframeList.length!=0){
        for (var i = 0; i < iframeList.length; i++) {
            var idKey = iframeList[i].id;
            if(localStorage.getItem(idKey)){
                var c=localStorage.getItem(idKey);
                var d=JSON.stringify(stateParams);
                if(c == d){
                    result = iframeList[i].id;
                    break;
                }else{
                    result = "new";
                }
            }else{
                result = iframeList[i].id;
            }
        }
    }else{
        result = "new";
    }
    return result;
}
function autoHeight($this){
    $this.height=document.documentElement.clientHeight-75;
}
//标签页的创建方法
function tabPages(router, tabTitle, stateParams) {
    var id = productId(router);
    localStorage.setItem("router", router);
    localStorage.setItem("newId", id);
    var isExist =  isExistInTabs(router,stateParams);
    if (isExist != "new") {
        //新打开页面时不刷新，展示当前页面
        $(".nav-tabs li a[href='#" + isExist + "']").tab("show");
        //新打开页面刷新，localStorage中的参数也进行刷新（后台数据库有改动时）
        /*localStorage.setItem(isExist, JSON.stringify(stateParams));
        var liIndex = $(".tab-content #"+isExist+" ").index();
        var iframeId = $(".tab-content div:eq(" + liIndex + ") iframe").attr("id").split("-")[0];
        var iframeRouter = iframeId.replace(/_/g, "/");
        var router = $(".tab-content div[id='" + isExist + "'] iframe").attr('src');
        $(".tab-content div[id='" + isExist + "'] iframe").remove();
        $(".tab-content div[id='" + isExist + "']").html('<iframe style="width: 100%;height:600px;boxder:none" frameborder="0" src="' + router + '" id="' + isExist + '"></iframe>');
        $(".nav-tabs li a[href='#" + isExist + "']").tab("show");*/
    } else {
        var main = $("#main-content");
        if (stateParams != null) {
            localStorage.setItem(id, JSON.stringify(stateParams));
        }else{
            top.setStateParamsLocal(id, "");
        }
        var iframe = $("#" + id + " iframe");
        if (iframe.length == 0) {
            main.data("tabs").addTab({
                id: id,
                text: tabTitle,
                closeable: true,
                url: "./iframe.html"
            })
        }
        document.oncontextmenu = function() {
            return false;
        };
        $('#myTab a').mousedown(function(e) {
            if (3 == e.which) {
                //获取右键点击坐标
                var x = e.clientX;
                var y = e.clientY;
                //获取menu的长宽
                var menuHeight = $(".popUpMenu").height();
                var menuWidth = $(".popUpMenu").width();
                //获取浏览器的可见长宽
                var clintHeight = getClientHeight();
                var clintWidth = getClientWidth();
                //判断
                if (menuHeight + y >= clintHeight) {
                    y = clintHeight - menuHeight - 8;
                }
                if (menuWidth + x >= clintWidth) {
                    x = clintWidth - menuWidth - 8;
                }
                //之前必须要绝对定位才行
                $(".popUpMenu").show().css({
                    left: x,
                    top: y
                });
            }
        });
    }

}
//点击空白隐藏鼠标右键
$(document).click(function() {
    $(".popUpMenu").hide();
});

//标签页右击菜单点击响应事件
function jy_menu(i) {
    switch (i) {
        case 0: //刷新
            var liIndex = $("#myTab .active ").index();
            var iframeId = $(".tab-content div:eq(" + liIndex + ") iframe").attr("id");
            var iframeRouter = iframeId.replace(/_/g, "/");
            var router = $(".tab-content div[id='" + iframeId + "'] iframe").attr('src');
            $(".tab-content div[id='" + iframeId + "'] iframe").remove();
            $(".tab-content div[id='" + iframeId + "']").html('<iframe style="width: 100%;height:600px;boxder:none" frameborder="0" src="' + router + '" id="' + iframeId + '"></iframe>');
            //$(".tab-content div[id='"+iframeId+"'] iframe").attr('src',$(".tab-content div[id='"+iframeId+"'] iframe").attr('src'));
            break;
        case 1: //刷新全部页面
            var liList = $("#myTab li");
            for (var i = 1; i < liList.length; i++) {
                var tabId = $(".tab-content div:eq(" + i + ")").attr("id");
                var tabRouter = $(".tab-content div:eq(" + i + ") iframe").attr('src')
                $(".tab-content div:eq(" + i + ") iframe").remove();
                $(".tab-content div:eq(" + i + ")").html('<iframe style="width: 100%;height:600px;boxder:none" frameborder="0" src="' + tabRouter + '" id="' + tabId + '"></iframe>');
            }
            break;
        case 2: //关闭当前页
            var closeNumber = $("#myTab .active").index();
            var currentLiWidth = $(".nav-tabs li")[closeNumber].offsetWidth;
            var cssLeft = parseInt($("#myTab").css("left"));
            if (cssLeft < -currentLiWidth) {
                $("#myTab").animate({
                    left: cssLeft + currentLiWidth
                });
            } else {
                $("#myTab").animate({
                    left: 0
                });
            }
            if (closeNumber != 0) {
                var showNumber = $("#myTab .active").index() - 1;
                var idSession = $(".tab-content div:eq(" + closeNumber + ")").attr("id");
                localStorage.removeItem(idSession);
                $(".nav-tabs li:eq(" + closeNumber + ")").remove();
                $(".tab-content div:eq(" + closeNumber + ")").remove();
                $(".nav-tabs li:eq(" + showNumber + ") a").tab("show");
            }
            break;
        case 3: //关闭其他页
            var idActive = $("#myTab .active a").attr("href");
            var liList = $("#myTab li");
            for (var i = liList.length - 1; i > 0; i--) {
                var href = $("#myTab li:eq(" + i + ") a").attr("href");
                var id = $("#myTab li:eq(" + i + ") a").attr("href").substring(1);
                if (href != idActive) {
                    $(".nav-tabs li a[href='" + href + "']").parents("li").remove()
                    $(".tab-content div[id='" + id + "']").remove()
                    localStorage.removeItem(id);
                }
            }
            $("#myTab").animate({
                left: 0
            });
            break;
    }
}
// 浏览器的可见高度
function getClientHeight() {
    var clientHeight = 0;
    if (document.body.clientHeight && document.documentElement.clientHeight) {
        clientHeight = (document.body.clientHeight < document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    } else {
        clientHeight = (document.body.clientHeight > document.documentElement.clientHeight) ? document.body.clientHeight : document.documentElement.clientHeight;
    }
    return clientHeight;
}

// 浏览器的可见宽度
function getClientWidth() {
    var clientWidth = 0;
    if (document.body.clientWidth && document.documentElement.clientWidth) {
        clientWidth = (document.body.clientWidth < document.documentElement.clientWidth) ? document.body.clientWidth : document.documentElement.clientWidth;
    } else {
        clientWidth = (document.body.clientWidth > document.documentElement.clientWidth) ? document.body.clientWidth : document.documentElement.clientWidth;
    }
    return clientWidth;
}

function setStateParamsLocal(key, stateParams) {
    if (key && localStorage.getItem(key)) {
        var state = JSON.parse(localStorage.getItem(key));
        state.stateParams = stateParams;
        if (key == state.name) {
            state[state.path].stateParams = stateParams;
        } else {
            state.name && (JSON.parse(localStorage.getItem(state.name)).stateParams = stateParams);
        }
        localStorage.setItem(key, JSON.stringify(state));
    }
};


function getStateParamsLocal(key) {
    var params = {};
    if (!key || key == '') {
        key = localStorage.getItem("router");
    }
    var obj = JSON.parse(localStorage.getItem(key));
    if (obj) {
        params = obj.stateParams || {};
    }
    return params;
}

// 重新登录按钮事件
$("#logout").click(function(event){
    var storage=window.localStorage.clear();
    window.location='login.html';
});

(function($) {
    // obtain requirejs config
    require(['require', './page/require_config'], function(require, config) {

        // set cache beater
        //config.urlArgs = "v=1.0.0";

        // update global require config
        window.require.config(config);

        // load app
        require(['./page/bootstrap_index.js']);
    });

})();