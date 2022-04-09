package library.inmemory;

import java.util.Calendar;
import java.util.Scanner;

public class MyPageFunc {

	private Scanner sc = new Scanner(System.in);

	public MyPageFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 내 회원정보를 보여주는 기능
	public void printMyInfo() {
		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			if (RegistrationFunc.userList.get(i).getId().equals(LoginFunc.getId())) {
				System.out.println(RegistrationFunc.userList.get(i));
			}
		}
	}

	// 회원정보 수정 기능
	public void changeUserList() {
		System.out.println("*아래 항목을 입력하세요.");
		System.out.print("수정항목(비밀번호(0), 이름(1), 생년월일(2), 이메일(3): ");
		int choice = Integer.parseInt(sc.nextLine().trim());
		System.out.print("수정사항: ");
		String change = sc.nextLine().trim();

		for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
			if (RegistrationFunc.userList.get(i).getId().equals(LoginFunc.getId())) {
				if (choice == 0) {
					RegistrationFunc.userList.get(i).setPassword(change);
				} else if (choice == 1) {
					RegistrationFunc.userList.get(i).setName(change);
				} else if (choice == 2) {
					RegistrationFunc.userList.get(i).setBirthDay(change);
				} else if (choice == 3) {
					RegistrationFunc.userList.get(i).setEmail(change);
				} else {
					System.out.print("잘못 입력하셨습니다. 메인 메뉴로 이동합니다.");
					LibraryView lv = new LibraryView();
					lv.showLibraryMenuLoginVer(); // 도서관 메인페이지로 이동
				}
				System.out.println("수정이 완료되었습니다.");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				System.out.println("아이디\t\t비밀번호\t\t이름\t\t생년월일\t\t이메일");
				System.out.println(
						"----------------------------------------------------------------------------------------");
				if (RegistrationFunc.userList.get(i).getId().equals(LoginFunc.getId())) {
					System.out.println(RegistrationFunc.userList.get(i));
				}
				System.out.println(
						"----------------------------------------------------------------------------------------");
			}
		}
	}

	// 반납일자 계산기
	public void returnDateCalculation() {
		Calendar c = Calendar.getInstance();

		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int date = c.get(Calendar.DATE);
		System.out.printf("반납일자: %d년 %d월 %d일%n", year, month, date + 7);
	}

}
