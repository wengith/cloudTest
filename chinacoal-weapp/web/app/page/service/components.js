define(['jquery','widget/ajax_form','widget/http','widget/dialog','bigautocomplete'], function($,ajax_form,http,dialog)  {
	var component = {
		//获得localStorage的值
		_getCookie:function(cname) {  
			return localStorage.getItem(cname);
		},
		//设置localStorage的值
		_setCookie:function(cname, cvalue, exdays) {
			localStorage.setItem(cname, cvalue); 
	    },
	    //提示框
	    alert:function(valueWord){
	    	dialog.alert({
	    		content:valueWord
	    	});
	    },
	    //确认框
	    confirm:function(valueWord,surefunction,rejectfunction){
	    	dialog.confirm({
	    		content:valueWord,
	    		title: '提示', //标题
	            sureBtnText: '是', //确 定按钮标题
	            cancelBtnText: '否', //取消按钮标题
	            onCreateAfter:function(){
	                $(".alert-background").show();
	            },
	            onSuerBefore:function(){
	            	$(".alert-background").hide();
	            	surefunction && typeof (surefunction) == 'function' && surefunction();
	            },
	            onCloseBefore:function(){
	            	$(".alert-background").hide();
	            	rejectfunction && typeof (rejectfunction) == 'function' && rejectfunction();
	            },
	            onCanceleBefore:function(){
	            	$(".alert-background").hide();
	            	rejectfunction && typeof (rejectfunction) == 'function' && rejectfunction();
	            }
	    	});
	    }
	};
	return component;
});