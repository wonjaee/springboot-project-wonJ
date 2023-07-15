/**
 * 
 */

//////////////////////////아이디 중복확인 (미완성)//////////////////////
function checkId(){
	var id = $("#userId").val();
	
	   var token = $("meta[name='_csrf']").attr('content');
    var header = $("meta[name='_csrf_header']").attr('content');
    if(token && header) {
        $(document).ajaxSend(function(event, xhr, options) {
            xhr.setRequestHeader(header, token);
        });
    }

	$.ajax({
		url:"/signup/check",
		type:"POST",
		data:{id:id},
		success:function(cnt){
			if(cnt !=1){
				$(".id").text("사용가능합니다.")
				console.log("1");
			}else{
				$(".id").text("아이디가 존재합니다.")
				console.log("0");
			}
		},
		error:function(request, error){
			console.log("에러.");
		}
	})
}

////////////////////////////////회원가입 유효성검사 ////////////////////
   $(function () {
        let checkID = RegExp(/^[a-z0-9]{6,20}$/);
        let checkPW = RegExp(/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[~!@#$%^&*()_+])[A-Za-z\d~!@#$%^&*()_+]{8,}$/);
        let checkName = RegExp(/^[가-힣]|[A-Z]|[a-z]$/);
        let checkPhone = RegExp(/^[0-9]+$/);        
        let checkEmail = RegExp(/^([a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,})$/);
        let checkRecommendId = RegExp(/^[a-z0-9]{6,20}$/);            

        function checkForm() {            
            //userID         
            $("#userID").blur(function (){                
                if($("#userID").val() == "" ){
                    // alert("아이디를 입력해주세요");
                    $(".id").text("아이디를 입력해주세요").css("color", "red");
                    $("#userID").focus();
                    return false;
                }else if(!checkID.test($("#userID").val())) {
                    $(".id").text("영문과 숫자를 조합하여 최소 6~20자리로 입력해주세요.").css("color", "red");
                    // alert("형식에 맞게 입력해주세요");
                    // $("#userID").val("");
                    $("#userID").focus();                
                    return false;
                }else if(checkID.test($("#userID").val())) {
                    $(".id").text("사용가능한 아이디입니다.").css("color", "#3f8ef7");                
                    $("#userPW").focus();
                    return true;
                }
            });

            // userPW
            $("#userPW").blur(function(){
                if($("#userPW").val() == "" ){                
                    $(".password").text("비밀번호를 입력해주세요").css("color","red");
                    $("#userPW").focus();
                    return false;
                }else if(!checkPW.test($("#userPW").val())) {
                    $(".password").text("대문자를 포함하여 8자리이상 입력하세요.(특수문자포함)").css("color", "red");
                    // $("#userPW").focus();                
                    return false;
                }else if(checkPW.test($("#userPW").val())) {
                    $(".password").text("사용가능한 비밀번호 입니다.").css("color", "#3f8ef7");
                    return true;                          
                }
            });

            //비밀번호 서로확인
            $("#userPW_confirm").blur(function(){
                if($("#userPW").val() != $("#userPW_confirm").val()){
                    // alert("비밀번호와 일치하게 입력해주세요.");
                    $(".password_confirm").text("비밀번호와 일치하게 입력해주세요.").css("color", "red");           
                    return false;
                }else if ($("#userPW").val() == $("#userPW_confirm").val()){
                    $(".password_confirm").text("비밀번호 일치합니다.").css("color", "#3f8ef7");
                    return true;  
                }
            });

            // userName
            $("#userName").blur(function(){
                if($("#userName").val() == "" ){  
                    $(".name").text("이름을 입력해주세요.").css("color", "red");             
                    // $("#userName").focus();
                    return false;
                }else if(!checkName.test($("#userName").val())) {
                    $(".name").text("한글 또는 영문으로 입력해주세요.").css("color", "red");
                    $("#userName").focus();                
                    return false;
                }else if(checkName.test($("#userName").val())) {
                    $(".name").text("사용가능한 이름입니다.").css("color", "#3f8ef7");                          
                    return true;
                }
            });

            // userPhone
            $("#userPhone").blur(function(){
                if($("#userPhone").val() == "" ){ 
                    $(".phone").text("휴대폰번호를 입력해주세요.");              
                    // $("#userPhone").focus();
                    return false;
                }else if(!checkPhone.test($("#userPhone").val())) {
                    $(".phone").text("숫자만 입력해주세요.").css("color", "red");
                    $("#userPhone").focus();                
                    return false;
                }else if(checkPhone.test($("#userPhone").val())) {
                    $(".phone").text("");
                    return true;                          
                }
            });

            // userEmail
            $("#userEmail").blur(function(){
                if($("#userEmail").val() == "" ){                
                    $(".email").text("이메일을 입력해주세요.");
                    $("#userEmail").focus();
                    return false;
                }else if(!checkEmail.test($("#userEmail").val())) {
                    $(".email").text("이메일 형식에 맞춰 입력해주세요. ex) test@naver.com").css("color", "red");
                    // $("#userEmail").focus();                
                    return false;
                }else if(checkEmail.test($("#userEmail").val())) {
                    $(".email").text("");
                    return true;                          
                }
            });
            // userRecommendId
            $("#userRecommendId").blur(function(){
                if(!checkRecommendId.test($("#userRecommendId").val())){
                    $(".recommend").text("아이디 형식에 맞게 입력해주세요.").css("color", "red");;               
                    return false;            
                }else if(checkID.test($("#userRecommendId").val())) {
                    $(".recommend").text("");
                    return true;              
                }
            });        
        }
        checkForm();    
           
        // button 클릭시        
        $('.btn-point').click(function(){
			var nameValue=$("#userName").val()
            if($("#userID").val() == "" || $("#userPW").val() == "" || $("#userName").val() == "" || $("#userPhone").val() == "" || $("#userEmail").val() == "" ){                
                alert("공백을 입력하세요.");               
                return false;
            }else if ($("#userPW").val() != $("#userPW_confirm").val()){
                alert("비밀번호가 서로 일치하지 않습니다.");
                return false;
            }else if(!checkID.test($("#userID").val()) || !checkPW.test($("#userPW").val()) || !checkName.test($("#userName").val()) || !checkPhone.test($("#userPhone").val()) || !checkEmail.test($("#userEmail").val())) {
                alert("형식에 맞춰 작성해주세요.")                               
                return false;
            }else {
        		alert(nameValue+"님 회원가입을 환영합니다.")
                return true;
            }                      
        });        
    });