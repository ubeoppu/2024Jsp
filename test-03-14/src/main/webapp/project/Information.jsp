<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>정보 수정</h2>
	<form action="OttServlet" method="post" name="frm">
	<input type ="hidden" name =command value ="update_member">
		<table border="1" width=600>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${Member.name}" size="40"
				readonly></td>
			</tr>
			<tr>
				<td>아이디</td> <!--READONLY 수정불가 -->
				<td><input type="text" name="userid"  id="userid" value ="${Member.userid}"
				size="40" readonly>
			    </td>
			</tr>
			<tr>
				<td>암 호 확인</td>
				<td><input type="password" name="pwd" size="20" ></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" value="${Member.email}" size="20"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" value="${Member.phone}"size="20"></td>
			</tr>
			<tr>
			<td>
			<tr>
			    <td>주소</td>
			    <td><input type ="text" id="sample6_address" name="address" value="${Member.address }"size="30"><br>
			    <input type="text" name="address" id="sample6_detailAddress" placeholder="상세주소" size="25"><br>
		   <input type="text" id="sample6_extraAddress" placeholder="참고항목" readonly  size="30">
			    <input type="button" onclick="sample6_execDaumPostcode()" value="주소 변경">
			    </td>
		   </tr>
		   <tr>
		</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="수정" onclick ="return pwdCheck()">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
				</td>
			</tr>
			<tr>
				<td colspan="2">${message }</td>
			</tr>
		</table>
	</form>
<script>
	function pwdCheck(){
		if(document.frm.pwd.value != ${Member.pwd}){
			alert("비밀번호가 일치하지 않습니다");
			return false;
		}
		if(document.frm.email.value == ""){
			alert("이메일을 작성해주세요.")
			return false;
		}
		if(document.frm.phone.value == ""){
			alert("전화번호를 입력해주세요.")
			return false;
		}
	//	if(document.frm.address.value.length == 0){
		//	alert("주소를 입력해주세요.")
	//		return false;
	//	}
	}
	
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample6_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
	</script>
	


</body>
</html>