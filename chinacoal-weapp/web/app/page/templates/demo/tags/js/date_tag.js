
/**
 * 用户查询模块
 */
define(['jquery', 'widget/dialog', 'route_config', 'widget/http', 'service/util_service', 'bootbox','widget/link_tool','widget/ins_search','address_select'], function ($, dialog, route_config, http, util_service, bootbox,link_tool,ins_search,address_select) {

    var page = {

        /**
         * 模块参数
         */
        params: {
            table_data: null //数据表格引用
        },

        /**
         * 模块入口
         */
       initPage:function() {
            this.initData();
        },
        callSearch:function() {
            return true;
        },

       //初始化表格数据
        initData:function(){
            $.templates("#dateTagTmpl").link("#date_tag",{});
        },
    };

    return {
        initPage: $.proxy(page.initPage, page),
        search:function() {
            page && page.params && page.params.table_data && page.params.table_data._showPage(null, null, true);
        }
    };
});