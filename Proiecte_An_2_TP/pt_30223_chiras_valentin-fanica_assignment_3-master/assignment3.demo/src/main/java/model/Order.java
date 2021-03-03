package model;
/**
 * 
 * @author Valentin
 *
 */
public class Order {
	private int id;
	private String  client;
	private String produs;
	private int cantitate;
	private float pret;
	
	public Order(){}
	/**
	 * 
	 * @param numeClient Numele clientului
	 * @param numeProdus Denumirea produsului
	 * @param cantitate Cantitatea comandata
	 */
	public Order(String numeClient,String numeProdus,int cantitate) {
		this.client=numeClient;
		this.produs=numeProdus;
		this.cantitate=cantitate;
	}
	/**
	 * 
	 * @return pret
	 */
	public float getPret() {
		return pret;
	}
	/**
	 * 
	 * @param pret pretul comenzii
	 */
	public void setPret(float pret) {
		this.pret = pret;
	}
	/**
	 * 
	 * @return cantitatea comenzii
	 */
	public int getCantitate() {
		return cantitate;
	}
	/**
	 * 
	 * @param cantitate cantitatea comandata
	 */
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	/**
	 * 
	 * @return produsul
	 */
	public String getProdus() {
		return produs;
	}
	/**
	 * 
	 * @param produs denumirea produsului
	 */
	public void setProdus(String produs) {
		this.produs = produs;
	}
	/**
	 * 
	 * @return numele clientului
	 */
	public String getClient() {
		return client;
	}
	/**
	 * 
	 * @param client numele clientului
	 */
	public void setClient(String client) {
		this.client = client;
	}
	/**
	 * 
	 * @return id-ul comenzii
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id id-ul comenzii
	 */
	public void setId(int id) {
		this.id = id;
	}
}
