package kr.or.connect.jdbcexam.dao; // 5.'.dao' package �߰� ����

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.connect.jdbcexam.dto.Role;

/*
 * 'role' ���̺��� �ִ� ������ �Է�/����/����/��ȸ �ϴ� ����� ������� Ŭ����: RoleDao(��� ��� �ѹ��� ����)
 */
public class RoleDao {
	
	/*
	 * 15.getConnection���� ���� db���� ��� ����� ���� �ٱ��ʿ� ����
	 */
	private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
	private static String dbUser = "connectuser";
	private static String dbpasswd = "connect123!@#";
	/*
	 * 6.�����͸� �� �� �������� �޼ҵ� (������ �����͸� ��Ƴ� ��ü = Role -> Role�� �����ϴ� ��ü�� ������ش�)
	 * getRole(Integer roleId):roleId�� �ش��ϴ� �Ѱ��� ���� Role�� �������� �޼ҵ�
	 */
	public Role getRole(Integer roleId) {
		
		// 7.������ Role ���� ���� role ����
		Role role = null; 
		
		// 9.��ü����
		Connection conn = null; // ������ �ξ �� �ִ� ��ü
		PreparedStatement ps = null; // ������ ������ ��ü
		ResultSet rs = null; // ������� ��Ƴ� ��ü
		
		// 10.����ó��
		try {
			// 13.����̹� �ε� (mysql ver):Class�� forName �޼ҵ� ����
			Class.forName( "com.mysql.jdbc.Driver" ); 

			// 14.Connection ��ü ������: java.sql ��Ű���� ���� DriverManager Ŭ������ getConnection() �޼ҵ� ���
			conn = DriverManager.getConnection(dburl, dbUser, dbpasswd); // url, user, password�� ���� �ߺ��� ��� ����
			
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
			if(rs.next()) {
				// 21. rs�� �����ִ� get() �޼ҵ带 �̿��Ͽ� �� �������� get'Type'(int colunmindex); ���� �ۼ�
				String description = rs.getString(1); // columnindex�� '17'���� �ۼ��� ���������� ������ column�� ������� �ۼ� 
				int id = rs.getInt("role_id"); // columnindex�� Į�� �̸��� �״�� �Է��ص� �ȴ�
				
				// 22.'21'�� description,id�� ���� ���� role��ü�� ������ ���� 
				role = new Role(id, description); 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally { // 11.close() �޼ҵ� �������� ��� ���� (rs,ps,conn):�Ĺ� ���������� ���� �ʵ��� ���� �ۼ��� ��
			
			// 12.������ �߻��Ҹ��� ��Ȳ�� ���� ���� �ڵ� ¥��
			if(rs != null) { 
				try {
					rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) { 
				try {
					ps.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) { 
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return role; // 8.Role ����
	}

}