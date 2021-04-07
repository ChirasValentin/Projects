package model;
/**
 * 
 * @author Valentin
 *
 */
public class Client {
	private int idClient;
	private String nume;
	private String adresa;
	private boolean flag;
	/**
	 * 
	 * @param nume numele clientului
	 * @param adresa adresa clientului
	 */
	public Client(String nume,String adresa) {
		this.setFlag(false);
		this.setNume(nume);
		this.setAdresa(adresa);
	}
	/**
	 * 
	 */
	public Client() {}
	/**
	 * 
	 * @return id-ul clientului
	 */
	public int getIdClient() {
		return idClient;
	}
	/**
	 * 
	 * @param idClient id-ul clientului
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	/**
	 * 
	 * @return numele clientului
	 */
	public String getNume() {
		return nume;
	}
	/**
	 * 
	 * @param nume numle clientului
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}
	/**
	 * 
	 * @return adresa clientului
	 */
	public String getAdresa() {
		return adresa;
	}
	/**
	 * 
	 * @param adresa clientului
	 */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	/**
	 * 
	 * @return flag-ul care hotaraste daca clientul este sters sau nu din baza de date
	 */
	public boolean isFlag() {
		return flag;
	}
	/**
	 * 
	 * @param flag valoarea flag-ului
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
