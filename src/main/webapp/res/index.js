function startLisi(){
	startName("lisi")
}

function startZhangsan(){
	startName("zhangsan")
}

function startName(name){
	$.ajax({
		  type: 'POST',
		  url: Urlhead+"appAjax/getSomeAjax/"+name,
		  success: function(result) {
		           if (result == "success") {
			              alert(name+":"+result.name);
			         } 
				},
		  dataType: "json"
		});
	
}
function sendMessage(){
	var jobName = $("#jobName").val();
	var type = $("#type").val();
	var cron = $("#cron").val();
	if(type=="30"&&(cron==null||cron=="")){
		alert("变更时间粒度 必输");
		return ;
	}
	$.ajax({
		  type: 'POST',
		  url: Urlhead+"appAjax/sendMessage",
		  data:{"type":type,"cron":cron,"jobName":jobName},
		  success: function(result) {
			  		var res = result.success
		           if (res == true) {
			              alert(result.data.name);
			         } 
				},
		  dataType: "json"
		});
}