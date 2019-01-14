/**
 * form提交
 * @module postForm
 * @author czl
 * @time 2015/11/5
 */
define(['require', 'jquery', './http', './dialog', 'jquery_validate'],
    function(require, $, http, dialog)  {
        "use strict";

        /**
         * AjaxForm的对象
         */
        var AjaxForm = function(options) {

            /**
             * AjaxForm的选项
             * @type Object
             * @private
             */
            this.options = $.extend({
                apiName: '',
                messages: {},
                rules: {},
                data: null,
                isOpenAlert: false,
                $form: $('#form'),
                ignore: ":hidden", //隐藏域不需要验证
                type: null,
                $container: null,
                $btnShowLoad: null,
                $showErrorPand: $('#div_error'),
                timeout: 60000,
                dataType: 'json',
                alertTitle: UtilMsg.ajax_save_alert_title,
                alertContent: UtilMsg.ajax_save_alert_content,
                beforeSubmit: null,
                afterSuccess: null,
                errorSubmit: null,
                beforeAjax: null,
                callManualCheck:function() {
                    return true;
                }
            }, options || {});
            this.util_service = null;
        };

        /**
         * AjaxForm类的静态函数
         */
        AjaxForm.init = function(opt) {
            return new AjaxForm(opt)._initAjaxForm();
        };

        /**
         * AjaxForm的原型对象
         */
        AjaxForm.prototype = {

            _initAjaxForm:function() {
                var valid  = this._validateForm();
                this.options.$form.validate(valid);
                if (!this.options.type) {
                    if (this.options.$form.find('#editMode').val() === 'create') {
                        this.options.type = 'POST';
                    } else {
                        this.options.type = 'PUT';
                    }
                }
                return this;
            },

            _validateForm:function() {
                var _this = this;

                return {
                    rules: this.options.rules,
                    messages: this.options.messages,
                    ignore: this.options.ignore || '',
                    invalidHandler:function(e, validator) {
                        if (_this.options.$showErrorPand && _this.options.$showErrorPand.length > 0) {
                            var errors = validator.numberOfInvalids();
                            if (errors) {
                                var message = errors == 1 ? 1 + UtilMsg.ajax_validatenum : errors + UtilMsg.ajax_validatenum;
                                _this.options.$showErrorPand.find('p').html(message);
                                _this.options.$showErrorPand.show();
                            } else {
                                _this.options.$showErrorPand.hide();
                            }
                        }

                    },
                    onfocusout:function(e) {
                        $(e).valid();
                    },
                    errorPlacement:function(error, element) {
                        var elem = $(element);
                        //console.info(elem, error.is(':empty'));
                        if (!error.is(':empty')) {
                            if (!elem.attr('aria-describedby')) {
                                elem.tooltip({
                                    placement: 'bottom',
                                    title: $(error).html(),
                                    trigger: 'manual'
                                }).tooltip('show');
                            } else {
                                $('#' + elem.attr('aria-describedby'))
                                    .find('.tooltip-inner').html($(error).html());
                            }

                        } else {
                            elem.tooltip('destroy');
                        }

                    },
                    success:function(a, b) {

                    },
                    submitHandler:function() {

                        _this.options.$showErrorPand && _this.options.$showErrorPand.hide();
                        if (!_this.options.isOpenAlert) {
                            _this._ajaxSubmit(_this.options.$form);
                        } else {
                            dialog.confirm({
                                title: _this.options.alertTitle || UtilMsg.ajax_save_alert_title,
                                content: _this.options.alertContent || UtilMsg.ajax_save_alert_content,
                                onSuerBefore:function() {
                                    _this._ajaxSubmit(_this.options.$form);
                                }
                            });
                        }

                    }
                };
            },

            _ajaxSubmit:function(fm) {
                var _this = this;
                if ($.isFunction(this.options.callManualCheck) && !this.options.callManualCheck.call(this)) {
                    return;
                }
                $.isFunction(this.options.beforeSubmit) && this.options.beforeSubmit.call(this);
                http.post({
                    apiName: this.options.apiName,
                    data: this.options.data || this.serializeObject(fm.serializeArray()),//fm.serialize(),
                    type: this.options.type,
                    dataType: this.options.dataType,
                    isMask: true,
                    $form: fm,
                    timeout: this.options.timeout,
                    $btnShowLoad: this.options.$btnShowLoad,
                    beforeSend:function() {
                        $.isFunction(_this.options.beforeAjax) && _this.options.beforeAjax.call(this);
                    },
                    complete:function(XMLHttpRequest, textStatus) {
                        $.isFunction(_this.options.complete) && _this.options.complete.call(this);
                    },
                    error:function(msg, xhr) {
                        if ($.isFunction(_this.options.errorSubmit)) {
                            _this.options.errorSubmit.call(this);
                        } else {
                        	http.alertError(xhr);
                        }
                    },
                    success:function(b) {
                        if (_this.options.dataType == 'html' && _this.options.$container) {
                            _this.options.$container.html(b);
                            if (!_this.util_service)
                                _this.util_service = require('../service/util_service');
                            _this.util_service._initPage(_this.options.$container);
                        } else {
                            $.isFunction(_this.options.afterSuccess) && _this.options.afterSuccess.call(this, b);
                        }
                    }
                });
            },
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
            _setApiName:function(apiName) {
                if (apiName && apiName != '')
                    this.options.apiName = apiName;
            },

            _setBtnShowLoad:function($obj) {
                if ($obj && $obj.length > 0)
                    this.options.$btnShowLoad = $obj;
            },

            _setaAlertTitle:function(str) {
                if (str != '')
                    this.options.alertTitle = str;
            },

            _setDataType:function(str) {
                if (str != '')
                    this.options.dataType = str;
            },

            _setType:function(str) {
                if (str != '')
                    this.options.type = str;
            },

            _setAlertContent:function(str) {
                if (str != '')
                    this.options.alertContent = str;
            },

            _deleteBtnShowLoad:function() {
                this.options.$btnShowLoad = null;
            }
        };

        return AjaxForm;
    });
