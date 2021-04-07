package com.assignment4.business;

import java.util.ArrayList;

import java.util.List;

public class CompositeProduct extends MenuItem {

	private static final long serialVersionUID = 1L;
	public List<BaseProduct> ingredients = new ArrayList<BaseProduct>();

	public CompositeProduct(String s,int price) {
		super(s,price);
	}

	public CompositeProduct() {
		super();
	}

	@Override
	public int computePrice() {
		int total = 0;
		for (MenuItem i : ingredients) {
			total = total + i.computePrice();
		}
		return total;
	}

}