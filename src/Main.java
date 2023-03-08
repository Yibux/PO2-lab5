import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    String nrKierunkowy;
    String nrTelefonu;

    public NrTelefoniczny(String nrKierunkowy, String nrTelefonu){
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public void printPhoneNumber(){
        System.out.println("+" + this.nrKierunkowy + " " + this.nrTelefonu);
    }

    public int compareTo(NrTelefoniczny o) {
        return nrKierunkowy.compareTo(o.nrKierunkowy) + nrTelefonu.compareTo(o.nrTelefonu);
    }
}

abstract class Wpis{
    String adres;
    NrTelefoniczny nrTelefonu;
    public abstract void opis();
}

class Osoba extends Wpis{
    String imie, nazwisko;
    public Osoba(String imie, String nazwisko, String adres, NrTelefoniczny nrTelefonu){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }
    public void opis() {
        System.out.print(imie + " " + nazwisko + ", " + adres + ", ");
        nrTelefonu.printPhoneNumber();
    }
}

class Firma extends Wpis{
    public Firma(String adres, NrTelefoniczny nrTelefonu){
        this.adres = adres;
        this.nrTelefonu = nrTelefonu;
    }
    public void opis() {
        System.out.print(adres + ", ");
        nrTelefonu.printPhoneNumber();
    }
}


public class Main {
    public static void printPhoneBook(TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna){
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator = ksiazkaTelefoniczna.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<NrTelefoniczny, Wpis> entry = iterator.next();
            entry.getValue().opis();
        }
    }
    public static void main(String[] args) {
        TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna = new TreeMap<>();
        NrTelefoniczny nr1 = new NrTelefoniczny("48", "123456789");
        Osoba osoba1 = new Osoba("Jan", "Kowalski", "ul. Warszawska 10, 00-001 Warszawa", nr1);
        ksiazkaTelefoniczna.put(nr1, osoba1);

        NrTelefoniczny nr2 = new NrTelefoniczny("21", "987654321");
        Firma firma1 = new Firma("ABC Sp. z o.o.", nr2);
        ksiazkaTelefoniczna.put(nr2, firma1);

        NrTelefoniczny nr3 = new NrTelefoniczny("11", "111222333");
        Osoba osoba2 = new Osoba("Anna", "Nowak", "ul. Krakowska 20, 30-001 Kraków", nr3);
        ksiazkaTelefoniczna.put(nr3, osoba2);

        NrTelefoniczny nr4 = new NrTelefoniczny("12", "311222333");
        Osoba osoba3 = new Osoba("Kamil", "Stańczyk", "ul. Krakowska 20, 30-001 Kraków", nr3);
        ksiazkaTelefoniczna.put(nr4, osoba3);

        printPhoneBook(ksiazkaTelefoniczna);

        deleteDuplicates(ksiazkaTelefoniczna);

        printPhoneBook(ksiazkaTelefoniczna);

    }



    public static void deleteDuplicates(TreeMap<NrTelefoniczny, Wpis> ksiazkaTelefoniczna){
        Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator1 = ksiazkaTelefoniczna.entrySet().iterator();

        while (iterator1.hasNext()){
            Map.Entry<NrTelefoniczny, Wpis> entry = iterator1.next();
            Wpis wpis1 = entry.getValue();
            Iterator<Map.Entry<NrTelefoniczny, Wpis>> iterator2 = ksiazkaTelefoniczna.entrySet().iterator();
            while (iterator2.hasNext()){
                Map.Entry<NrTelefoniczny, Wpis> entry2 = iterator2.next();
                Wpis wpis2 = entry2.getValue();
                if(!wpis1.equals(wpis2) && wpis1.adres.equals(wpis2.adres)){
                    iterator2.remove();
                    iterator2 = ksiazkaTelefoniczna.entrySet().iterator();
                    iterator1 = ksiazkaTelefoniczna.entrySet().iterator();
                }
            }
        }
    }
}