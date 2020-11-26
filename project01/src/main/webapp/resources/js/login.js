let user_id ;
let user_pw;

window.onload = function(){
	
}


function login(){
	user_id = document.getElementsByClassName("user_id")[0].val();
	user_pw =  document.getElementsByClassName("user_pw")[0].val();
	
	let loginVal = {
			"user_id":user_id,
			"user_pw":user_pw
	}
	if(user_id == "" || user_pw == "" || user_id == null || user_pw == null){
		alert("ID와  PW를 입력해주세요!");
	}else{
		$.ajax({
			url:"login.do",
			data: JSON.stringify(loginVal),
			contentType: "application/json",
			dataType: json,
			success : function(data){
				console.log("data : "+data);
			},
			error: function(data){
				
			}
		});
	}

}