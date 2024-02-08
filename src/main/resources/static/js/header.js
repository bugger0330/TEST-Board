const menus = document.querySelectorAll(".menu");

menus[0].onclick = () => {
	location.href = "/";
}
menus[1].onclick = () => {
	location.href = "/signin";
}
menus[2].onclick = () => {
	location.href = "/signup";
}

let username = getUserInfo();
function getUserInfo(){
	let username = "";
	$.ajax({
		type : "post",
		url : "/get/userinfo",
		async : false,
		success : function(data){
			if(data != ""){
				username = data;
			}else{
				console.log("유저 못가져옴");
			}
		},
		error : function(){
			console.log("유저정보 가져오기 에러");
		}
	});
	
	return username;
	
}









