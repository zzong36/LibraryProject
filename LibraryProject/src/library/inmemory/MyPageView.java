package library.inmemory;

import java.util.Scanner;

public class MyPageView {

	private Scanner sc = new Scanner(System.in);

	public MyPageView() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 마이페이지 보기
	public void showMyPage() {
		MyPageFunc mpf = new MyPageFunc();
		LibraryView lv = new LibraryView();

		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<마이페이지>");
		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<내 정보>");
		System.out.println("아이디\t\t비밀번호\t\t이름\t\t생년월일\t\t이메일");
		System.out.println("----------------------------------------------------------------------------------------");
		mpf.printMyInfo(); // 로그인한 회원의 회원정보 출력
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("\t \t \t \t \t<대출 현황>");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("----------------------------------------------------------------------------------------");
		if (BorrowBookFunc.borrowBook.get(LoginFunc.getId()) != null) {
			System.out.println(BorrowBookFunc.borrowBook.get(LoginFunc.getId()));
			System.out.println(
					"----------------------------------------------------------------------------------------");
			mpf.returnDateCalculation();// 반납일자 계산
		}
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.print("회원정보 수정(0), 메인 메뉴로(1): "); // 회원정보 수정
		loop: while (true) {
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 0:
				mpf.changeUserList(); // 회원정보 수정 기능
				System.out.println("메인 메뉴로 이동합니다");
				lv.showLibraryMenuLoginVer();
				break loop;
			case 1:
				System.out.println("메인 메뉴로 이동합니다");
				lv.showLibraryMenuLoginVer(); // 로그인 버전 도서관 메뉴로 이동
				break loop;
			}
			System.out.print("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요: ");
		}
	}
}
