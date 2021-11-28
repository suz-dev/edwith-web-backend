package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ���α׷��� �����ų ������ - ���� �ٽ� ����
 */
public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		System.out.println("�ʱ�ȭ �Ϸ�!");
		
		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		
		if(userBean == userBean2)
			System.out.println("���� �ν��Ͻ� �Դϴ�.");
	}

}
