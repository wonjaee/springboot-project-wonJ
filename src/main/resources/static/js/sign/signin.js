/**
 * 
 */

$(function(){
	$("#userId").blur(function(){
		if($("#userId").val() == ""){
			$(".idError").show().css("color","red")
		}else{
			  $(".idError").hide();
		}
	})
})

$(function(){
	$("#userPass").blur(function(){
		if($("#userPass").val() == ""){
			$(".passError").show().css("color","red")
		}else{
			  $(".passError").hide();
		}
	})
})



/*

$(function(){
  $("#userId").blur(function(){
  	if($("#userId").val() == ""){
		  $(".idError").text("아이디를 입력해주세요").css("color","red")
		  
		   return false;
			
	}else{
		 $(".idError").hide(); 
		 return true
	}
	})

})
*/

/*
function idClicked(){
	if($("#userId").val() == ""){
		  $(".idError").show().css("color","red")

		   }else{
			    $(".idError").hide();
			   
		   }		   
}
*/

/*
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
*/