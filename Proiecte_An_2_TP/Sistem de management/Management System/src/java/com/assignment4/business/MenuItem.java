package java.com.assignment4.business;

import java.io.Serializable;

public class MenuItem implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	public MenuItem() {}
	public MenuItem(String s) {
		name = s;
	}

	public MenuItem(String s, int price) {
		name = s;
		this.price = price;
	}

	public int computePrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " " + price +" USD";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean equals(MenuItem item) {
		if (this.name == item.name)
			return false;
			return true;
	}
}