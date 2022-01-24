package com.bl.gson.addressBook;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;

public class OpenCSV {
	
	public static String CONTACT_CSV_FILE = "Address.cvs";
	
	public static void main(String[] args) {
		writerCSV();
		readCVS();
	}
	
	private static void readCVS() {
		try {
		Reader reader = Files.newBufferedReader(Paths.get(CONTACT_CSV_FILE));
		CSVReader csvReader = new CSVReader(reader);
		String[]record;
		
			while ((record = csvReader.readNext()) != null) {
				System.out.println("FirstName :"+record[0]);
				System.out.println("LastName :"+record[1]);
				System.out.println("city :"+record[2]);
				System.out.println("state :"+record[3]);
				System.out.println("PhoneNumber:"+record[4]);
				System.out.println("email :"+record[5]);
				
				reader.close();
				csvReader.close();
			}
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void writerCSV() {
		
			FileWriter writter;
			try {
				writter = new FileWriter(CONTACT_CSV_FILE);
			
			List<Contact> contactList = new ArrayList<>();
			
			Contact contact = new Contact("Rajshekar", "Reddy", "Nandyal", "AndhraPradesh", "7884554097", "Rajshekar@gmail.com", "543452");
		
			ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
			mappingStrategy.setType(Contact.class);
			String[] header = {"FirstName", "LastName", "city", "State", "PhoneNumber", "Email"};
			mappingStrategy.setColumnMapping(header);
			
			StatefulBeanToCsvBuilder<Contact> builder = new StatefulBeanToCsvBuilder(writter);
			StatefulBeanToCsv beanWritter = builder.withMappingStrategy(mappingStrategy).build();
			
			try {
				beanWritter.write(contactList);
			} catch (CsvDataTypeMismatchException e) {
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				e.printStackTrace();
			}
			System.out.println("File Writed");
			writter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
