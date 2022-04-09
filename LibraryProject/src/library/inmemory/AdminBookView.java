package library.inmemory;

import java.util.Scanner;

public class AdminBookView {

	private Scanner sc = new Scanner(System.in);

	public AdminBookView() {
		super();
		// TODO Auto-generated constructor stub
	}

	AdminView adv = new AdminView();
	AdminBookFunc abf = new AdminBookFunc();

	public void adminShowBookList() {
		System.out.println("==============================================================================");
		System.out.println("\t\t\t\t<도서 목록>");
		System.out.println("==============================================================================");
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		bookListPrint(); // 도서목록 조회 기능
		System.out.println("------------------------------------------------------------------------------");
		System.out.print("신착도서 추가(0), 도서목록 수정(1) 관리자 메뉴(2): ");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 0:
			System.out.println("------------------------------------------------------------------------------");
			abf.inputBook(); // 신착 도서 추가 기능
			abf.inputBookAgain();
			System.out.println("------------------------------------------------------------------------------");
			bookListPrint(); // 도서 목록 조회
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("관리자 메뉴로 이동합니다.");
			adv.adminShowMenu(); // 관리자 메뉴
			break;
		case 1:
			System.out.println("------------------------------------------------------------------------------");
			abf.changeBookList();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("관리자 메뉴로 이동합니다.");
			adv.adminShowMenu(); // 관리자 메뉴
		default:
			System.out.println("관리자 메뉴로 이동합니다.");
			adv.adminShowMenu();
		}
	}

	public void bookListPrint() {
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t보유권수");
		System.out.println("------------------------------------------------------------------------------");
		for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
			System.out.println(AdminBookFunc.bookList.get(i));
		}
	}
}
