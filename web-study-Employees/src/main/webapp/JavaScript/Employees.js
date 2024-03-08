
function loginCheck(){
	
	if(document.frm.id.value.length == 0){
		alert("아이디를 입력해주세요.")
		frm.id.focus();
		return false;
	}
	
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력해주세요.")
		frm.pass.focus();
		return false;
	}
	
	return true;
}

function loginPassFail(){
	
	alert("비밀번호가 틀렸습니다.");
}

function passwordCheck(){
	if(document.frm.password.value == document.frm.CheckPassword.value){
	alert("비밀번호가 맞지 않습니다.")
	return false;
}
}
