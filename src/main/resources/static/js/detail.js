/**
 * 
 */


 //////////////수정버튼///////////////
 $(function(){
	$("#btn-update").click(btnClickedUpdate);
	
});
 function btnClickedUpdate(){
	 $("#basic").hide();
	 $("#form-update").show();
 }
 function clickedCancel(){
	 $("#basic").show();
	 $("#form-update").hide();
 }