package library.io;

import java.util.Scanner;

public class SearchBookFunc {

	private Scanner sc = new Scanner(System.in);

	public SearchBookFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void searchBookName(String bookSearch) { // 도서명 검색 시 조회기능
		for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
			if (AdminBookFunc.bookList.get(i).getBookName().contains(bookSearch))
				System.out.println(AdminBookFunc.bookList.get(i));
		}
	}

}
