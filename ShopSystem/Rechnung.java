import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Rechnung {

    Einkaufswagen einkaufswagen = new Einkaufswagen();
    Kunde kunde = new Kunde();
    ProduktListe list = new ProduktListe();
    ShopSystem shopSys = new ShopSystem();

    public void RechnungCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name : ");
        kunde.kundeName = sc.nextLine();
        kunde.nachname = sc.nextLine();

        System.out.println("___________________RECHNUNG___________________");
        System.out.println("______________________________________________");
        System.out.println("Vorname: " + kunde.kundeName);
        System.out.println("Nachname: " + kunde.nachname);
        LocalDate date = LocalDate.now();
        System.out.println("Datum: " + date);
        LocalTime time = LocalTime.now();
        System.out.println("Uhrzeit: " + time);
        System.out.println("______________________________________________");
        einkaufswagen.EinkaufswagenCommand();
        System.out.println("\n______________________________________________");
        System.out.println("Alle Produkte: " + kunde.einkaufswagen);
        double sum = 0;
        for (double i : kunde.preis) {
            sum += i;
        }
        System.out.println("Rechnung: €" + sum);
        System.out.println("______________________________________________");
        System.out.println("_____________________DANKE____________________");

        // File file = new File("newFileKunde.txt"); ----------------------------- dead
        // code
        String vorname = kunde.kundeName; // ----------------------------Redundancy
        String nachname = kunde.nachname;
        try {
            FileWriter output = new FileWriter("newFileKunde.txt");
            output.write("______________________________________________");
            output.write("\nVorname:" + vorname);
            output.write("\nNachname: " + nachname);
            output.write("\nDatum & Uhrzeit: " + date + time);
            output.write("\nAnzahl: " + kunde.einkaufswagen.size());
            output.write("\nGekaufte Produkte: " + kunde.einkaufswagen);
            output.write("\nGesamtpreis: " + sum);
            output.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        sc.close();

        System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
        System.out.print("Enter: ");
        int num = sc.nextInt();
        if (num == 1) {
            kunde.KundeCommand();
        } else if (num == 2) {
            return;
        } else {
            System.out.println("Ungültige Eingabe");
        }
    }
}
