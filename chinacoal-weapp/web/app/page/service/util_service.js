/**
 * 工具
 * @module util_service
 * @author czl
 * @time 2015/11/5
 */
 define(['require', 'jquery', '../widget/template', 'datetimepicker'], function(require, $, template)  {

    var dialog = null;
    var params = {};
    var route_config = null;
    var util = {
     _createXMLDom:function(){
        var xmlhttp = null;
        try{
            xmlhttp=new XMLHttpRequest();
        }catch(e){
            try{
                xmlhttp= xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }catch(e){
                alert(e.message);
                return;
            }
        }
        return xmlhttp;
    },
    _getXmlData:function(path){
        var xmlhttp = this._createXMLDom();
        xmlhttp.open("GET",path,false);
        xmlhttp.send();
        var root = xmlhttp.responseXML;
        return root;
    },
        /**
        初始化页面
        **/
        _initPage:function($container) {
            if (!$container || $container.length === 0) return;
            this._initInjectiontp($container);
            //this._closeDialog($container);
        },
        //获得文件的大小
        findSize:function(fileInput) {
            let byteSize = fileInput.files[0].size;
            return (Math.ceil(byteSize / 1024));
        },
         /**
        解码html
        **/
        HTMLDecode:function(text) {
            if (!text || text == '')
                return '';
            var temp = document.createElement("div");
            temp.innerHTML = text;
            var output = temp.innerText || temp.textContent;
            temp = null;
            return output;
        },
        /**
        初始化日期组件框
        **/
        _initDateWidget:function($container) {
            var $this;
            $.each($container.find("input.form_date"), function(i, n)  {
                $this = $(n);
                $this.datetimepicker({
                    format: $this.data('format') || 'yyyy-mm-dd',
                    minViewMode: "0",
                    autoclose: true,
                    clearBtn: $this.data('clear-btn') || false,
                    todayHighlight: true,
                    todayBtn: 'linked',
                    language: "zh-CN",
                    endDate: $this.data('end-date') ? new Date() : null
                }).on('changeDate', function(e) {
                    $(e.currentTarget).trigger('changeTime').trigger('blur');
                }).next('span').on('click', function() {
                    $(this).prev('input').trigger('focus');
                });
            });
        },
        /**
         * 关闭模态窗口
         */
         _closeDialog:function($obj, flag) {
            if (!dialog)
                dialog = require('../widget/dialog');
            $obj = !flag ? $obj.find('button.btn-close') : $obj;
            $obj.on('click', function(n)  {
                dialog.closeDialog($(n.currentTarget).closest('div.modal').attr('id'));
            });
        },
        /**
         * 中文编码
         * @param {object} obj 对象
         * @param {String} type 对象类型 1：对象，2：表单对象
         */
         _codeZhCnObject:function(obj, type) {
            if (typeof(obj) != "object")
                return obj;

            if (!type || type === '1') {
                for (var name in obj) {
                    if (/.*[\u4e00-\u9fa5]+.*$/.test(obj[name])) {
                        obj[name] = encodeURI(obj[name]);

                    }
                }
            } else {
                for (var name in obj) {
                    if (/.*[\u4e00-\u9fa5]+.*$/.test(obj[name].value)) {
                        obj[name].value = encodeURI(obj[name].value);

                    }
                }
            }
            return obj;
        },

        /**
         * 对象值渲染到指定容器的表单输入域(输入域的样式存在“no-render”，则不进行渲染)
         * @param {object} $obj 渲染的容器
         * @param {String} obj json对象
         */
         _renderJsonToForm:function($obj, obj) {
            if (typeof(obj) === 'object' && $obj && $obj.length > 0) {
                var $input;
                for (var name in obj) {
                    $input = $obj.find('select[name=' + name + '],input[name=' + name + '],input[textarea=' + name + ']');
                    $input && $input.length > 0 && !$input.hasClass('no-render') && this._voluationToForm($input, obj[name]);
                }
            }
        },
        /**
         * 序列化对象
         * @param obj 需要序列化的对象，例如表单
         */
         serializeObject:function(obj) {
            var o = {};
            $.each(obj, function() {
                if (o[this.name] !== undefined) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        },

        serializeObject1:function(obj) {
            var o = '';
            $.each(obj, function() {
                if (this.value !== undefined&&this.value!=="") {
                    o += this.name + '=' + this.value + '&';
                } /*else {
                    o += this.name + '=' + '&';
                }*/
            });
            if (o.length > 0) o = o.substring(0, o.length - 1);
            return o;
        },
        /**
         * 赋值给表单域对象，比如对输入框、单选框、复选框、下拉框
         * @param obj 对象
         * @param str 值
         */
         _voluationToForm:function($obj, str) {
            switch ($obj.attr('type')) {
                case 'text':
                $obj.val(str);
                break;
                case 'radio':
                case 'checkbox':
                var $this;
                $obj.each(function(i, n)  {
                    $this = $(n);
                    $.trim($this.val()) === str && $this.prop('checked', true);
                });
                break;
                default:
                if ($obj.is('select')) {
                    $obj.find('option[value="' + str + '"]').prop('selected', true);
                } else if ($obj.is('textarea')) {
                    $obj.text(str);
                }
                break;
            }

        },

        /**
         * 获取选中的值
         * @param {object} $obj 结点
         * @param {String} type 0:checkbox 1:radio
         * @param {String} joinType 拼接的字符 默认','
         * @param {String} dataType 值取的属性
         * @returns {String} 
         */
         _getCheckData:function($obj, type, joinType, dataType) {
            if (!$obj || $obj.length == 0)
                return '';

            var param = '';

            if (type === '0') {
                joinType = !joinType ? ',' : joinType;

                $obj.find('input[type=checkbox]:checked').each(function(i, n)  {
                    param += !dataType ? $(n).val() + joinType : $(n).attr(dataType) + joinType;
                });

                return param && param.length > 0 ? param.substring(0, param.length - 1) : '';
            } else {
                param = !dataType ? $obj.find('input[type=radio]:checked').val() : $obj.find('input[type=radio]:checked').attr(dataType);

                return param;
            }


        },

        /**
         * readonly所有输入与域
         * @param $obj
         * @param type 0:查找form表单，1:使用当前注入的jq对象
         */
         _readonlyInput:function($obj, type) {
            if (!$obj || $obj.length === 0) return;

            $obj.find('select, input, textarea').each(function(i, n)  {
                util._handleReadonlyInput(n);
            });

        },
        _handleReadonlyInput:function(obj) {
            switch (obj.tagName) {
                case 'INPUT':
                var $obj = $(obj);
                switch ($obj.attr('type')) {
                    case 'text':
                    $obj.prop('readonly', true);
                    break;
                    case 'radio':
                    case 'checkbox':
                    $obj.prop('disabled', true);
                    break;
                }
                break;
                case 'TEXTAREA':
                $(obj).prop('disabled', true);
                case 'SELECT':
                var $t = $(obj);
                $t.attr('name', '');
                $t.prop('disabled', true);
                $fm.append('<input type="hidden" name="' + $t.attr('name') + '" value="' + $t.attr('defaultValue') + '">');
                break;
            }
        },
        /**
         * 格式化数字
         * @param $obj input对象
         * @param isShow 是否是展示用 true=展示, false=非展示
         * @param type 1=金额, 2=重量 
         * @param l 小数点长度
         */
         _forAutoMatNum:function($obj, isShow, type, l) {
            if (!$obj || $obj.length == 0)
                return;

            var val = $.trim($obj.val()),
            b = true,
            decimal = $obj.data('decimal-length'),
            l = decimal || decimal == '0' ? parseInt(decimal) : l;

            if (val == '') {
                return;
            } else {
                if (val.indexOf('-') > -1) {
                    val = val.substring(1, val.length);
                    b = false;
                }
                val = val.replace(/,/g, '');
                if (!/(^[0-9]+$)|(^[0-9]+.[0-9]{1,}$)/.test(val)) {
                    $obj.val('');
                    return;
                }

                if (!isShow) {
                    if (/^0+\./.test(val)) {
                        val = val.replace(/^0+\./, '0.');
                    } else {
                        val != '0' && (val = val.replace(/^0+/g, ''), val == '' && (val = '0'));
                    }
                    val = this._forMatNumber(val, l);
                    val = val.replace(/,/g, '');
                    if (this._forMatPrice($obj, val, 16, l) != '0')
                        return;
                }

                val = this._forMatNumber(val, l);
            }

            !b && (val = '-' + val);
            $obj.val(val);
        },

        /**
         * 金额位数校验
         * @param $obj
         * @param precision 位数
         * @returns 
         */
         _forMatPrice:function($obj, val, precision, l) {
            var _this = this;
            //判断位数
            if (val.length > precision) {
                //位数超出
                //setTimeout(function(){
                    if (!dialog)
                        dialog = require('../widget/dialog');
                    !_this.d_alert && (_this.d_alert = dialog.alert({
                        content: '输入数据不能超出' + precision + '位，整数部分不能超出' + (precision - l - 1) + '位。',
                        lazyshow: true,
                        onCloseBefore:function() {
                            $obj.focus();
                            _this.d_alert = null;
                        }
                    }));
                //}, 150);
                return "1";
            } else {
                return "0";
            }
        },

        /**
         * 数字千分位
         * @param num
         * @returns {String}
         */
         _forMatNumber:function(value, precision) {
            value = value + "";
            var pos = value.indexOf('.');
            if (pos > -1) {
                var firstValue = value.substring(0, pos);
                var lastValue = value.substring(pos + 1);
                var re = /(-?\d+)(\d{3})/;
                while (re.test(firstValue)) {
                    firstValue = firstValue.replace(re, "$1,$2");
                }
                value = firstValue + "." + lastValue;
            } else {
                var re = /(-?\d+)(\d{3})/;
                while (re.test(value)) {
                    value = value.replace(re, "$1,$2");
                }
            }
            if (precision != undefined && !isNaN(precision) && precision) {
                var pos = value.indexOf('.');
                if (pos == -1) {
                    value += ".";
                    pos = value.indexOf('.');
                }

                var len = value.length - pos - 1;
                if (len <= precision) {
                    for (var i = len; i < precision; i++) {
                        value += "0";
                    }
                } else {
                    value = value.substring(0, (value.length - len + precision));
                }

            }
            return value;
        },
        _initInjectiontp:function($obj) {
            if (!route_config)
                route_config = require('route_config');

            $obj.find('includepage').each(function(i, n)  {
                var $this = $(n),
                url = $this.data('url'),
                type = $this.data('type');

                route_config.forwardPage(url, {
                    $container: $this,
                    type: type,
                    stateParams: {},
                    data: {},
                    isInitPage: true
                });
            });
        }
    };
//代码参照 jquery_datatable.js   version     1.10.19-dev
// http://en.wikipedia.org/wiki/Foreign_exchange_market
// - \u20BD - Russian ruble.
// - \u20a9 - South Korean Won
// - \u20BA - Turkish Lira
// - \u20B9 - Indian Rupee
// - R - Brazil (R$) and South Africa
// - fr - Swiss Franc
// - kr - Swedish krona, Norwegian krone and Danish krone
// - \u2009 is thin space and \u202F is narrow no-break space, both used in many
// - Ƀ - Bitcoin
// - Ξ - Ethereum
//   standards as thousands separators.
var _re_formatted_numeric = /[',$£€¥%\u2009\u202F\u20BD\u20a9\u20BArfkɃΞ]/gi;
var _re_date = /^\d{2,4}[\.\/\-]\d{1,2}[\.\/\-]\d{1,2}([T ]{1}\d{1,2}[:\.]\d{2}([\.:]\d{2})?)?$/;
var _re_new_lines = /[\r\n]/g;
var _re_dic = {};
// Escape regular expression special characters
var _re_escape_regex = new RegExp( '(\\' + [ '/', '.', '*', '+', '?', '|', '(', ')', '[', ']', '{', '}', '\\', '$', '^', '-' ].join('|\\') + ')', 'g' );
/**
 * Escape a string such that it can be used in a regular expression
 *  @param {string} sVal string to escape
 *  @returns {string} escaped string
 *  @memberof DataTable#oApi
 */
 function _fnEscapeRegex ( sVal )
 {
    return sVal.replace( _re_escape_regex, '\\$1' );
}
var _empty = function ( d ) {
    return !d || d === true || d === '-' ? true : false;
};
var _numToDecimal = function ( num, decimalPoint ) {
    // Cache created regular expressions for speed as this function is called often
    var _re_dic = [];
    if ( ! _re_dic[ decimalPoint ] ) {
        _re_dic[ decimalPoint ] = new RegExp( _fnEscapeRegex( decimalPoint ), 'g' );
    }
    return typeof num === 'string' && decimalPoint !== '.' ?
    num.replace( /\./g, '' ).replace( _re_dic[ decimalPoint ], '.' ) :
    num;
};
var _isNumber = function ( d, decimalPoint, formatted ) {
    var strType = typeof d === 'string';

    // If empty return immediately so there must be a number if it is a
    // formatted string (this stops the string "k", or "kr", etc being detected
    // as a formatted number for currency
    if ( _empty( d ) ) {
        return true;
    }

    if ( decimalPoint && strType ) {
        d = _numToDecimal( d, decimalPoint );
    }

    if ( formatted && strType ) {
        d = d.replace( _re_formatted_numeric, '' );
    }
    return !isNaN( parseFloat(d) ) && isFinite( d );
};
var _htmlNumeric = function ( d, decimalPoint, formatted ) {
    if ( _empty( d ) ) {
        return true;
    }

    var html = _isHtml( d );
    return ! html ?
    null :
    _isNumber( _stripHtml( d ), decimalPoint, formatted ) ?
    true :
    null;
};

util.ext = {
    typesDetectFun :[],
    order : [],
    search : []
};

$.extend(util.ext.typesDetectFun, [
    function ( d, settings )
    {
        var decimal = settings.oLanguage.sDecimal;
        return _isNumber( d, decimal ) ? 'num'+decimal : null;
    },
    //日期
    function ( d, settings )
    {
        if ( d && !(d instanceof Date) && ! _re_date.test(d) ) {
            return null;
        }
        var parsed = Date.parse(d);
        return (parsed !== null && !isNaN(parsed)) || _empty(d) ? 'date' : null;
    },
    //带格式的数字
    function ( d, settings )
    {
        var decimal = settings.oLanguage.sDecimal;
        return _isNumber( d, decimal, true ) ? 'num-fmt'+decimal : null;
    },
    function ( d, settings )
    {
        var decimal = settings.oLanguage.sDecimal;
        return _htmlNumeric( d, decimal ) ? 'html-num'+decimal : null;
    },

    function ( d, settings )
    {
        var decimal = settings.oLanguage.sDecimal;
        return _htmlNumeric( d, decimal, true ) ? 'html-num-fmt'+decimal : null;
    },
    function ( d, settings )
    {
        return _empty( d ) || (typeof d === 'string' && d.indexOf('<') !== -1) ?
        'html' : null;
    }
    ] );
util.ext.getDataType = function(data,settings){
    var types = util.ext.typesDetectFun;
    var detectedType =null;
    for ( j=0, jen=types.length ; j<jen ; j++ ) {
        detectedType = types[j]( data, settings );
        if ( ! detectedType && j !== types.length-1 ) {
            //最后一个方法也没有检测出来
            break;
        }
        if ( detectedType === 'html' ) {
            break;
        }
    }
    return detectedType;
}
$.extend( util.ext.search, {
    html: function ( data ) {
        return _empty(data) ?
        data :
        typeof data === 'string' ?
        data
        .replace( _re_new_lines, " " )
        .replace( _re_html, "" ) :
        '';
    },

    string: function ( data ) {
        return _empty(data) ?
        data :
        typeof data === 'string' ?
        data.replace( _re_new_lines, " " ) :
        data;
    }
} );

// Default sort methods
$.extend( util.ext.order, {
    // Dates
    "date-pre": function ( d ) {
        var ts = Date.parse( d );
        return isNaN(ts) ? -Infinity : ts;
    },

    // html
    "html-pre": function ( a ) {
        return _empty(a) ?
        '' :
        a.replace ?
        a.replace( /<.*?>/g, "" ).toLowerCase() :
        a+'';
    },

    // string
    "string-pre": function ( a ) {
        // This is a little complex, but faster than always calling toString,
        // http://jsperf.com/tostring-v-check
        return _empty(a) ?
        '' :
        typeof a === 'string' ?
        a.toLowerCase() :
        ! a.toString ?
        '' :
        a.toString();
    },

    // string-asc and -desc are retained only for compatibility with the old
    // sort methods
    "string-asc": function ( x, y ) {
        return ((x < y) ? -1 : ((x > y) ? 1 : 0));
    },

    "string-desc": function ( x, y ) {
        return ((x < y) ? 1 : ((x > y) ? -1 : 0));
    }
} );
return util;
});
