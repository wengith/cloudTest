/**
 * jsviews配置
 * @author 
 */
define(['jquery','../widget/link_tool','jsviews'], (jQuery,link_tool) => {
    //复写templates方法，添加link的aop前置方法preCall和后置方法aftCall
    (function($){
        var _templates = $.templates;
        $.templates = function(name, item, parentTmpl){
            var _linkObj =  _templates(name, item, parentTmpl);
            _linkObj.link = function(to, from,context, noIteration, parentView, prevNode, nextNode){
                var _this = this;
                if($.templates.wholePreCalls){
                    var i=0;
                    var j=0;
                    for(var keyItem in $.templates.wholePreCalls){
                        j++;
                    }
                    for(var key in $.templates.wholePreCalls){
                        var defer = $.Deferred();
                        $.templates.wholePreCalls[key](defer);
                        defer.done(function(){
                            i++;
                            if(i==j){
                                callBak(_this);
                            }
                        })
                    }
                }else{
                    callBak(_this);
                }
                var result;
                function callBak(__this){//数据之前处理一些事情
                    result = $.link(__this, to, from, context, noIteration, parentView, prevNode, nextNode);
                    if($.templates.wholeAftCalls){
                        for(var key in $.templates.wholeAftCalls){
                            $.templates.wholeAftCalls[key]();
                        }
                    }
                }
                return result;
            };
            return _linkObj;
        }
        function linkCallback(){
            
        }
    })(jQuery);
    $.templates.wholeAftCalls = {};
    $.templates.wholePreCalls = {};
    $.templates.instanceAftCalls = {};
    $.templates.instancePreCalls = {};
    $.templates.wholeAftCall = function(key,fun){
        $.templates.wholeAftCalls[key] = fun;
    };
    $.templates.wholePreCall = function(key,fun){
        $.templates.wholePreCalls[key] = fun;
    };
    $.templates.instanceAftCall = function(instance,key,fun){
        if(!$.templates.instanceAftCalls[instance]){
            $.templates.instanceAftCalls[instance]={};
        }
        $.templates.instanceAftCalls[instance][key] = fun;
    };
    $.templates.instancePreCall = function(instance,key,fun){
        if(!$.templates.instancePreCalls[instance]){
            $.templates.instancePreCalls[instance]={};
        }
        $.templates.instancePreCalls[instance][key] = fun;
    };


    /*
     * ======================================
     * =====☆ jsviews全局linkaop函数  ☆======
     * ======================================
     */
    //前置全局执行函数
    $.templates.wholePreCall("initDirData",function(obj){
        obj.resolve();
    })
    //后置全局执行函数
    $.templates.wholeAftCall("initJqueryValidate",function(){
         $("form").each(function(i){
            var $this = $(this);
            if($this.attr("valflag")) return true;
            $this.attr("valflag","1");
            $this.validate({
                rules: {},
                messages: {},
                ignore: ":hidden",
                onfocusout(e) {
                    if($(e).attr("readonly")) return;
                    $(e).valid();
                },
                errorPlacement(error, element) {
                    var elem = $(element);
                    if (!error.is(':empty')) {
                            elem.tooltip({
                                placement: 'bottom',
                                title: $(error).html(),
                                trigger: 'manual'
                            }).tooltip('show');

                    } else {
                        elem.tooltip('destroy');
                    }

                },
                success(a, b) {

                }
            });
        });
    });

    /*
     * ======================================
     * ===☆ jsviews全局converters函数  ☆====
     * ======================================
     */
    $.views.converters("c", function (value) {
        return value;  
    });
    $.views.converters("cnum", function (value) {
        return value?value:0;  
    });
    $.views.converters("csum", function (value) {
        return value?value:0;  
    });
    $.views.converters("exitCheck", function (value,checkValue) {
        console.log(value+" "+checkValue);
        return $.trim(value).indexOf(checkValue)!= -1;  
    });

    /*
     * ====================================
     * ====☆ jsviews全局helps函数  ☆======
     * ====================================
     */
    $.views.helpers({
        addLine:function(listData,lineData){
            var newLineData = $.extend( true,{}, lineData);
            $.observable(listData).insert(listData.length,newLineData);
        },
        removeLine:function(listData,ev){
            var index = $.view(ev.target).getIndex();;
            $.observable(listData).remove(index);
        }
    });

    /*
     * ====================================
     * ======☆ jsviews自定义标签  ☆=======
     * ====================================
     */
    //数据字典下拉列表
    $.views.tags("ins_dir_select", function(codeType,text,name,linkdata,validates){
        if(!validates) validates = "";
        var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 text-right control-label' for='"+name+"'>"+text+"</label>\
                    <div class='col-md-8'>\
                         <select class='form-control' id='"+name+"' data-link='"+linkdata+"' "+validates+">\
                         <option value=''></option>";
        var data = DirCache['init_dictionary_data'+GlobalUtils.stringify({ dataType: codeType})];
        for(var i=0 ; i<data.length ; i++){
            tagOption += "<option value='"+data[i].result.code+"'>"+data[i].result.name+"</option>";
        }
        tagOption +="</select>\
                         <input type='hidden' name='"+name+"' data-link='"+linkdata+"'/>\
                    </div>\
                    </div>";
        return tagOption;
    });
    //数据字典下拉列表（仅选项）
    $.views.tags("ins_dir_options", function(codeType){
        var tagOption = "";
        var data = DirCache['init_dictionary_data'+GlobalUtils.stringify({ dataType: codeType})];
        for(var i=0 ; i<data.length ; i++){
            tagOption += "<option value='"+data[i].result.code+"'>"+data[i].result.name+"</option>";
        }
        return tagOption;
    });
    //数据字典普通查询
    $.views.tags({ins_dir_search_input:{
        render: function(codeType,text,name,linkdata,validates) {
            if(!validates) validates = "";
            var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 text-right control-label' for='"+name+"'>"+text+"</label>\
                    <div class='col-md-8'>\
                        <input id='"+name+"' class='form-control input-sm' type='text' value='' "+validates+"/>\
                         <input name='"+name+"' data-link='"+linkdata+"' type='hidden' value=''/>\
                    </div>\
                </div>";
            return tagOption;
        },
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var api='init_dictionary_data';
            var params = { dataType: tagCtx.args[0]};
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            var $hidden = $parent.find("input[type='hidden']");
            link_tool._aftinitsearch(params,$input,$hidden,api);
        }
    }});
    //数据字典普通查询通用形式
    $.views.tags({ins_dir_search_input_common:{
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var api='init_dictionary_data';
            var params = { dataType: tagCtx.args[0]};
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            var $hidden = $parent.find("input[type='hidden']");
            link_tool._aftinitsearch(params,$input,$hidden,api);
        }
    }});
    //数据字典查询服务器模式
    $.views.tags("ins_dir_server_search_input", function(codeType,text,name,linkdata,validates){
        var tagOption = "";
        return tagOption;
    });
    //普通查询服务器模式
    $.views.tags({ins_server_search_input:{
        render: function(api,params,istransfer,text,name,linkdata,validates) {
            if(!validates) validates = "";
            var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 text-right control-label' for='"+name+"'>"+text+"</label>\
                    <div class='col-md-8'>\
                        <input id='"+name+"' class='form-control input-sm' type='text' value='' "+validates+"/>\
                         <input name='"+name+"' data-link='"+linkdata+"' type='hidden' value=''/>\
                    </div>\
                </div>";
            return tagOption;
        },
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var api = tagCtx.args[0];
            var params = tagCtx.args[1];
            var istransfer = tagCtx.args[2];
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            var $hidden = $parent.find("input[type='hidden']");
            link_tool._aftinitsearchserver(params,$input,$hidden,api,istransfer=="true");
        }
    }});
    //普通查询
    $.views.tags({ins_search_input:{
        render: function(api,params,text,name,linkdata,validates) {
            if(!validates) validates = "";
            var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 text-right control-label' for='"+name+"'>"+text+"</label>\
                    <div class='col-md-8'>\
                        <input id='"+name+"' class='form-control input-sm' type='text' value='' "+validates+"/>\
                         <input name='"+name+"' data-link='"+linkdata+"' type='hidden' value=''/>\
                    </div>\
                </div>";
            return tagOption;
        },
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var api = tagCtx.args[0];
            var params = tagCtx.args[1];
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            var $hidden = $parent.find("input[type='hidden']");
            link_tool._aftinitsearch(params,$input,$hidden,api);
        }
    }});
    //普通查询通用形式
    $.views.tags({ins_search_input_common:{
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var api = tagCtx.args[0];
            var params = tagCtx.args[1];
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            var $hidden = $parent.find("input[type='hidden']");
            link_tool._aftinitsearch(params,$input,$hidden,api);
        }
    }});
    //普通的bootstrap input
    $.views.tags("ins_input", function(text,name,linkdata,validates){
        if(!validates) validates = "";
        var tagOption = "<div class='form-group'>\
                        <label class='col-md-3 control-label text-right' for='"+name+"'>"+text+"</label>\
                        <div class='col-xs-8 col-md-8 col-lg-8'>\
                        <input type='text' class='form-control input-sm' id='"+name+"' name='"+name+"' data-link='"+linkdata+"' "+validates+"/>\
                        </div>\
                    </div>";
        return tagOption;
    });
    //普通的bootstrap date input
    $.views.tags({ins_date:{
        render: function(text,name,linkdata,validates) {
            if(!validates) validates = "";
            var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 control-label text-right' for='"+name+"'>"+text+"</label>\
                    <div class='col-xs-8 col-md-8 col-lg-8'>\
                        <div class='input-group date' data-provide='datepicker'>\
                           <input type='text' class='form-control' id='"+name+"' name='"+name+"' data-link='"+linkdata+"' readonly='readonly' "+validates+"/>\
                            <span class='input-group-addon'>\
                                <span class='glyphicon glyphicon-calendar theme-icon-color'></span>\
                            </span>\
                        </div>\
                    </div>\
                </div>";
            return tagOption;
        },
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            
        }
    }});
    //普通的地址选择框
    $.views.tags({ins_address:{
        render: function(text,name,linkdata,validates) {
            if(!validates) validates = "";
            var tagOption = "<div class='form-group'>\
                    <label class='col-md-3 control-label text-right' for='"+name+"'>"+text+"</label>\
                    <div class='col-xs-8 col-md-8 col-lg-8'>\
                           <input type='text' class='form-control' id='"+name+"' name='"+name+"' data-link='"+linkdata+"' "+validates+"/>\
                    </div>\
                </div>";
            return tagOption;
        },
        contentCtx: true, // Inherit parent view data context
        flow: true,
        onAfterLink: function(tagCtx, linkCtx, ctx, event) {
            var _this = this;
            var $parent = $(_this.parentElem);
            var $input = $parent.find("input[type='text']");
            $input.addressSelect();
        }
    }});
});
