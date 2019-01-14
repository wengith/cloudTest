/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({
        //查询短信模板
		search_template: '/misc/sms/template/search',
		//更新模板
		update_template: '/misc/sms/template/update',
		//获取短信模板
		select_template: '/misc/sms/template/select/{id}',
		//新增或者修改模板
		create_template: '/misc/sms/template/create',
		//删除模板
		delete_template: '/misc/sms/template/delete/{ids}'
    });
    //配置路由函数
    route_config.state({
        path: '/sms/template/list'
    }).state({
        path: '/sms/template/edit'
        
    }) 
});