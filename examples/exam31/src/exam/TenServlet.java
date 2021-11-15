package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 웹버전 3.0 이상에서 서블릿 작성 방법
 */

@WebServlet("/ten") // 어노테이션 ("/url mapping")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TenServlet() {
        super();
    }

    /*
     * 'HttpServletRequest': 요청에 대한 부분을 가지는 객체
     * 'HttpServletResponse': 응답에 대한 부분을 가지는 객체
     * 'setContentType()': 콘텐츠 타입 지정 메소드
     * 'getWriter()': 실제 보낼 내용을 넣을 통로 (out)
     * 'getWriter()'메소드 수행 시 'PrintWriter'객체 리턴받음
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>1부터 10까지 출력합니다.<h1>");
		for(int i = 1; i<=10; i++) {
			out.print(i+"<br>");
		}
		out.close();
	}

}
