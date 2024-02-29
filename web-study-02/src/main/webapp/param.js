




function check(){
	if(document.frm.id.value ==""){
		alert("아이디를 입력하세요")
		document.frm.id.focus();
		return false;
		}else if(document.frm.pass.value == ""){
			alert("비밀번호를 입력해주세요")
			document.frm.focus();
			return false;
		}else if(isNaN(document.frm.pass.value)){
			alert("정수만 입력해주세요!")
			document.frm.pass.focus();
			return false;
		}else if(document.frm.id.length()  < 3){
			alert("아이디는 3자리 이상이어야 합니다")
			document.frm.id.focus();
			return false;
		}else{
			return true;
		}
}