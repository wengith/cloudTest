$(function(){

	//��ɫѡ��������ע���¼�
	$(".li-cursor").click(function(){
		var t = $("#" + $(this).attr("demo"));
		t.siblings().hide();
		t.show();
		$(this).addClass("demo-text")
			   .siblings().removeClass("demo-text");
	});	
	
	$("#tt").bigAutocomplete({data:[{title:"book"},{title:"blue"},{title:"fool"},{title:"bus"}]});
    $("#ff").bigAutocomplete({width:"200px",data:[{title:"book"},
                                    {title:"blue"},
                                    {title:"fool"},
                                    {title:"bus"}]});	
    $("#qq").bigAutocomplete({data:[{title:"book",result:"booooook"},
                                    {title:"blue",result:"bluuuuue"},
                                    {title:"fool"},
                                    {title:"bus",result:[1,2,3]}],
                          callback:function(data){
                            alert(data);
                          }});	
                          
    var url_ = "../autocomplete/ajax.html";
    $("#nn").bigAutocomplete({url:url_});                             
    $(".batch-text").bigAutocomplete({data:[{title:"book"},{title:"blue"},{title:"fool"},{title:"bus"}]});          

})
