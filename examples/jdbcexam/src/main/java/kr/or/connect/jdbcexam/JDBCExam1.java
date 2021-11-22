package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam1 {
	
	/*
	 * jdbcexam(select예제) 실행 코드
	 * RoleDao가 잘 실행되는지 알아보기 위함 -> RoleDao 객체 생성
	 * dao가 가지고 있는 getRole(roleId) 메소드 수행 -> role_id를 가져와서 수행 (리턴타입=Role)
	 * role 출력
	 */

	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}

}
