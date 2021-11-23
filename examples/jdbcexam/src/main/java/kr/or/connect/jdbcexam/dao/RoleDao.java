package kr.or.connect.jdbcexam.dao; // 5.'.dao' package �߰� ����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.connect.jdbcexam.dto.Role;

/*
 * 'role' ���̺� �ִ� ������ �Է�/����/����/��ȸ �ϴ� ����� ������� Ŭ����: RoleDao(��� ��� �ѹ��� ����)
 */
public class RoleDao {

	/*
	 * 15.getConnection���� ���� db ���ӿ�� ����� ���� �ٱ��ʿ� ����
	 */
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";

	/*
	 * [Update ���� - JDBCExam5]
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
	 * [Delete ���� - JDBCExam4]
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
	 * [Select * ���� - JDBCExam3] Role ������ ��� �����;� �� 
	 * Role�� �� ���� �����͸� ���� �� �ֱ� ������ List�� �����ؾ� ��� ������ ��ȸ�ؼ� ��ȯ ���� ->����Ÿ��:List<Role> 
	 * +) try-with resource �̿�:
	 * try(����� ���ҽ��� ������ �ڵ� ����)->�ش� ��ü���� ������ 'close()' ����
	 * 
	 * *1.getRoles() �޼ҵ带 ���� Role�� ��� ���ڸ� List<Role>�� ��´�
	 */
	public List<Role> getRoles() {

		// *2.���� ����� ���� List<>�� ���� ����
		List<Role> list = new ArrayList<>();

		// *3.�� �κп��� ��ü���� ���� ����

		try {
			// *4.����̹� �ε�(mysql ver):Class�� forName �޼ҵ� ����
			Class.forName("com.mysql.jdbc.Driver");

			// *5.����ó��
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// *6.������ ������ String���� �ۼ�
		String sql = "SELECT description, role_id FROM role order by role_id desc";

		/*
		 * *7.try-with resource �̿�: try(����� ���ҽ��� ������ �ڵ� ����)->�ش� ��ü���� ������ 'close()'���� (finally ��� ���� close() ���� �� �ʿ� X) 
		 * Connection ��ü ����, Statement ��ü ���� ('*6'������ �̿�)
		 */
		try (Connection conn = DriverManager.getConnection(dburl, dbUser, dbpasswd);
				PreparedStatement ps = conn.prepareStatement(sql)) {

			// *8.ResultSet ��ü�� try �� ���ο��� ResultSet�� ����
			try (ResultSet rs = ps.executeQuery()) {

				/*
				 * *9.ResultSet ��ü�� ������� ���� ��쿡 ���� �ݺ��� �ۼ� (���� ���� ������ �����;� �ϱ� ������ �ݺ��� ����) 
				 * next()�޼ҵ�(boolean Ÿ��): ������� �ִٸ� ù ��° ���ڵ�� Ŀ���� �̵���Ų �� true ���� 
				 * 							-> ����� ������ ���� ���ڵ�� Ŀ���� �̵����� �ݺ� ���� 
				 * 							������� ���ٸ� false ����
				 */
				while (rs.next()) {

					String description = rs.getString(1); // get() �޼ҵ带 ���� description, id �� ���� ������ �ϳ��� ������
					int id = rs.getInt("role_id");
					Role role = new Role(id, description); // Role ��ü ���� -> get() �޼ҵ带 ���� �޾ƿ� ������ ��´�
					list.add(role); // list�� �ݺ��ɶ����� Role �ν��Ͻ��� �����Ͽ� list�� �߰��Ѵ�
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list; // list ����
	}

	/*
	 * [Insert ���� - JDBCExam2] i1.�� ���� �Է��ϴ� �޼ҵ� addRole()�� role�� ���ڷ� �޾� ����
	 */
	public int addRole(Role role) {
		// i2.���� ����� ���� ������ ���� ����
		int insertCount = 0;

		// i3.��ü ���� (insert�� �̱� ������ ��� ���� ResultSet���� �������� �ʾ� ResultSet ��ü�� �������� ����)
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			// i4.����̹� �ε� (mysql ver):Class�� forName �޼ҵ� ����
			Class.forName("com.mysql.jdbc.Driver");

			// i5.Connection ��ü ������: java.sql ��Ű���� ���� DriverManager Ŭ������ getConnection()
			// �޼ҵ� ���
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // url, user, password�� ���� �ߺ��� ���

			// i7.������ ������ String���� �ۼ� (���� ���ڰ��� �Ź� �ٲ� �� '?'�� ��밡��:preparedStatement Ư¡)
			String sql = "INSERT INTO role (role_id, description) VALUES ( ?, ? )";

			// i6.Connection ��ü�� �̿��� Statement ��ü ���� (������ �ʿ�)
			ps = conn.prepareStatement(sql);

			/*
			 * i8.'i7'���� '?'�κ��� ���� �ٲ��ִ� �ڵ� preparedStatement�� ������ �ִ� set�޼ҵ� ���
			 * set'Type'(parameterIndex, x)���� �ۼ� 
			 * parameterIndex : ����ǥ�� ���� ('i7'�� �������� ������ column�� ����) 
			 * x:'?'��� �־��� ��->���⼭�� �ش� �޼ҵ��� ���ڷ� �޾ƿ� Role ��ü�� ���� �ִ� role_id, description
			 */
			ps.setInt(1, role.getRoleId());
			ps.setString(2, role.getDescription());

			// i9.executeUpdat():������ �����ϴ� �޼ҵ� (Insert, Update, Delete�� ������ �� ���)
			insertCount = ps.executeUpdate();

			// i10.����ó��
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally { // i.11.close() �޼ҵ� �������� ��� ���� (ps,conn):�Ĺ� ���������� ���� �ʵ��� ���� �ۼ��� ��
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
		return insertCount; // insertCount ����
	}

	/*
	 * [Select ���� - JDBCExam1] 
	 * 6.�����͸� �� �� �������� �޼ҵ� (������ �����͸� ��Ƴ� ��ü = Role -> Role�������ϴ� ��ü�� ������ش�) 
	 * getRole(Integer roleId):roleId�� �ش��ϴ� �Ѱ��� ���� Role�� �������� �޼ҵ�
	 */
	public Role getRole(Integer roleId) {

		// 7.������ Role ���� ���� role ����
		Role role = null;

		// 9.��ü����
		Connection conn = null; // ������ �ξ �� �ִ� ��ü
		PreparedStatement ps = null; // ����� ������ ��ü
		ResultSet rs = null; // ������� ��Ƴ� ��ü

		try {
			// 13.����̹� �ε� (mysql ver):Class�� forName �޼ҵ� ����
			Class.forName("com.mysql.jdbc.Driver");

			// 14.Connection ��ü ������: java.sql ��Ű���� ���� DriverManager Ŭ������ getConnection()
			// �޼ҵ� ���
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // url, user, password�� ���� �ߺ��� ���

			// 17.������ ������ String���� �ۼ� (���� ���ڰ��� �Ź� �ٲ� �� '?'�� ��밡��:preparedStatement Ư¡)
			String sql = "SELECT description,role_id FROM role WHERE role_id = ?";

			// 16.Connection ��ü�� �̿��� Statement ��ü ���� (������ �ʿ�)
			ps = conn.prepareStatement(sql);

			/*
			 * 18.'17��'���� '?'�κ��� ���� �ٲ��ִ� �ڵ� preparedStatement�� ������ �ִ� set�޼ҵ� ���
			 * set'Type'(parameterIndex, x)���� �ۼ� 
			 * parameterIndex : ����ǥ�� ����
			 * x:'?'��� �־��� ��->���⼭�� �ش� �޼ҵ��� ����(roleId)�� ���� �޾ƿ� ��
			 */
			ps.setInt(1, roleId);

			// 19.executeQuery():������ �����ϴ� �޼ҵ� (ResultSet ��ü(rs)�κ��� ����� ������)
			rs = ps.executeQuery();

			/*
			 * 20.ResultSet ��ü�� ������� ���� ��쿡 ���� ���ǹ� �ۼ� 
			 * next() �޼ҵ�(boolean Ÿ��): ������� �ִٸ� ù ��° ���ڵ�� Ŀ���� �̵���Ų �� true ����  
			 * 							 -> ����� ������ ���� ���ڵ�� Ŀ���� �̵����� �ݺ� ���� 
			 * 							  ������� ���ٸ� false ����
			 */
			if (rs.next()) {
				// 21. rs�� �����ִ� get() �޼ҵ带 �̿��Ͽ� �� �������� get'Type'(int colunmindex); ���� �ۼ�
				String description = rs.getString(1); // columnindex�� '17'���� �ۼ��� ���������� ������ column�� ������� �ۼ�
				int id = rs.getInt("role_id"); // columnindex�� Į�� �̸��� �״�� �Է��ص� �ȴ�

				// 22.'21'�� description,id�� ���� ���� role��ü�� ������ ����
				role = new Role(id, description);
			}
			// 10.����ó��
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 11.close() �޼ҵ� �������� ��� ���� (rs,ps,conn):�Ĺ� ���������� ���� �ʵ��� ���� �ۼ��� ��

			// 12.������ �߻��Ҹ��� ��Ȳ�� ���� ���� �ڵ� ¥��
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

		return role; // 8.Role ����
	}

}
