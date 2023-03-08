class NrTelefoniczny implements Comparable<NrTelefoniczny> {
    String nrKierunkowy;
    String nrTelefonu;

    public NrTelefoniczny(String nrKierunkowy, String nrTelefonu){
        this.nrKierunkowy = nrKierunkowy;
        this.nrTelefonu = nrTelefonu;
    }

    public void printPhoneNumber(){
        System.out.println(this.nrKierunkowy + " " + this.nrTelefonu);
    }

    public int compareTo(NrTelefoniczny o) {
        return 0;
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
        System.out.println(adres + ", ");
        nrTelefonu.printPhoneNumber();
    }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}