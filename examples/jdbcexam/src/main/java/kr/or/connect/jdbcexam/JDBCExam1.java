package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {
	
	/*
	 * jdbcexam(select����) ���� �ڵ�
	 * RoleDao�� �� ����Ǵ��� �˾ƺ��� ���� -> RoleDao ��ü ����
	 * dao�� ������ �ִ� getRole(roleId) �޼ҵ� ���� -> role_id�� �����ͼ� ���� (����Ÿ��=Role)
	 * role ���
	 */

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
