import java.util.ArrayList;
import java.util.Scanner;

public class Kunde {

    String kundeName; // vorname
    String nachname;
    int kundenID;
    int maxItemLimit = 5;
    int ausgewaehlteItems;
    public ArrayList<String> einkaufswagen = new ArrayList<>();
    ArrayList<Double> preis = new ArrayList<>();

    ProduktListe list = new ProduktListe();

    ArrayList<String> gekauft = new ArrayList<>();

    public String getName() {
        return kundeName;
    }

    public String getId() {
        return nachname;
    }

    public void KundeCommand() {
        System.out.println("___________________manegement___________________\n");
        System.out.println("View als Kunde");
        System.out.println(
                "\t\tAuswahl eingeben:\n\t\t1: Einkaufen\n\t\t2: Einkaufswagen\n\t\t3: Rechnung\n\t\t\t\t\t\t99: Back");

        System.out.println("___________________manegement___________________");
        System.out.print("Enter: ");
        Scanner sc = new Scanner(System.in);

        int inputKunde = sc.nextInt();

        switch (inputKunde) {
            case 1:
                System.out.println("\tEinkaufen: ");

                System.out.println("Verfügbare Produkte: ");
                System.out.println("_______________________________________________");
                System.out.println("Produkt Nummer\t\tProdukt\t\t\tPreis\n");
                for (int i = 0; i < list.produkt.size(); i++) {
                    System.out.println(i + "\t\t" + list.produkt.get(i) + "\t\t\t€" + list.produktPreise.get(i));
                }
                System.out.println("_______________________________________________");

                System.out.print("wie viele Produkte möchten Sie einkaufen?: ");
                int anzahlProdukte = sc.nextInt();

                int[] gekauftListe = new int[5];

                if (anzahlProdukte <= maxItemLimit) {
                    try {
                        System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
                        for (int i = 0; i < anzahlProdukte; i++) {
                            // Das versteh ich nicht, das geht ja jetzt das ganze Array duch und für jedes
                            // Produkt
                            // Wird ein imput vom User erwaret :D
                            gekauftListe[i] = sc.nextInt();
                        }
                        ausgewaehlteItems = anzahlProdukte;
                        System.out.println("_______________________________________________");
                        System.out.println("          E I K A U F S W A G E N              ");
                        System.out.println(anzahlProdukte);
                        System.out.println("_______________________________________________");
                        for (int i = 0; i < anzahlProdukte; i++) {
                            System.out.println(gekauftListe[i] + ": " + list.produkt.get(gekauftListe[i]) + "\t\t€"
                                    + list.produktPreise.get(gekauftListe[i]));
                            einkaufswagen.add(i, list.produkt.get(gekauftListe[i]));
                            preis.add(list.produktPreise.get(gekauftListe[i]));
                        }
                    } catch (Exception e) {
                        System.out.println("Ungültige Eingabe");
                        // Also erstmal, wir sollen keine Exeption e machen, wir sollen immer den Fehler
                        // selber mit angeben
                        // Also z.b. Falscher input von User oder so
                        // Dann versteh ich auch nicht was für ein Fehler generell abgefangen werden
                        // soll
                        // Fühlt sich so an als hättest du das einfach hier reingemacht weil es ne
                        // Anforderung von Lehrer ist :D
                    } finally {
                        System.out.println("_______________________________________________");
                    }
                } else {
                    System.out.println("Nicht mehr als 5 Produkte erlaubt");
                }

                System.out.println("Auswählen:\n\t1: Fortfahren\n\t2: Exit");
                System.out.print("Enter: ");
                // Scanner sc = new Scanner(System.in);
                int num = sc.nextInt();
                if (num == 1) {
                    KundeCommand();
                } else if (num == 2) {
                    sc.close();
                    return;
                } else {
                    sc.close();
                    return;
                }

            case 2:
                System.out.println("Einaufswagen: ");
                System.out.println("_______________________________________________");
                Einkaufswagen();
                System.out.println("_______________________________________________");
                System.out.println("Anzahl an Produkten: " + einkaufswagen);
                double sum = 0;
                for (double i : preis) {
                    sum += i;
                }
                System.out.println("Gesamtbetrag: €" + sum);

                System.out.println("_______________________________________________");
                System.out.println("Auswählen: \1: Mehr hinzufügen\n2: Produkt entfernen");
                System.out.print("Enter: ");
                Scanner einkaufswagenBearbeiten = new Scanner(System.in);
                double eb = einkaufswagenBearbeiten.nextInt();

                if (eb == 1) {
                    System.out.println("Wählen Sie ein Produkt aus (mit Produktnummer): ");
                    int ebb = sc.nextInt();
                    for (int i = 0; i < ausgewaehlteItems; i++) {
                        einkaufswagen.set(inputKunde, list.produkt.get(ebb));
                        preis.add(list.produktPreise.get(ebb));
                    }
                    Einkaufswagen();
                } else if (eb == 2) {

                } else {
                    return;
                }
                sc.close();
        }
    }

    public void Einkaufswagen() {
        // Main oi = new Main();
        System.out.println("NR \tProdukte\t\tPreis");
        System.out.println("_______________________________________________");
        for (int i = 0; i < ausgewaehlteItems; i++) {
            System.out.println(i + "\t" + einkaufswagen.get(i) + "\t\t€" + preis.get(i));
        }
    }

}