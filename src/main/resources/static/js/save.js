const inputs = document.querySelector("input");
const content = document.querySelector(".content");
const btn = document.querySelector("button");
const userBox = document.querySelector(".username");

load();
function load(){
	if(username == ""){
		alert("로그인이 필요한 서비스입니다.");
		location.href = "/signin";
	}
	userBox.textContent = username;
}

btn.onclick = () => {
	if(inputs.value == ""){
		alert("제목을 입력하세요!");
		inputs.focus();
		return;
	}else if(content.value == ""){
		alert("내용을 입력하세요!");
		content.focus();
		return;
	}
	
	if(inputs.value.length > 20){
		alert("제목과 내용은 20자를 넘어갈 수 없습니다.");
		inputs.focus();
		return;
	}else if(content.value.length > 20){
		alert("제목과 내용은 20자를 넘어갈 수 없습니다.");
		content.focus();
		return;
	}

	$.ajax({
		type : "post",
		url : "/board/save",
		data : {
			title : inputs.value,
			content : content.value,
			username : username
		},
		success : function(data){
			if(data == true){
				location.href = "/";
			}else{
				alert("글 등록을 실패하였습니다.");
			}
		},
		error : function(){
			console.log("에러");
		}
	});
	
}