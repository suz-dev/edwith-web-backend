package kr.or.connect.jdbcexam.dao; // 5.'.dao' package 추가 생성

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

/*
 * 'role' 테이블에 있는 정보를 입력/수정/삭제/조회 하는 기능을 묶어놓은 클래스: RoleDao(모든 기능 한번에 가짐)
 */
public class RoleDao {

	/*
	 * 15.getConnection에서 사용될 db 접속요소 상수와 같이 바깥쪽에 선언
	 */
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	/*
	 * [Update 예제 - JDBCExam5]
	 */
	public int updateRole(Role role) {
		int updateCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
			String sql = "UPDATE role SET description = ? where role_id = ? ";

			ps = conn.prepareStatement(sql);
			ps.setString(1, role.getDescription());
			ps.setInt(2, role.getRoleId());

			updateCount = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			}
		}
		return updateCount;
	}

	/*
	 * [Delete 예제 - JDBCExam4]
	 */
	public int deleteRole(Integer roleId) {
		int deleteCount = 0;

		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);

			String sql = "DELETE FROM role WHERE role_id = ?";

			ps = conn.prepareStatement(sql);

			ps.setInt(1, roleId);

			deleteCount = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			} // if

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			} // if
		} // finally

		return deleteCount;
	}

	/*
	 * [Select * 예제 - JDBCExam3] Role 정보를 모두 가져와야 함 
	 * Role은 한 건의 데이터만 담을 수 있기 때문에 List를 리턴해야 모든 정보를 조회해서 반환 가능 ->리턴타입:List<Role> 
	 * +) try-with resource 이용:
	 * try(사용할 리소스를 얻어오는 코드 생성)->해당 객체들이 스스로 'close()' 수행
	 * 
	 * *1.getRoles() 메소드를 통해 Role의 모든 인자를 List<Role>에 담는다
	 */
	public List<Role> getRoles() {

		// *2.수행 결과를 담을 List<>형 변수 선언
		List<Role> list = new ArrayList<>();

		// *3.이 부분에서 객체선언 하지 않음

		try {
			// *4.드라이버 로딩(mysql ver):Class의 forName 메소드 수행
			Class.forName("com.mysql.jdbc.Driver");

			// *5.예외처리
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// *6.수행할 쿼리문 String으로 작성
		String sql = "SELECT description, role_id FROM role order by role_id desc";

		/*
		 * *7.try-with resource 이용: try(사용할 리소스를 얻어오는 코드 생성)->해당 객체들이 스스로 'close()'수행 (finally 블록 에서 close() 수행 할 필요 X) 
		 * Connection 객체 얻어옴, Statement 객체 얻어옴 ('*6'쿼리문 이용)
		 */
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			// *8.ResultSet 객체는 try 블럭 내부에서 ResultSet을 얻어옴
			try (ResultSet rs = ps.executeQuery()) {

				/*
				 * *9.ResultSet 객체에 결과값이 없을 경우에 대한 반복문 작성 (여러 건의 정보를 가져와야 하기 때문에 반복문 실행) 
				 * next()메소드(boolean 타입): 결과값이 있다면 첫 번째 레코드로 커서를 이동시킨 뒤 true 리턴 
				 * 							-> 수행될 때마다 다음 레코드로 커서를 이동시켜 반복 수행 
				 * 							결과값이 없다면 false 리턴
				 */
				while (rs.next()) {

					String description = rs.getString(1); // get() 메소드를 통해 description, id 에 대한 정보를 하나씩 꺼낸다
					int id = rs.getInt("role_id");
					Role role = new Role(id, description); // Role 객체 생성 -> get() 메소드를 통해 받아온 정보를 담는다
					list.add(role); // list에 반복될때마다 Role 인스턴스를 생성하여 list에 추가한다
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list; // list 리턴
	}

	/*
	 * [Insert 예제 - JDBCExam2] i1.한 건을 입력하는 메소드 addRole()에 role을 인자로 받아 수행
	 */
	public int addRole(Role role) {
		// i2.수행 결과를 담을 정수형 변수 선언
		int insertCount = 0;

		// i3.객체 선언 (insert문 이기 때문에 결과 값을 ResultSet으로 가져오지 않아 ResultSet 객체는 선언하지 않음)
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// i4.드라이버 로딩 (mysql ver):Class의 forName 메소드 수행
			Class.forName("com.mysql.jdbc.Driver");

			// i5.Connection 객체 얻어오기: java.sql 패키지가 가진 DriverManager 클래스의 getConnection()
			// 메소드 사용
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // url, user, password에 대해 중복값 사용

			// i7.수행할 쿼리문 String으로 작성 (들어올 인자값이 매번 바뀔 때 '?'로 사용가능:preparedStatement 특징)
			String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

			// i6.Connection 객체를 이용해 Statement 객체 얻어옴 (쿼리문 필요)
			ps = conn.prepareStatement(sql);

			/*
			 * i8.'i7'에서 '?'부분의 값을 바꿔주는 코드 preparedStatement가 가지고 있는 set메소드 사용
			 * set'Type'(parameterIndex, x)으로 작성 
			 * parameterIndex : 물음표의 순서 ('i7'의 쿼리에서 나열한 column의 순서) 
			 * x:'?'대신 넣어줄 값->여기서는 해당 메소드의 인자로 받아온 Role 객체가 갖고 있는 role_id, description
			 */
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			// i9.executeUpdat():실행을 수행하는 메소드 (Insert, Update, Delete를 수행할 때 사용)
			insertCount = ps.executeUpdate();

			// i10.예외처리
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally { // i.11.close() 메소드 역순으로 모두 수행 (ps,conn):후반 과정이지만 잊지 않도록 먼저 작성할 것
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception ex) {
				}
			} // if

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {
				}
			} // if
		} // finally
		return insertCount; // insertCount 리턴
	}

	/*
	 * [Select 예제 - JDBCExam1] 
	 * 6.데이터를 한 건 가져오는 메소드 (가져온 데이터를 담아낼 객체 = Role -> Role을리턴하는 객체를 만들어준다) 
	 * getRole(Integer roleId):roleId에 해당하는 한건의 정보 Role을 가져오는 메소드
	 */
	public Role getRole(Integer roleId) {

		// 7.리턴할 Role 값인 변수 role 선언
		Role role = null;

		// 9.객체선언
		Connection conn = null; // 연결을 맺어낼 수 있는 객체
		PreparedStatement ps = null; // 명령을 선언할 객체
		ResultSet rs = null; // 결과값을 담아낼 객체

		try {
			// 13.드라이버 로딩 (mysql ver):Class의 forName 메소드 수행
			Class.forName("com.mysql.jdbc.Driver");

			// 14.Connection 객체 얻어오기: java.sql 패키지가 가진 DriverManager 클래스의 getConnection()
			// 메소드 사용
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // url, user, password에 대해 중복값 사용

			// 17.수행할 쿼리문 String으로 작성 (들어올 인자값이 매번 바뀔 때 '?'로 사용가능:preparedStatement 특징)
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";

			// 16.Connection 객체를 이용해 Statement 객체 얻어옴 (쿼리문 필요)
			ps = conn.prepareStatement(sql);

			/*
			 * 18.'17번'에서 '?'부분의 값을 바꿔주는 코드 preparedStatement가 가지고 있는 set메소드 사용
			 * set'Type'(parameterIndex, x)으로 작성 
			 * parameterIndex : 물음표의 순서
			 * x:'?'대신 넣어줄 값->여기서는 해당 메소드의 인자(roleId)로 값을 받아올 것
			 */
			ps.setInt(1, roleId);

			// 19.executeQuery():실행을 수행하는 메소드 (ResultSet 객체(rs)로부터 결과값 꺼내옴)
			rs = ps.executeQuery();

			/*
			 * 20.ResultSet 객체에 결과값이 없을 경우에 대한 조건문 작성 
			 * next() 메소드(boolean 타입): 결과값이 있다면 첫 번째 레코드로 커서를 이동시킨 뒤 true 리턴  
			 * 							 -> 수행될 때마다 다음 레코드로 커서를 이동시켜 반복 수행 
			 * 							  결과값이 없다면 false 리턴
			 */
			if (rs.next()) {
				// 21. rs가 갖고있는 get() 메소드를 이용하여 값 꺼내오기 get'Type'(int colunmindex); 으로 작성
				String description = rs.getString(1); // columnindex는 '17'에서 작성된 쿼리문에서 나열한 column의 순서대로 작성
				int id = rs.getInt("role_id"); // columnindex에 칼럼 이름을 그대로 입력해도 된다

				// 22.'21'의 description,id의 값을 담을 role객체를 실제로 생성
				role = new Role(id, description);
			}
			// 10.예외처리
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 11.close() 메소드 역순으로 모두 수행 (rs,ps,conn):후반 과정이지만 잊지 않도록 먼저 작성할 것

			// 12.오류가 발생할만한 상황에 대해 상세한 코드 짜기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role; // 8.Role 리턴
	}

}
