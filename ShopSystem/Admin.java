import java.io.FileReader;
import java.util.Scanner;

public class Admin extends Kunde {
	ProduktListe list = new ProduktListe();
	ShopSystem shopSys = new ShopSystem();

	public void AdminCommand() {
		System.out.println("___________________management___________________\n");
		System.out.println("View als Admin\n");
		System.out.println(
				"\t\tAuswahl eingeben: \n\t\t1: Produkt hinzufügen\n\t\t2: Produkt bearbeiten\n\t\t3: Produkt entfernen\n\t\t4: Stock Details\n\t\t5: Kundendaten");
		System.out.println("___________________management___________________");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter: ");
		int adminInput = sc.nextInt();
		int num = sc.nextInt();

		switch (adminInput) {
			case 1:
				System.out.println("Produktname & Preis");
				System.out.print("Produkt: ");

				String newName = sc.nextLine();
				list.produkt.add(list.produkt.size(), newName);
				System.out.print("Preis: ");
				double newPreis = sc.nextInt();
				list.produktPreise.add(newPreis);
				break;

			case 2:
				// Scanner sc = new Scanner(System.in);
				System.out.println("Index: ");
				int index = sc.nextInt();
				System.out.print("Produktname: ");

				String name = sc.nextLine();
				System.out.println("Preis: ");
				double preis = sc.nextInt();
				list.produkt.set(index, name);
				list.produktPreise.set(index, preis);

				System.out.println("Produkt erfolgreeich bearbeitet");
				System.out.println("Auswählen: \n\t1: Fortfahren\n\t2: Exit");
				System.out.println("Enter: ");

				// Scanner sc = new Scanner(System.in);

				if (num == 1) {
					AdminCommand();
				} else if (num == 2) {
					sc.close();
					return;
				} else {
					sc.close();
					return;
				}

			case 3:
				// Scanner sc = new Scanner(System.in);
				System.out.print("Index: ");
				int entferneProdukt = sc.nextInt();
				list.produkt.remove(entferneProdukt);
				System.out.println("Produkt wurde entfernt");
				AdminCommand();

			case 4:
				shopSys.Stock();
				System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
				// Scanner sc = new Scanner(System.in);
				// int num = sc.nextInt();
				if (num == 1) {
					AdminCommand();
				} else if (num == 2) {
					sc.close();
					return;
				} else {
					sc.close();
					return;
				}
			case 5:
				shopSys.KundenDaten();

				if (adminInput == 99) {
					AdminCommand(); // ----------------------------------------------- Ammend!
					sc.close();
				} else {
					System.out.println("Ungültige Eingabe! ");
					AdminCommand();
				}
		}
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
