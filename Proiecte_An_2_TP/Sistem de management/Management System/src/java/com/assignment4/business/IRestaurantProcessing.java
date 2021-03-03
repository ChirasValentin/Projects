package java.com.assignment4.business;

import java.util.ArrayList;

/**
 * Interfata IrestaurantPrcessing contine metodele ce reprezinta activitatea
 * unui Administrator si a unui Ospatar Administratorul va adauga,sterge sau
 * edita un produs Ospatarul va crea o comanda si va genera factura pentru
 * comnada respectiva
 * 
 * @author valen
 *
 */
public abstract interface IRestaurantProcessing {
	/**
	 * actualizeaza WaiterGUI
	 */
	public void actualizare();
	/**
	 * 
	 * @param name
	 * @param price
	 */
	public void addBaseProduct(String name, int price);
	/**
	 * 
	 * @param name
	 * @param ingredients ingredientele produsului
	 * @param price
	 */
	public void addCompositeProduct(String name, ArrayList<BaseProduct> ingredients, int price);
	/**
	 * 
	 * @param editProduct produsul ce va fi editat
	 * @param name numele nou
	 * @param price	pretul nou
	 */
	public void editProduct(MenuItem editProduct, String name, int price);
	/**
	 * 
	 * @param item	produsul ce va fi sters din meniu
	 */
	public void deleteProduct(MenuItem item);
	/**
	 * 
	 * @param id
	 * @param data
	 * @param table
	 * @param products
	 */
	public void createOrder(int id, String data, int table, ArrayList<MenuItem> products);
	/**
	 * 
	 * @param order Reprezinta carei comenzi se va genera factura
	 */
	public void generateBill(Order order);

}