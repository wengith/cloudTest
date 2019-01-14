
/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        //接口
        search_gateway: '/misc/gateway/intf/search',
        select_gateway: '/misc/gateway/intf/select/{id}',
        create_gateway: '/misc/gateway/intf/create',
        delete_gateway: '/misc/gateway/intf/delete/{ids}',
        //限流方案
        search_limit: '/misc/gateway/ratelimit/search',
        select_limit: '/misc/gateway/ratelimit/select/{id}',
        create_limit: '/misc/gateway/ratelimit/create',
        delete_limit: '/misc/gateway/ratelimit/delete/{ids}'
    });
    //配置路由函数
    route_config.state({
        name: 'gateway_intf_list',
        path: '/gateway/intf/list',
        viewNode: 'main-content',
        templateUrl: '../page/templates/gateway/intf/list.html',
        component: '../page/templates/gateway/intf/js/list'
    }).state({
        name: 'gateway_intf_edit',
        path: '/gateway/intf/edit',
        viewNode: 'main-content',
        templateUrl: '../page/templates/gateway/intf/edit.html',
        component: '../page/templates/gateway/intf/js/edit'
    }).state({
        name: 'gateway_ratelimit_list',
        path: '/gateway/ratelimit/list',
        viewNode: 'main-content',
        templateUrl: '../page/templates/gateway/ratelimit/list.html',
        component: '../page/templates/gateway/ratelimit/js/list'
    }).state({
        name: 'gateway_ratelimit_edit',
        path: '/gateway/ratelimit/edit',
        viewNode: 'main-content',
        templateUrl: '../page/templates/gateway/ratelimit/edit.html',
        component: '../page/templates/gateway/ratelimit/js/edit'
    })  
});