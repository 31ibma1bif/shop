package Shop;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ShopSystem extends Main implements Shop {

	public int Stock() {
		System.out.println("___________________S T O C K___________________");
		System.out.println("Alle Produkte: " + list.produkt.size());

		int sum = 0;
		for (int i : list.produktPreise) {
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

	public void Admin() {
		System.out.println("___________________manegement___________________\n");
		System.out.println("View als Admin\n");
		System.out.println("\t\tAuswahl eingeben: \n\t\t1: Produkt hinzufügen\n\t\t2: Produkt bearbeiten\n\t\t3: Produkt entfernen\n\t\t4: Stock Details\n\t\t5: Kundendaten");
		System.out.println("___________________manegement___________________");
		Scanner inputAdmin = new Scanner(System.in);
		System.out.print("Enter: ");
		int adminInput = inputAdmin.nextInt();

		//Mit Switch-Case deutlich weniger aufwand und es kann de Fehler abgefangen werden
		//Wenn eine falsche Zahl eingegeben wird
		if (adminInput == 1) {
			System.out.println("Produktname & Preis");

			//Du erstellt jetzt jeden mal nen neuen Scanner, du kannst einfach den ersten immer wieder neu verwenden
			//Nenn den dann einfach sc oder so dann ist das auch nicht verwirrd
			//Un Scenner am besten auch sofort schließen wenn der nicht mehr gebraucht wird
			Scanner newProdukt = new Scanner(System.in);
			System.out.print("Produkt: ");
			//Mit dem wiederverwendeten Scanner sieht das dann so aus: String newName = sc.nextLine();
			String newName = newProdukt.nextLine();
			list.produkt.add(list.produkt.size(), newName);
			System.out.print("Preis: ");
			int newPreis = newProdukt.nextInt();
			list.produktPreise.add(newPreis);

			System.out.println("Produkt wurde hinzugefügt");
		} else if (adminInput == 2) {
			Scanner aendern = new Scanner(System.in);
			System.out.println("Index: ");
			int index = aendern.nextInt();
			System.out.print("Produktname: ");
			//Wenn du nur next() angiebst nimmt er glaub nur den ersten Buchstaben 
			//NextLine() macht dann das Ganze Wort
			String name = aendern.next();
			System.out.println("Preis: ");
			int preis = aendern.nextInt();
			list.produkt.set(index, name);
			list.produktPreise.set(index,preis);

			System.out.println("Produkt erfolgreeich bearbeitet");
			System.out.println("Auswählen: \n\t1: Fortfahren\n\t2: Exit");
			System.out.println("Enter: ");
			//Da hast du ja den sc scanner :D den kannst du wenn du ihn oben devisiert ganze Zeit nutzen
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			//Wieder Switch case aber so is auch ok
			if (num == 1) {
				Admin();
			} else if (num == 2) {
				return;
			} else {
				return;
			}
		} else if ( adminInput == 3) {
			Scanner entfernen = new Scanner(System.in);
			System.out.print("Index: ");
			int entferneProdukt = entfernen.nextInt();
			list.produkt.remove(entferneProdukt);
			System.out.println("Produkt wurde entfernt");

			Admin();
		} else if (adminInput == 4) {
			Stock();
			System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			if (num == 1) {
				Admin();
			} else if (num == 2) {
				return;
			} else {
				return;
			}
			} else if (adminInput == 5) {
				KundenDaten();
			} else if (adminInput == 99) {
				main(null);
			} else {
				System.out.println("Ungültige Eingabe! ");
				Admin();
			}
		}

		public void Kunde() {
			System.out.println("___________________manegement___________________\n");
			System.out.println("View als Kunde");
			System.out.println("\t\tAuswahl eingeben:\n\t\t1: Einkaufen\n\t\t2: Einkaufswagen\n\t\t3: Rechnung\n\t\t\t\t\t\t99: Back");

			System.out.println("___________________manegement___________________");
			System.out.print("Enter: ");
			Scanner kundeInput = new Scanner(System.in);
			int inputKunde = kundeInput.nextInt();

			//Hier is Switch Case eigenlich besser, is halt übersichtlicher
			if (inputKunde == 1) {
				System.out.println("\tEinkaufen: ");

				System.out.println("Verfügbare Produkte: ");
				System.out.println("_______________________________________________");
				System.out.println("Produkt Nummer\t\tProdukt\t\t\tPreis\n");
				for (int i = 0; i < list.produkt.size(); i++) {
					System.out.println(i + "\t\t" + list.produkt.get(i) + "\t\t\t€" + list.produktPreise.get(i));
				} System.out.println("_______________________________________________");

				Scanner produktKaufen  = new Scanner(System.in);

				System.out.print("wie viele Produkte möchten Sie einkaufen?: ");
				int anzahlProdukte = produktKaufen.nextInt();

				//Das erstellt jetzt ein Array wo max 5 Items din gepseichert werden können
				//Wenn ich das jetzt richtig verstanden hab soll das Array doch anzahlProdukte groß sein 
				int[] gekauftListe = new int [5];

				//Wenn du dann die Variablen in der Main Klasse auf private machst kannst du aich nicht meht 
				//auf maxItemLimit zugreifen, dann musst du dehn getter benutzen
				if (anzahlProdukte <= maxItemLimit) {
					try {
						System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
						for (int i = 0; i < anzahlProdukte; i++) {
							//Das versteh ich nicht, das geht ja jetzt das ganze Array duch und für jedes Produkt
							//Wird ein imput vom User erwaret :D
							gekauftListe[i] = produktKaufen.nextInt();
						}
						ausgewaehlteItems = anzahlProdukte;
						System.out.println("_______________________________________________");
						System.out.println("          E I K A U F S W A G E N              ");
						System.out.println(anzahlProdukte);
						System.out.println("_______________________________________________");
						for (int i = 0; i < anzahlProdukte; i++) {
							System.out.println(gekauftListe[i] + ": " + list.produkt.get(gekauftListe[i]) + "\t\t€" + list.produktPreise.get(gekauftListe[i]));
							einkaufswagen.add(i, list.produkt.get(gekauftListe[i]));
							preis.add(list.produktPreise.get(gekauftListe[i]));
						}
					} catch (Exception e) {
						//Also erstmal, wir sollen keine Exeption e machen, wir sollen immer den Fehler selber mit angeben
						//Also z.b. Falscher input von User oder so
						//Dann versteh ich auch nicht was für ein Fehler generell abgefangen werden soll 
						//Fühlt sich so an als hättest du das einfach hier reingemacht weil es ne Anforderung von Lehrer ist :D 
				} finally {
					System.out.println("_______________________________________________");
				}
				//Falsche Einrückung :,( 
			}else {
					System.out.println("Nicht mehr als 5 Produkte erlaubt");
				}

				System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
				System.out.print("Enter: ");
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				if (num == 1) {
					Kunde();
				} else if (num == 2) {
					return;
				} else {
					return;
				}
			}else if (inputKunde == 2) {

				System.out.println("Einaufswagen: ");
				System.out.println("_______________________________________________");
				Einkaufswagen();
				System.out.println("_______________________________________________");
				System.out.println("Anzahl an Produkten: " + einkaufswagen);
				double sum = 0;
				for (int i : preis) {
					sum += i;
				}
				System.out.println("Gesamtbetrag: €" + sum);

				System.out.println("_______________________________________________");
				System.out.println("Auswählen: \1: Mehr hinzufügen\n2: Produkt entfernen");
				System.out.print("Enter: ");
				Scanner einkaufswagenBearbeiten = new Scanner(System.in);
				int eb = einkaufswagenBearbeiten.nextInt();

				if (eb == 1) {
					System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
					Scanner add = new Scanner(System.in);
					int ebb = add.nextInt();
					for (int i = 0; i < ausgewaehlteItems; i++) {
						einkaufswagen.set(inputKunde,  list.produkt.get(ebb));
						preis.add(list.produktPreise.get(ebb));
					}
					Einkaufswagen();
				} else if (eb == 2) {

				} else {
					return;
				}
				} else if (inputKunde == 3) {
					Rechnung();
					System.out.println("Auswählen: \n1: Fortfahren\n\t2: Exit");
					System.out.println("Enter: ");
					Scanner sc = new Scanner(System.in);
					int num = sc.nextInt();
					if (num == 1) {
						Kunde();
					} else if (num == 2) {
						return;
					} else {
						return;
					}
 				}else if (inputKunde == 99) {
 					main(null);
 				} else {
 					System.out.println("Ungültige Eingabe");
 				}
			}

			public void Einkaufswagen() {
				Main oi = new Main();
				System.out.println("NR \tProdukte\t\tPreis");
				System.out.println("_______________________________________________");
				for (int i = 0; i < ausgewaehlteItems; i++) {
					System.out.println(i + "\t" + einkaufswagen.get(i) + "\t\t€" + preis.get(i));
				}
			}

			public void Rechnung() {
				Scanner name = new Scanner(System.in);
				System.out.print("Name : ");
				kundeName = name.nextLine();
				nachname = name.nextLine();

				System.out.println("___________________RECHNUNG___________________");
				System.out.println("______________________________________________");
				System.out.println("Vorname: " + kundeName);
				System.out.println("Nachname: " + nachname);
				LocalDate date = LocalDate.now();
				System.out.println("Datum: " + date);
				LocalTime time = LocalTime.now();
				System.out.println("Uhrzeit: " + time);
				System.out.println("______________________________________________");
				Einkaufswagen();
				System.out.println("\n______________________________________________");
				System.out.println("Alle Produkte: " + einkaufswagen);
				double sum = 0;
				for (int i : preis) {
					sum += i;
				}
				System.out.println("Rechnung: €" + sum);
				System.out.println("______________________________________________");
				System.out.println("_____________________DANKE____________________");

				File file = new File("newFileKunde.txt");
				String vorname = kundeName;
				String nachnameKunde = nachname;
				try {
					FileWriter output = new FileWriter("newFileKunde.txt");
					output.write("______________________________________________");
					output.write("\nVorname:" + name);
					output.write("\nNachname: " + nachname);
					output.write("\nDatum & Uhrzeit: " + date + time);
					output.write("\nAnzahl: " + einkaufswagen.size());
					output.write("\nGekaufte Produkte: " + einkaufswagen);
					output.write("\nGesamtpreis: " + sum);
					output.close();
				} catch (Exception e) {
					e.getStackTrace();
				}

				System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
				System.out.print("Enter: ");
				int num = name.nextInt();
				if (num == 1) {
					Kunde();
				} else if (num == 2) {
					return;
				} else {
					System.out.println("Ungültige Eingabe");
				}
			}

			public void KundenDaten() {
				char[] array = new char[100];
				try {
					FileReader input = new FileReader("newFileKune.txt");

					input.read(array);
					System.out.println("Kundeninfo");
					if(input != null) {
						System.out.println(array);
					}
				} catch(Exception e) {
					e.getStackTrace();
				}
    }
}

