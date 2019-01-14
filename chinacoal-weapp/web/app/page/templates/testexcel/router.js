/**
 * 上传excel路由
 * @author
 * @time 
 */
define(["route_config"], function(route_config)  {
    //设置api
    route_config.api({

        excelUpload:'/misc/excel/test/upload',
        excelDownload:'/misc/excel/test/download'

    });
    //配置路由函数
    route_config.state({
        path: '/testexcel/showexcel/show/excel',
        name: 'testexcel_showexcel_show_excel',
        viewNode: 'main-content',
        templateUrl: '../page/templates/testexcel/showexcel/show_excel.html',
        component: '../page/templates/testexcel/showexcel/js/show_excel' ,
    }).state({
        path: '/excel/test/download' 
    });

});