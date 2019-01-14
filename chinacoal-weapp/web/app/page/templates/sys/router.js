
/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        //接口
        search_menu: '/misc/menus/search',
        select_menu: '/misc/menus/select/{id}',
        load_menu: '/misc/menus/load/{id}',
        create_menu: '/misc/menus/create',
        delete_menu: '/misc/menus/delete/{ids}',
        sys_menu_set_node:"/misc/menus/setTreeNode/{systemCode}",
        add_sys_menu:"/misc/menus/create",
        delete_sys_menu:"/misc/menus/delete/{ids}",
    });
    //配置路由函数
    route_config.state({
        path: '/sys/menu/list'
    }).state({
        path: '/sys/menu/edit' 
    }).state({
        name: 'sys_menu_setting',
        path: '/sys/menu/setting',
        viewNode: 'main-content',
        templateUrl: '../page/templates/sys/menu/menu_setting.html',
        component: '../page/templates/sys/menu/js/menu_setting',
    }).state({
        name: 'sys_menu_edit',
        path: '/sys/menu/edit',
        viewNode: 'main-content',
        templateUrl: '../page/templates/sys/menu/edit.html',
        component: '../page/templates/sys/menu/js/edit',
    })
});