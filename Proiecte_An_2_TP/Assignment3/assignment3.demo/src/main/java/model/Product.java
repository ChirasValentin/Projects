package model;
/**
 * 
 * @author Valentin
 *
 */
public class Product {
	private int id;
	private String nume;
	private int stoc;
	private float pret;
	private boolean flag;
	/**
	 * 
	 * @param nume numele produsului
	 * @param stoc stocul produsului
	 * @param pret pretul produsului
	 */
	public Product(String nume,int stoc,float pret) {
		this.setNume(nume);
		this.setStoc(stoc);
		this.setPret(pret);
		this.setFlag(false);
	}
	public Product() {}
	/**
	 * 
	 * @return id-ul produsului
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id id-ul produsului
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return numele produsului
	 */ 
	public String getNume() {
		return nume;
	}
	/**
	 * 
	 * @param nume numele produsului
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	/**
	 * 
	 * @return stocul produsului
	 */
	public int getStoc() {
		return stoc;
	}
	/**
	 * 
	 * @param stoc stocul produsului
	 */
	public void setStoc(int stoc) {
		this.stoc = stoc;
	}
	/**
	 * 
	 * @return pretul produsului
	 */
	public float getPret() {
		return pret;
	}
	/**
	 * 
	 * @param pret pretul produsului
	 */
	public void setPret(float pret) {
		this.pret = pret;
	}
	/**
	 * 
	 * @return flagul care hotaraste daca prdsului este sters sau nu
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * 
	 * @param flag valoarea falgului
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
