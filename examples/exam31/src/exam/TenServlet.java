package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ������ 3.0 �̻󿡼� ���� �ۼ� ���
 */

@WebServlet("/ten") // ������̼� ("/url mapping")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TenServlet() {
        super();
    }

    /*
     * 'HttpServletRequest': ��û�� ���� �κ��� ������ ��ü
     * 'HttpServletResponse': ���信 ���� �κ��� ������ ��ü
     * 'setContentType()': ������ Ÿ�� ���� �޼ҵ�
     * 'getWriter()': ���� ���� ������ ���� ��� (out)
     * 'getWriter()'�޼ҵ� ���� �� 'PrintWriter'��ü ���Ϲ���
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>1���� 10���� ����մϴ�.<h1>");
		for(int i = 1; i<=10; i++) {
			out.print(i+"<br>");
		}
		out.close();
	}

}
