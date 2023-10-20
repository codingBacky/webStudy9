function boardCheck(){
	if(document.frm.name.value.length == 0){
		alert("작성자를 입력하세요");
		return false;
	}
	if(document.frm.pwd.value.length == 0){
		alert("비밀번호 입력하세요");
		return false;
	}
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요");
		return false;
	}
}
function open_win(url, name){
	window.open(url, name, "width=500, height=230")
}
function passCheck(){
	if(document.frm.pass.value.lenth == 0){
		alert("비밀번호 입력하세요");
		return false;
	}
	return true;
}