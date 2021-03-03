package businessLayer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dataAccessLayer.OrderDAO;
import dataAccessLayer.ProductDAO;
import model.Order;
/**
 * 
 * @author Valentin
 *
 */
public class OrderBLL {
	/**
	 * 
	 * @param order
	 * @return
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public int insertOrder(Order order) throws FileNotFoundException, DocumentException {
		if (ProductDAO.findStoc(order.getProdus()) < order.getCantitate())
			return 0;
		else {
			int id = OrderDAO.insert(order);
			ProductDAO.update(order.getProdus(), id);
			order.setId(id);
			OrderDAO.updatePret();
			bill(order);
			return 1;
		}
	}
	/**
	 * Creaza un pdf ce contine raportul cu toate comenzile inregistrate in baza de date
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void raport() throws FileNotFoundException, DocumentException {
		ArrayList<Order> listOrders = OrderDAO.showOrders();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Raport order.pdf"));
		document.open();
		document.add(new Paragraph("Raport Orders"));
		PdfPTable table = new PdfPTable(5);
		document.add(new Paragraph(" "));
		addTableHeader(table);
		for (Order o : listOrders) {
			addRows(table, o);
		}
		document.add(table);
		document.close();
	}

	/**
	 * Creaza cate o facutra pentru fiecare comanda
	 * @param order
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void bill(Order order) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		order.setPret(OrderDAO.getUpdatePret(order.getId()));
		PdfWriter.getInstance(document, new FileOutputStream("Bill" + order.getId() +" "+ order.getClient()+ ".pdf"));
		document.open();
		document.add(new Paragraph("Bill: " + order.getId()));
		document.add(new Paragraph(" "));
		PdfPTable table = new PdfPTable(5);
		addTableHeader(table);
		addRows(table, order);
		document.add(table);
		document.close();
	}
	/**
	 * 
	 * @param table tabelul cu comenzi
	 */
	private void addTableHeader(PdfPTable table) {
		Stream.of("id", "Client", "Produs", "Cantitate", "pret").forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.CYAN);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(columnTitle));
			table.addCell(header);
		});
	}
	/**
	 * 
	 * @param table
	 * @param order
	 */
	private void addRows(PdfPTable table, Order order) {
		table.addCell(order.getId() + "");
		table.addCell(order.getClient());
		table.addCell(order.getProdus());
		table.addCell(order.getCantitate() + "");
		table.addCell(order.getPret() + "");
	}
}
