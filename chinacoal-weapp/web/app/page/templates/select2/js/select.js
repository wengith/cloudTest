define(['jquery',  'service/util_service','widget/ajax_form', 'widget/select2','route_config', 'bootbox'], function ($,util_service,ajax_form,select2, route_config, bootbox) {
   


    var page = {

        params: {
            select2: null //数据表格引用
        },

        /**
         * 模块参数
         */
        /**
         * 模块入口
         */

         initPage:function() {
            //初始化数据表格
            var url = $('.example').attr("href");
            this.params.select2 = select2.show({
                view: {
                    url: url, //本模块service.js中定义的apiName
                    type:'example'
                }
            });
            /*var option = new Option("mail.userName","2", true, true);
            $(".example").append(option).trigger('change');*/
            /*$(".exampleLocal").on("select2:opening",function(){
                alert("aaaa")
            })*/
            this.params.select2 = select2.show({
                view: {
                    url: null, //本模块service.js中定义的apiName
                    type:'exampleLocal',
                    localJson:[
                        {id: 1, typeId: 1, code: "mail.host", value: "smtp.126.com", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"smtp.126.com",version:1},
                        {id: 2, typeId: 1, code: "mail.userName", value: "jsptzsupport", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"jsptzsupport",version:1},
                        {id: 3, typeId: 1, code: "mail.password", value: "jsptz1234", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"jsptz1234",version:1},
                        {id: 4, typeId: 1, code: "mail.smtp.timeout", value: "25000", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"2500",version:1},
                        {id: 5, typeId: 1, code: "mail.smtp.auth", value: "true", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"true",version:1},
                        {id: 6, typeId: 1, code: "mail.sendFrom", value: "jsptzsupport@126.com", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"jsptzsupport@126.com",version:1},
                        {id: 7, typeId: 1, code: "hibernate.dialect", value: "org.hibernate.dialect.MySQLDialect", language: null, operateTimeForHis:null , typeId:1 , validStatus:"1" , value:"org.hibernate.dialect.MySQLDialect",version:1}
                        ]
                }
            });
            /*$(".exampleLocal").val("2").trigger('change');*/
        },


    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});