package kr.or.connect.diexam01;

// �� Ŭ����
public class UserBean {
	
/*
 * Bean�� Ư¡
 * 1) �⺻ �����ڸ� ������ �ִ�
 * 2) �ʵ�� private �ϰ� �����Ѵ�
 * 3) getter, setter �޼ҵ带 ������ (getName() setName() �޼ҵ带 name ������Ƽ(Property)��� �Ѵ�-���**)
 */
	
	private String name;
	private int age;
	private boolean male;
	
	// �⺻�����ڸ� �ݵ�� ������ �־�� �Ѵ�
	public UserBean() {} 
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
		
	} // Source -> Generate Getters and Setters ...
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	
	
}
