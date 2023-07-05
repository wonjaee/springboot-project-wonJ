/**
 * 
 */

function tempUpload(fileEl){
	var fileData=$(fileEl)[0].files[0];
	var formData= new FormData();
	formData.append("temp",fileData);
	
	$.ajax({
		url:"/admin/good/temp-img",
		type:"POST",
		contentType:false,
		processData:false,
		data: formData,
		success:function(resultMap){
			
			
		}
		
	})
}