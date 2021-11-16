package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 요청시 가지고 들어온 파라미터를 읽어들여 출력하는 서블릿
 * (http://localhost:8080/firstweb/param?name=kim&age=5):'?'기준 뒷 부분이 파라미터, 파라미터이름=파라미터 값, &:기준점
 */

@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ParameterServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		// 응답시 'getParameter()'메소드 수행
		String name = request.getParameter("name"); 
		String age = request.getParameter("age");
		
		out.println("name : " + name + "<br>");
		out.println("age : " +age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
