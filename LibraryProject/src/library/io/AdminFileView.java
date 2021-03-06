package library.io;

public class AdminFileView {

	public AdminFileView() {
		super();
		// TODO Auto-generated constructor stub
	}

	AdminFileSaveFunc aff = new AdminFileSaveFunc();
	AdminFileReadFunc afr = new AdminFileReadFunc();

	// 하루가 끝나면 관리자가 프로그램 종료 전 인메모리 정보를 저장하는 기능
	public void showFileSave() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("*아래 사항을 txt 파일로 저장했습니다!");

		System.out.println();
		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<회원정보>");
		System.out.println("========================================================================================");
		System.out.println("아이디\t\t비밀번호\t\t이름\t\t생년월일\t\t이메일");
		System.out.println("----------------------------------------------------------------------------------------");
		aff.printSaveUserList(); // 회원목록 txt 파일로 저장하기
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<도서목록>");
		System.out.println("========================================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("----------------------------------------------------------------------------------------");
		aff.printSaveBookList(); // 도서목록 txt 파일로 저장하기
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("==============================================================================");
		System.out.println("\t\t\t\t<회원별 대출 현황>");
		System.out.println("==============================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("------------------------------------------------------------------------------");
		aff.printSaveRentList(); // 도서대출 목록 txt파일로 저장하기
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("오늘 하루 수고하셨습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}

	// 하루를 시작할 때 관리자가 외부에 저장된 txt 파일을 불러와 전날 시점에서 다시 기록할 수 있게 하는 기능
	public void showFileRead() {
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("*아래 사항을 txt 파일로부터 읽어왔습니다!");

		System.out.println();
		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<회원정보>");
		System.out.println("========================================================================================");
		System.out.println("아이디\t\t비밀번호\t\t이름\t\t생년월일\t\t이메일");
		System.out.println("----------------------------------------------------------------------------------------");
		afr.readUserFile();// DATA/UserInfo.txt 로부터 읽어온 회원정보
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("========================================================================================");
		System.out.println("\t \t \t \t \t<도서목록>");
		System.out.println("========================================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("----------------------------------------------------------------------------------------");
		afr.readBookFile(); // DATA/BookInfo.txt로부터 읽어온 도서정보
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("==============================================================================");
		System.out.println("\t\t\t\t<회원별 대출 현황>");
		System.out.println("==============================================================================");
		System.out.println("도서관리번호\t도서명\t\t저자\t\t\t출판사\t\t도서관재고");
		System.out.println("------------------------------------------------------------------------------");
		afr.readRentFile();; // DATA/RentInfo.txt로부터 읽어온 대출정보
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("데이터 업로드가 완료되었습니다. 좋은 하루 보내세요!");
		AdminView av = new AdminView();
		av.adminShowMenu();

	}

}
