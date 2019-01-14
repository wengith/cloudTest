/**
 * 下拉查询框
 * Created by xubincheng on 2018/1/31.
 */
define(['require', 'jquery', './http'],
    (require, $, http) => {
    var bigAutocomplete = new function(){
        var currentInputText = null;//目前获得光标的输入框（解决一个页面多个输入框绑定自动补全功能）
        this.functionalKeyArray = [9,20,13,16,17,18,91,92,93,45,36,33,34,35,37,39,112,113,114,115,116,117,118,119,120,121,122,123,144,19,145,40,38,27];//键盘上功能键键值数组
        this.holdText = null;//输入框中原始输入的内容

        //初始化插入自动补全div，并在document注册mousedown，点击非div区域隐藏div
        this.init = function($this){
            $("body").append("<div id='bigAutocompleteContent' class='bigautocomplete-layout'></div>");
            $(document).bind('mousedown',function(event){
                var $target = $(event.target);
                if((!($target.parents().andSelf().is('#bigAutocompleteContent'))) && (!$target.is($(currentInputText)))){
                    bigAutocomplete.hideAutocomplete(false);
                }
            })

            //鼠标悬停时选中当前行
            $("#bigAutocompleteContent").delegate("tr", "mouseover", function() {
                $("#bigAutocompleteContent tr").removeClass("ct");
                $(this).addClass("ct");
            }).delegate("tr", "mouseout", function() {
                $("#bigAutocompleteContent tr").removeClass("ct");
            });

            //单击选中行后，选中行内容设置到输入框中，并执行callback函数
            $("#bigAutocompleteContent").delegate("tr", "click", function() {
                $(currentInputText).val( $(this).find("div:last").html());
                var callback_ = $(currentInputText).data("config").callback;
                if($("#bigAutocompleteContent").css("display") != "none" && callback_ && $.isFunction(callback_)){
                    callback_($(this).data("jsonData"));
                }
                bigAutocomplete.hideAutocomplete(false);
            });
        }

        this.autocomplete = function(param){
            var $this = this;//为绑定自动补全功能的输入框jquery对象
            if($("body").length > 0 && $("#bigAutocompleteContent").length <= 0){
                bigAutocomplete.init($this);//初始化信息
            }
            var $bigAutocompleteContent = $("#bigAutocompleteContent");

            this.config = {
                width:0,    //width:下拉框的宽度，默认使用输入框宽度
                url:null,   //url：格式url:""用来ajax后台获取数据，返回的数据格式为data参数一样
                /*data：格式{data:[{title:null,result:{}},{title:null,result:{}}]}
                 url和data参数只有一个生效，data优先*/
                data:null,
                callback:null,                    //callback：选中行后按回车或单击时回调的函数
                currentInput: null,				//查询框input的jquery对象
                result: {},						//查询结果赋值，key是属性名,value是元素jquery对象
                params: {},						//后台数据请求携带的参数
                apiName: "",						//后台api地址，router.js中配置
                initDataInput: null,				//初始化翻译时code的值所在的input对象，jquery对象
                serverModel: false,				//是否启用服务器模式，启用时通过查询框内容分页查询展示查询结果，不启用则初始化时就加载全量数据
                page: {
                    pageSize: 50,
                    loadingText: "@i18n(ins_search.loadingText)",
                    endText: "@i18n(ins_search.endText)"
                },
                selectedCallback: function() {}		//选择后执行的回调函数
            };
            $.extend(true, this.config, param);

            $this.data("config",this.config);

            $this.data("pageNo", 0);

            //输入框keydown事件
            $this.keydown(function(event) {
                if($this.attr("readonly")) return;
                var node = event.currentTarget;
                switch (event.keyCode) {
                    case 40://向下键

                        if($bigAutocompleteContent.css("display") == "none")return;

                        var $nextSiblingTr = $bigAutocompleteContent.find(".ct");
                        if($nextSiblingTr.length <= 0){//没有选中行时，选中第一行
                            $nextSiblingTr = $bigAutocompleteContent.find("tr:first");
                        }else{
                            $nextSiblingTr = $nextSiblingTr.next();
                        }
                        $bigAutocompleteContent.find("tr").removeClass("ct");

                        if($nextSiblingTr.length > 0){//有下一行时（不是最后一行）
                            $nextSiblingTr.addClass("ct");//选中的行加背景
                            //$(node).val($nextSiblingTr.find("div:last").html());//选中行内容设置到输入框中

                            //div滚动到选中的行,jquery-1.6.1 $nextSiblingTr.offset().top 有bug，数值有问题
                            $bigAutocompleteContent.scrollTop($nextSiblingTr[0].offsetTop - $bigAutocompleteContent.height() + $nextSiblingTr.height() );

                        }else{
                            // $(node).val(bigAutocomplete.holdText);//输入框显示用户原始输入的值
                        }


                        break;
                    case 38://向上键
                        if($bigAutocompleteContent.css("display") == "none")return;

                        var $previousSiblingTr = $bigAutocompleteContent.find(".ct");
                        if($previousSiblingTr.length <= 0){//没有选中行时，选中最后一行行
                            $previousSiblingTr = $bigAutocompleteContent.find("tr:last");
                        }else{
                            $previousSiblingTr = $previousSiblingTr.prev();
                        }
                        $bigAutocompleteContent.find("tr").removeClass("ct");

                        if($previousSiblingTr.length > 0){//有上一行时（不是第一行）
                            $previousSiblingTr.addClass("ct");//选中的行加背景
                            //$(node).val($previousSiblingTr.find("div:last").html());//选中行内容设置到输入框中

                            //div滚动到选中的行,jquery-1.6.1 $$previousSiblingTr.offset().top 有bug，数值有问题
                            $bigAutocompleteContent.scrollTop($previousSiblingTr[0].offsetTop - $bigAutocompleteContent.height() + $previousSiblingTr.height());
                        }else{
                            // $(node).val(bigAutocomplete.holdText);//输入框显示用户原始输入的值
                        }

                        break;
                    case 27://ESC键隐藏下拉框

                        bigAutocomplete.hideAutocomplete(false);
                        break;
                }
            });
            //双击查询全部
            $this.dblclick(function(event){
                if($this.attr("readonly")) return;
                $(this).val("*").trigger("keyup");
            });
            //输入框keyup事件
            $this.keyup(function(event) {
                if($this.attr("readonly")) return;
                var k = event.keyCode;
                var node = event.currentTarget;
                var ctrl = event.ctrlKey;
                var $node = $(node);
                var config = $node.data("config");
                if (config.result) {
                    for (var key in config.result) {
                        var $result = config.result[key];
                        if (!$result.is($node)) {
                            $result.val("").trigger("input");
                        }
                    }
                }

                var isFunctionalKey = false;//按下的键是否是功能键
                for(var i=0;i<bigAutocomplete.functionalKeyArray.length;i++){
                    if(k == bigAutocomplete.functionalKeyArray[i]){
                        isFunctionalKey = true;
                        break;
                    }
                }
                //k键值不是功能键或是ctrl+c、ctrl+x时才触发自动补全功能
                if(!isFunctionalKey && (!ctrl || (ctrl && k == 67) || (ctrl && k == 88)) ){
                    var offset = $node.offset();
                    if(config.width <=0){
                        config.width  = $(node).outerWidth() - 2
                    }
                    $bigAutocompleteContent.width(config.width);
                    var h = $node.outerHeight() - 1;
                    $bigAutocompleteContent.css({"top":offset.top + h,"left":offset.left});

                    var keyword_ = $.trim($node.val());
                    if(keyword_ == null || keyword_ == ""){
                        bigAutocomplete.hideAutocomplete(false);
                        return;
                    }
                    if (config.serverModel == false) {//非服务器模式
                        var data = config.data;
                        var url = config.url;
                        if(keyword_ == "*"){
                            var data_ = new Array();
                            for(var i=0;i<data.length;i++){
                                data_.push(data[i]);
                            }
                            makeContAndShow(data_);
                            if(data_.length>=1){
                                var e = $.Event("keydown");
                                e.keyCode = 40; //9是键盘tab键
                                $this.trigger(e);
                            }
                        }else if(data != null && $.isArray(data) ){
                            var data_ = new Array();
                            for(var i=0;i<data.length;i++){
                                if(data[i].title.indexOf(keyword_) > -1){
                                    data_.push(data[i]);
                                }
                            }

                            makeContAndShow(data_);
                            if(data_.length>=1){
                                var e = $.Event("keydown");
                                e.keyCode = 40; //9是键盘tab键
                                $this.trigger(e);
                            }
                        }else if(url != null && url != ""){//ajax请求数据
                            $.post(url,{keyword:keyword_},function(result){
                                if(!$this.is(":focus")){
                                    return;
                                }
                                makeContAndShow(result.data)
                            },"json")
                        }
                        bigAutocomplete.holdText = $node.val();
                    } else if (config.serverModel == true) {//服务器模式
                        showMessage(config.page.loadingText);
                        clearTimeout($this.get(0).queryTimer);
                        $this.get(0).queryTimer = setTimeout(function(){
                            //通过http请求获取数据
                            config.page.pageNo = 0;
                            config.params.keyword = keyword_;
                            $this.data("config", config);
                            $this.data("lockScroll", false);    //解锁滚动条
                            http.post({
                                apiName: config.apiName,
                                data: $.extend(config.params, config.page),
                                tipoff: true,
                                success: function(result) {
                                    if (result.data.length < config.page.pageSize) {//不足一页，不触发滚动条
                                        $this.data("lockScroll", true);    //解锁滚动条
                                    }
                                    if(!$this.is(":focus")){
                                        return;
                                    }
                                    makeContAndShow(result.data);
                                }
                            });
                            //监听
                            $bigAutocompleteContent.off("scroll").on("scroll", scrollContent);
                        }, 1000);
                    }
                }
                //回车键
                if(k == 13){
                    var callback_ = $node.data("config").callback;
                    if($bigAutocompleteContent.css("display") != "none"){
                        if(callback_ && $.isFunction(callback_)){
                            callback_($bigAutocompleteContent.find(".ct").data("jsonData"));
                        }
                        $bigAutocompleteContent.hide();
                    }
                }
            });

            //服务器模式下需要加载滚动监听事件
            function scrollContent(event) {
                var autoCompleteDiv = $(this);
                //判断是否符合触发条件
                if ($this.data("lockScroll")) {
                    return;
                }
                event = event || window.event;
                var scrollHeight = autoCompleteDiv.prop("scrollHeight");
                var scrollTop =autoCompleteDiv.scrollTop();
                if ((scrollHeight - scrollTop) < 300) {
                    var config = $this.data("config");
                    var keyword = config.params.keyword;
                    $this.data("lockScroll", true);
                    config.page.pageNo++;
                    $this.data("config", config);
                    showLoadingMsg(config.page.loadingText, true);        //显示加载中
                    http.post({
                        apiName: config.apiName,
                        data: $.param($.extend(config.params, config.page)),
                        tipoff: true,
                        success: function(result) {
                            if(!$this.is(":focus")){
                                return;
                            }
                            hideLoadingMsg();
                            makeContAndShow(result.data, true);
                            console.log("result.data.length="+result.data.length);
                            console.log("config.page.pageSize="+config.page.pageSize);
                            if (result.data.length == config.page.pageSize) {//加载数据满足一页时解锁
                                $this.data("lockScroll", false);//锁定
                            } else {
                                showMessage(config.page.endText, true);
                            }

                        }
                    })
                };
                event.stopPropagation();
            };

            /**
             * 显示信息
             * @param message
             */
            function showMessage(message, isAppend) {
                var cont = "<div>" + message + "</div>";
                if (isAppend) {
                    $bigAutocompleteContent.find("tbody").append(cont);
                } else {
                    $bigAutocompleteContent.html(cont);
                }
                $bigAutocompleteContent.show();
            }

            function showLoadingMsg(message, isAppend) {
                var cont = "<div class='search-box-loading'>" + message + "</div>";
                if (isAppend) {
                    $bigAutocompleteContent.find("tbody").append(cont);
                } else {
                    $bigAutocompleteContent.html(cont);
                }
                $bigAutocompleteContent.show();
            }

            function hideLoadingMsg() {
                $bigAutocompleteContent.find(".search-box-loading").remove();
            }


            /**
             * 组装下拉框html内容并显示
             * @param data_ 待显示数据
             * @param isAppend 是否追加
             */
            function makeContAndShow(data_, isAppend){
                if (!isAppend || $bigAutocompleteContent.html() == '') {
                    if(data_ == null || data_.length <=0 ){
                        var cont = "<div style='color:red;'>@i18n(ins_search.noresult)</div>";
                        $bigAutocompleteContent.html(cont);
                        $bigAutocompleteContent.show();
                        return;
                    }

                    var cont = "<table><tbody>";
                    for(var i=0;i<data_.length;i++){
                        cont += "<tr><td><div>" + data_[i].title + "</div></td></tr>";
                    }
                    cont += "</tbody></table>";
                    $bigAutocompleteContent.html(cont);
                    $bigAutocompleteContent.show();

                    //每行tr绑定数据，返回给回调函数
                    $bigAutocompleteContent.find("tr").each(function(index){
                        $(this).data("jsonData",data_[index]);
                    })
                } else {
                    if (data_ == null || data_.length <=0 ) {
                        return;
                    }
                    var cont = "";
                    for (var i=0; i<data_.length; i++) {
                        cont += "<tr class='searchbox-append'><td><div>" + data_[i].title + "</div></td></tr>";
                    }
                    $bigAutocompleteContent.find("tbody").append(cont);
                    $bigAutocompleteContent.show();

                    //每行tr绑定数据，返回给回调函数
                    $bigAutocompleteContent.find("tr.searchbox-append").each(function(index, elem){
                        $(elem).data("jsonData",data_[index]).removeClass("searchbox-append");
                    })
                }


            }


            //输入框focus事件
            $this.focus(function(event){
                currentInputText = event.currentTarget;
            });

        }
        //隐藏下拉框
        this.hideAutocomplete = function(isclearhidden){
            if(!isclearhidden){
                bigAutocomplete.clearValueIfNotSelect();
            }
            var $bigAutocompleteContent = $("#bigAutocompleteContent");
            if($bigAutocompleteContent.css("display") != "none"){
                $bigAutocompleteContent.find("tr").removeClass("ct");
                $bigAutocompleteContent.hide();
                $bigAutocompleteContent.off("scroll");
            }
            $(this).data("lockScroll", false);//解锁
        }

        this.clearValueIfNotSelect = function(){
            $(".searchBox").each(function(index, elem){
                var config = $(elem).data("config");
                if (config && config.result) {
                    var flag = true;
                    for (var key in config.result) {
                        if (!$(elem).is(config.result[key]) && config.result[key].val() != '') {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        $(elem).val("");
                    }
                }
            });
        }
    };

    $.fn.bigAutocomplete = bigAutocomplete.autocomplete;
});