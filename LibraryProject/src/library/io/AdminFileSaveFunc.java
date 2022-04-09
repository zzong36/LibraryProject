package library.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AdminFileSaveFunc {

	public AdminFileSaveFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	// DATA 폴더 안의 UserInfo.txt 파일에 인메모리에 있는 회원정보를 저장하는 기능
	public void printSaveUserList() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("DATA/UserInfo.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
				System.out.println(RegistrationFunc.userList.get(i));
				pw.printf("%s,%s,%s,%s,%s%n", RegistrationFunc.userList.get(i).getId(),
						RegistrationFunc.userList.get(i).getPassword(), RegistrationFunc.userList.get(i).getName(),
						RegistrationFunc.userList.get(i).getBirthDay(), RegistrationFunc.userList.get(i).getEmail());
			}

			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// DATA 폴더 안의 BookInfo.txt 파일에 인메모리에 있는 도서정보를 저장하는 기능
	public void printSaveBookList() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("DATA/BookInfo.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
				System.out.println(AdminBookFunc.bookList.get(i));
				pw.printf("%s,%s,%s,%s,%d%n", AdminBookFunc.bookList.get(i).getBooknumber(),
						AdminBookFunc.bookList.get(i).getBookName(), AdminBookFunc.bookList.get(i).getAuthor(),
						AdminBookFunc.bookList.get(i).getPublisher(), AdminBookFunc.bookList.get(i).getStock());
			}

			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// DATA 폴더 안의 RentInfo.txt 파일에 인메모리에 있는 도서대출정보를 저장하는 기능
	public void printSaveRentList() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("DATA/RentInfo.txt");
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);

			Set set = BorrowBookFunc.borrowBook.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				System.out.println("아이디: " + e.getKey());
				System.out.println(e.getValue());
			}

			for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
				pw.printf("%s\t%s%n", RegistrationFunc.userList.get(i).getId(),
						BorrowBookFunc.borrowBook.get(RegistrationFunc.userList.get(i).getId()));
			}

			bw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
