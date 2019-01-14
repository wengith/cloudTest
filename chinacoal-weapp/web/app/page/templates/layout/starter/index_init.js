define(['jquery', 'widget/http','bootstrap-tab','service/jquery_extend'], function($, http) {
    var userData = {
        user: {
            code: '王蕴(3201000001) ',
            img: '../img/img/user1-128x128.jpg',
            name: '',
            work: false
        }
    }
    $(function() {
        $.templates({
            userDataTmpl: "#userDataTml"
        });
        userData.user.code = localStorage.getItem("username");
        userData.user.name = localStorage.getItem("nickname");
        $.templates.userDataTmpl.link("#userData", userData.user)

        var tbody = $("a.info");
        tbody.on('click', $.proxy(monitorDetail, this));
        require(['jquery','widget/http','route_config'], function($,http,route_config)  {
            route_config.innerRouterPage("/menu",$("#moreMenu"));
        });
    });

    function setCompanyVal(val) {
        $.observable(userData.user).setProperty("company", val);
    }
    function monitorDetail(event) {
        let $this = $(event.target),
        url = $this.data('id');
        dialog.page({
            title: '监控',
            modal_width: 1200,
            stateParams: {
                pageType: 'view',
                url: url
            }, //传输给新页面的数据；pageType比传；update,add,view
            loadUrl: '/monitor/admin/detail'
        });
    }
    function autoHeight(id){
        var h = document.documentElement.clientHeight;
        $("#"+id).each(function(index,element){
            element.style.height=h-75+"px"
        });
    }
    //页面刷新时加载首页
    localStorage.setItem("router", "/indexContent/indexContent");
    localStorage.setItem("newId", "home");
    $("#main-content").tabs({
        data: [{
            id: 'home',
            text: '首页',
            url: "./iframe.html"
        }]
    });
    autoHeight("home");
});