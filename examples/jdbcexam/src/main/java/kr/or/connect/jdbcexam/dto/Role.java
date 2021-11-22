package kr.or.connect.jdbcexam.dto; // 1.package ���� (dto �� ���߿�)

public class Role { // 2. column 2���� ���� ���� �ʿ� (roleId, description)
	private Integer roleId; // int
	private String description; // varchar
	
	public Role() { 

	}

	public Role(Integer roleId, String description) { // 4.���ڰ� �ΰ��� �޾Ƶ鿩 �������� ���� ����ִ� ������: ��ü ������ ����
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	// 3. Source -> Generates Getters and Setters (Getter/Setter �޼ҵ�):�����͸� ������ �ִ� ���� ����
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// 4. toString() ���� �޼ҵ� �������̵�:�ȿ� �ִ� ������ ���ϰ� ����ϱ� ���� ����
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
}
