<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div>
	<jsp:include page="../main/menu.jsp" />
	</div>
	<div><h1>회원가입</h1>
	<div>
		<form id = "frm" action = "memberInsert.do" onsubmit="return formCheck()" method = "get">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width = "300">
							<input type="email" id="memberId" name="memberId"> <!--id= js, name=java 사용  -->
							<button type="button" id="checkId" value="No" onclick="idCheck()">
							중복체크</button>
						</td>
					</tr>
					
					<tr>
						<th>비밀번호</th>
						<td>
							<input type="password" id="memberPassword" name="memberPassword" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>비밀번호 확인</th>
						<td>
							<input type="password" id="passwordcheck" name="passwordcheck" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>사용자명</th>
						<td>
							<input type="text" id="memberName" name="memberName" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>나이</th>
						<td>
							<input type="text" id="memberAge" name="memberAge"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>전화번호</th>
						<td>
							<input type="tel" id="memberTel" name="memberTel" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>성별</th>
						<td>
							<input type="text" id="memberGender" name="memberGender" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" onclick = "location.href='main.do'" value="홈 가기">
			</div>
		</form>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</div>
<script type="text/javascript">
	function formCheck(){
		let frm =  document.getElementById("frm");
		if(frm.memberPassword.value != frm.passwordcheck.value){
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword.value = "";
			frm.passwordcheck.value="";
			frm.memberPassword.focus();
			return false;
		}else if(frm.checkId.value != "Yes"){
			alert("아이디 중복체크를 수행하세요.");
			return false;
		}
		
		
		return true;
	}
	
	function idCheck(){
		let id = document.getElementById("memberId").value;
		let url = "ajaxCheckId.do?id=" +id;
		fetch(url) //ajax 호출
			.then(response => response.text()); //.then = 결과 받는 곳 (콜백함수?)
			.then(text => htmlProcess(text));
	}
	
	function htmlProcess(data){
		if(data == 'Yes'){
			alert(document.getElementById("memberId").value + " \n 사용가능한 아이디 입니다."));
			document.getElementById("checkId").value = 'Yes';
		}else{
			alert(document.getElementById("memberId").value + " \n 이미 사용하는 아이디 입니다."));
			document.getElementById("memberId").value = "";
			document.getElementById("memberId").focus();
		}
		
		
	}
	
	
	
</script>

</div>
</body>
</html>