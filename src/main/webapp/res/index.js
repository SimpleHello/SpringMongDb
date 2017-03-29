function startLisi(){
	startName("lisi")
}

function startZhangsan(){
	startName("zhangsan")
}

function startName(name){
	$.ajax({
		  type: 'POST',
		  url: "http://localhost:8080/SpringMongDb/ajax/getSomeAjax/"+name,
		  success: function(result) {
		           if (result == "success") {
			              alert(name+":"+result.name);
			         } 
				},
		  dataType: "json"
		});
	
}