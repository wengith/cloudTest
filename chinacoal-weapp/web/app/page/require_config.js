if (typeof define !== 'function') {
  // to be able to require file from node
  var define = require('amdefine')(module);
}

function getSourceVersion() {
    try {
        return version;
    } catch (e) {
        console.log(e)
    }
    return "0";
}

/**
 * 配置requirejs
 * 模块路径缩写，版本管理
 */
define({
    urlArgs: "v=" + getSourceVersion(),
    baseUrl: 'page',
    paths: {
        'jquery': '../plugin/jquery1.11.1/jquery.min',
        'domReady': '../plugin/requirejs/domReady',
        'route_config': "./route_config",
        'jsviews': '../plugin/jsviews/jsviews.min',
        'jquery_validate': '../plugin/jquery.validate/jquery.validate',
        'jquery-placeholder': '../plugin/jquery-placeholder/jquery.placeholder',
        'bootstrapui': '../plugin/bootstrap/js/bootstrap.min',
        //选择框
       // 'select2':'../plugin/select2-master/dist/js/select2.min',
        'icheck': '../plugin/icheck-1.x/icheck.min',
        'bootbox': '../plugin/bootbox/4.4.0/bootbox',
        'dropdowns': '../plugin/dropdowns/dist/js/dropdowns-enhancement',
        'bootstrap-suggest': '../plugin/search/bootstrap-suggest.min',
        'slimscroll': '../plugin/slimScroll/jquery.slimscroll.min',
        'datetimepicker': '../plugin/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min',
        'messages': './i18n/messages_zh_cn',
		'jquery_form': '../plugin/jquery.form/jquery.form',
        'cropper': '../plugin/cropper/src/cropper',
        'ckeditor': '../plugin/ckeditor/ckeditor',
        'jquery_fly': '../plugin/fly/jquery.fly.min',
        'jquery-datatable': '../plugin/custom/jquery.dataTables.min',
        'bootstrap-editable':'../plugin/bootstrap3-editable-1.5.1/bootstrap3-editable/js/bootstrap-editable.min',
        'bootstrap-table':'../plugin/bootstrap-table/dist/bootstrap-table.min',
        'bootstrap-table-locale-zh':'../plugin/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min',
        'bootstrap-table-editable':'../plugin/bootstrap-table/dist/extensions/editable/bootstrap-table-editable.min',
        'fileinput':'../plugin/bootstrap-fileinput/js/fileinput',
        'fileinput-zh':'../plugin/bootstrap-fileinput/js/locales/zh',
        'theme':'../plugin/bootstrap-fileinput/themes/explorer/theme.min',
        'echarts':'../plugin/echarts/echarts',
        'echarts-gl':'../plugin/echarts/echarts-gl',
        'components': '../page/service/components',
        'bigautocomplete': '../plugin/jquery-bigautocomplete/js/jquery.bigautocomplete',
        'zTree':'../plugin/zTree_v3/js/jquery.ztree.all',
        'qrcode':'../plugin/jquery-qrcode/qrcode',
        'jquery-qrcode':'../plugin/jquery-qrcode/jquery.qrcode',
        'index': '../page/templates/layout/starter/index_init',
        'select2':'../plugin/select2-master/dist/js/select2.min',
        'ueditor':'../plugin/ueditor/ueditor.all',
        'ueditorConfig':'../plugin/ueditor/ueditor.config',
        'zeroclipboard': '../plugin/ueditor/third-party/zeroclipboard/ZeroClipboard',
        'autoComplete': '../plugin/jquery-ui-1.12.1.custom/jquery-ui.min',
        'bootstrap-tab': '../plugin/bootstrap-tab/js/bootstrap-tab',
        'address_select': '../plugin/jquery-addressselect/js/address_select'
    },
    waitSeconds: 0,
    shim: {
        'bootstrapui': ['jquery', 'autoComplete'],
        'icheck':['jquery'],
        'jquery_validate': ['jquery'],
        'messages': ['jquery', 'jquery_validate'],
        'jquery-placeholder': ['jquery'],
        'slimscroll': ['jquery'],
        'jsviews': ['jquery'],
        'datepicker': ['jquery', 'bootstrapui'],
        'bootbox': ['jquery', 'bootstrapui'],
        'dropdowns': ['jquery','bootstrapui'],
        'select2':['jquery'],
        'bootstrap-suggest': ['jquery', 'bootstrapui'],  
        'bootstrap-editable':['jquery','bootstrapui'],
        'bootstrap-table':['jquery','bootstrapui'],
        'bootstrap-table-locale':['jquery','bootstrap-table'],
        'bootstrap-table-editable':['jquery','bootstrap-table','bootstrap-editable'],
        'fileinput':['jquery','bootstrapui'],
        'theme':['jquery','fileinput'],
        'echarts':['jquery'],
        'echarts-gl':['jquery','echarts'],
        'jquery-datatable': ['jquery'],
        'components':['jquery'],
        'bigautocomplete': ['jquery'],
        'zTree':['jquery'],
        'qrcode':['jquery'],
        'jquery-qrcode':['qrcode'],
        'index': ['jquery','jsviews'],
        'ueditor': {
            //注意：此处的依赖顺序不能颠倒
            deps: ['zeroclipboard','ueditorConfig'],
            exports: 'UE',
            init:function(ZeroClipboard){
            //导出到全局变量，供ueditor使用
            window.ZeroClipboard = ZeroClipboard;
            }
        },
        'bootstrap-tab': ['jquery','bootstrapui']
    }
});
