package library.io;

import java.util.Scanner;

public class SearchBookView {

	private Scanner sc = new Scanner(System.in);

	public SearchBookView() {
		super();
		// TODO Auto-generated constructor stub
	}

	SearchBookFunc sbf = new SearchBookFunc();
	BorrowBookFunc bbf = new BorrowBookFunc();

	public void showSearchBookMenu() {
		System.out.println("==============================================================================");
		System.out.println("\t\t\t\t<도서 검섹>");
		System.out.println("==============================================================================");
		System.out.print("도서명을 입력하세요 : ");
		String bookSearch = sc.nextLine();
		System.out.println();
		System.out.println("\t\t\t\t<도서 목록>");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t보유권수");
		System.out.println("------------------------------------------------------------------------------");
		sbf.searchBookName(bookSearch); // 도서 조회 기능
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("조회가 완료되었습니다.");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("*도서 대여기간은 1주일 입니다");
		System.out.print("도서를 대출하시겠습니까? yes(0), no(1) : ");

		int choice;
		loop: while (true) {
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 0:
				showBorrowBookView(); // 도서대출 화면
				break loop;
			case 1:
				System.out.println("메인 메뉴로 이동합니다");
				LibraryView lv = new LibraryView();	
				lv.showLibraryMenuLoginVer(); // 도서관 메인 메뉴 로그인 버젼으로 이동
				break loop;
			}
			System.out.print("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요: ");
		}
	}
	
	public void showBorrowBookView() {
		System.out.print("도서번호를 입력하세요 : ");
		String bookNumber = sc.nextLine();
		bbf.borrowBook(bookNumber);
	}

}
