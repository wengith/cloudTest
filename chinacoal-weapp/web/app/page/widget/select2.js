/**
 * 数据表格
 * @module table_data
 * @author czl
 * @time 2015/10/29
 */
define(['jquery', './template', './dialog', '../service/util_service', './http', 'route_config'],
    function($, template, dialog, util_service, http, route_config)  {

        var SelectData = function(opt) {

            /**
             * TableData的选项
             * @type Object
             **/
            this.options = $.extend({
                view: {
                    url:null,
                    type:null,
                    localJson:null
                }
            }, opt || {});

        };

        /**
         * TableData的静态函数，标准：分页
         * @method show
         */
        SelectData.show = function(options) {
         //  alert(777);
            var url=options.view.url==null?"api/misc/sdd/code/queryList?":options.view.url;
            var type=options.view.type;
            var localJson=options.view.localJson;
            $("select."+type).each(
                function() {
                    var $this = $(this);
                    if(localJson!=null){
                        $this.select2({
                        tags:true,
                        data:localJson,
                        placeholder: "请输入关键字",
                        language:'zh-CN',// 指定语言为中文，国际化才起效
                        escapeMarkup : function(markup) {
                            return markup;
                        }, // let our custom formatter work
                        minimumInputLength : 0,// 最少输入一个字符才开始检索
                        templateResult : function(repo) {// 显示的结果集格式，这里需要自己写css样式，可参照demo
                            // 正在检索
                            if (repo.loading)
                                return repo.text;

                            var markup = "<table class='select2-result-repository clearfix'>" 
                            + "<tr>"
                            + "<td style='word-break:break-all;' width='300px'>" + repo.code + "</td>"
                            + "<td width='400px' align='center' >" + repo.value + "</td>"
                            + "</tr>"
                            + "</table>"
                            ;

                            return markup;
                        }, 
                        templateSelection : function(repo) {
                            //if(repo.code==undefined||repo.value==undefined){
                            if($this.val()==undefined || $this.val()==null || $this.val()==""){
                                return "请输入关键字";  
                            }else{
                                 return repo.code||repo.value||repo.text;
                            }
                        },// 列表中选择某一项后显示到文本框的内容
                        createTag: function (params) {
                          var term = $.trim(params.term);

                            if (term === '') {
                              return null;
                            }

                            return {
                              id: term, typeId: 1, code: term, value: term, language: null, operateTimeForHis:null , typeId:1 , validStatus:1 , value:term,version:1,
                              //newTag: true // add additional parameters
                            }
                          },
                          insertTag: function (data, tag) {
                            // Insert the tag at the end of the results
                            data.push(tag);
                          }
                        });
                    }else{
                    $this.select2({
                        tags:true,
                        placeholder: "请输入关键字",
                        language : "zh-CN",// 指定语言为中文，国际化才起效
                        allowClear: true,
                        ajax : {
                            url :url,
                            dataType : 'json',
                            delay : 250,// 延迟显示
                            data : function(params) {
                                return {
                                    id : params.term, // 搜索框内输入的内容，传递到Java后端的parameter为username
                                    page : params.page,// 第几页，分页哦
                                    rows : 10// 每页显示多少行
                                };
                            },
                            beforeSend: function(request) {
                                 request.setRequestHeader("Authorization","Arch6WithCloud "+localStorage.getItem("jwt"));
                            },
                            // 分页
                            processResults : function(data, params) {
                                params.page = params.page || 1;

                                return {
                                    results : data.data,// 后台返回的数据集
                                    pagination : {
                                        more : params.page < data.total// 总页数为10，那么1-9页的时候都可以下拉刷新
                                    }
                                };
                            },
                            cache : false
                        },
                        escapeMarkup : function(markup) {
                            return markup;
                        }, // let our custom formatter work
                        minimumInputLength : 0,// 最少输入一个字符才开始检索
                        templateResult : function(repo) {// 显示的结果集格式，这里需要自己写css样式，可参照demo
                            // 正在检索
                            if (repo.loading)
                                return repo.text;

                            var markup = "<table class='select2-result-repository clearfix'>" 
                            + "<tr>"
                            + "<td style='word-break:break-all;' width='300px'>" + repo.code + "</td>"
                            + "<td width='400px' align='center' >" + repo.value + "</td>"
                            + "</tr>"
                            + "</table>"
                            ;

                            return markup;
                        }, 
                        templateSelection : function(repo) {
                            //if(repo.code==undefined||repo.value==undefined){
                            if($this.val()==undefined || $this.val()==null || $this.val()==""){
                                return "请输入关键字";  
                            }else{
                                 return repo.code||repo.value||repo.text;
                            }
                        },// 列表中选择某一项后显示到文本框的内容
                        createTag: function (params) {
                          var term = $.trim(params.term);

                            if (term === '') {
                              return null;
                            }

                            return {
                              id: 10000, typeId: 1, code: term, value: term, language: null, operateTimeForHis:null , typeId:1 , validStatus:1 , value:term,version:1,
                              //newTag: true // add additional parameters
                            }
                          },
                          insertTag: function (data, tag) {
                            // Insert the tag at the end of the results
                            data.push(tag);
                          }
                    });
                    }
            });
        };

        return SelectData;
    });
