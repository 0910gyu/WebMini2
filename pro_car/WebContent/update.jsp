<%@page import="car.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">




</style>
</head>
<body>
		<%
  		 MemberVO mem = (MemberVO)session.getAttribute("mem");
		%>
<br>
	<h3>개인 정보 수정하기</h3>
		<br>
		<form action="logSc" method="post">
			  <table border="1" cellspacing="1" width="60%">
				  <tr>
					<td width=30%>사용자 아이디</td>
					<td width=70%><%=mem.getId()%></td>
				  </tr>
				  <tr>
					<td width="30%">비밀번호 수정</td>
					<td width="70%"><input type="password" name="password"
					value="<%= mem.getPassword() %>"></td>
				  </tr>			  
				  <tr>
					<td width="30%">이름</td>
					<td width="70%"><%= mem.getName() %></td>
				  </tr>
				  <tr>
					<td width="30%">이메일</td>
					<td width="70%"><%= mem.getEmail() %></td>	  
				  <tr>				  
				  <tr>
					<td width="30%">주소</td>
					<td width="70%"><%= mem.getAddr() %></td>	  
				  <tr>				  
				  <tr>
					<td width="30%">전화번호</td>
					<td width="70%"><%= mem.getPhone() %></td>	  
				  <tr>				  
			</table>  
			<input type="hidden" value="update"  name="command">
			<input type="submit" value="수정" ><br>
			
		</form>
		

</body>
</html>