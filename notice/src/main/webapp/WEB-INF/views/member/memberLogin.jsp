<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align ="center">
	<jsp:include page="../main/menu.jsp" />
		<div><h1>로그인</h1></div>
		
	<!-- 로그인고는 어따가 넣지 -->
		<form id = "frm" action = "memberLogingo.do" onsubmit="return formCheck()" method = "get">
	<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width = "300">
							<input type="email" id="memberId" name="memberId"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
					<tr>
						<th>비밀번호</th>
						<td>
							<input type="password" id="memberPassword" name="memberPassword" required="required"> <!--id= js, name=java 사용  -->
						</td>
					</tr>
					
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				
					</div>
	
	</div>
</body>
</html>