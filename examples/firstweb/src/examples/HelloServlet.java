package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public HelloServlet() {
        super();
    }
    /*
     * 'doGet()': 응답이 들어왔을 때 실제로 처리해주는 메소드
     * 'response': 응답할 내용들을 모두 추상화해놓은 객체 ('setContentType': 'response' 객체에  'content'타입을 정해준다)
     * 'response'의 'getWriter()'메소드를 통해 'PrintWriter'객체 리턴
     * 응답결과 출력 후 실행
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello Servlet</h1>");
	}

}
