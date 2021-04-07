package com.assignment4.business;

public class BaseProduct extends MenuItem {

	private static final long serialVersionUID = 1L;

	public BaseProduct(String s) {
		super(s);
	}

	public BaseProduct(String s, int price) {
		super(s, price);
	}

	@Override
	public int computePrice() {
		return super.computePrice();
	}

}