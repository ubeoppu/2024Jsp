function open_wid(url, name){
	window.open(url, name, "width=500, height=230");
}

function okPass(){
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요");
	    return false;
	}
}