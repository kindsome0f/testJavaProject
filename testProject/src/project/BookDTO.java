package project;

public class BookDTO {
	String name, writer, maker;
	int price;
	String year;
	int amount;
	int tot;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTot() {
		return (price*amount);
	}
	public void setTot(int tot) {
		this.tot = (price*amount);
	}
	@Override
	public String toString() {
		return "BookDAO [name=" + name + ", writer=" + writer + ", maker=" + maker + ", price=" + price + ", year="
				+ year + ", amount=" + amount + ", tot=" + tot + "]";
	}
	public BookDTO(String name, String writer, String maker, int price, String year, int amount, int tot) {
		super();
		this.name = name;
		this.writer = writer;
		this.maker = maker;
		this.price = price;
		this.year = year;
		this.amount = amount;
		this.tot = (price*amount);
	}
	public BookDTO() {
		super();
	}
	
}
