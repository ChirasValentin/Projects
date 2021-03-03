package java.com.assignment4.data;

import java.util.ArrayList;
import java.util.List;


import java.com.assignment4.business.MenuItem;

public class RestaurantSerializable implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public List<MenuItem> meniu = new ArrayList<MenuItem>();

	public RestaurantSerializable(List<MenuItem> meniu) {
		super();
		this.meniu = meniu;
	}

	
	public  List<MenuItem> getMenu() {
		return meniu;
	}
}