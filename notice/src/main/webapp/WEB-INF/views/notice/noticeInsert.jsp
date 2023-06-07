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
	<jsp:include page="../main/menu.jsp"></jsp:include>
	<div>
		<h1>게시글 등록</h1>
	
	</div>
	<div>
		<form id="frm" action="noticeInsert.do" method="post"> 
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="150">
								<input type="text" id="noticeWriter" name="noticeWriter" value="${name }" readonly="readonly">
						</td>
						<th width="150">작성일자</th>
						<td width="150">
							<input type="date" id="noticeWdate" name="noticeWdate" required="required">
						</td>
					</tr>
					
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" id="noticeTitle" name="noticeTitle" size="70" required="required">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="100" id="noticeSubject" name="noticeSubject"></textarea>
						</td>
					</tr>
				</table>
			</div><br>
			<div>
				<input type="submit" value="등록">
				<input type="reset" value="취소">
				<!-- <input type="button" value="목록" onclikc="location.href'notice."> -->
			
			</div>
		
		
		
		</form>
	
	</div>
	



</div>
</body>
</html>