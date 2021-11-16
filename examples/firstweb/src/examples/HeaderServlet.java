package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 헤더 정보 읽어 들이기 

@WebServlet("/header")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public HeaderServlet() {
        super();
    }

    /*
     * 컨텐츠 타입 지정
     * 클라이언트와의 연결 통로 지정
     * 응답으로 보내줄 'html'태그 입력
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter(); 
		out.println("<html>"); 
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		/*
		 * 'getHeaderNames()'메소드: 모든 헤더 이름을 문자열 'Enumeration'객체로 반환
		 * 'nextElement()'메소드 -> 헤더 네임 
		 * 'getHeader()'메소드 ->헤더값
		 */
		Enumeration<String> headerNames = request.getHeaderNames(); 
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();  
			String headerValue = request.getHeader(headerName); 
			out.println(headerName + " : " + headerValue + " <br> "); 
		}	
		
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
