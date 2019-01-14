define(['jquery', 'service/util_service', 'widget/ajax_form', 'widget/select2', 'route_config', 'bootbox', 'autoComplete'], function($, util_service, ajax_form, select2, route_config, bootbox, autocomplete) {
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

    initPage: function() {
      function split(val) {
        return val.split(/,\s*/);
      }

      function extractLast(term) {
        return split(term).pop();
      }
      var availableTags = [{
        id: 1,
        typeId: 1,
        code: "mail.host",
        value: "smtp.126.com",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "smtp.126.com",
        version: 1
      }, {
        id: 2,
        typeId: 1,
        code: "mail.userName",
        value: "jsptzsupport",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "jsptzsupport",
        version: 1
      }, {
        id: 3,
        typeId: 1,
        code: "mail.password",
        value: "jsptz1234",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "jsptz1234",
        version: 1
      }, {
        id: 4,
        typeId: 1,
        code: "mail.smtp.timeout",
        value: "25000",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "2500",
        version: 1
      }, {
        id: 5,
        typeId: 1,
        code: "mail.smtp.auth",
        value: "true",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "true",
        version: 1
      }, {
        id: 6,
        typeId: 1,
        code: "mail.sendFrom",
        value: "jsptzsupport@126.com",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "jsptzsupport@126.com",
        version: 1
      }, {
        id: 7,
        typeId: 1,
        code: "hibernate.dialect",
        value: "org.hibernate.dialect.MySQLDialect",
        language: null,
        operateTimeForHis: null,
        typeId: 1,
        validStatus: "1",
        value: "org.hibernate.dialect.MySQLDialect",
        version: 1
      }];
//////////////////////////////////////////////单选/////////////////////////////////////////////////////
      $("#exampleSingle")
        .bind("keydown", function(event) {
          if (event.keyCode === $.ui.keyCode.TAB &&
            $(this).data("ui-autocomplete").menu.active) {
            //event.preventDefault();
          }
        })
        .autocomplete({
          source: function(request, response) {
            // 回到 autocomplete，但是提取最后的条目
            response($.ui.autocomplete.filter(
              availableTags, extractLast(request.term)));
          },
          minLength: 0,
          minChars: 0

        })
        .data("ui-autocomplete")._renderItem = function(ul, item) {
          var markup = "<table style='padding:0px;margin:0px;' class='table table-hover'>" +
            "<tr>" +
            "<td>" + item.code + "</td>" +
            "<td>" + item.value + "</td>" +
            "</tr>" +
            "</table>";
          return $("<li>")
            .append(markup)
            .appendTo(ul);
        };
//////////////////////////////////////////////多选/////////////////////////////////////////////////////
      $("#exampleMultiple")
        .bind("keydown", function(event) {
          if (event.keyCode === $.ui.keyCode.TAB &&
            $(this).data("ui-autocomplete").menu.active) {
            event.preventDefault();
          }
        })
        .autocomplete({
          source: function(request, response) {
            // 回到 autocomplete，但是提取最后的条目
            response($.ui.autocomplete.filter(
              availableTags, extractLast(request.term)));
          },
          minLength: 0,
          focus: function() {
            // 防止在获得焦点时插入值
            return false;
          },
          select: function(event, ui) {
            var terms = split(this.value);
            // 移除当前输入
            terms.pop();
            // 添加被选项
            terms.push(ui.item.label);
            // 添加占位符，在结尾添加逗号+空格
            terms.push("");
            this.value = terms.join(", ");
            return false;
          }
        });
//////////////////////////////////////////////单选ajax/////////////////////////////////////////////////////
      var qingkong = false;//添加判断选项，判断输入框是否清空
      var str = true;//判断书法的模式，控制输入汉字时，输入框中显示的字母触发ajax事件
      $("#exampleMultipleAjax").bind('compositionend',function(){//compositionend判断输入法的输入模式的事件
        str = true;
      })
      $("#exampleMultipleAjax").bind('compositionstart',function(){
        str = false;
      })
      $("#exampleMultipleAjax")
        .bind("keydown", function(event) {
          if (event.keyCode === $.ui.keyCode.TAB &&
            $(this).data("ui-autocomplete").menu.active) {
            //event.preventDefault();
          }
        })
        .autocomplete({
          //数据源属性，可以配置ajax或者本地数据源
          source: function(request, response) {
            if (str) {
              $.ajax({
                url: "api/misc/sdd/code/queryListAuotComplete",
                type: "post",
                dataType: "json",
                data: {
                  value: $("#exampleMultipleAjax").val()
                },
                beforeSend: function(request) {
                  request.setRequestHeader("Authorization", "Arch6WithCloud " + localStorage.getItem("jwt"));
                },
                success: function(data) {
                  if (data.data.length==1) {
                    $("#exampleMultipleAjax").val(data.data[0].code);
                    qingkong = false;
                    setTimeout(function () { $("#exampleMultipleAjax").autocomplete( "close" ); }, 1000);
                  }
                  response($.map(data.data, function(item) {
                    return {
                        label: item.code,
                        value: item.value
                    }
                    return item;
                  }));
                }
              });
            }
          },
          minLength: 0,//配置下拉框的最小查询字符长度
          //输入框获取焦点事件
          focus: function() {
            // 防止在获得焦点时插入值
            return false;
          },
          // 点击下拉框中的选项触发
          select: function( event, ui ) {
              $("#exampleMultipleAjax").val(ui.item.label);
              qingkong = false
              return false;
          },
          //下拉框展开是触发的事件
          response: function( event, ui ) {
              // event 是当前事件对象
              // ui对象仅有一个content属性，它表示当前用于显示菜单的数组数据
              // 每个元素都是具有label和value属性的对象
              // 你可以对属性进行更改，从而改变显示的菜单内容
              if (ui.content.length==0) {
                  qingkong = true;
                  ui.content[0]={label: "无数据", value: null, category: "无数据"};
                  setTimeout(function () { $("#exampleMultipleAjax").autocomplete( "close" ); }, 1000);
              }
          },
          //焦点离开输入框时触发的事件
          change: function( event, ui ) {
              if($("#exampleMultipleAjax").val()==''){
                $("#exampleMultipleAjax").val('');
              }
              if(qingkong){
                $("#exampleMultipleAjax").val("");
              }
              qingkong = true;
              // if(null==ui.item||$input.val()==''){
              //   hiddenlist[0].val('');
              // }
              /*if($input.val()==''){
                hiddenlist[0].val('');
              }
              if(selectedCallback && typeof (selectedCallback) == 'function'){
                selectedCallback();
              }*/
              return false;
          },


        })
        //双击事件
        .dblclick(function() {
          // 双击的时候进行查找
          $(this).autocomplete('search', '');
        })
        //下拉框模板配置
        .data("ui-autocomplete")._renderItem = function(ul, item) {
          //自定义模板
          if (item.value != null) {
          var markup = "<table style='padding:0px;margin:0px;' class='table'>" +
            "<tr>"
            + "<td>" + item.label + "</td>"
            + "<td>" + item.value + "</td>" +
            "</tr>" +
            "</table>";
          return $("<li>")
            .append(markup)
            .appendTo(ul);
          } else {
            return ul.append( "<li class='ui-autocomplete-category' style='pointer-events: none;cursor: default;color:red;'>" + item.category + "</li>" );
          }
        };
    },


  };

  return {
    initPage: $.proxy(page.initPage, page)
  };
});