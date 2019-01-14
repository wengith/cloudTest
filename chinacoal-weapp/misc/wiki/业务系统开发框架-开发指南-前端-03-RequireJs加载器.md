# 1 概述
## 1.1 什么是ReuqireJs
在说明什么是RequireJS之前，不得不提的就是Javascript模块化历史的背景。其实在早期，javascript作为一门新兴的脚本语言出现，有着庞大的愿景，它并不是作为一门仅仅针对客户端设计的语言。只是说后来web应用的流行，javascript作为浏览器端脚本语言而迅速传开，加上Netscape和微软的竞争将其过早的标准化。所以就导致了JS的诸多缺陷，其中一个就是模块化(但是你可以惊奇地发现其实javascript有将import,export等作为保留字，说明设计的时候其实是有考虑的，新的标准es6也让原生支持模块化了)。然后随着web应用越来越复杂，嵌入的javascript代码越来越多，还有node的兴起，模块化编程就变成了必须。

所以就有了后来Dojo工具包和Google的Closure库支持的模块系统。还有两个非常通用的标准规范，CommonJS和AMD。这里就不展开说了，我们只需要知道，实现CommonJS规范的API是同步加载模块的，而实现AMD规范的API是则是异步加载模块。
所以理论上来说，AMD规范的非阻塞加载更加适合浏览器端。而RequireJS就是AMD规范的最好实现。抄一段官方文档对RequireJS的描述：

RequireJS 是一个JavaScript模块加载器。它非常适合在浏览器中使用, 它非常适合在浏览器中使用，但它也可以用在其他脚本环境, 就像 Rhino and Node. 使用RequireJS加载模块化脚本将提高代码的加载速度和质量。

## 1.2 什么是AMD规范
一种基于模块的异步加载JavaScript代码的机制，它推荐开发人员将JavaScript代码封装进一个个模块，对全局对象的依赖变成了对其他模块的依赖，无须再声明一大堆的全局变量。通过延迟和按需加载来解决各个模块的依赖关系。模块化的JavaScript代码好处很明显，各个功能组件的松耦合性可以极大的提升代码的复用性、可维护性。这种非阻塞式的并发式快速加载JavaScript代码，使Web页面上其他不依赖 JavaScript代码的UI元素，如图片、CSS以及其他DOM节点得以先加载完毕，Web页面加载速度更快，用户也得到更好的体验。

## 1.2 RequireJs的好处
* 异步“加载”。我们知道，通常网站都会把script脚本的放在html的最后，这样就可以避免浏览器执行js带来的页面阻塞。使用RequireJS，会在相关的js加载后执行回调函数，这个过程是异步的，所以它不会阻塞页面。

* 按需加载。通过RequireJS，你可以在需要加载js逻辑的时候再加载对应 的js模块，这样避免了在初始化网页的时候发生大量的请求和数据传输，或许对于一些人来说，某些模块可能他根本就不需要，那就显得没有必要。

* 更加方便的模块依赖管理。相信你曾经一定遇到过因为script标签顺序问题而导致依赖关系发生错误，这个函数未定义，那个变量undefine之类的。通过RequireJS的机制，你能确保在所有的依赖模块都加载以后再执行相关的文件，所以可以起到依赖管理的作用。

* 更加高效的版本管理。想一想，如果你还是用的script脚本引入的方式来引入一个jQuery2.x的文件，然后你有100个页面都是这么引用的，那当你想换成jQuery3.x，那你就不得不去改这100个页面。但是如果你的requireJS有在config中做jQuery的path映射，那你只需要改一处地方即可。

* 当然还有一些诸如cdn加载不到js文件，可以请求本地文件等其它的优点，这里就不一一列举了。

## 1.3 兼容性
IE 6+ ..........compatible ✔
Firefox2+ ..... compatible ✔
Safari3.2+ .... compatible ✔
Chrome3+ ...... compatible ✔
Opera10+ ...... compatible ✔

# 2 RequireJS 使用

## 2.1 下载requieJS
在用requieJS模块化开发之前，请先下载RequireJs，官方下载地址为：http://requirejs.org/docs/download.html

## 2.2 引入requieJS
RequireJs的引入在index.html文件中：
```
<script src="./plugin/requirejs/require.js"></script>
<script src="./page/templates/layout/index.js"></script>
```
在业务系统开发框架的前端代码中，requirejs的入口为page/templates/layout/index.js，代码片段如下：
   ```
 require(['require', './page/require_config'], function(require, config) {

        // set cache beater
        config.urlArgs = "v=1.0.0";

        // update global require config
        window.require.config(config);

        // load app
        require(['./page/bootstrap.js']);
    });
```
## 2.3 require_config

我们先看一下 require_config.js里都有哪些内容

```
/*
    require.config执行baseUrl为'js'，
    baseUrl指的模块文件的根目录，可以是绝对路径或相对路径
*/
define({
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
        'select2':'../plugin/select2-master/dist/js/select2.min',
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
        'theme':'../plugin/bootstrap-fileinput/themes/explorer/theme.min',
        'echarts':'../plugin/echarts/echarts',
        'echarts-gl':'../plugin/echarts/echarts-gl',
        'components': '../page/service/components',
        'bigautocomplete': '../plugin/jquery-bigautocomplete/js/jquery.bigautocomplete',
        'zTree':'../plugin/zTree_v3/js/jquery.ztree.all',
        'qrcode':'../plugin/jquery-qrcode/qrcode',
        'jquery-qrcode':'../plugin/jquery-qrcode/jquery.qrcode',
        'index': '../page/templates/layout/index_init',
    },
    waitSeconds: 0,
    shim: {
        'bootstrapui': ['jquery'],
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
        'index': ['jquery','jsviews']
    }
});
```
## 2.4 RequireJs 函数
### requirejs下。其主要API主要是下面三个函数:
* define– 该函数用户创建模块。每个模块拥有一个唯一的模块ID，它被用于RequireJS的运行时函数，define函数是一个全局函数，不需要使用requirejs命名空间.

* require– 该函数用于读取依赖。同样它是一个全局函数，不需要使用requirejs命名空间.

* config– 该函数用于配置RequireJS.

### require.config配置参数选项

* baseUrl——用于加载模块的根路径。

* paths——用于映射不存在根路径下面的模块路径。

* shims——配置在脚本/模块外面并没有使用RequireJS的函数依赖并且初始化函数。假设underscore并没有使用  RequireJS定义，但是你还是想通过

* RequireJS来使用它，那么你就需要在配置中把它定义为一个shim。

* deps——加载依赖关系数组

## 2.5 RequireJs 模块化编程
### 2.5.1 AMD模块的写法
require.js加载的模块，采用AMD规范。也就是说，模块必须按照AMD的规定来写。具体来说，就是模块必须采用特定的define()函数来定义。如果一个模块不依赖其他模块，那么可以直接定义在define()函数之中。
例如page.js
```
define(['mylib'],(mylib) => {
     var page={
         initPage() {
             alert(1);
         }
     };
     return {
         initPage: $.proxy(page.initPage, page),
     }  
});
```
### 2.5.2 模块加载
```
require(['./page/page'], function(page) {
    page.initPage();
});
```






