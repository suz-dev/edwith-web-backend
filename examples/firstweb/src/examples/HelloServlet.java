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
     * 'doGet()': ������ ������ �� ������ ó�����ִ� �޼ҵ�
     * 'response': ������ ������� ��� �߻�ȭ�س��� ��ü ('setContentType': 'response' ��ü��  'content'Ÿ���� �����ش�)
     * 'response'�� 'getWriter()'�޼ҵ带 ���� 'PrintWriter'��ü ����
     * ������ ��� �� ����
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello Servlet</h1>");
	}

}