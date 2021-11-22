package kr.or.connect.jdbcexam.dto; // 1.package 구분 (dto 뜻 나중에)

public class Role { // 2. column 2개를 담을 공간 필요 (roleId, description)
	private Integer roleId; // int
	private String description; // varchar
	
	public Role() { 

	}

	public Role(Integer roleId, String description) { // 4.인자값 두개를 받아들여 각각에다 값을 담아주는 생성자: 객체 생성시 편리함
		super();
		this.roleId = roleId;
		this.description = description;
	}
	
	// 3. Source -> Generates Getters and Setters (Getter/Setter 메소드):데이터를 꺼내고 넣는 과정 수행
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
	
	// 4. toString() 등의 메소드 오버라이딩:안에 있는 값들을 편하게 출력하기 위한 목적
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", description=" + description + "]";
	}
	
}
