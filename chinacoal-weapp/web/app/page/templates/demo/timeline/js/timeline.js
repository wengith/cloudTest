/**
 * 用户查询模块
 */
define(['jquery', 'widget/table_data', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service','bootbox','widget/ajax_table','bootstrap-tab'],
 function($, table_data, dialog, route_config, http, util_service,bootbox,ajax_table)  {

    var page = {

        /**
         * 模块参数
         */
        params: {
            table_data: null, //数据表格引用
            pageNum:0,//滚动加载分页的页码
            pageListcount:5//滚动加载每页显示的条数
        },

        /**
         * 模块入口
         */
        initPage:function() {
            this.initData();
            //初始化数据表格

            this.bindEvent();
        },
        callSearch:function() {
            return false;
        },
        //初始化表格数据
        initData:function(){
            var myTemplate = $.templates("#queryFormTmpl");
            myTemplate.link("#main-content", app);

        },
        /**
         * 事件绑定
         */
        bindEvent:function() {
           
        },
        bts: [],
        /**
         * table的模板
         */
        
    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});
