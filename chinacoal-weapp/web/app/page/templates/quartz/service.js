/**
 * 管理模块服务 
 */
define(['widget/http'], function(http)  {
    var service = {};

    service.search_quartz = function(id, callBack) {
        http.get({
            apiName: 'search_quartz',
            urlParams: {value: id},
            success:function(data) {
                callBack && typeof (callBack) == 'function' && callBack(data.data);
            }
        })
    }; 
    service.select_quartz = function(id, callBack)  {
        http.get({
            apiName: 'select_quartz',
            urlParams: {id: id},
            success:function(data) {
                callBack && typeof (callBack) == 'function' && callBack(data.data);
            }
        })
    }; 
    service.delete_quartz = function(id, callBack)  {
        http.get({
            apiName: 'delete_quartz',
            urlParams: {id: id},
            success:function(data) {
                callBack && typeof (callBack) == 'function' && callBack(data.data);
            }
        })
    }; 
    service.changeRunStatus_quartz = function(id, callBack)  {
        http.get({
            apiName: 'changeRunStatus_quartz',
            urlParams: {id: id},
            success:function(data) {
                callBack && typeof (callBack) == 'function' && callBack(data.data);
            }
        })
    }; 
    return service;
});
