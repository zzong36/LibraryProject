package library.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdminFunc {
	private Scanner sc = new Scanner(System.in);

	public AdminFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	RegistrationFunc rgf = new RegistrationFunc();

	// 관리자 아이디(root)와 비밀번호(root) 로그인 기능
	public void adminLogin() {
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String password = sc.nextLine();
		Map<String, String> adminLogin = new HashMap<>();
		adminLogin.put("root", "root");

		if (adminLogin.containsKey(id) && adminLogin.get(id).equals(password)) {
			System.out.println("로그인 성공!");
			AdminView adv = new AdminView();
			adv.adminShowMenu();
		} else {
			System.out.println("로그인 실패. 개발자에게 문의하세요");
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
	}

	// 회원목록 출력 기능
	public void memberListPrint() {
		System.out.println("아이디\t\t비밀번호\t\t이름\t\t생년월일\t\t이메일");
		System.out.println("----------------------------------------------------------------------------------------");
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			System.out.println(RegistrationFunc.userList.get(i));
		}
	}

	// 관리자의 회원 추가 기능
	public void memberAdd() {
		rgf.inputUser();
		inputUserAgain();
	}

	// 관리자 회원 재추가 기능
	public void inputUserAgain() {
		System.out.print("다른 회원을 추가 하시겠습니까? yes(0), no(1): ");
		int choice = Integer.parseInt(sc.nextLine());
		while (choice == 0) {
			rgf.inputUser();
			System.out.print("다른 회원을 추가 하시겠습니까? yes(0), no(1): ");
			choice = Integer.parseInt(sc.nextLine());
		}
	}
}
