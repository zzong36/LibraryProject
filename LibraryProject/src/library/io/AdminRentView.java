package library.io;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdminRentView {

	public AdminRentView() {
		super();
		// TODO Auto-generated constructor stub
	}

	// 전회원의 대출 및 반납 현황 조회
	public void showRentStatus() {
		System.out.println("==============================================================================");
		System.out.println("\t\t\t\t<회원별 대출 현황>");
		System.out.println("==============================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("------------------------------------------------------------------------------");
		Set set = BorrowBookFunc.borrowBook.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("아이디: " + e.getKey());
			System.out.println(e.getValue());
			System.out.println("------------------------------------------------------------------------------");
		}
		AdminView adv = new AdminView();
		System.out.println("관리자 메뉴로 이동합니다.");
		adv.adminShowMenu();

	}

}
