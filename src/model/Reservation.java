package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Reservation{
	private String path="C:\\Users\\Alain\\eclipse-workspace\\MiniProject\\src\\books.txt";
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
	public void setResult(String result) {
		this.result=result;
	}
	public boolean getIsBooked() {
		return this.isBooked;
	}
	
	public void book() {
		int i = this.books.indexOf(this.result);
		if (i!=-1) {
			this.isBooked=this.available.get(i);
			if (this.isBooked) {
				this.available.set(i,false);
				this.save();
				this.load();
			}
		}
	}
	public void search() {
		for (int i =0;i<this.books.size();i++) {
			String search = this.book.toLowerCase();
			String book = this.books.get(i).toLowerCase();
			if (search.equals(book)) {
				this.result=this.books.get(i);
			}
		}
	}
	public void load() {
		try {
			this.books = new ArrayList<String>();
			this.available = new ArrayList<Boolean>();
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String line = "";
			while ((line = reader.readLine()) != null) {
				
				String[] words= line.split(" ");
				if (words[0].equals("true")) {
					this.available.add(true);
				}else {
					this.available.add(false);
				}
				String B = "";
				for (int i =0;i<words.length-1;i++) {
					if (i!=0) {
						B+=" ";
					}
					B+=words[i+1];
				}
				this.books.add(B);
			}	
		} catch (Exception e) {
			System.out.println("Unable to load file");
			e.printStackTrace();
		}
	} 
	public void save() {
		try {
			File file = new File(path);
			file.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));	
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
