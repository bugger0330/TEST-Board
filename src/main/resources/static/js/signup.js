const inputs = document.querySelectorAll("input");
const btn = document.querySelector("button");

btn.onclick = () => {
	if(inputs[0].value == ""){
		alert("아이디를 입력하세요!");
		inputs[0].focus();
		return;
	}else if(inputs[1].value == ""){
		alert("비밀번호를 입력하세요!");
		inputs[1].focus();
		return;
	}else if(inputs[2].value == ""){
		alert("비밀번호를 입력하세요!");
		inputs[2].focus();
		return;
	}else if(inputs[1].value != inputs[2].value){
		alert("비밀번호를 확인해주세요!");
		return;
	}
	$.ajax({
		type : "post",
		url : "/user/signup",
		data : {
			username : inputs[0].value,
			password : inputs[1].value
		},
		success : function(data){
			if(data == true){
				location.href = "/signin";
			}else{
				alert("회원가입을 실패하셨습니다.");
			}
		},
		error : function(){
			console.log("에러");
		}
	});
}