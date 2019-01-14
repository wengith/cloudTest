'use strict';

/**
 * 管理模块服务 
 */
define(['widget/http'], function (http) {
    var service = {};

    service.search_gateway = function (id, callBack) {
        http.get({
            apiName: 'search_gateway',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_gateway = function (id, callBack) {
        http.get({
            apiName: 'select_gateway',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.search_limit = function (id, callBack) {
        http.get({
            apiName: 'search_limit',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_limit = function (id, callBack) {
        http.get({
            apiName: 'select_limit',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    return service;
});