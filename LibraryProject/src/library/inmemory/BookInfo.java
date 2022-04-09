package library.inmemory;

public class BookInfo {

	private String bookNumber; // 도서관리 번호
	private String bookName; // 도서명
	private String author; // 저자
	private String publisher; // 출판사
	private int stock; // 도서 재고

	public BookInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookInfo(String bookNumber, String bookName, String author, String publisher, int stock) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.stock = stock;
	}

	public String getBooknumber() {
		return bookNumber;
	}

	public void setBooknumber(String booknumber) {
		this.bookNumber = booknumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return bookNumber + "\t\t" + bookName + "\t\t" + author + "\t\t" + publisher + "\t\t" + stock;
	}

}
