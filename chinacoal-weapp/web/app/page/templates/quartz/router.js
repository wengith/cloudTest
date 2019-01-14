/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        //更新定时任务
        update_quartz: '/misc/quartz/updateQuartz',
        //通过主键获取定时任务
        select_quartz: '/misc/quartz/selectQuartzById/{id}',
        //增加定时任务
        create_quartz: '/misc/quartz/addQuartz',
        //按条件查找定时任务
        search_quartz: '/misc/quartz/findQuartz',
        //删除定时任务
        delete_quartz: '/misc/quartz/deleteQuartz/{id}',
        //改变定时任务运行状态
        changeRunStatus_quartz: '/misc/quartz/changeRunStatus/{id}'
    });
    //配置路由函数
    route_config.state({
        // 注意：注释的部分按照惯例根据path生成，如果有不同则自行配置
        // name: 'sysuser_user_list',
        // viewNode: 'main-content',
        // templateUrl: '../page/templates/sysuser/user/list.html',
        // component: '../page/templates/sysuser/user/js/list',
        path: '/quartz/quartzPage/list',
        name: 'list',
        viewNode: 'main-content',
        templateUrl: '../page/templates/quartz/quartzPage/list.html',
        component: '../page/templates/quartz/quartzPage/js/list'
    }).state({
        path: '/quartz/quartzPage/edit', 
        name: 'edit',
        viewNode: 'main-content',
        templateUrl: '../page/templates/quartz/quartzPage/edit.html',
        component: '../page/templates/quartz/quartzPage/js/edit'
    })
});
