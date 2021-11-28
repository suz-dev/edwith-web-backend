package kr.or.connect.diexam01;

// 빈 클래스
public class UserBean {
	
/*
 * Bean의 특징
 * 1) 기본 생성자를 가지고 있다
 * 2) 필드는 private 하게 선언한다
 * 3) getter, setter 메소드를 가진다 (getName() setName() 메소드를 name 프로퍼티(Property)라고 한다-용어**)
 */
	
	private String name;
	private int age;
	private boolean male;
	
	// 기본생성자를 반드시 가지고 있어야 한다
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
