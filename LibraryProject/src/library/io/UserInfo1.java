package library.io;

public class UserInfo1 {
	private String id; // 아이디
	private String password; // 비밀번호
	private String name; // 사용자 이름
	private String birthDay; // 생일
	private String email; // 이메일

	public UserInfo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo1(String id, String password, String name, String birthDay, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birthDay = birthDay;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + "\t\t" + password + "\t\t" + name + "\t\t" + birthDay+ "\t\t" + email;
	}
	
	
	
	

}
