//우편번호 찾기
function exePostCode(){
	new daum.Postcode({
		oncomplete: function(data){
			var addr='';
			var extraAddr = ''; //참고항목 변수
			
            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }
            
            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
            } 
            
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById('address').value=addr;
            document.getElementById('detailAddress').focus();
		}
	}).open();
}

//아이디 유효성 (영문소문자/숫자, 6~12자)
//이메일 유효성
//비밀번호 유효성 (영문 대소문자/숫자/특수문자 중 3가지 이상 조합, 8~16자)
let idRex;
let idRex2;
let han;
let han2;
let emailRex;
let pwRex;
$(document).ready(function(){
	//아이디 유효성
	$(".user_id").keyup(function(){
		var user_id = $(".user_id").val();
		$.ajax({
			url: "idvalidity.do?user_id="+user_id,
			type: 'get',
			success: function(data){
				idRex = /^[A-Za-z0-9]{6,12}$/;
				idRex2 = /[a-zA-Z0-9]/;
				han = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
				han2 = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{6,12}$/;
				if(data==1){
					$(".id_text").text("");
					$(".id_text").text("이미 존재하는 아이디입니다.");
				}else{
					if(idRex.test(user_id) && !han.test(user_id)){
						$(".id_text").text("사용가능한 아이디입니다.")
					}else if(user_id == ""){
						$(".id_text").text("아이디를 입력해주세요.(영문소문자/숫자, 6~12자)");
					}else if((han.test(user_id) && han2.test(user_id)) 
							|| (idRex.test(user_id)) 
							|| ((user_id.search(idRex2) >= 0 
							&& user_id.search(han) >= 0)) 
							&& user_id.length >= 6){
						$(".id_text").text("아이디는 영문소문자/숫자만 가능합니다.");
					}else{
						$(".id_text").text("아이디는 6-12자 이내로 입력해주세요.");
					}
				}
			},
			error: function(data){
				alert("아이디 유효성 통신실패!!!ㅠ");
			}
		});
	})
	
	//이메일 유효성
	$(".user_email").keyup(function(){
		let user_email = $(".user_email").val().trim();
		$.ajax({
			url: "emailvalidity.do?user_email="+user_email,
			type: "get",
			success: function(data){
				emailRex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				han = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
				if(data == 1){
					$(".email_text").text("");
					$(".email_text").text("이미 존재하는 아이디입니다. 다른 이메일로 다시 시도해주세요.");
				}else{
					if(emailRex.test(user_email)){
						$(".email_text").text("사용가능한 이메일입니다.");
					}else if(user_email == ""){
						$(".email_text").text("이메일을 입력해주세요.");
					}else{
						$(".email_text").text("유효한 이메일을 입력해주세요.");
					}
				}
			},
			error: function(data){
				alert("이메일 유효성 통신실패!!ㅠㅠ");
			}
		});
	})
	
	//비밀번호 유효성  (영문 대소문자/숫자/특수문자 중 3가지 이상 조합, 8~16자)
	$(".user_pw").keyup(function(){
		let user_pw = $(".user_pw").val().trim();
		var user_id = $(".user_id").val().trim();
		pwRex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,16}$/;
		
		if(user_pw == ""){
			$(".password_text").text("비밀번호를 입력해주세요.");
		}else if(user_pw.length < 8 || user_pw.length > 16){
			$(".password_text").text("8~16자 이내로 입력해주세요.");
		}else if(false === pwRex.test(user_pw)){
			$(".password_text").text("영문 대소문자/숫자/특수문자 중 3가지 이상 조합해주세요.");
		}else if(/(\w)\1\1\1/.test(user_pw)){
			$(".password_text").text("같은 문자를 4번이상 사용하실 수 없습니다.");
		}else if(user_pw.search(/\s/) != -1){
			$(".password_text").text("비밀번호는 공백없이 입력해주세요.");
		}else if(user_pw.search(user_id) > -1){
			$(".password_text").text("비밀번호에 아이디가 포함되어 있습니다.");
		}
		else{
			$(".password_text").text("");
		}
	});
	
	$(".user_pw_check").keyup(function(){
		let user_pw = $(".user_pw").val().trim();
		let user_pw_check = $(".user_pw_check").val().trim();
		
		if(user_pw != user_pw_check){
			$(".password_check_text").text("비밀번호가 일치하지 않습니다.");
		}else{
			$(".password_check_text").text("");
		}
	});
})
