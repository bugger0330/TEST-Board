const inputs = document.querySelectorAll("input");
const btn = document.querySelector("button");

btn.onclick = () => {
	$.ajax({
		type : "post",
		url : "/user/signin",
		data : {
			username : inputs[0].value,
			password : inputs[1].value
		},
		success : function(data){
			location.href = "/";
		},
		error : function(){
			console.log("에러");
		}
	});
}