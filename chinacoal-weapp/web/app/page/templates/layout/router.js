/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        "queryallmenu":"/misc/menus/systemMenu/platform",
        //消息
        "findEurekaInstances":"/gateway/monitor/clients"
    });
    //配置路由函数
    route_config.state({
        path: '/menu',
        name: 'menu',
        viewNode: 'main-content',
        templateUrl: '../page/templates/layout/elements/menu/menu.html',
        component: '../page/templates/layout/elements/menu/menu'
    }).state({//主页面信息
        path: '/indexContent/indexContent',
        name: 'index_content',
        viewNode: 'main-content',
        templateUrl: '../page/templates/layout/elements/indexContent/indexContent.html',
        component: '../page/templates/layout/elements/indexContent/indexContent'
    })
});