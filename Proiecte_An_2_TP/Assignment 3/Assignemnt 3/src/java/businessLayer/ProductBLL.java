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

import dataAccessLayer.ProductDAO;
import model.Product;

/**
 * 
 * @author Valentin
 *
 */
public class ProductBLL {
	/**
	 * 
	 * @param Product
	 * @return
	 */
	public int insertProduct(Product Product) {
		ArrayList<Product> listProduct = ProductDAO.showProducts();
		for (Product p : listProduct) {
			if (p.getNume().equals(Product.getNume())) {
				ProductDAO.insertStoc(Product.getStoc(), Product.getNume());
				return 0;
			}
		}
		return ProductDAO.insert(Product);
	}

	/**
	 * 
	 * @param nume
	 */
	public void deleteProduct(String nume) {
		ProductDAO.delete(nume);
	}
	/**
	 * 
	 * @param nume
	 * @param id
	 */
	public void updateProduct(String nume, int id) {
		ProductDAO.update(nume, id);
	}

	/**
	 * Aceasta metoda creaza un pdf cu raportul tuturor Productelor din baza de date
	 * 
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void raport() throws FileNotFoundException, DocumentException {
		ArrayList<Product> listProduct = ProductDAO.showProducts();
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Raport Produse.pdf"));
		document.open();
		document.add(new Paragraph("Raport Producte"));
		PdfPTable table = new PdfPTable(4);
		document.add(new Paragraph(" "));
		addTableHeader(table);
		for (Product c : listProduct) {
			addRows(table, c);
		}
		document.add(table);
		document.close();

	}

	/**
	 * 
	 * @param table tabelul cu Producte
	 */

	private void addTableHeader(PdfPTable table) {
		Stream.of("id", "Nume", "Stoc", "Pret").forEach(columnTitle -> {
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
	 * @param Product
	 */
	private void addRows(PdfPTable table, Product Product) {
		table.addCell(Product.getId() + "");
		table.addCell(Product.getNume());
		table.addCell(Product.getStoc() + "");
		table.addCell(Product.getPret() + "");
	}
}
