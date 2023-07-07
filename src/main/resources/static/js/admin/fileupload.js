/**
 * 
 */

function tempUpload(fileEl){
	console.log($(fileEl));
	var fileData=$(fileEl)[0].files[0];
	var formData= new FormData();
	formData.append("temp",fileData);
var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	 $.ajax({
		 url:"/admin/goods/temp-img",
		 type:"POST",
		 contentType: false,
		 processData: false,
		 data: formData,
		 success: function(resultMap){
		//console.log(resultMap.imgUrl);
		//console.log(resultMap.orgName);
		//console.log(resultMap.tempKey);
		$(fileEl).parent().css("background-image",`url(${resultMap.imgUrl})`);
		$(fileEl).parent(".img-wrap").find("orgName").val(resultMap.orgName);
		$(fileEl).parent(".img-wrap").find("tempKey").val(resultMap.tempKey);
			
		}
		
	})
}