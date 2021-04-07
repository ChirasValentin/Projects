package com.assignment4.business;

import java.util.Objects;

public class Order {
	public int orderID;
	public String data;
	public int table;

	public boolean equals(Object deComparat) {
		if (deComparat == this)
			return true;
		if (deComparat instanceof Order) {
			Order comanda = (Order) deComparat;
			return orderID == comanda.orderID && Objects.equals(comanda.data, data) && table == comanda.table;
		} else
			return false;
	}

	public int hashCode() {
		return Objects.hash(orderID, data, table);
	}
}