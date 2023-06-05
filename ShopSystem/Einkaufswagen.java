public class Einkaufswagen {

    Kunde kunde = new Kunde();

    public void EinkaufswagenCommand() {
        System.out.println("NR \tProdukte\t\tPreis");
        System.out.println("_______________________________________________");
        for (int i = 0; i < kunde.ausgewaehlteItems; i++) {
            System.out.println(i + "\t" + kunde.einkaufswagen.get(i) + "\t\t€" + kunde.preis.get(i));
        }
    }
}
