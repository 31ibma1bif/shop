
//import java.io.File;
import java.io.FileReader;
//import java.io.FileWriter;
//import java.time.LocalDate;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Scanner;

public class ShopSystem {

	ProduktListe list = new ProduktListe();
	Kunde kunde = new Kunde();

	public int Stock() {
		System.out.println("___________________S T O C K___________________");
		System.out.println("Alle Produkte: " + list.produkt.size());

		int sum = 0;
		for (double i : list.produktPreise) {
			sum += i;
		}
		System.out.println("Gesamtwert: " + sum);

		System.out.println("_______________________________________________");
		System.out.println("Produkt no\t\tProdukt\t\t\tPreis\n");
		for (int i = 0; i < list.produkt.size(); i++) {
			System.out.println(i + "\t\t" + list.produkt.get(i) + "\t\t\t€" + list.produktPreise.get(i));
		}
		System.out.println("_______________________________________________");
		return sum;
	}

	public void KundenDaten() {
		char[] array = new char[100];
		try {
			FileReader input = new FileReader("newFileKune.txt");

			input.read(array);
			System.out.println("Kundeninfo");
			if (input != null) {
				System.out.println(array);
			}
			input.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}

/*
 * public void Admin() {
 * System.out.println("___________________management___________________\n");
 * System.out.println("View als Admin\n");
 * System.out.
 * println("\t\tAuswahl eingeben: \n\t\t1: Produkt hinzufügen\n\t\t2: Produkt bearbeiten\n\t\t3: Produkt entfernen\n\t\t4: Stock Details\n\t\t5: Kundendaten"
 * );
 * System.out.println("___________________management___________________");
 * Scanner sc = new Scanner(System.in);
 * System.out.print("Enter: ");
 * int adminInput = sc.nextInt();
 * int num = sc.nextInt();
 * 
 * switch(adminInput) {
 * case 1:
 * System.out.println("Produktname & Preis");
 * System.out.print("Produkt: ");
 * 
 * String newName = sc.nextLine();
 * list.produkt.add(list.produkt.size(), newName);
 * System.out.print("Preis: ");
 * double newPreis = sc.nextInt();
 * list.produktPreise.add(newPreis);
 * break;
 * 
 * case 2:
 * //Scanner sc = new Scanner(System.in);
 * System.out.println("Index: ");
 * int index = sc.nextInt();
 * System.out.print("Produktname: ");
 * 
 * String name = sc.nextLine();
 * System.out.println("Preis: ");
 * double preis = sc.nextInt();
 * list.produkt.set(index, name);
 * list.produktPreise.set(index,preis);
 * 
 * System.out.println("Produkt erfolgreeich bearbeitet");
 * System.out.println("Auswählen: \n\t1: Fortfahren\n\t2: Exit");
 * System.out.println("Enter: ");
 * 
 * //Scanner sc = new Scanner(System.in);
 * 
 * if (num == 1) {
 * Admin();
 * } else if (num == 2) {
 * sc.close();
 * return;
 * } else {
 * sc.close();
 * return;
 * }
 * 
 * case 3:
 * //Scanner sc = new Scanner(System.in);
 * System.out.print("Index: ");
 * int entferneProdukt = sc.nextInt();
 * list.produkt.remove(entferneProdukt);
 * System.out.println("Produkt wurde entfernt");
 * Admin();
 * 
 * case 4:
 * Stock();
 * System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
 * //Scanner sc = new Scanner(System.in);
 * //int num = sc.nextInt();
 * if (num == 1) {
 * Admin();
 * } else if (num == 2) {
 * sc.close();
 * return;
 * } else {
 * sc.close();
 * return;
 * }
 * case 5:
 * KundenDaten();
 * 
 * if (adminInput == 99) {
 * Admin(); //----------------------------------------------- Ammend!
 * sc.close();
 * } else {
 * System.out.println("Ungültige Eingabe! ");
 * Admin();
 * }
 * }
 * }
 * 
 * public void Kunde() {
 * System.out.println("___________________manegement___________________\n");
 * System.out.println("View als Kunde");
 * System.out.
 * println("\t\tAuswahl eingeben:\n\t\t1: Einkaufen\n\t\t2: Einkaufswagen\n\t\t3: Rechnung\n\t\t\t\t\t\t99: Back"
 * );
 * 
 * System.out.println("___________________manegement___________________");
 * System.out.print("Enter: ");
 * Scanner sc = new Scanner(System.in);
 * 
 * int inputKunde = sc.nextInt();
 * 
 * switch(inputKunde) {
 * case 1:
 * System.out.println("\tEinkaufen: ");
 * 
 * System.out.println("Verfügbare Produkte: ");
 * System.out.println("_______________________________________________");
 * System.out.println("Produkt Nummer\t\tProdukt\t\t\tPreis\n");
 * for (int i = 0; i < list.produkt.size(); i++) {
 * System.out.println(i + "\t\t" + list.produkt.get(i) + "\t\t\t€" +
 * list.produktPreise.get(i));
 * } System.out.println("_______________________________________________");
 * 
 * 
 * System.out.print("wie viele Produkte möchten Sie einkaufen?: ");
 * int anzahlProdukte = sc.nextInt();
 * 
 * int[] gekauftListe = new int [5];
 * 
 * if (anzahlProdukte <= kunde.maxItemLimit) {
 * try {
 * System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
 * for (int i = 0; i < anzahlProdukte; i++) {
 * //Das versteh ich nicht, das geht ja jetzt das ganze Array duch und für jedes
 * Produkt
 * //Wird ein imput vom User erwaret :D
 * gekauftListe[i] = sc.nextInt();
 * }
 * kunde.ausgewaehlteItems = anzahlProdukte;
 * System.out.println("_______________________________________________");
 * System.out.println("          E I K A U F S W A G E N              ");
 * System.out.println(anzahlProdukte);
 * System.out.println("_______________________________________________");
 * for (int i = 0; i < anzahlProdukte; i++) {
 * System.out.println(gekauftListe[i] + ": " + list.produkt.get(gekauftListe[i])
 * + "\t\t€" + list.produktPreise.get(gekauftListe[i]));
 * kunde.einkaufswagen.add(i, list.produkt.get(gekauftListe[i]));
 * kunde.preis.add(list.produktPreise.get(gekauftListe[i]));
 * }
 * } catch (Exception e) {
 * System.out.println("Ungültige Eingabe");
 * //Also erstmal, wir sollen keine Exeption e machen, wir sollen immer den
 * Fehler selber mit angeben
 * //Also z.b. Falscher input von User oder so
 * //Dann versteh ich auch nicht was für ein Fehler generell abgefangen werden
 * soll
 * //Fühlt sich so an als hättest du das einfach hier reingemacht weil es ne
 * Anforderung von Lehrer ist :D
 * } finally {
 * System.out.println("_______________________________________________");
 * }
 * }else {
 * System.out.println("Nicht mehr als 5 Produkte erlaubt");
 * }
 * 
 * System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
 * System.out.print("Enter: ");
 * //Scanner sc = new Scanner(System.in);
 * int num = sc.nextInt();
 * if (num == 1) {
 * Kunde();
 * } else if (num == 2) {
 * sc.close();
 * return;
 * } else {
 * sc.close();
 * return;
 * }
 * 
 * case 2:
 * System.out.println("Einaufswagen: ");
 * System.out.println("_______________________________________________");
 * Einkaufswagen();
 * System.out.println("_______________________________________________");
 * System.out.println("Anzahl an Produkten: " + kunde.einkaufswagen);
 * double sum = 0;
 * for (double i : kunde.preis) {
 * sum += i;
 * }
 * System.out.println("Gesamtbetrag: €" + sum);
 * 
 * System.out.println("_______________________________________________");
 * System.out.println("Auswählen: \1: Mehr hinzufügen\n2: Produkt entfernen");
 * System.out.print("Enter: ");
 * Scanner einkaufswagenBearbeiten = new Scanner(System.in);
 * int eb = einkaufswagenBearbeiten.nextInt();
 * 
 * if (eb == 1) {
 * System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
 * int ebb = sc.nextInt();
 * for (int i = 0; i < kunde.ausgewaehlteItems; i++) {
 * kunde.einkaufswagen.set(inputKunde, list.produkt.get(ebb));
 * kunde.preis.add(list.produktPreise.get(ebb));
 * }
 * Einkaufswagen();
 * } else if (eb == 2) {
 * 
 * } else {
 * return;
 * } sc.close();
 * 
 * case 3:
 * Rechnung();
 * System.out.println("Auswählen: \n1: Fortfahren\n\t2: Exit");
 * System.out.println("Enter: ");
 * //Scanner sc = new Scanner(System.in);
 * int num1 = sc.nextInt();
 * if (num1 == 1) {
 * Kunde();
 * } else if (num1 == 2) {
 * return;
 * } else {
 * return;
 * }
 * 
 * if (inputKunde == 99) {
 * Kunde();//------------------------------------------
 * } else {
 * System.out.println("Ungültige Eingabe");
 * }sc.close();
 * }
 * }
 * 
 * public void Einkaufswagen() {
 * //Main oi = new Main();
 * System.out.println("NR \tProdukte\t\tPreis");
 * System.out.println("_______________________________________________");
 * for (int i = 0; i < kunde.ausgewaehlteItems; i++) {
 * System.out.println(i + "\t" + kunde.einkaufswagen.get(i) + "\t\t€" +
 * kunde.preis.get(i));
 * }
 * }
 * 
 * public void Rechnung() {
 * Scanner sc = new Scanner(System.in);
 * System.out.print("Name : ");
 * kunde.kundeName = sc.nextLine();
 * kunde.nachname = sc.nextLine();
 * 
 * System.out.println("___________________RECHNUNG___________________");
 * System.out.println("______________________________________________");
 * System.out.println("Vorname: " + kunde.kundeName);
 * System.out.println("Nachname: " + kunde.nachname);
 * LocalDate date = LocalDate.now();
 * System.out.println("Datum: " + date);
 * LocalTime time = LocalTime.now();
 * System.out.println("Uhrzeit: " + time);
 * System.out.println("______________________________________________");
 * Einkaufswagen();
 * System.out.println("\n______________________________________________");
 * System.out.println("Alle Produkte: " + kunde.einkaufswagen);
 * double sum = 0;
 * for (double i : kunde.preis) {
 * sum += i;
 * }
 * System.out.println("Rechnung: €" + sum);
 * System.out.println("______________________________________________");
 * System.out.println("_____________________DANKE____________________");
 * 
 * // File file = new File("newFileKunde.txt"); -----------------------------
 * dead code
 * String vorname = kunde.kundeName; //----------------------------Redundancy
 * String nachname = kunde.nachname;
 * try {
 * FileWriter output = new FileWriter("newFileKunde.txt");
 * output.write("______________________________________________");
 * output.write("\nVorname:" + vorname);
 * output.write("\nNachname: " + nachname);
 * output.write("\nDatum & Uhrzeit: " + date + time);
 * output.write("\nAnzahl: " + kunde.einkaufswagen.size());
 * output.write("\nGekaufte Produkte: " + kunde.einkaufswagen);
 * output.write("\nGesamtpreis: " + sum);
 * output.close();
 * } catch (Exception e) {
 * e.getStackTrace();
 * } sc.close();
 * 
 * System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
 * System.out.print("Enter: ");
 * int num = sc.nextInt();
 * if (num == 1) {
 * Kunde();
 * } else if (num == 2) {
 * return;
 * } else {
 * System.out.println("Ungültige Eingabe");
 * }
 * }
 */
