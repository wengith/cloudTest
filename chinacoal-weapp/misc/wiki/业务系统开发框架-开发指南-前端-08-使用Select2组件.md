## 1. 在require_config.js中引入select2.min.js
```
/**
 * 配置requirejs
 * 模块路径缩写，版本管理
 */
define({
    baseUrl: 'page',
    paths: {
        'select2':'../plugin/select2/js/select2.min'
    },
    waitSeconds: 0
});

```
## 2. 在index.html中引入select2.css
```
<link rel="styleSheet" href="./plugin/select2/css/select2.css" type="text/css">
```

## 3.在bootstrap.js中定义select2启动器并引入路由文件
```
/**
 * 启动器
 */
define([    
    'select2',
    'templates/select2/router'
], (starter) => {
    'use strict';
    let data = {
        userName: '张三'
    };
    starter._init(data);
});
```

## 4.router.js
```
/**
 * 管理模块路由
 * @author
 * @time 
 */
define(["route_config"], (route_config) => {
    //配置路由函数
    route_config.state({
        path: '/select2/select',
    })
});
```
## 5.select.html
```
<!DOCTYPE html>
<html>
<head>
<title></title>
<style type="text/css"> 
</style>

</head>
<body>

      <div class="col-md-10" style="margin-top: 20px;">
            <div style="width:110%;text-align:left;color: gray;border-bottom: 2px solid #df5f4a;"><p style="font-weight: bold;
        font-size: 14px;">select2示例页面</p></div>
            <br>
        </div>


  <div  class="page-title col-md-10" style="z-index:-1;margin-top: 5px;" placeholder>
     <span>单选</span>
  </div>
   
<div  class="col-md-10">
   <select style="width:70%;overflow:visible;" class="example" placeholder="Search W3School">  
   </select>
</div>

<div class="page-title col-md-10" style="z-index:-1">
     <span>多选</span>
  </div>

<div  class="col-md-10">
   <select style="width:70%;overflow:visible;" class="example" multiple>  
   </select>
</div>

  <div class="page-title col-md-10" style="z-index:-1">
     <span>核心代码</span>
  </div>

<div class="col-md-10 column">
  <textarea class="col-md-10 column" style="width:110%;height:1200px" >

      $("select."+type).each(
        function() {
            var $this = $(this);
            $this.select2({
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
                         request.setRequestHeader("Authorization","Arch6WithCloud "+localStorage.getItem("JSESSIONID"));
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
                    if(repo.code==undefined||repo.value==undefined){
                        return "请输入关键字";  
                    }else{
                         return repo.code||repo.value;
                    }
                }// 列表中选择某一项后显示到文本框的内容
             });

             });

             
</textarea>
</div>

</body>

<script type="text/javascript">

</script>


<html>


```
## 6.select.js
```
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
        },


    };

    return {
        initPage: $.proxy(page.initPage, page)
    };
});
```
## 6.select2.js
```
/**
 * 数据表格
 * @module table_data
 * @author czl
 * @time 2015/10/29
 */
define(['jquery', './template', './dialog', '../service/util_service', './http', 'route_config'],
    function($, template, dialog, util_service, http, route_config)  {
    var tabInstance;

        var SelectData = function(opt) {

            /**
             * TableData的选项
             * @type Object
             **/
            this.options = $.extend({
                view: {
                    url:null,
                    type:null
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
      $("select."+type).each(
        function() {
            var $this = $(this);
            $this.select2({
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
                         request.setRequestHeader("Authorization","Arch6WithCloud "+localStorage.getItem("JSESSIONID"));
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
                    if(repo.code==undefined||repo.value==undefined){
                        return "请输入关键字";  
                    }else{
                         return repo.code||repo.value;
                    }
                }// 列表中选择某一项后显示到文本框的内容
             });

             });
        };

        return SelectData;
    });

```

## 7.controller
注意返回为json类型

```

@RestController
@RequestMapping("/sdd/code")
public class StuApi extends BaseApi {
	@Autowired
	StuService userService;		
		
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public ApiResponse queryList(HttpServletRequest request) throws IOException {
	    String uid=request.getParameter("id");
	    List<SddCode> users = new ArrayList<SddCode>();
		users = sddCodeService.queryList(uid);
		
		ApiResponse response = new ApiResponse();
		
		response.setData(users);
		
		return response;
     }
	


}

```

