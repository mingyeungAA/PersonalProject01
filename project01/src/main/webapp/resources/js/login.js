let user_id ;
let user_pw;

function loginPrc(){
	user_id = $(".user_id").val().trim();
	user_pw = $(".user_pw").val().trim();
	console.log("user_id : "+user_id);
	console.log("user_pw: "+user_pw);
	let loginVal = {
			"user_id":user_id,
			"user_pw":user_pw
	}
	if(user_id == "" || user_pw == "" || user_id == null || user_pw == null){
		alert("ID와  PW를 입력해주세요!");
	}else{
		$.ajax({
			type:"post",
			url:"login.do",
			data: JSON.stringify(loginVal),
			contentType: "application/json",
			dataType: "json",
			success : function(data){
				if(data.check == true){
					
					location.href="main.do";
				}else{
					alert("ID 혹은 PW가 틀렸습니다!")
				}
				
			},
			error: function(data){
				alert("통신실패!!!ㅠㅠㅠ");
			}
		});
	}

}