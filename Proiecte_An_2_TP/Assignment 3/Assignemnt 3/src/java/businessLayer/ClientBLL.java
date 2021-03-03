package java.businessLayer;

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

import java.dataAccessLayer.ClientDAO;
import java.model.Client;
/**
 * 
 * @author Valentin
 *
 */
public class ClientBLL {
	/**
	 * 
	 * @param client
	 * @return
	 */
	public int insertClient(Client client) {
		return ClientDAO.insert(client);
	}
	/**
	 * 
	 * @param nume
	 * @param adresa
	 */
	public void deleteClient(String nume,String adresa) {
		ClientDAO.delete(nume,adresa);
	}
	/**
	 * 
	 * @param nume
	 */
	public void updateClient(String nume) {
		ClientDAO.backClient(nume);
	}
	/**
	 * Creaza un pdf cu raportul tuturor clientilor inregistrati in baza de date
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void raport() throws FileNotFoundException, DocumentException {
		ArrayList<Client> listClients = ClientDAO.showClients();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Raport clienti.pdf"));
		document.open();
		document.add(new Paragraph("Raport clienti"));
		PdfPTable table = new PdfPTable(3);
		document.add(new Paragraph(" "));
		addTableHeader(table);
		for (Client c : listClients) {
			addRows(table, c);
		}
		document.add(table);
		document.close();

	}
	/**
	 * 
	 * @param table tabelul cu clienti
	 */
	private void addTableHeader(PdfPTable table) {
		Stream.of("id", "Nume", "Adresa").forEach(columnTitle -> {
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
	 * @param client
	 */
	private void addRows(PdfPTable table, Client client) {
		table.addCell(client.getIdClient() + "");
		table.addCell(client.getNume());
		table.addCell(client.getAdresa());
	}
}
