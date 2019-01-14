/**
 * 管理模块服务 
 */
define(['widget/http'], function (http) {
    var service = {};

    service.search_template = function (id, callBack) {
        http.get({
            apiName: 'search_template',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_template = function (id, callBack) {
        http.get({
            apiName: 'select_template',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    return service;
});