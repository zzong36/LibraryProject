package library.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationFunc {

	private String id;
	private String email;
	private Scanner sc = new Scanner(System.in);

	public RegistrationFunc() {
		super();
	}

	static List<UserInfo1> userList = new ArrayList<>();

	public void inputUser() {
		String id = idRegister();
		String password = passwordRegister();
		String name = nameRegister();
		String birthDay = birthDayRegister();
		String email = emailRegister();

		userList.add(new UserInfo1(id, password, name, birthDay, email));
	}

	// 아이디 입력
	public String idRegister() {
		System.out.print("아이디: ");
		id = sc.nextLine().trim();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getId().equals(id)) { // 아이디 중복입력 불가 
				System.out.println("아이디 " + id + "이/가 이미 존재합니다. 다시 입력해주세요.");
				idRegister();
			}
		}
		return id;
	}

	// 비밀번호 입력
	public String passwordRegister() {
		System.out.print("비밀번호: ");
		String password = sc.nextLine().trim();
		return password;
	}

	// 이름 입력
	public String nameRegister() {
		System.out.print("이름: ");
		String name = sc.nextLine().trim();
		return name;
	}

	// 생일 입력
	public String birthDayRegister() {
		System.out.print("생년월일: ");
		String birthDay = sc.nextLine().trim();
		return birthDay;
	}

	// 이메일 입력
	public String emailRegister() {
		System.out.print("이메일: ");
		email = sc.nextLine().trim();
		for (int i = 0; i < userList.size(); i++) { // 이메일 중복입력 불가
			if (userList.get(i).getEmail().equals(email)) {
				System.out.println("이메일 [" + email + "]이/가 이미 존재합니다. 다시 입력해주세요.");
				emailRegister();
			}
		}
		return email;
	}

}
