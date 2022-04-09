package library.io;

import java.util.Scanner;

public class LoginFunc {

	private static String id;
	private String password;
	private Scanner sc = new Scanner(System.in);
	private String id1;

	public LoginFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		LoginFunc.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	// 로그인 아이디와 비밀번호 입력 기능
	public void loginInput() {
		inputId();
	}

	// 아이디 입력 및 존재여부 확인
	public void inputId() {
		System.out.print("아이디: ");
		id1 = sc.nextLine();
		setId(id1);
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			if (RegistrationFunc.userList.get(i).getId().equals(id1)) {
				inputPassword();
				loginValidation();
			}
		}
		System.out.println("아이디 [" + id1 + "]이/가 존재하지 않습니다. 다시 입력해주세요.");
		inputId();

	}

	// 비밀번호 입력
	public void inputPassword() {
		System.out.print("비밀번호: ");
		password = sc.nextLine().trim();
	}

	// 아이디와 비밀번호 일치 여부 확인
	public void loginValidation() {
		LibraryView lbv = new LibraryView();
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			if (RegistrationFunc.userList.get(i).getId().equals(id1)
					&& RegistrationFunc.userList.get(i).getPassword().equals(password)) {
				System.out.println("로그인 성공!");
				lbv.showLibraryMenuLoginVer();
			}
		}
		System.out.println("로그인 실패");
		System.out.print("비밀번호를 변경하시겠습니까? 예(0), 메인메뉴(1): ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 0:
			changePassword();
			break;
		default:
			lbv.showLibraryMenu();
		}

	}

	// 비밀번호 변경 기능
	public void changePassword() {
		LibraryView lbv = new LibraryView();

		System.out.print(id + "님 회원가입시 등록한 이메일을 입력하세요: ");
		String email = sc.nextLine().trim();
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			if (RegistrationFunc.userList.get(i).getEmail().equals(email)) {
				System.out.print("이메일이 회원정보와 일치합니다. 새로운 비밀번호를 입력하세요: ");
				String newPassword = sc.nextLine().trim();
				RegistrationFunc.userList.get(i).setPassword(newPassword);
				System.out.println("비밀번호가 성공적으로 변경되었습니다!");

				// 도서관 메인 홈페이지로 이동
				System.out.println("메인 홈페이지로 이동합니다.");
				lbv.showLibraryMenu();
			}
		}
		System.out.println("회원정보를 조회할 수 없습니다. 관리자에게 문의하세요.");
		lbv.showLibraryMenu();
	}

	public void showList() {
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			System.out.println(RegistrationFunc.userList);
		}
	}

}