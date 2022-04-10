package library.io;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AdminFileReadFunc {

	public AdminFileReadFunc() {
		super();
		// TODO Auto-generated constructor stub
	}

	// DATA 폴더에 저장된 UserInfo.txt file을 읽어오는 기능
	public void readUserFile() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("DATA/UserInfo.txt"));
			for (int j = 0; j < lines.size(); j++) {
				String[] arr = lines.get(j).split(",");
				RegistrationFunc.userList.add(new UserInfo1(arr[0], arr[1], arr[2], arr[3], arr[4]));

			}
			for (int i = 0; i < RegistrationFunc.userList.size(); i++) {
				System.out.println(RegistrationFunc.userList.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DATA 폴더에 저장된 BookInfo.txt file을 읽어오는 기능
	public void readBookFile() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("DATA/BookInfo.txt"));
			for (int j = 0; j < lines.size(); j++) {
				String[] arr = lines.get(j).split(",");
				int num = Integer.parseInt(arr[4]);
				AdminBookFunc.bookList.add(new BookInfo(arr[0], arr[1], arr[2], arr[3], num));
				
			}
			for (int i = 0; i < AdminBookFunc.bookList.size(); i++) {
				System.out.println(AdminBookFunc.bookList.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// DATA 폴더에 저장된 RentInfo.txt file을 읽어오는 기능
	public void readRentFile() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("DATA/RentInfo.txt"));
			for (int i = 0; i < lines.size(); i++) {
				String[] arr = lines.get(i).split(",");
				if(arr[1].startsWith(AdminBookFunc.bookList.get(i).getBooknumber())) {
					BorrowBookFunc.borrowBook.put(arr[0], AdminBookFunc.bookList.get(i));
				}
			}
			
			Set set = BorrowBookFunc.borrowBook.entrySet();
			Iterator it = set.iterator();

			while (it.hasNext()) {
				Map.Entry e = (Map.Entry) it.next();
				System.out.println("아이디: " + e.getKey());
				System.out.println(e.getValue());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
