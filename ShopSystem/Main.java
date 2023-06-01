package Shop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	public Main() {

	}

	public Main(int max) {

	}

	protected String kundeName; //vorname
	protected String nachname;
	protected int maxItemLimit = 5;
	protected int ausgewaehlteItems;
	protected ArrayList<String> einkaufswagen = new ArrayList<>();
	protected ArrayList <Integer> preis = new ArrayList<>();

	ProduktListe list = new ProduktListe();

	ArrayList<String> gekauft = new ArrayList<>();

	public String getName() {
		return kundeName;
	}

	public String getId() {
		return nachname;
	}

	public void setName(String newName) {
		kundeName = newName;
	}

	public void setId(String newNachname) {
		nachname = newNachname;
	}

	public static void main(String[] args) {
		//TODO
	}
}
