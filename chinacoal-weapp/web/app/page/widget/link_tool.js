/**
 * jsviewslink拓展工具
 * @time 2018/11/23
 * @author sxj
 */
define(['jquery','./http','jsviews','../config/jsviews_config'],($,http) => {
	  /**
	   * jsviewslink拓展工具
	   * @static
	   */
	  var jsviewsLink = {
	  	_wholePreLink(key,callback){
	  		$.templates.wholePreCall(key,callback);
	  	},
	  	_wholeAftLink(key,callback){
	  		$.templates.wholeAftCall(key,callback);
	  	},
	  	_instancePreLink(tmpl,key,callback){
	  		$.templates.instancePreCall(tmpl,key,callback);
	  	},
	  	_instanceAftLink(tmpl,key,callback){
	  		$.templates.instanceAftCall(tmpl,key,callback);
	  	},
	  	_getAllTagType(str){
	  		var regselect = /\{ins_dir_select(.+?)\/\}/gi;
	  		var regoptions = /\{ins_dir_options(.+?)\/\}/gi;
			var arrselect = str.match(regselect);
			var arroptions = str.match(regoptions);
			var arrresult = new Array();
			if(arrselect && arrselect.length>0){
				for(var i=0;i<arrselect.length;i++){
					var diritem = $.trim(arrselect[i].replace("{ins_dir_select","")
						.replace(/\/\}/gi,"")
						.replace(/\'/gi,"")
						.replace(/\"/gi,"")).split(" ")[0];
					if(!arrresult.contains(diritem)){
						arrresult.push(diritem);
					}
				}
			}
			if(arroptions && arroptions.length>0){
				for(var i=0;i<arroptions.length;i++){
					var diritem = $.trim(arroptions[i].replace("{ins_dir_options","")
						.replace(/\/\}/gi,"")
						.replace(/\'/gi,"")
						.replace(/\"/gi,""));
					if(!arrresult.contains(diritem)){
						arrresult.push(diritem);
					}
				}
			}
			return arrresult;
	  	},
	  	_link(options){
	  		options.templateinstance = $.templates(options.template);
	  		var tags = jsviewsLink._getAllTagType(options.templateinstance.markup);
	  		if(tags && tags.length>0){
	  			jsviewsLink._instancePreLink(options.template+options.container,"initdirtagdata",function(obj){
		  			var j = 0;
		  			for(var i=0;i<tags.length;i++){
		  				if(DirCache['init_dictionary_data'+GlobalUtils.stringify({ dataType: tags[i]})]){
		  					j++;
		                	if(j==tags.length){
		                 		obj.resolve();
		                	}
		  					continue;
		  				}
		  				(function(i,obj){
			  				http.get({
		  					 	 apiName : 'init_dictionary_data',
				                 async : true,
				                 params : { dataType: tags[i]},
				                 success(data) {
				                 	DirCache['init_dictionary_data'+GlobalUtils.stringify({ dataType: tags[i]})] = data.data;
				                 	j++;
				                	if(j==tags.length){
				                 		obj.resolve();
				                	}
				                }
		  					 });
		  				})(i,obj);
		  			}
	  			});
	  		}
	  		
	  		if($.templates.instancePreCalls[options.template+options.container]){
                var i=0;
                var j=0;
                for(var keyItem in $.templates.instancePreCalls[options.template+options.container]){
                    j++;
                }
                for(var key in $.templates.instancePreCalls[options.template+options.container]){
                    var defer = $.Deferred();
                    $.templates.instancePreCalls[options.template+options.container][key](defer);
                    defer.done(function(){
                        i++;
                        if(i==j){
                            options.templateinstance.link(options.container,options.data,options.helps);
                            if($.templates.instanceAftCalls[options.template+options.container]){
				                for(var key in $.templates.instanceAftCalls[options.template+options.container]){
				                    $.templates.instanceAftCalls[options.template+options.container][key]();
				                }
				            }
                        }
                    });
                }
            }else{
            	options.templateinstance.link(options.container,options.data,options.helps);
            	if($.templates.instanceAftCalls[options.template+options.container]){
	                for(var key in $.templates.instanceAftCalls[options.template+options.container]){
	                    $.templates.instanceAftCalls[options.template+options.container][key]();
	                }
	            }
            }
	  	},
	  	_aftinitsearch(params,$input,$hidden,api){
  			if(!DirCache[api+GlobalUtils.stringify(params)]){
				http.get({
					apiName : api,
	                async : true,
	                params : GlobalUtils.parse(params),
	                success(data) {
	                	DirCache[api+GlobalUtils.stringify(params)] = data.data;
						searchautocomplete._initSearchBox({
							currentInput:$input,
							initDataInput:$hidden,
							data:DirCache[api+GlobalUtils.stringify(params)],
							result:{
								'code':$hidden,
								'name':$input
							}
						});
	                }
				});
			}else{
				searchautocomplete._initSearchBox({
					currentInput:$input,
					initDataInput:$hidden,
					data:DirCache[api+GlobalUtils.stringify(params)],
					result:{
						'code':$hidden,
						'name':$input
					}
				});
			}
	  	},
	  	_aftinitsearchserver(params,$input,$hidden,api,istransfer){
	  		if(!istransfer) istransfer = false;
	  		searchautocomplete._initSearchBoxServer({
	  			currentInput:$input,
				initDataInput:$hidden,
				apiName:api,
				istransfer:istransfer,
				params:GlobalUtils.parse(params),
				result:{
					'code':$hidden,
					'name':$input
				}
	  		});
	  	}
	 };

	  var searchautocomplete = {
			_initSearchBox(options) {
				options.currentInput.addClass("searchBox").attr("autocomplete", "off").attr("placeholder","@i18n(searchinput.placeholder)");
				options.callback = function(data){
					for (var key in options.result) {
						options.result[key].val(data.result[key]).trigger("change");
					}
					options.selectedCallback && options.selectedCallback(data.result);
				};
				options.currentInput.bigAutocomplete(options);
				if(!options.currentInput.val() && options.initDataInput != null && options.initDataInput.val() != ''){//初始化翻译
					//非服务器模式下，从缓存数据中翻译获取
					options.currentInput.val(searchautocomplete._transferCode(options.data, options.initDataInput.val()));
				}
			},
			_initSearchBoxServer(opt){
				opt.currentInput.addClass("searchBox").attr("autocomplete", "off").attr("placeholder","@i18n(searchinput.placeholder)");
				var options = $.extend(true, {
					currentInput: null,				//查询框input的jquery对象
					result: {},						//查询结果赋值，key是属性名,value是元素jquery对象
					params: {},						//后台数据请求携带的参数
					initDataInput: null,				//初始化翻译时code的值所在的input对象，jquery对象
					istransfer:false,
					serverModel: true,				//是否启用服务器模式，启用时通过查询框内容分页查询展示查询结果，不启用则初始化时就加载全量数据
					selectedCallback: function() {}		//选择后执行的回调函数
				}, opt);
				options.callback = function(data){
					for (var key in options.result) {
						options.result[key].val(data.result[key]).trigger("input");
					}
					options.selectedCallback && options.selectedCallback(data.result);
				}
				options.currentInput.bigAutocomplete(options);
				if(options.istransfer && !options.currentInput.val() && options.initDataInput != null && options.initDataInput.val() != ''){//初始化翻译
					//服务器模式下，翻译
					options.params.code=options.initDataInput.val();
					http.get({
  					 	 apiName : options.apiName,
		                 async : true,
		                 params : options.params,
		                 success(data) {
		                 	options.currentInput.val(data.data[0].result.name);
		                }
  					 });
				}
			},
			_transferCode(data,code){
				if(data){
					for(var i = 0 ; i < data.length ; i++){
						if(data[i].result.code == code){
							return data[i].result.name;
						}
					}
				}
				return "";
			}
		};
	
	return jsviewsLink;
});