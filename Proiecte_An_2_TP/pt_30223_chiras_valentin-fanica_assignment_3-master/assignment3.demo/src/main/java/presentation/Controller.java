package presentation;

/**

 * @author Alin Georgiu
 * @version 1.0
 * @since 2020-04-24
 */

import java.util.Scanner;

import businessLayer.ClientBLL;
import businessLayer.OrderBLL;
import businessLayer.ProductBLL;
import model.Client;
import model.Order;
import model.Product;
import start.Start;

public class Controller {
	private ClientBLL clientBLL;
	private OrderBLL orderBLL;
	private ProductBLL productBLL;

	public Controller() {
		clientBLL = new ClientBLL();
		orderBLL = new OrderBLL();
		productBLL = new ProductBLL();
	}

	public void convertInput() throws Exception {
		Scanner myScanner = Start.getScanner();

		while (myScanner.hasNextLine()) {
			String line;
			line = myScanner.nextLine();
			System.out.println(line.toString());
			String[] tokens = line.split(" |\\|, |\\: |\\,");
			String command = tokens[0];
			String table = tokens[1];
			switch (command) {
			case "Insert":
				switch (table) {
				case "client":
					String name = tokens[2] + " " + tokens[3];
					String address = tokens[5];
					clientBLL.insertClient(new Client(name, address));
					break;
				case "product":
					productBLL.insertProduct(
							new Product(tokens[2], Integer.parseInt(tokens[4]), Float.parseFloat(tokens[6])));
					break;
				default:
					System.out.println("I don't recognize the table name");
				}
				break;

			case "Delete":
				switch (table) {
				case "client":
					String name = tokens[2] + " " + tokens[3];
					String address = tokens[5];
					clientBLL.deleteClient(name, address);
					break;

				case "product":
					productBLL.deleteProduct(tokens[2]);
					break;

				default:
					System.out.println("I don't recognize the table name");
				}
				break;

			case "Order":
				String clientName = tokens[1] + " " + tokens[2];
				String productName = tokens[4];
				String quantity = tokens[6];
				orderBLL.insertOrder(new Order(clientName, productName, Integer.parseInt(quantity)));
				break;

			case "Report":
				switch (table) {
				case "client":
					clientBLL.raport();
					break;

				case "product":
					productBLL.raport();
					break;

				case "order":
					orderBLL.raport();
					break;

				default:
					System.out.println("I don't recognize the table name");
				}
				break;
			default:
				System.out.println("I don't recognize the command name");
			}
		
		}
	}
}
