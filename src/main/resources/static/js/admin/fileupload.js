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
		
	$.ajax({
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		url:"/admin/goods/temp-img",
		type:"POST",
		contentType:false,
		processData:false,
		data: formData,
		success:function(resultMap){
		console.log(resultMap.imgUrl);
		console.log(resultMap.orgName);
		console.log(resultMap.tempKey);
			
		}
		
	})
}