package java.dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Product;

/**
 * 
 * @author Valentin
 *
 */

public class ProductDAO {
	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO produs(nume,stoc,pret)" + "VALUES(?,?,?)";
	private static final String showStatementString = "SELECT * from produs where produs.flag=false";
	private static final String deleteStatementString = "UPDATE produs SET produs.flag=true where nume=?";
	private static final String updateStatementString = "UPDATE comanda,produs SET produs.stoc=produs.stoc-comanda.cantitate WHERE produs.nume=? and comanda.idComanda=?";
	private static final String stocStatementString = "Select produs.stoc from produs where produs.nume=?";
	private static final String insertStocString = "UPDATE produs SET stoc = stoc + ? where produs.nume=?";

	/**
	 * Acesta clasa este,mai exact,"Database Access" a tabelei produs!
	 */
	public ProductDAO() {
	}

	/**
	 * Aceasta metoda insereaza in baza de date produsul declarat ca parametru
	 * 
	 * @param produs
	 * @return id-ul generat automat al prdousului
	 */
	public static int insert(Product produs) {
		Connection connection = ConnectionFactory.getConnection();
		int id = 0;
		PreparedStatement insertStatement = null;
		try {
			insertStatement = connection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, produs.getNume());
			insertStatement.setInt(2, produs.getStoc());
			insertStatement.setFloat(3, produs.getPret());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO insert : " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(connection);
		}
		return id;
	}

	/**
	 * Introduce intr-o lista toate produsele din baza de date
	 * 
	 * @return lista tuturor produselor din baza de date
	 */
	public static ArrayList<Product> showProducts() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ArrayList<Product> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			showStatement = connection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Product produs = new Product();
				produs.setNume(rs.getString("nume"));
				produs.setId(rs.getInt("idProdus"));
				produs.setPret(rs.getFloat("pret"));
				produs.setStoc(rs.getInt("stoc"));
				produs.setFlag(rs.getBoolean("flag"));
				list.add(produs);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO show: " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(showStatement);
			ConnectionFactory.close(connection);
		}
		return list;
	}

	/**
	 * Sterge un produs din baza de date
	 * 
	 * @param nume
	 */
	public static void delete(String nume) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = connection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, nume);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO delete: " + e.getMessage());
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * Seteaza Stoc-ul produsului dat de "nume" si "id" conform formulei
	 * stoc=stoc-comanda.comanda
	 * 
	 * @param nume
	 * @param id
	 */
	public static void update(String nume, int id) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = connection.prepareStatement(updateStatementString);
			updateStatement.setString(1, nume);
			updateStatement.setInt(2, id);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO update: " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * 
	 * @param produs
	 * @return stocul ramas al produsului
	 */
	public static int findStoc(String produs) {
		Connection connection = ConnectionFactory.getConnection();
		int stoc = 0;
		PreparedStatement updateStatement = null;
		ResultSet rs = null;
		try {
			updateStatement = connection.prepareStatement(stocStatementString);
			updateStatement.setString(1, produs);
			rs = updateStatement.executeQuery();
			rs.next();
			stoc = rs.getInt("produs.stoc");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO stoc: " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(connection);

		}
		return stoc;
	}

	/**
	 * In cazul in care se incearca reitroducere unui produs deja existenta acesta
	 * is va actualiza doar stoc-ul
	 * 
	 * @param stoc
	 * @param produs
	 */
	public static void insertStoc(int stoc, String produs) {
		Connection connection = ConnectionFactory.getConnection();

		PreparedStatement updateStatement = null;
		try {
			updateStatement = connection.prepareStatement(insertStocString);
			updateStatement.setInt(1, stoc);
			updateStatement.setString(2, produs);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO insertStoc: " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(connection);

		}
	}
}
