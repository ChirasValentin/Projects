package java.com.assignment4.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.com.assignment4.business.*;

public class FileWriter {

	static String file = "restaurant.ser";

	public RestaurantSerializable item;
	List<MenuItem> meniu;

	public FileWriter() {

		item = new RestaurantSerializable(meniu);
	}

	public void scrieItem(List<MenuItem> menu) {

		try {
			FileOutputStream fisier = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fisier);
			out.writeObject(menu);

			out.close();
			fisier.close();
			System.out.println("Object has been serialized\n" + menu);
		} catch (IOException ex) {
			System.out.println("Eroare la scriere in fiser");
		}

	}

	@SuppressWarnings("unchecked")
	public ArrayList<MenuItem> citesteItem() {
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

		try {
			FileInputStream fisier = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fisier);
			menuItems = (ArrayList<MenuItem>) in.readObject();

			in.close();
			fisier.close();
			System.out.println("\nObject has been deserialized ");

			item = new RestaurantSerializable(menuItems);

		} catch (IOException ex) {
			System.out.println("Eroare la citire din fiser " + ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException");
		}
		return menuItems;

	}

}