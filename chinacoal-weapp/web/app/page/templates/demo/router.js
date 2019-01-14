
/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        search_sdd_type: '/misc/sdd/type/search',
        //消息
        findEurekaInstances:"/gateway/monitor/clients"

    });
    //配置路由函数
    route_config.state({
        name: 'demo_tags_date_tag',
        path: '/demo/tags/date_tag',
    }).state({
        name: 'demo_table_page',
        path: '/demo/table/table_page',
    }).state({
        name: 'demo_general',
        path: '/demo/general/general',
    }).state({
        name: 'demo_icons',
        path: '/demo/icons/icons',
    }).state({
        name: 'demo_buttons',
        path: '/demo/buttons/buttons',
    }).state({
        name: 'demo_timeline',
        path: '/demo/timeline/timeline',
    }).state({
        name: 'demo_modals',
        path: '/demo/modals/modals',
    })
});