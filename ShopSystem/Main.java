package Shop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	// Das mach für mich keinen Sinn warum eine Main Klasse mit Konstrukor erstellen
	// An sich kannst du alles in eine Extra Klasse auslagern 
	public Main() {

	}

	public Main(int max) {

	}

	//Da kannst du eine eine Kunden klasse machen wo du alles reinspeichers
	//Dann ist das auch deutlich bersichtlicher
	//An sich sind Variablen in der Klasse immer private
	protected String kundeName; //vorname
	protected String nachname;
	protected int maxItemLimit = 5;
	protected int ausgewaehlteItems;
	protected ArrayList<String> einkaufswagen = new ArrayList<>();
	protected ArrayList <Integer> preis = new ArrayList<>();

	ProduktListe list = new ProduktListe();

	ArrayList<String> gekauft = new ArrayList<>();


	//Die ganzen Setter und Getter machen nur Sinn, wenn die Variablen oben private sind
	//Mit Protected kannst du sowiso drauf zurgreifen und braucht keine Setter 
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

	//Also an sich sieht die Klasse für mich so aus als wäre die gedacht ein Kunde darzustellen
	//Also warum heist die dann Main wenn nicht passiert was einer Main klasse entspeicht? :D

	//Das ist meiner Meinung nach das einzige was in der Mainclasse stehen sollte :D
	//Mit der Mainmethode hast du dann quasi so ein "Hub" wo du alles anlegen kannst
	//Die Klassen sind nur ein Aufbau und hier in der main Methode sollte dann alles aufgreufen werden
	public static void main(String[] args) {
		//TODO
	}
}
