package Shop;

import java.util.ArrayList;

public class Kunde {

        protected String kundeName; //vorname
        protected String nachname;
        protected int maxItemLimit = 5;
        protected int ausgewaehlteItems;
        public ArrayList<String> einkaufswagen = new ArrayList<>();
        protected ArrayList <Integer> preis = new ArrayList<>();

        ProduktListe list = new ProduktListe();

        ArrayList<String> gekauft = new ArrayList<>();


        public String getName() {
            return kundeName;
        }

        public String getId() {
            return nachname;
        }
}
