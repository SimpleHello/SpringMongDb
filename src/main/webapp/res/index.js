function startLisi(){
	startName("lisi")
}

function startZhangsan(){
	startName("zhangsan")
}

function startName(name){
	$.ajax({
		  type: 'POST',
		  url: "http://10.0.6.135:8080/SpringMongDb/ajax/getSomeAjax/"+name,
		  success: function(result) {
		           if (result == "success") {
			              alert(name+":"+result.name);
			         } 
				},
		  dataType: "json"
		});
	
}
function sendMessage(){
	var mes = $("#mes").val();
	$.ajax({
		  type: 'POST',
		  url: "http://10.0.6.135:8080/SpringMongDb/ajax/sendMessage",
		  data:{"name":mes},
		  success: function(result) {
			  		var res = result.success
		           if (res == true) {
			              alert(result.data.name);
			         } 
				},
		  dataType: "json"
		});
}