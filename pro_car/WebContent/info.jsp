<%@page import="car.dao.LoginDAO"%>
<%@page import="car.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
<%
	 String id = (String)request.getParameter("id");
	 LoginDAO dao = LoginDAO.getInstance();
	 MemberVO mem= dao.getUserInfo(id);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>info</title>
</head>
<body>
		<h3>개인 회원 정보 보기</h3>
	<br>
	
	<form action="logSc" method="post">
		
		<table border="1" cellspacing="1" width="60%">
			<tr>
				<td width=30%>사용자 아이디</td>
				<td width=70%>
					<%=mem.getId() %>
				</td>
			</tr>
			<tr>
				<td width="30%">비밀번호</td> 
				<td width=70%>
					 <%=mem.getPassword() %>
				</td>
			</tr>
			<tr>
				<td width="30%">이름</td>
				<td width=70%>
					 <%=mem.getName() %>
				</td>
			</tr>
			<tr>
				<td width="30%">이메일</td>
				<td width=70%>
					<%=mem.getEmail() %>
				</td>
			</tr>
			<tr>
				<td width="30%">집 주소</td>
				<td width=70%>
					<%=mem.getAddr() %>
				</td>
			</tr>
			<tr>
				<td width="30%">전화번호</td>
				<td width=70%>
					<%=mem.getPhone() %>
				</td>
			</tr>
		</table>
		<br> <br> 
		<input type="button" value="수정">
		
	</form>

</body>
</html>