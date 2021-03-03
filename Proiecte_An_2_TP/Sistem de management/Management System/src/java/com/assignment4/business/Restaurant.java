package java.com.assignment4.business;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Clasa Restaurant implementeaza metodele Intergefetei IRestaurantProcessing
 * 
 * @author valen
 *
 */
@SuppressWarnings("deprecation")
public class Restaurant extends Observable implements IRestaurantProcessing {

	public ArrayList<MenuItem> meniu;
	public Hashtable<Order, List<MenuItem>> orders;
	public ArrayList<MenuItem> productsOrder;
	public String noteChef;

	/**
	 * 
	 */
	public Restaurant() {
		meniu = new ArrayList<MenuItem>();
		orders = new Hashtable<Order, List<MenuItem>>();
		productsOrder = new ArrayList<MenuItem>();
		noteChef = new String();
	}

	/**
	 * 
	 */
	public void actualizare() {
		setChanged();
		notifyObservers(noteChef);
	}

	@Override
	public void addBaseProduct(String name, int price) {
		meniu.add(new BaseProduct(name, price));

	}

	@Override
	public void addCompositeProduct(String name, ArrayList<BaseProduct> ingredients, int price) {
		CompositeProduct product = new CompositeProduct(name, price);
		product.ingredients = ingredients;
		meniu.add(product);

	}

	@Override
	public void editProduct(MenuItem editProduct, String name, int price) {
		MenuItem newProduct = new MenuItem(name, price);
		for (MenuItem p : meniu) {
			if (p.equals(editProduct)) {
				meniu.remove(p);
				break;
			}
		}
		meniu.add(newProduct);
	}

	@Override
	public void deleteProduct(MenuItem item) {
		for (MenuItem p : meniu) {
			if (p.equals(item)) {
				meniu.remove(p);
				break;
			}
		}
	}

	@Override
	public void createOrder(int id, String data, int table, ArrayList<MenuItem> products) {
		Order order = new Order();
		order.data = data;
		order.orderID = id;
		order.table = table;
		orders.put(order, products);
		for (MenuItem i : products) {
			noteChef += i.getName().toString();
		}
		setChanged();
		notifyObservers("----------------------");

	}

	@Override
	public void generateBill(Order order) {
		int totalPrice = 0;
		for (MenuItem i : orders.get(order)) {
			totalPrice += i.computePrice();
		}
		try {
			PrintWriter writer = new PrintWriter("Bill " + order.orderID + ".txt");
			writer.println("------BON------");
			writer.println("Date: " + order.data);
			writer.println("Table: " + order.table);
			writer.print("Order: ");
			writer.println(orders.get(order).toString());
			writer.println("Total: " + totalPrice + " USD");
			writer.println("Have a nice day!!");
			writer.close();
			productsOrder = new ArrayList<MenuItem>();
		} catch (FileNotFoundException e) {
			System.out.print("Eroare la crearea bonului fiscal");
			e.printStackTrace();

		}

	}

}