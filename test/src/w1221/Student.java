package w1221;

public class Student {
	private int id;
	private String name;
	
	public Student() {
		
	}
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public void print() {
		System.out.printf("아이디 : %d, 이름 : %s\n",getId(),getName());
	}
	
	
}
