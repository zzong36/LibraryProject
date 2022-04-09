package library.inmemory;

import java.util.Scanner;

public class ReturnBookView {

	private Scanner sc = new Scanner(System.in);
	public ReturnBookView() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	// 도서 반납 메뉴
	public void showReturnBookMenu() {
		ReturnBookFunc rbf = new ReturnBookFunc();
		LibraryView lv = new LibraryView();

		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<대출 현황>");
		System.out.println("========================================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t보유권수");
		System.out.println("----------------------------------------------------------------------------------------");
		rbf.showBorrowedBook(); // 도서 대출현황 조회
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("반납하시겠습니까? yes(0), no(1)");
		int choice;
		loop: while (true) {
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 0:
				System.out.print("도서관리번호: ");
				String bookNumber = sc.nextLine();
				rbf.returnBook(bookNumber);;
				System.out.println("----------------------------------------------------------------------------------------");
				System.out.println("반납이 완료되었습니다! 메인 메뉴로 이동합니다.");
				lv.showLibraryMenuLoginVer(); // 메인 메뉴로 이동
				break loop;
			case 1:
				System.out.println("메인메뉴로 이동합니다.");
				lv.showLibraryMenuLoginVer(); // 메인 메뉴로 이동
				break loop;
			}
			System.out.print("잘못 입력하셨습니다. 메뉴번호를 다시 입력하세요: ");
		}
		

	}

}
