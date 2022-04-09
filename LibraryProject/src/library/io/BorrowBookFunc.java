package library.io;

import java.util.HashMap;

public class BorrowBookFunc {

	public BorrowBookFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	static HashMap<String, Object> borrowBook = new HashMap<>();

	// 도서대출 기능
	public void borrowBook(String bookNumber) {
		LibraryView lv = new LibraryView();

		for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
			if (AdminBookFunc.bookList.get(i).getBooknumber().equals(bookNumber)) {

				int num = AdminBookFunc.bookList.get(i).getStock();
				if (num > 0) {// 재고가 있다면 대출 가능
					num--;
					AdminBookFunc.bookList.get(i).setStock(num);
					borrowBook.put(LoginFunc.getId(), AdminBookFunc.bookList.get(i));
					System.out.println("도서대출이 완료되었습니다!");
					printBorrowBook();
					System.out.println("메인메뉴로 이동합니다.");
					lv.showLibraryMenuLoginVer();
				} else { // 도서 재고가 없다면 대출 불가능
					System.out.println("대출 가능한 재고가 없습니다");
					System.out.println("메인메뉴로 이동합니다.");
					lv.showLibraryMenuLoginVer();
				}

			}
		}
	}

	// 대출도서 보여주는 기능
	public void printBorrowBook() {
		System.out.println("\t\t\t\t<대출 목록>");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println(BorrowBookFunc.borrowBook.get(LoginFunc.getId()));
		System.out.println("------------------------------------------------------------------------------");
	}

}
