package library.inmemory;

import java.util.Scanner;

public class AdminView {
	private Scanner sc = new Scanner(System.in);

	public AdminView() {
		super();
		// TODO Auto-generated constructor stub
	}

	AdminFunc adf = new AdminFunc();

	// 관리자 로그인 메뉴
	public void adminShowLoginMenu() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <관리자 로그인>");
		System.out.println("==============================================================");
		adf.adminLogin(); // 관리자 로그인 기능
	}

	// 관리자 로그인 후 메뉴
	public void adminShowMenu() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <관리자 메뉴>");
		System.out.println("==============================================================");
		System.out.printf("*관리자님 환영합니다!%n");

		System.out.println("1. 회원 목록");
		System.out.println("2. 도서 등록");
		System.out.println("3. 대출 및 반납 현황");
		System.out.println("4. 관리자 로그아웃");

		System.out.println();

		int menuNum;
		loop: while (true) {
			System.out.print("*메뉴 번호를 입력하세요(1~4): ");
			menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1:
				adminShowMemberList(); // 회원목록 조회
				break loop;
			case 2:
				AdminBookView abv = new AdminBookView();
				abv.adminShowBookList(); // 도서등록 페이지 조회
				break loop;
			case 3:
				AdminRentView arv = new AdminRentView();
				arv.showRentStatus(); // 회원들의 대출 및 반납현황 조회
				break loop;
			case 4:
				LibraryView lbv = new LibraryView();
				lbv.showLibraryMenu(); // 메인메뉴로 이동
				break loop;
			}
			System.out.println("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요.");
		}
	}

	public void adminShowMemberList() {
		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<회원 목록>");
		System.out.println("========================================================================================");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------------------");
		adf.memberListPrint(); // 회원목록 조회 기능
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("회원을 추가하시겠습니까? yes(0) no(1): ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 0:
			System.out.println(
					"----------------------------------------------------------------------------------------");
			adf.memberAdd();
			System.out.println(
					"----------------------------------------------------------------------------------------");
			adf.memberListPrint();
			System.out.println(
					"----------------------------------------------------------------------------------------");
			System.out.println("관리자 메뉴로 이동합니다.");
			adminShowMenu(); // 관리자 메뉴로 이동
			break;
		default:
			System.out.println("관리자 메뉴로 이동합니다.");
			adminShowMenu(); // 관리자 메뉴로 이동
		}
 
	}
}