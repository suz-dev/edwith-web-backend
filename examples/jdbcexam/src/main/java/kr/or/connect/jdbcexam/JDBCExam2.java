package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {
	
	/*
	 * jdbcexam2(insert ����) ���� �ڵ�
	 * roleId, description�� ���� �� �ο� 
	 * 
	 * �ش� ��ü ����
	 * 
	 * Roledao ��ü ����
	 * add.Role() �޼ҵ忡 �ش� ��ü�� �־� ����
	 * 
	 * ����
	 */

	public static void main(String[] args) {	
		int roleId = 500;
		String description = "CTO";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		
		System.out.println(insertCount);

	}

}
