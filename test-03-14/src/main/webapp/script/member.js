

function open_wid(url, name){
	window.open(url, name, "width=500, height=230");
};


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


//	console.log("isCheck");
//
	if (document.frm.userid.value == "") {
		alert("아이디를 입력해주세요.")
		document.frm.userid.focus();
		return false;
	}
	//idCheck.do?userid = user
	let url = "idCheck.do?userid=" + document.frm.userid.value;

	window.open(url, "_blank_1", "width=450, height=200");
	
	return true;
}

function idok(){
	//opener는 현재창의 부모를 나타내는 JavaScript객체.
	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
}

function joinCheck(){
	
    	if(document.frm.name.value.length == 0){
	    alert("이름을 써주세요.");
     	document.frm.name.focus();
    	return false;
    }
		if (document.frm.userid.value.length == 0) {
		alert("아이디를 반드시 입력해주세요.")
		document.frm.userid.focus();
		return false;
	}
		if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.")
		document.frm.userid.focus();
		return false;
	}
			if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해주세요.")
		document.frm.userid.focus();
		return false;
	}
		//비밀번호 재확인
		if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		document.frm.userid.focus();
		return false;
	}
		if(document.frm.reid.value.length ==0){
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}

function cmUpdateOpen(){
	window.name ="upForm";
	window.open("")
}

