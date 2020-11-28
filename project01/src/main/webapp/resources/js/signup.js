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
$(document).ready(function(){
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
					console.log("data : "+data);
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
				alert("통신실패!!!");
			}
		});
	})
})
