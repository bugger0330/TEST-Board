const tbody = document.querySelector("tbody");
const insertBtn = document.querySelector(".insert-btn");

insertBtn.onclick = () => {
	if(username == ""){
		alert("로그인이 필요한 서비스입니다.");
		location.href = "/signin";
	}else{
		location.href = "/board/saveForm";
	}
}

load();

function load(){
	$.ajax({
		type : "get",
		url : "/board/select/list",
		success : function(data){
			selectBoard(data);
		},
		error : function(){
			alert("에러");
		}
	});
}

function selectBoard(data){
	let innr = "";
	if(data != null){
		for(let i = 0; i < data.length; i++){
			innr += `
				<tr class="color">
					<td>${data[i].id}</td>
					<td>${data[i].title}</td>
					<td>${data[i].content}</td>
					<td>${data[i].username}</td>
					<td>
						<button type="button" class="delete-btn" id="${data[i].id}">삭제</button>
						<button type="button" class="update-btn" id="${data[i].id}">수정</button>
					</td>
				</tr>
			`;
		}
		tbody.innerHTML = innr;
		const deleteBtn = document.querySelectorAll(".delete-btn");
		const updateBtn = document.querySelectorAll(".update-btn");
		const trList = document.querySelectorAll(".color");
		deleteEvent(deleteBtn);
		updateEvent(updateBtn);
		boardColor(trList);
	}
}

function deleteEvent(btns){
	if(btns != null){
		for(let i = 0; i < btns.length; i++){
			btns[i].onclick = () => {
				if(confirm("정말 삭제하시겠습니까?")){
					$.ajax({
						type : "post",
						url : `/board/${btns[i].id}/delete`,
						success : function(data){
							if(data == true){
								alert("삭제되었습니다.");
								load();
							}
						},
						error : function(){
							alert("에러");
						}
					});
				}
			}
		}
	}
}
function updateEvent(btns){
	if(btns != null){
		for(let i = 0; i < btns.length; i++){
			btns[i].onclick = () => {
				if(username == ""){
					alert("로그인이 필요한 서비스입니다.");
					location.href = "/signin";
				}
				location.href = `/board/${btns[i].id}/updateForm`;
			}
		}
	}
}

function boardColor(trList){
	if(trList != null){
		for(let i = 0; i < trList.length; i += 2){
			const tds = trList[i].querySelectorAll("td");
			for(let k = 0; k < tds.length; k++){
				tds[k].style.backgroundColor = "gray";
			}
		}
	}
}
























