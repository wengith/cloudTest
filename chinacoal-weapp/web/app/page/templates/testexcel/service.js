define(['widget/http'], function(http)  {
    var service = {};

    service.excelDownload = function(callBack) {
        http.post({
            apiName: 'excelDownload',
            type: 'POST',
            success:function(data) {
                bootbox.alert("下载成功");
                callBack && typeof (callBack) == 'function' && callBack(data.data);
            }
        })
    }; 

    return service;
});