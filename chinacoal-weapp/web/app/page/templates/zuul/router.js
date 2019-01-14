
/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        //接口
        search_zuul: '/misc/zuul/intf/search',
        select_zuul: '/misc/zuul/intf/select/{id}',
        create_zuul: '/misc/zuul/intf/create',
        delete_zuul: '/misc/zuul/intf/delete/{ids}',
        //限流方案
        search_limit1: '/misc/zuul/rtlimit/search',
        select_limit1: '/misc/zuul/rtlimit/select/{id}',
        create_limit1: '/misc/zuul/rtlimit/create',
        delete_limit1: '/misc/zuul/rtlimit/delete/{ids}'
    });
    //配置路由函数
    route_config.state({
        path: '/zuul/intf/list'
    }).state({
        path: '/zuul/intf/edit' 
    }).state({
        path: '/zuul/rtlimit/list'
    }).state({
        path: '/zuul/rtlimit/edit' 
    })  
});