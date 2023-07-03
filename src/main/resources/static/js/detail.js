/**
 * 
 */

 $(function(){
	$("#btnsave-reply").click(btnsaveReplyClicked);
	
	 
 });

 
 
 function btnsaveReplyClicked(){
	 var stringFormData=$("#form-reply").serialize();
	 var boardNo=$("#detail-board-no").text().trim();
	 $.ajax({
		 url:`/boards/${boardNo}/replies`,
		 type:"post",
		 data:stringFormData,
		 success:function(result){
			 if(result){
				
			 }
		 }
		 	 
	 });
 }