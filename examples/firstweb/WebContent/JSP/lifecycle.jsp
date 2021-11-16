<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

hello

<%
	System.out.print("jspService()"); 
%>

<%--'<%!'생성자 사용:'Service()'메소드 바깥에 선언 가능 --%>
<%!
	public void jspInit() {
	System.out.print("jspInit()"); 
	}
%>

<%!
	public void jspDestroy() {
	System.out.print("jspDestroy()"); 
	}
%>

</body>
</html>

