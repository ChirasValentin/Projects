package java.start;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.itextpdf.text.DocumentException;
import presentation.Controller;

public class Start {

	private static Scanner myScanner;
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
	
		Path filePath = Paths.get(args[0]);
		try {
			myScanner = new Scanner(filePath);
		} catch (IOException e) {
			e.getMessage();
		}
	
		Controller controller = new Controller();
		try {
			
			controller.convertInput();
		} catch (Exception e) {
			e.getStackTrace();
			
		}	
	}
	
	public static Scanner getScanner() {
		return myScanner;
	}
}
