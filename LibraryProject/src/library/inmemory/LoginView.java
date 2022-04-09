package library.inmemory;

public class LoginView {

	public LoginView() {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginFunc lof = new LoginFunc();

	public void showLoginMenu() {
		System.out.println("==============================================================");
		System.out.println("\t \t \t <일반회원 로그인>");
		System.out.println("==============================================================");
 
		lof.loginInput();

	}

}
