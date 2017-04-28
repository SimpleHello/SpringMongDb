$(function(){
	window.Index3={
			createPng:function(){
				createPng();
			}
	}
	function createPng(){
		$.ajax({
			  type: 'POST',
			  url: Url.test.createPng,
			  success: function(result) {
			           if (result.success) { 
				              alert(result.data.result);
				         } 
					},
			  dataType: "json"
			});
	}
	
});