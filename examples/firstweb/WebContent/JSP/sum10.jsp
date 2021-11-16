<%--'<%@ page': 페이지 지시자, 첫줄은 페이지 지시문 (언어, 콘텐츠타입,'JSP'파일 형식(UTF-8)--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>

<%--모든 'jsp'는 'Servlet'으로 바뀌어서 동작   
	'<%', '%>': 서블릿으로 바꿀 때 어떻게 바꿔야 되는지를 알려줌 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%--'<% %>':'Scriptlet'-> 자바코드를 입력할 수 있는 부분 
	'<%=': 표현식(응답 결과에 넣고 싶은 자바코드를 넣어주어야 함)--%>
<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    }
%>

<%--'out.print();' = '<%= %>'--%>
1부터 10까지의 합 : <%=total %>

</body>
</html>