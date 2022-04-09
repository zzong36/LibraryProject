package library.inmemory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class LibraryView {

	private Scanner sc = new Scanner(System.in);

	public LibraryView() {
		super();
	}

	LoginView lov = new LoginView();

	public void showLibraryMenu() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <도서관 홈페이지>");
		System.out.println("==============================================================");

		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 시스템 종료");
		System.out.println("--------------------------------------------------------------");
		System.out.println("4. 관리자 로그인");
		System.out.println();
		System.out.print("*해당 페이지를 열람하려면 메뉴 번호를 입력하세요(1~4): ");
		int menuNum;

		loop: while (true) {
			menuNum = Integer.parseInt(sc.nextLine()); 
			switch (menuNum) {
			case 1:
				RegistrationView rf = new RegistrationView();
				rf.showRegistrationMenu(); // 회원가입 메뉴로 이동
				break loop;
			case 2:
				lov.showLoginMenu(); // 일반회원 로그인 메뉴로 이동
				break loop;
			case 3:
				System.exit(0); // 시스템 종료
				break loop;
			case 4:
				AdminView adv = new AdminView();
				adv.adminShowLoginMenu(); // 관리자 로그인 메뉴로 이동
				break loop;
			}
			System.out.print("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요: ");
		}
	}

	public void showLibraryMenuLoginVer() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <도서관 홈페이지>");
		System.out.println("==============================================================");

		System.out.println("*" + LoginFunc.getId() + "님 환영합니다!");
		String pattern = "yyyy년도 MM월 dd일 hh시 mm분";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		System.out.println("*로그인 일시: " + sdf.format(new Date())); // 로그인 일시 출력

		System.out.println();
		System.out.println("1. 도서 검색");
		System.out.println("2. 도서 반납");
		System.out.println("3. 마이페이지");
		System.out.println("4. 로그아웃");
		System.out.print("*해당 페이지를 열람하려면 메뉴 번호를 입력하세요(1~4): ");
		System.out.println();

		int menuNum;
		loop: while (true) {
			menuNum = Integer.parseInt(sc.nextLine());
			switch (menuNum) {
			case 1:
				SearchBookView sbv = new SearchBookView();
				sbv.showSearchBookMenu(); // 도서검색 페이지로 이동
				break loop;
			case 2:
				ReturnBookView rbv = new ReturnBookView();
				rbv.showReturnBookMenu(); // 대출도서 반납 페이지로 이동
				break loop;
			case 3:
				MyPageView mpv = new MyPageView();
				mpv.showMyPage(); // 내 정보 페이지로 이동
				break loop;
			case 4:
				showLibraryMenu(); // 도서관 메인 홈페이지로 이동
				break loop;
			}
			System.out.print("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요: ");
		}
	}

}
