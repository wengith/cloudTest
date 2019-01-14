'use strict';

/**
 * 管理模块服务 
 */
define(['widget/http'], function (http) {
    var service = {};

    service.search_menu = function (id, callBack) {
        http.get({
            apiName: 'search_menu',
            urlParams: { value: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };
    service.select_menu = function (id, callBack) {
        http.get({
            apiName: 'select_menu',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };

    service.load_menu = function (id, callBack) {
        http.get({
            apiName: 'load_menu',
            urlParams: { id: id },
            success: function success(data) {
                callBack && typeof callBack == 'function' && callBack(data.data);
            }
        });
    };

    return service;
});