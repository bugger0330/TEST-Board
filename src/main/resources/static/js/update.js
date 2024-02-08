const inputs = document.querySelector("input");
const content = document.querySelector(".content");
const btn = document.querySelector("button");
const userBox = document.querySelector(".username");
let pageNum = (window.location.pathname).split("/")[2];
console.log("페이지번호", pageNum);

load();
function load(){
	if(username == ""){
		alert("로그인이 필요한 서비스입니다.");
		location.href = "/signin";
	}
	userBox.textContent = username;
	$.ajax({
		type : "get",
		url : `/board/select/${pageNum}`,
		success : function(data){
			inputs.value = data.title;
			content.value = data.content;
		},
		error : function(){
			console.log("에러");
		}
	});
	
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
	$.ajax({
		type : "post",
		url : `/board/${pageNum}/update`,
		data : {
			title : inputs.value,
			content : content.value
		},
		success : function(data){
			if(data == true){
				location.href = "/";
			}else{
				alert("수정을 실패했습니다.");
			}
		},
		error : function(){
			console.log("에러");
		}
	});
}