package library.inmemory;

public class ReturnBookFunc {

	public ReturnBookFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 대출현황 조회
	public void showBorrowedBook() {
		if (BorrowBookFunc.borrowBook.get(LoginFunc.getId()) != null) {
			System.out.println(BorrowBookFunc.borrowBook.get(LoginFunc.getId()));
		}
	}

	// 대출도서 반납
	public void returnBook(String bookNumber) {
		for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
			if (AdminBookFunc.bookList.get(i).getBooknumber().equals(bookNumber)) {
				int num = AdminBookFunc.bookList.get(i).getStock();
				num++;
				AdminBookFunc.bookList.get(i).setStock(num);
				BorrowBookFunc.borrowBook.remove(LoginFunc.getId());
			}

		}
	}
}
