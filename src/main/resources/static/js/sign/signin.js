/**
 * 
 */
$(function(){
  $("#userId").blur(function(){
  	if($("#userId").val() == ""){
		  $(".idError").text("아이디를 입력해주세요").css("color","red")
	}
	})

})
$(function(){
  $("#userPass").blur(function(){
  	if($("#userPass").val() == ""){
		  $(".passError").text("비밀번호를 입력해주세요").css("color","red")
	}
	})

})
