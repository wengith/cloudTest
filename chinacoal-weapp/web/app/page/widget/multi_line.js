/**
 * 数据表格
 * @module table_data
 * @author czl
 * @time 2015/10/29
 */
 define(['jquery', './http','widget/select2','jquery-datatable'],function($,http,select2){
  var multiLineInstance;
  var multiTable;
  var columns;
  var $this;
  var MultiLine = function(opt) {

    /**
     * 多行数据的选项
     * @type Object
     **/
    this.options = $.extend({
      'searching': false,
      'ordering':  false,
      'info': false,
      'lengthChange': true,
      'autoWidth':false,
      "paging": false,
      'destroy':true,
      "processing": false,
      "oLanguage": {//国际语言转化
        "sEmptyTable": "无数据"
      },
      'table':null,
      'data':null,
      'columns':null,
      'rowCallback':null,
      '$addButton':null
    }, opt || {});
    $.extend($.fn.dataTable.defaults, this.options);
  };

  /**
   * 多行数据展示
   * @method show
   */
   MultiLine.show = function(options) {
    var multiLine = new MultiLine(options);
    var $table = multiLine.options.table;
    multiTable = $table;
    multiLine.options.rowCallback = multiLine.rowCallback;
    columns = multiLine.options.columns;
    multiLineInstance = $table.DataTable(multiLine.options);
    multiLine.bindEvent();
    $this = multiLine;
    return $this;
  };

    /**
     * 多行数据的原型
     * @static
     */
  MultiLine.prototype = {

    /**
     * 初始化数据表格
     */
    bindEvent:function() {
      multiTable.find('tbody').on('click','i.delete',$.proxy(this.deleteClick, this));
      this.options.$addButton.on('click',$.proxy(this.addClick, this));
    },
    rowCallback:function(row, data, displayIndex, displayIndexFull) {
      var str = '';
      str += '<a href="#" title="删除" ><i class="fa fa-times fa-lg delete" data-index="'+displayIndex+'"></i></a>&nbsp;';
      var td = "td:eq('size')";
      for(var i in columns){
        if(i<columns.length-1){
          var colum = columns[i];
          var d = colum.data;
          var $td = td.replace(/size/g,i);
          var type = colum.type; 
          if(type==undefined||type=='text'){
            var name = colum.name;
            name = name.replace(/form/g,displayIndex);
            $($td, row).html('<input class="form-control" type="text" value="'+data[d]+'" name="'+name+'" />');
          }
          else if (type=="select"){
            var items = name.split(".");
            var select = items.join("");//数组转成字符串,元素是通过指定的分隔符进行分隔的。此时以空串分割：即直接连接
            select = select.replace("[","");
            select = select.replace("]","");
            $($td, row).html('<select style="width:70%;overflow:visible;" class="form-control '+select+'" name="'+name+'"></select>');
            select2.show({
                view: {
                    url: null, //本模块service.js中定义的apiName
                    type:select,
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
            $("."+select).val("2").trigger('change');
          }
        }
        else{
          $('td:eq('+i+')', row).html(str);
        }
      }
    },
    addClick:function(event){
      var $this = $(event.target);
      var index = $this.data('index');
      var columns = this.options.columns;
      var temp = new Object();
      for(var i in columns){
        temp[columns[i].data]="";
      }
      multiLineInstance
      .row
      .add(temp).draw();
    },
    deleteClick:function(event){
      var $this = $(event.target);
      var index = $this.data('index');
      //移除当前行
      multiLineInstance
      .row($this.parents('tr') )
      .remove()
      .draw();
    }
  };
  return MultiLine;
});
