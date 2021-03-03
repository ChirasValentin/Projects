package java.Start;

import java.com.assignment4.business.Restaurant;
import java.com.assignment4.presentation.*;

public class Start {
	public static void main(String[] args) {
		Restaurant r = new Restaurant();
		AdministratorGUI administrator = new AdministratorGUI(r);
		WaiterGUI waiter = new WaiterGUI(r);
		ChefGUI chef = new ChefGUI(r);
		r.actualizare();
		administrator.setVisible(true);
		waiter.setVisible(true);
		chef.setVisible(true);
	}
}
