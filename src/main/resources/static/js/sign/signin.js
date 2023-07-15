/**
 * 
 */

$(function(){
  $("#userId").blur(function(){
  	if($("#userId").val() == ""){
		  $(".idError").text("아이디를 입력해주세요").css("color","red")
		   $("#userId").focus();
			
	}else{
		 $(".idError").hide(); 
	}
	})

})





$(function(){
  $("#userPass").blur(function(){
  	if($("#userPass").val() == ""){
		  $(".passError").text("비밀번호를 입력해주세요").css("color","red")
		  $("#userPass").focus();
	}else{
		$(".passError").hide();
	}
	})

})
