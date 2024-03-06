

function loginCheck() {
	//                name의 값의 길이가 0이면 실행
	console.log("loginCheck");

	if (document.frm.userid.value.length == 0) {
		alert("아이디를 입력해주세요.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("비밀번호를 입력해주세요.");
		frm.pwd.focus();
		return false;
	}

	return true;
}

function idCheck() {

	console.log("isCheck");
	if (document.frm.userid.value == "") {
		alert("아이디를 입력해주세요.")
		document.frm.userid.focus();
		return false;
	}
	//idCheck.do?userid = user
	let url = "idCheck.do?userid=" + document.frm.userid.value;

	window.open(url, "_blank_1", "width=450, height=200");

}

function idok(){
	//opener는 현재창의 부모를 나타내는 JavaScript객체.
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}
