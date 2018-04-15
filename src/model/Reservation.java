package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Reservation {
	private String book;
	private String result="";
	private List<String> books = new ArrayList<String>();
	private List<Boolean> available = new ArrayList<Boolean>();
	private Boolean isBooked=false;
	
	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}
	public String getResult() {
		return this.result;
	}
	public void setResult(String res) {
		this.result=res;
	}
	public boolean getIsBooked() {
		return this.isBooked;
	}
	
	
	public void book() {
		int index = this.books.indexOf(this.result);
		if (index!=-1) {
			this.isBooked=this.available.get(index);
			if (this.isBooked) {
				this.available.set(index,false);
				this.save();
				this.load();
			}
		}
	}

	public void search() {
		for (int i =0;i<this.books.size();i++) {
			String searchMin = this.book.toLowerCase();
			String bookMin = this.books.get(i).toLowerCase();
			if (searchMin.equals(bookMin)) {
				this.result=this.books.get(i);
			}
		}
	}
	public void load() {
		
		try {
			this.books = new ArrayList<String>();
			this.available = new ArrayList<Boolean>();
			URL url = new URL("C:\\Users\\Alain\\eclipse-workspace\\MiniProject\\src\\books.txt");
			File books = new File(url.toURI());
			BufferedReader buffer = new BufferedReader(new FileReader(books));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				
				String[] words= line.split(" ");
				if (words[0].equals("true")) {
					this.available.add(true);
				}else {
					this.available.add(false);
				}
				String nBook = "";
				for (int i =0;i<words.length-1;i++) {
					if (i!=0) {
						nBook+=" ";
					}
					nBook+=words[i+1];
				}
				this.books.add(nBook);
			}	
		} catch (Exception e) {
			System.out.println("Unable to load file");
			e.printStackTrace();
		}
	} 
	public void save() {
		try {
			URL url = new URL("C:\\Users\\Alain\\eclipse-workspace\\MiniProject\\src\\books.txt");
			File booksa = new File(url.toURI());
			booksa.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(url.toURI())));	
			for (int i =0;i<this.books.size();i++) {
				writer.write(this.available.get(i)+" "+this.books.get(i));
				writer.newLine();
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Unable to save file");
			e.printStackTrace();
		}
	} 

}
