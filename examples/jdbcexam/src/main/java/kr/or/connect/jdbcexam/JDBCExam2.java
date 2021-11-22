package kr.or.connect.jdbcexam;

import kr.or.connect.jdbcexam.dao.RoleDao;
import kr.or.connect.jdbcexam.dto.Role;

public class JDBCExam2 {
	
	/*
	 * jdbcexam2(insert 예제) 실행 코드
	 * roleId, description에 각각 값 부여 
	 * 
	 * 해당 객체 생성
	 * 
	 * Roledao 객체 생성
	 * add.Role() 메소드에 해당 객체를 넣어 실행
	 * 
	 * 실행
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
