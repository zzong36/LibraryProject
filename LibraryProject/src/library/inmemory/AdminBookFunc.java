package library.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminBookFunc {

	private Scanner sc = new Scanner(System.in);
	private String bookNumber;

	public AdminBookFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	static List<BookInfo> bookList = new ArrayList<>();

	// 신착도서 등록
	public void inputBook() {
		String bookNumber = bookNumberRegister();
		String bookName = bookNameRegister();
		String author = authorRegister();
		String publisher = publisherRegister();
		int stock = stockRegister();

		bookList.add(new BookInfo(bookNumber, bookName, author, publisher, stock));
	}

	// 신착도서 추가 등록
	public void inputBookAgain() {
		System.out.print("다른 도서를 추가 하시겠습니까? yes(0), no(1): ");
		int choice = Integer.parseInt(sc.nextLine());
		while (choice == 0) {
			inputBook();
			System.out.print("다른 도서를 추가 하시겠습니까? yes(0), no(1): ");
			choice = Integer.parseInt(sc.nextLine());
		}
	}

	// 도서목록 수정 기능
	public void changeBookList() {
		AdminView av = new AdminView();

		System.out.println("*아래 항목을 입력하세요.");
		System.out.print("도서관리번호: ");
		bookNumber = sc.nextLine().trim();
		System.out.print("수정항목(도서명(0), 저자(1), 출판사(2), 도서재고(3): ");
		int choice = Integer.parseInt(sc.nextLine().trim());
		System.out.print("수정사항: ");
		String change = sc.nextLine().trim();

		for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
			if (AdminBookFunc.bookList.get(i).getBooknumber().equals(bookNumber)) {
				if (choice == 0) {
					AdminBookFunc.bookList.get(i).setBookName(change);
				} else if (choice == 1) {
					AdminBookFunc.bookList.get(i).setAuthor(change);
				} else if (choice == 2) {
					AdminBookFunc.bookList.get(i).setPublisher(change);
				} else if (choice == 3) {
					AdminBookFunc.bookList.get(i).setStock(Integer.parseInt(change));
				}

				System.out.println("수정이 완료되었습니다.");
				System.out.println("------------------------------------------------------------------------------");
				System.out.println(AdminBookFunc.bookList.get(i));
				System.out.println("------------------------------------------------------------------------------");
				System.out.println("메인메뉴로 이동합니다.");
				av.adminShowMenu();

			}
		}
		System.out.println("일치하는 항목이 없습니다. 메인메뉴로 이동합니다.");
		av.adminShowMenu();
	}

	// 도서관리 번호 입력
	public String bookNumberRegister() {
		System.out.print("도서관리번호(중복설정불가): ");
		bookNumber = sc.nextLine().trim();
		for (int i = 0; i < bookList.size(); i++) {
			if (bookList.get(i).getBooknumber().equals(bookNumber)) {
				System.out.println(bookList.get(i).getBooknumber());
				System.out.println(bookNumber);
				System.out.println(bookList.get(i));
				System.out.println("도서관리번호 " + bookNumber + "이/가 이미 존재합니다. 다시 입력해주세요.");
				bookNumberRegister();
			}
		}
		return bookNumber;
	}

	// 도서명 입력
	public String bookNameRegister() {
		System.out.print("도서명: ");
		String bookName = sc.nextLine().trim();
		return bookName;
	}

	// 저자명 입력
	public String authorRegister() {
		System.out.print("저자명: ");
		String author = sc.nextLine().trim();
		return author;
	}

	// 출판사 입력
	public String publisherRegister() {
		System.out.print("출판사: ");
		String publisher = sc.nextLine().trim();
		return publisher;
	}

	// 보유권수 입력
	public int stockRegister() {
		System.out.print("보유권수: ");
		int stock = Integer.parseInt(sc.nextLine().trim());
		return stock;
	}

}
