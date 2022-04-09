package library.inmemory;

public class RegistrationView {

	public RegistrationView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	RegistrationFunc rf = new RegistrationFunc();
	LoginView lv = new LoginView();
	
	public void showRegistrationMenu() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <도서관 회원가입>");
		System.out.println("==============================================================");
		System.out.println("*아래 사항을 입력하세요");
		
		rf.inputUser();
		System.out.println("회원가입이 완료되었습니다. 로그인 페이지로 이동합니다..");
		lv.showLoginMenu();
	}
	

}
