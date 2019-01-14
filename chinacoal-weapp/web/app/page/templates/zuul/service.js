'use strict';

/**
 * 管理模块服务 
 */
define(['widget/http'], function (http) {
    var service = {};

    service.search_zuul = function (id, callBack) {
        http.get({
            apiName: 'search_zuul',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_zuul = function (id, callBack) {
        http.get({
            apiName: 'select_zuul',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.search_limit = function (id, callBack) {
        http.get({
            apiName: 'search_limit1',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_limit = function (id, callBack) {
        http.get({
            apiName: 'select_limit1',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };

    return service;
});