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
import model.Order;

/**
 * 
 * @author Valentin
 *
 */
public class OrderDAO {
	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO comanda(idClient,idProdus,cantitate)"
			+ "VALUES((SELECT client.idClient from client where client.nume = ?),(SELECT produs.idProdus from produs where produs.nume = ? ),?)";
	private static final String showStatementString = "select comanda.idComanda,client.nume as client,produs.nume as produs,comanda.cantitate,comanda.pret"
			+ " from comanda,client,produs where comanda.idClient=client.idClient and comanda.idProdus=produs.idProdus";
	private static final String updatePretStatementString = "UPDATE comanda,produs SET comanda.pret=comanda.cantitate*produs.pret where comanda.idProdus=produs.idProdus";
	private static final String selectPretStatementString = "Select comanda.pret from comanda where idComanda=?";

	/**
	 * Acesta clasa este,mai exact,"Database Access" a tabelei Order!
	 */
	public OrderDAO() {
	}

	/**
	 * Insereaza in baza de date o comanda
	 * 
	 * @param order
	 * @return id-ul comenzii introduse in baza de date
	 */
	public static int insert(Order order) {
		Connection connection = ConnectionFactory.getConnection();
		int id = 0;
		PreparedStatement insertStatement = null;
		try {
			insertStatement = connection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, order.getClient());
			insertStatement.setString(2, order.getProdus());
			insertStatement.setInt(3, order.getCantitate());
			insertStatement.executeUpdate();
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO insert : " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(connection);
		}
		return id;
	}

	/**
	 * 
	 * @param id
	 * @return pretul total al comenzii
	 */
	public static float getUpdatePret(int id) {
		Connection connection = ConnectionFactory.getConnection();
		float pret = 0;
		ResultSet rs = null;
		PreparedStatement getStatement = null;
		try {
			getStatement = connection.prepareStatement(selectPretStatementString);
			getStatement.setInt(1, id);
			rs = getStatement.executeQuery();
			if (rs.next())
				pret = rs.getFloat("pret");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO getPret: " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(getStatement);
			ConnectionFactory.close(connection);
		}
		return pret;
	}

	/**
	 * 
	 * @return O lista ce contine toate comenzile din baza de date
	 */
	public static ArrayList<Order> showOrders() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement showStatement = null;
		ArrayList<Order> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			showStatement = connection.prepareStatement(showStatementString);
			rs = showStatement.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("idComanda"));
				order.setCantitate(rs.getInt("cantitate"));
				order.setClient(rs.getString("client"));
				order.setPret(rs.getFloat("pret"));
				order.setProdus(rs.getString("produs"));
				list.add(order);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO show: " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(showStatement);
			ConnectionFactory.close(connection);
		}
		return list;
	}

	/**
	 * Actualieaza pretul comenzii dupa formula pret=produs.pret * comanda.cantitate
	 */
	public static void updatePret() {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;

		try {
			updateStatement = connection.prepareStatement(updatePretStatementString);
			updateStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO updatePret: " + e.getMessage());
		} finally {

			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(connection);
		}
	}

}
