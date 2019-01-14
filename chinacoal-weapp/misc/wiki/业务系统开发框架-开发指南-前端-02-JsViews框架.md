# 一、 什么是JsViews

1） 下一代MVVM框架，兼具MVVM的特性和JavaScript的特性，使JsRender模板更加快捷和简单。

2） JsViews框架引入了声明式的数据绑定到JsRender Template，支持MVVM和MVP（自定义标签控制）。

3）是一个用于数据绑定的单page的app。

4）JsViews提供了动态绑定的功能，构建与JsRender模板之上。让JsRender template动起来。

# 二、简单的例子
## 1. 使用template.link()
```
<!DOCTYPE html>
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>  
<table><tbody id="peopleList"></tbody></table> 
<script id="peopleTmpl" type="text/x-jsrender">  
  <tr><td>  
    <ul>  
      {{for p}}  
        <li>  
          {{:name}}  
        </li>  
      {{/for}}  
    </ul>  
  </td></tr>  
</script>  
<script>  
    var myTemplate = $.templates("#peopleTmpl");  
      
    var people = [  
        {  
          name: "JoshWang"  
        },  
        {  
          name: "WangSheng"  
        }  
      ];  
      
    var app = {  
        p: people  
      };   
    myTemplate.link("#peopleList", app);  
</script>    
</body>  
</html>
```
**说明：**很容易看出这个例子和之前的JsRender sample的例子是极其类似的。唯一不同地方是，之前用于渲染template数据的两行代码现在只有一行代码即可。
```
var html = myTemplate.render(app);
$("#peopleList").html(html);
```
...用这行代码替代:
`myTemplate.link("#peopleList", app);`
第一个参数表示的是元素的container（此处是一个table）第二个参数表示的是用于渲染的数据。
## 2. Data-linking
在JsViews中使用data-linking来进行数据绑定。但是涉及到一些特殊的应用的时候，就需要使用obserable的数组和对象了。
**例如**，如果现在有一个对象，并且赋予其中一个属性一个新的值，显然这里没有相关的事件来通知其他的code去更新该object。同样地，修改一个数组也不会有相关的事件通知其他的code做相关的更新。
基于这个原因，就出现了JsObservable(http://josh-persistence.iteye.com/admin/blogs/1916759), 它显示地提供了修改对象和数组的方法。
例子：（显示地修改对象和数组）
```
$("#addBtn").on("click", function(){
  $.observable(people).insert(people.length, {name: "name"});
})
```
实例1：可视的数组和对象（可视的意思是该对象或者数组发生变化时，template中与之绑定的数据也会自动更新）
```
<!DOCTYPE html>  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>    
<table><tbody id="peopleList"></tbody></table>  
  
<script id="peopleTmpl" type="text/x-jsrender">  
  <tr><td>  
    <button id="addBtn">Add</button>  
  </td></tr>  
  {^{for p}}  
    <tr><td>  
      {{:name}}  
    </td></tr>  
  {{/for}}  
</script>  
<script>  
    var myTemplate = $.templates("#peopleTmpl");  
    var people = [  
        {  
          name: "JoshWang"  
        },  
        {  
          name: "WangSheng"  
        }  
    ];  
      
    var app = {  
        p: people  
    };  
    var html = myTemplate.link("#peopleList", app);  
      
    $("#addBtn").on("click", function(){  
      $.observable(people).insert(people.length, {name: "newName"});  
    })  
</script>
</body>  
</html>  
```
代码说明：点击Add按钮，会添加一条记录到Array中，然后该template就会自动更新并显示出新加的这一行。使用的code是：

`$.observable(people).insert(people.length, {name: "name"});`

但是需要注意的是这个template和之前的template所有不同，{^{for ...}}。如果去掉^，然后重新点击Add Button后，你会发现没有任何的变化。这是因为任何的常规的JsRender 的标签：{{someTag...}}，无论是内置的还是自定义的，都可以通过添加^变成一个数据绑定标签：{^{some Tag...}}.换句话说，这样的标签就变成了动态的标签，当无论何时需要的哦时候，都会自动的的去重新渲染它（如果相关的数据发生变化时）。

**简言之：^这样的标签是动态的可用于动态绑定的标签，而没有^的标签是死的标签，不能用于数据绑定。**

**实例2： 可视的变化：属性变化。（可视表示属性发生变化时，template中绑定的内容也会自动刷新）**
```
<!DOCTYPE html>  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>    
<table><tbody id="peopleList"></tbody></table>  
<script id="peopleTmpl" type="text/x-jsrender">  
  <tr><td colspan="2">  
    <button id="addBtn">Add</button>  
  </td></tr>  
  {^{for p}}  
    <tr>  
      <td>{^{:name}}</td>  
      <td>  
        <button class="changeBtn">Change</button>  
      </td>  
    </tr>  
  {{/for}}  
</script>  
<script>  
var myTemplate = $.templates("#peopleTmpl");  
  
var people = [  
    {  
      name: "JoshWang"  
    },  
    {  
      name: "WangSheng"  
    }  
  ];   
var app = {  
    p: people  
};    
var counter = 1;   
myTemplate.link("#peopleList", app);    
$("#addBtn").on("click", function() {  
  $.observable(people).insert(people.length, {name: "name"});  
})    
$("#peopleList").on("click", ".changeBtn", function() {  
  var dataItem = $.view(this).data;  
  $.observable(dataItem).setProperty("name", dataItem.name + counter++);  
})    
</script>  
</body>  
</html> 
```
代码解读：
1） $.observable(myObject)可以获取该对象的可视形式，即使该对象变成可视对象，即该对象的修改会引起和他绑定的template中相关内容的自动更新。
2）var dataItem = $.view(this).data 用于获取当前需要修改的object。
## 3.基于标签的"data-link"
`<td data-link="name"></td>`

这和上一个例子中的：

`<td>{^{:name}}</td>  `

具有相关的效果。
## 4. 双向的数据绑定：
```
<td data-link="name"></td>
<td>
  <input data-link="name"/>
</td>
```
`<input>`和`<td>`都是数据绑定的，这使得不需要向实例2中那样添加一个propertyChange(属性变化）来使得template同时发生变化。

```
<!DOCTYPE html>    
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>   
<table><tbody id="peopleList"></tbody></table>  
  
<script id="peopleTmpl" type="text/x-jsrender">  
  <tr><td colspan="2">  
    <button id="addBtn">Add</button>  
  </td></tr>  
  {^{for people}}  
    <tr>  
      <td data-link="name"></td>  
      <td>  
        <input data-link="name"/>  
      </td>  
    </tr>  
  {{/for}}  
</script>  
  
<script>  
var myTemplate = $.templates("#peopleTmpl");  
  
var people = [  
    {  
      name: "JoshWang"  
    },  
    {  
      name: "WangSheng"  
    }  
  ];    
var app = {  
    people: people  
  };   
var counter = 1;   
myTemplate.link("#peopleList", app);  
  
$("#addBtn").on("click", function() {  
  $.observable(people).insert(people.length, {name: "name"});  
})   
</script>    
</body>  
</html>
```
## 5. 更加完整的例子：（在Select标签上使用数据绑定）
```
<!DOCTYPE html>  
  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>  
  
<table><tbody id="peopleList"></tbody></table>  
  
<script id="peopleTmpl" type="text/x-jsrender">  
  <tr><td>  
    <button id="addBtn">Add</button>  
    <button id="removeBtn" data-link="disabled{:selectedID === '0'}">Remove</button>  
  </td></tr>  
  <tr><td>  
    <select data-link="selectedID" size="5">  
      <option value="0">Choose a person to edit</option>  
      {^{for people}}  
        <option data-link="{:name} value{:ID} selected{:ID === ~root.selectedID}"></option>  
      {{/for}}  
    </select>  
  </td></tr>  
  <tr><td>  
    <label>Name:<input data-link="{:selected().name:} disabled{:selectedID === '0'}" /></label>  
    <label>Nickname:<input data-link="{:selected().nickname:} disabled{:selectedID === '0'}" /></label>  
  </td></tr>  
  <tr><td class="center">  
    {^{for selected()}}  
      {^{:name}}      
      {^{if nickname}}  
        ( {^{:nickname}} )  
      {{/if}}  
    {{/for}}  
  </td></tr>  
</script>  
  
<script>  
var myTemplate = $.templates("#peopleTmpl");  
  
var people = [  
  {  
    ID: "Ad0",  
    name: "JoshWang"  
  },  
  {  
    ID: "Ro0",  
    name: "WangSheng",  
    nickname: "Jack"  
  }  
];  
  
var counter = 1;  
  
var app = {  
    people: people,  
    selectedID: people[1].ID,  
    selected: function() {  
      for (var i=0; i<people.length; i++) {  
        if (people[i].ID === this.selectedID) {  
          return people[i];  
        }  
      }  
      return {};  
    }  
  };  
  
app.selected.depends = "selectedID";  
  
// Data-link details container to people, using the peopleTmpl template  
myTemplate.link("#peopleList", app);  
  
$("#addBtn").on("click", function(){  
var newID = "new" + counter++;  
  $.observable(people).insert(people.length, {ID: newID, name: "name"});  
  $.observable(app).setProperty("selectedID", newID);  
  
})  
  
$("#removeBtn").on("click", function(){  
  $.observable(people).remove($.inArray(app.selected(), people));  
  $.observable(app).setProperty("selectedID", "0");  
})  
  
</script>  
  
</body>  
</html> 
```
运行效果图：

![运行效果图](http://git.jsptz.com/cloud/pictures/raw/master/%E8%BF%90%E8%A1%8C%E6%95%88%E6%9E%9C%E5%9B%BE.png)

## 6.事件绑定

### 6.1.两种事件绑定方式

Jsviews绑定事件的方式有两种方式，入下面的代码中所示：

```
<!DOCTYPE html>  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="js/jquery.min.js"></script>  
    <script src="js/jsviews.min.js"></script>  
</head>  
<script>  
  $(function(){
    var tmpl = $.templates("#tmpl");

    var person = {};

    var helpers = {
      doSomething: function() {
        alert("do something");
      }
    }
    tmpl.link("#result", person,helpers); // Render and link the template
    // Attach handler to buttons (class 'myButton'), whether in top-level or rendered content.
    $(".myButton").on("click", helpers.doSomething);
  })
</script>  
<body>  
  <span id="result"></span>
  <script id="tmpl" type="text/x-jsrender">
    <button class="myButton">first bind</button>
    <button data-link="{on ~doSomething}">second bind</button>
  </script>
</body>  
</html>

```

如代码中所示，first bind的按钮使用jQuery中的事件绑定方式`$(".myButton").on("click", helpers.doSomething);`的方式绑定，second bind采用jsviews中的新增加的{on}的方式对方法进行绑定`data-link="{on ~doSomething}"`的方式进行数据绑定，其中doSomething是helpers中定义的方法名称，在此之前需要将helpers的对象注入到模板中。

### 6.2.{on}方法中的参数

使用`{on}`的方式进行方法绑定是想方法中传入三个参数分别表示：

第一个参数为触犯方式

第二个参数为标签的类名、ID值或其他表示标签身份的名称

第三个问方法名称

具体使用方法参考下面的代码：
```
<!DOCTYPE html>  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="js/jquery.min.js"></script>  
    <script src="js/jsviews.min.js"></script>  
</head> 
<style>
ul { margin: 0; padding-left: 0;}
li {border: 1px solid green; width: 100px; background-color: white; cursor: pointer; list-style: none;}
</style> 
<script>  
  $(function(){
    var cnt = 0,
    data = {
      add: function(ev, eventArgs) {
        $.observable(data.items).insert({label: "new" + cnt++});
      }, 
      remove: function(ev, eventArgs) {
        var index = $.view(ev.target).index
        $.observable(data.items).remove(index);
        return false;
      },
      select: function(ev, eventArgs) {
        var targetStyle = ev.target.style;
        targetStyle.backgroundColor = targetStyle.backgroundColor==="yellow" ? "white" : "yellow";
      },  
      items: [
        {label: "one"},
        {label: "two"},
        {label: "three"}
      ]
    };
    $.templates("#tmpl").link("#result", data);
  })
</script>  
<body>  
<style>
ul { margin: 0; padding-left: 0;}
li {border: 1px solid green; width: 100px; background-color: white; cursor: pointer; list-style: none;}
</style>
<script id="tmpl" type="text/x-jsrender">
  <div data-link="
    {on 'click' '.addBtn' add}<!--第一个参数为触犯方式第二个参数为标签的类名、ID值或其他表示标签身份的名称第三个问方法名称 -->
    {on 'click' '.remove' remove}
    {on 'click' 'li' select}
  ">
    <button class="addBtn">add</button>
    <ul>
      {^{for items}}
        <li>{{>label}} <span class="remove"></span></li>
      {{/for}}
    </ul>
  </div>
</script>
<div id="result"></div>
</body>  
</html>

```
`{on}`后面的参数不止这三个，只是这三个比较常用，其他参数还包括：

```
 {on [eventName][selector] handler [param1...][context=expr][data=expr][tmpl='label'] }
```

上面这些为全部的参数

1、`[eventName]`：触发事件；

2、`[selector]`：选择器，指定需要绑定的标签；

3、`Handler`：需要绑定的方法；

4、`[param1...]`：方法中需要传入的参数；

5、`[context=expr]`：用来指定绑定方法中this指针的指向位置例如当前的绑定的方法为：A.B.handle()方法，若不指定则this指向A.B，若context=A则this指向A;

6、`[data=expr]`：将提供给处理程序的数据；

7、`[tmpl='label']`：将label作为标签（或参考含有标签的外部模板）；

# 三、Jsviews中的模板标签

## 1.{{ }}

jsrender使用`{{}}`来做分界，如果{{}}与你现有的模板引擎冲突你可以使用api来自定义，比如：

```
$.views.settings.delimiters("<%", "%>");
//原本
<p>{{:name}}</p>
//修改后
<p><%:name%></p>

```

## 2.{{:name}}

`{{:name}}`：基本变量需要使用冒号 ":" 作为标识，一般是简单对象的某个属性。比如传入一个简单对象data

```
<!DOCTYPE html>  
  
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="js/jquery.min.js"></script>  
    <script src="js/jsviews.min.js"></script>  
</head> 
<style>
</style> 
<script>  
  $(function(){
var team = {
  person1: {
    name: "Peter",
    nickname: "Pete"
  },
  person2: {
    name: "Octavia"
  },
};
var tmpl = $.templates("#teamTmpl");
tmpl.link("#result", team);
  })
</script>  
<body>  
<div id="result"></div>
<script id="teamTmpl" type="text/x-jsrender">
  <em>Name:</em>{{:person1.name}} <br/>
  <em>Nickname:</em>{{:person1.nickname}}<br/>
  <em>Name:</em>{{:person2.name}} <br/>
</script>
</body>  
</html>

```

## 3.{^{: ...}}

`{^{: ...}}`：该标签和3.2中的`{{: ...}}`标签有相同功能进行标签的数据绑定，不同点是它评估表达式并返回其字符串值。用法如下面的代码所示：

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->

<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>

<div id="result"></div>

<script id="teamTmpl" type="text/x-jsrender">
  <button data-link="{on changeManager}">Change manager</button><br/><br/>

  <em>Name:</em> <input data-link="manager^name" /><br/>
  <em>Nickname:</em> <input data-link="manager^nickname" /><br/>

  <em>&lcub;{^:manager^nickname || manager^name}&rcub;:</em>
  <span class="spanbox">
    {^{:manager^nickname || manager^name}}
  </span>

</script>

<script>
var team = {
  person1: {
    name: "Peter",
    nickname: "Pete"
  },
  person2: {
    name: "Octavia"
  },
  changeManager: function() {
    $.observable(this).setProperty({
      manager: this.manager === this.person1 ? this.person2 : this.person1
    });
  }
};

team.manager = team.person1;

var tmpl = $.templates("#teamTmpl");

tmpl.link("#result", team);
</script>

</body>
</html>

```

注意：`{^{: ...}}`的表达式中不能出现HTML代码. 因此如果你输入 ` ...<sometag>... `像上面代码中nickname属性的值， `{^{: ...}}` 标签会将该标记插入到HTML中，这将导致错误（不匹配的标签）。在这种情况下，应该使用`{^ { > }}`标签。

## 4.{^{> ...}}

`{^{> ...}}`：这个标签对基本变量有转译功能，标签使用大于号 ">" 作为标识，可以让数据原样输出，可以防止注入攻击。比如

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>
<div id="result"></div>
<script id="teamTmpl" type="text/x-jsrender">
  <button data-link="{on changeManager}">Change manager</button><br/><br/>
  <em>Name:</em> <input data-link="manager^name" /><br/>
  <em>Nickname:</em> <input data-link="manager^nickname" /><br/>
  <em>&lcub;^{>manager^nickname || manager^name}&rcub;:</em>
  <span class="spanbox">
    {^{>manager^nickname || manager^name}}
  </span>
</script>
<script>
var team = {
  person1: {
    name: "Peter",
    nickname: "Pete"
  },
  person2: {
    name: "Octavia"
  },
  changeManager: function() {
    $.observable(this).setProperty({
      manager: this.manager === this.person1 ? this.person2 : this.person1
    });
  }
};
team.manager = team.person1;
var tmpl = $.templates("#teamTmpl");
tmpl.link("#result", team);
</script>
</body>
</html>

```

注意：`{^{> ...}}`的表达式中可以出现HTML代码，因此如果你输入`...<sometag>...`像上面代码中nickname属性的值， `{^{> ...}}` 标签会将该标记原样插入到HTML中，这将不会出现错误。

## 5.{^{include ...}}

`{{include}}`：可以引入外部模板或者改变模板的上下文。实现模板的嵌套使用，如下面的代码所示：

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>
<div id="result"></div>
<script id="teamTmpl" type="text/x-jsrender">
  <button data-link="{on changeManager}">Change manager</button><br/><br/>
  <em>Name:</em> <input data-link="manager^name" /><br/>
  <em>Template:</em> <input data-link="manager^template" /><br/>
  <em>^&lcub;{include manager ^tmpl="manager^template"/}&rcub;:</em>
  <span class="spanbox">
    {^{include manager ^tmpl=manager^template/}}
  </span>
</script>
<script>
var team = {
  person1: {
    name: "Peter",
    template: "I am {^{>name}}"
  },
  person2: {
    name: "Octavia",
    template: "My name is <b>{^{>name}}</b>"
  },
  changeManager: function() {
    $.observable(this).setProperty({
      manager: this.manager === this.person1 ? this.person2 : this.person1
    });
  }
};
team.manager = team.person1;
var tmpl = $.templates("#teamTmpl");
tmpl.link("#result", team);
</script>
</body>
</html>

```

## 6.{^{for ...}}

`{^{for ...}}`：for循环会默认把数组或对象的第一层循环遍历掉，我们只要管里面的数据就行了，而且使用了循环之后的模板也可以单独写成一个模板，在for循环中引用,循环数组的时候可以使用`{{:#index}}`来获取当前数组的下标，并且index是从0开始。如下面的代码所示：

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>
<div id="team"></div>
<script id="teamTemplate" type="text/x-jsrender">
  <button data-link="{on addMember}">Add</button>
  <button data-link="{on replaceMembers}">Replace</button><br/><br/>
  <label><input type="checkbox" data-link="isEditable"/> Editable</label>
  <ol>
    {^{for members ^tmpl=isEditable?"#memberEditTmpl":"#memberTmpl" /}}
  </ol>
</script>
<script id="memberTmpl" type="text/x-jsrender">
  <li>
    {{>name}}
    <span class="remove" data-link="{on ~root.removeMember #index}"></span>
  </li>
</script>
<script id="memberEditTmpl" type="text/x-jsrender">
  <li>
    <input data-link="name"/>
    <span class="remove" data-link="{on ~root.removeMember #index}"></span>
  </li>
</script>
<script>
var team = {
  members: [
    {name: "Robert"},
    {name: "Sarah"}
  ],
  isEditable: false,
  addMember: function() {
    $.observable(this.members).insert({name: "new" + cnt++})
  },
  removeMember: function(index) {
    $.observable(this.members).remove(index);
  },
  replaceMembers: function() {
    $.observable(this).setProperty("members", [{name: "Peter"}, {name: "Octavia"}, {name: "Xavier"}])
  }
},
cnt = 1;
$.templates("#teamTemplate").link("#team", team);
</script>
</body>
</html>

```

`^tmpl=isEditable?"#memberEditTmpl":"#memberTmpl"`根据条件判断使用的不同的模板。

## 7.{^{if ...}}

`{^{if ...}}`：条件判断语句，但是，跟正常的代码逻辑还是有点区别的，当只有两种情况的时候，是没有区别的，就是if else。

```
{^{if reverse}}
    <b>{{:last}}</b>, {{:first}}
  {{else}}
    {{:first}} <b>{{:last}}</b>
  {{/if}}

```

但是当有多种情况的时候，也就是if elseif elseif else的时候，可是jsrender并没有elseif这样的写法，它会根据情况来判断，如果是多重情况，它会自动把else 当做elseif来使用，如下面代码所示：

```
{^{if reverse==1}}
    <b>{{:last}}</b>, {{:first}}
  {{else reverse==2}}
{{:first}} <b>{{:last}}</b>
{{else}}
    {{:middle}} <b>{{:middle}}</b>
  {{/if}}

```

注意：jsviews中的else不止与if一起用，后面单独介绍。

## 8.{^{props ...}}

`{^{props ...}}`：遍历对象并且获取到对象的key/value，当我们遍历对象需要使用到对象的key值时，使用props可以获取到key/value值，而且也可以在for循环中进行对象的遍历,在数据循环中获取可以使用#data获取到当前的对象，当然也可以使用引入外部模板来当做循环模板。

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/editable-data/hash-dictionary/" />
  <script src="../../../download/jsviews.min.js"></script>
  <link href="../sample.css" rel="stylesheet">
</head>
<body>
<div class="buttons">
  <button data-link="{on showData}">show data</button>
  <button data-link="{on deleteLast}">delete last language</button>
</div>
<div class="comment">Click to select and edit</div>
<div id="movieList"></div>
<script id="movieTemplate" type="text/x-jsrender">
  <table>
    <thead><tr>
      <th>Title</th><th>Languages</th>
      <th class="addMovie" data-link="{on ~addMovie}">Add</th>
    </tr></thead>
    <tbody class="movies">
      {^{props}}
        <tr class="hover" data-link="css-background-color{:~bgColor()} {on ~select key}">
          <td>
            {^{:#index + 1}}: {^{>prop.title}}
          </td>
          <td>
            {^{for prop.languages}}
              <div>{^{>name}}</div>
            {{/for}}
          </td>
          <td><span class="removeMovie" data-link="{on ~removeMovie key}"></span></td>
        </tr>
      {{/props}}
    </tbody>
  </table>
  <div class="detail">
    {^{for #data[~selectedKey]}}
      <div>
        <div class="title">Title:</div>
        <div><input data-link="title" /></div>
        <div class="title">
          Languages: <span class="addLanguage" data-link="{on ~addLanguage languages}">Add</span>
        </div>
        {^{for languages ~languages=languages}}
          <input data-link="name" />
          <span class="removeLanguage" data-link="{on ~removeLanguage ~languages #index}"></span>
        {{/for}}
      </div>
    {{/for}}
  </div>
</script>
<script id="showData" type="text/x-jsrender">
  {{props}}
	<div>
    <b>Movie:</b> {{>prop.title}}
    <b>Languages:</b> {{for prop.languages}} {{>name}}{{/for}}
  </div>
  {{/props}}
</script>
<div id="console">
</div>
<script>
"use strict";
var counter = 0,
  movies = { // Hash/dictionary of movies
    movJb: {
      title:"Meet Joe Black",
      languages: [
        {name: "English"},
        {name: "French"}
      ]
    },
    movEws: {
      title:"Eyes Wide Shut",
      languages: [
        {name: "German"},
        {name: "French"},
        {name: "Spanish"}
      ]
    }
  },
  helpers = {
//  selectedKey: "movEws", // Optionally set initial selection
    bgColor: function() {
      return this.ctxPrm("selectedKey")===this.data.key
        ? "yellow"
        : (this.index%2 ? "#fdfdfe" : "#efeff2");
    },
    select: function select(key, ev, eventArgs) {
      eventArgs.view.ctxPrm("selectedKey", key);
    },
    addMovie: function(ev, eventArgs) {
      var newKey = "mov" + counter;
      $.observable(movies).setProperty(
        newKey,
        {
          title: "NewTitle" + counter,
          languages: [
            {name: "NewLanguage" + counter++}
          ]
        }
      );
      eventArgs.view.ctxPrm("selectedKey", newKey);
    },
    removeMovie: function(key, ev, eventArgs) {
      eventArgs.view.ctxPrm("selectedKey", null);
      $.observable(movies).removeProperty(key);
      return false;
    },
    addLanguage: function(languages) {
      $.observable(languages).insert({
        name: "NewLanguage" + counter++
      });
    },
    removeLanguage: function(languages, index) {
      $.observable(languages).remove(index);
      return false;
    },
    deleteLast: function() {
      var propsArray = $.view("#movieList").get(true, "array").data;
      if (propsArray.length) {
        var lastMovie = propsArray[propsArray.length - 1].prop;
        $.observable(lastMovie.languages).remove();
      }
    },
    showData: function() {
      $("#console").append("<hr/>" + $("#showData").render(movies));
    }
  },
  movieTmpl = $.templates("#movieTemplate");
// Set dependency on bgColor, to update on collection (deletion) and selection changes
helpers.bgColor.depends = ["#index", "~selectedKey"];
// Render movies
movieTmpl.link("#movieList", movies, helpers);

// Data-link top-level buttons
$.link(true, ".buttons", helpers);
</script>
</body>
</html>

```

## 9.{^{radiogroup ...}}

`{^{radiogroup ...}}`：便于对radio按钮进行操作，使用方法如下面代码所示：

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>
<div id="top-level-linked">
  <div data-link="{radiogroup selectedCar}">
    <label><input type="radio" value=""/>
      None</label><br/>
    <label><input type="radio" value="vlv"/>
      Volvo</label><br/>
   <label><input type="radio" value="frd"/>
      Ford</label>
  </div>
  <span class="spanbox" data-link="selectedCar||'none'"></span>
</div>
<script>
var data = {selectedCar: "frd"};
$.link(true, "#top-level-linked", data);
</script>
</body>
</html>

```

注意：该标签中间可以嵌套for标签进行使用，上面代码中的selectedCar与设置默认选中值有关。

## 10.{{else ...}}

`{{else ...}}`：判断标签，jsviews中不止可以与if一块用，还可与`{^{for}}` 和 `{^{props}}`标签一同使用。

与{^{if}}一同使用

```
{^{if type==='book'}}
    The book price is {{>price}} 
  {{else type==='car'}}
    The car costs {{>price}}
  {{else}}
    Nothing chosen
  {{/if}}

```

与{^{for}}一同使用：

```
{^{for members}}
      <li>
        Member {^{:#index + 1}}: {{>name}}
        <span class="remove" data-link="{on ~root.removeMember #index}"></span>
      </li>
    {{else reserves}}
      <li>
        Reserve {^{:#index + 1}}: {{>name}}
        <span class="remove" data-link="{on ~root.removeReserve #index}"></span>
      </li>
    {{else}}
      <li>No members or reserves</li>
    {{/for}}

```

与{^{props}}一同使用：

```
{^{props members}}
      <li>
        <input data-link="prop"/>
        {^{>prop}}
        <span class="remove" data-link="{on ~root.removeMember key}"></span>
      </li>
    {{else}}
      There are no members
    {{/props}}

```

## 11.{^{on ...}}

`{^{on ...}}`：该标签可以进行方法绑定（参考2.6章节），还可按钮的创建；

创建按钮，下面代码中对`{^{on}}`创建按钮的样式和功能绑定的几种方式进行了展示：

```
<!DOCTYPE html>
<!-- To run the current sample code in your own environment, copy this to an html page. -->
<html>
<head>
  <script src="//code.jquery.com/jquery-1.12.4.min.js"></script>
  <base href="//www.jsviews.com/samples/" />
  <script src="../download/jsviews.min.js"></script>
  <link href="samples.css" rel="stylesheet" />
</head>
<body>
<style>
  .red {color: red;}
</style>
<span id="result"></span>
<script id="tmpl" type="text/x-jsrender">
  <button data-link="{on ~doSomething}" id="btn0">Click me</button>
  {^{on ~doSomething}}<button id="btn1">Click me</button>{{/on}}
  {^{on ~doSomething}}Click me{{/on}}
  {^{on ~doSomething tmpl="Click me" /}}
  {^{on ~doSomething /}}
  {^{on ~doSomething height=13 width=75 class="red" id="btn5"}}Click me{{/on}}
</script>
<script>
var tmpl = $.templates("#tmpl");
var person = {};
var helpers = {
  doSomething: function(ev) {
    alert("do something. id: " + ev.target.id);
  }
}
tmpl.link("#result", person, helpers); // Render and link the template
</script>
</body>
</html>

```

# 四、其他一些方法和用法

## 1.{{converters:value}}

`{{converters:value}}`：当后端给我们返回的数据格式跟页面所以展示的格式不一样的时候，我们就需要对数据进行转换。比如说后端返回时间的毫秒数，可是页面却要显示 年-月-日的格式或者是后端返回小写的字符，页面却要显示成大写的字符，这个时候转换器就派上用场了。

```
<script type="text/x-jsrender" id="j-myPersonalInfoTpl">
  <div>
      <h3>{{upper:name}}</h3>
      <p>{{:age}}</p>
  </div>
</script>
$.views.converters({
    upper: function(val){
        return val.toUpperCase();
    }
})
//使用jQuery选择器获取script标签声明的jsrender模板并传入数据跟一些方法渲染模板
var myPersonalTpl = $("#j-myPersonalInfoTpl").render(info);

```

## 2.{{:~helper(value)}} 

`{{:~helper(value)}}`对传入的参数value做处理，当我们拿到的数据不符合展示的需求是，我们需要对数据进行处理，那么我们可以使用辅助函数，把原始当参数传入，返回我们需要的数据。

```
<script type="text/x-jsrender" id="j-myPersonalInfoTpl">
        <div>
            <h3>{{:~hello(firstName, lastName)}}</h3>
            <p>{{:age}}</p>
        </div>
</script>
var info = {
    firstName: 'tom',
    lastName: 'joker',
    age: 18
};
$.views.helpers({
    hello: function(fisrtName, lastName){
        return 'Hello ' + fisrtName + ' ' + lastName;
    }
})
//使用jQuery选择器获取script标签声明的jsrender模板并传入数据渲染模板
var myPersonalTpl = $("#j-myPersonalInfoTpl").render(info);
```

## 3.$.templates()

`$.templates()`：除了上面介绍的可以指定一个模板外，还有其他一些用法

1. 可以指定多个模板：

```
//定义一个模板
    $.templates({
        'myTmpl': '#myTmpl',
        'extraTmpl': '<p>this is extraTmpl</p>'
    });
    //模板与数据关联
    var finalmyTmpl= $.render.myTmpl(info);
    var extraTmpl = $.render.extraTmpl();
    $('.box').html(finalmyTmpl).append(extraTmpl);
```

2. 指定一个模板时，为该模板指定专用的方法：

```
<script type="text/x-jsrender" id="myTpl">
    <div>
        <h3>{{upper:~append(name, ' stev')}}</h3>
        <p>{{:age}}</p>
    </div>
</script>
//定义一个命名模板,并指定只供这个模板使用的转换方法与辅助方法
$.templates("myTpl", {
    markup: "#myTpl",
    converters: {
        upper: function(val) {
            return val.toUpperCase();
        }
    },
    helpers: {
        append: function(a, b) {
            return a + b;
        }
    }
});
//模板与数据关联
var finalTpl = $.render.myTpl(info);

```

## 4.render() 

当我们使用`$.templates()`方法注册一个模板对象时，最后还是需要把模板对象跟数据结合得到最终的html字符串的，render()的使用方式有以下三种:

第一种：当模板对象myTmpl是使用`$.templates()`注册的模板时，只能使用`myTmpl.render(data)`的方式来渲染模板

```
//定义模板
var myTemplate = $.templates("#peopleTmpl");
//模板和数据进行关联
myTemplate. render (data);
```

第二种：当模板对象myPersonalTpl是以命名模板的方式注册时，需要使用`$.render.myPersonalTpl(data)`或者`$.render['myPersonalTpl'](data)`的方式来渲染模板:

```
$.templates({'myTmpl': '#myTmpl'});
$.render. myTmpl'(data)
```

第三种：当使用jQuery、并且模板是在script标签中声明时，还可以直接使用`$("#personTemplate").render(data)`，并不需要调用`$.templates()`方法来注册模板。

```
var myHelpers = {
        upper: function(val){
            return val.toUpperCase();
        }
    }
    //使用jQuery选择器获取script标签声明的jsrender模板并传入数据跟一些方法渲染模板
    var myPersonalTpl = $("#j-myPersonalInfoTpl").render(info, myHelpers);
    $('.box').html(finalTpl);
```

注意：在渲染模板的同时，传入一些函数供模板使用，例如：`$.render. myTmpl'(data，方法名)`

## 5.$.views.tags()

`$.views.tags()`：该方法可以创建自定义的jsviews的标签使用方法如下面代码所示：

```
$.views.tags("mytag", {
  render: function(...) {...},
  template: ...
});

{{mytag ...}} ... {{/mytag}}
```

第二种用法不定义模板，只定义方法：

```
$.views.tags("mytag", function(...) {
  ...return rendered content
});

{{mytag ...}} ... {{/mytag}}
```

第三种用法只定义模板不定义方法：

```
$.views.tags("mytag", "templateMarkup...");

{{mytag ...}} ... {{/mytag}}
```

第四种用法同时定义多个标签：

```
$.views.tags({
  mytag1: {
    render: function(val) {...},
    template: ...
  },
  mytag2: function(val) {...},
  mytag3: tag3TemplateString,
});
```

## 6.$.views.settings.debugMode()调试模式

当设置`$.views.settings.debugMode()`为true时，错误信息会打印在页面上的对应标签处

```
$.views.settings.debugMode(true);
```

当设置`$.views.settings.debugMode()`为false时，错误信息不会打印在页面上

```
$.views.settings.debugMode(false);
```

获得调试模式对象

```
var isDebugMode = $.views.settings.debugMode(); // false by default
```



# 五、综合实例

1. 动态绑定：所谓动态绑定就是当数据源发生变化时，与数据源绑定的组件也会动态的刷新。

```
<!DOCTYPE html>
<html>  
<head>  
    <link href="http://www.jsviews.com/samples/resources/css/samples.css" rel="stylesheet"/>  
    <script src="../jquery/jquery-2.0.3.js"></script>  
    <script src="../jsviews/jsviews.js"></script>  
</head>  
<body>  
<div id="result"></div>   
<script id="theTmpl" type="text/x-jsrender">  
<div>  
  Edit: <input type="checkbox" data-link="editable"/>  
  <em>Name:</em> {^{:name}}  
  {^{if showNickname && nickname}}  
    (Goes by <em data-link="nickname"></em>)  
  {{/if}}  
  {^{if editable}}  
    <div>  
      <input data-link="name"/>  
      <input data-link="nickname"/>  
      <input type="checkbox" data-link="showNickname"/>  
    </div>  
  {{/if}}  
</div>   
</script>  
<script>  
var data = [  
  {  
    "name": "JoshWang",  
    "nickname": "DW",  
    "showNickname": true  
  },  
  {  
    "name": "Susan",  
    "nickname": "Sue",  
    "showNickname": false  
  }  
];   
var template = $.templates("#theTmpl");    
template.link("#result", data);  
</script>    
</body>  
</html>  
```
代码解读

1）{^{name}} ... {^{if showNickname && nickname}}.这些标签是数据绑定标签，当与之关联的数据发生变化时，在template中相关的数据单元也会自动的发生变化。

2）将{{if...}}改成{^{if...}}同样是数据绑定。当关联的数据发生变化时，整个template部分的内容会自动的移除或者是重新插入。

3）`<em data-link="nickname">`： 同样可使用element-based来做数据绑定，这里表示<em>标签的文本内容会自动的绑定到nickName的值。

4） `<input data-link="name"/>`：这里 input会一双重绑定的方式自动的绑定到相关联数据的name属性。在这里，当修改input text box中的值的时候，相关的关联数据也会自动的更新，二该template的其他data-linked到同样属性(name)的部分也会立即自动的更新。
 