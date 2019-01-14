/**
 * template
 * @module template
 */
define(function(){

	  var cache = {};
	  
	  /**
	   * 模板工具
	   * @static
	   */
	  var template = function(str, data){
	    
	    var fn = !/\W/.test(str) ?
	      cache[str] = cache[str] ||
	        template(document.getElementById(str).innerHTML) :
	      
	      
	      new Function("obj",
	        "var p=[],print=function(){p.push.apply(p,arguments);};" +
	       
	        "with(obj){p.push('" +
	        	        
	        str
	          .replace(/[\r\t\n]/g, " ")
	          .split("<%").join("\t")
	          .replace(/((^|%>)[^\t]*)'/g, "$1\r")
	          .replace(/\t=(.*?)%>/g, "',$1,'")
	          .split("\t").join("');")
	          .split("%>").join("p.push('")
	          .split("\r").join("\\'")
	      + "');}return p.join('');");
	    
	    return data ? fn( data ) : fn;
	  };
	
	return {
		parse: template
	}
});