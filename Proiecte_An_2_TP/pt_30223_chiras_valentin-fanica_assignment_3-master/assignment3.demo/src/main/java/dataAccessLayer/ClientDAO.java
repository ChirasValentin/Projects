package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

/**
 * 
 * @author Valentin
 *
 */
public class ClientDAO {
	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO client(nume,adresa)" + "VALUES(?,?)";
	private static final String showStatementString = "SELECT * from client where client.flag=false";
	private static final String deleteStatementString = "UPDATE client SET client.flag=true where nume=? and adresa=?";
	private static final String updateStatementString = "UPDATE client SET client.flag = false where nume = ?";

	/**
	 * Acesta clasa este,mai exact,"Database Access" a tabelei client!
	 */
	public ClientDAO() {
	}

	/**
	 * Aceasta metoda introduce in baza de date un client
	 * 
	 * @param client
	 * @return id-ul clientului introdus in baza de date
	 */
	public static int insert(Client client) {
		Connection connection = ConnectionFactory.getConnection();
		int id = 0;
		PreparedStatement insertStatement = null;
		try {
			insertStatement = connection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, client.getNume());
			insertStatement.setString(2, client.getAdresa());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO insert : " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(connection);
		}
		return id;
	}

	/**
	 * 
	 * @return O lista cu toti clientii
	 */
	public static ArrayList<Client> showClients() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ArrayList<Client> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			showStatement = connection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Client client = new Client();
				client.setIdClient(rs.getInt("idClient"));
				client.setAdresa(rs.getString("adresa"));
				client.setNume(rs.getString("nume"));
				client.setFlag(rs.getBoolean("flag"));
				list.add(client);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO show: " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(showStatement);
			ConnectionFactory.close(connection);
		}
		return list;
	}

	/**
	 * Sterge un client din baza de date
	 */
	public static void delete(String nume, String adresa) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement deleteStatement = null;
		try {
			deleteStatement = connection.prepareStatement(deleteStatementString);
			deleteStatement.setString(1, nume);
			deleteStatement.setString(2, adresa);
			deleteStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO delete: " + e.getMessage());
		} finally {
			ConnectionFactory.close(deleteStatement);
			ConnectionFactory.close(connection);
		}
	}

	/**
	 * In cazul in care un client este sters si se doreste sa se reintroduca
	 */
	public static void backClient(String nume) {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		try {
			updateStatement = connection.prepareStatement(updateStatementString);
			updateStatement.setString(1, nume);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO update: " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(connection);

		}
	}
}
