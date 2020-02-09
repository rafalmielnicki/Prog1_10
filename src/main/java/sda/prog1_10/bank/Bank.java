package sda.prog1_10.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank<T extends Klient> {

    private String nazwaBanku;
    private List<T> listaKlientowBanku;
    private List<OPT> listaRachunkowBanku;
    
    public Bank(String nazwaBanku) {
        this.nazwaBanku = nazwaBanku;
        listaKlientowBanku = new ArrayList<>();
    }

    public boolean addKlient (T klient) {
        if (!listaKlientowBanku.contains(klient)) {
            System.out.println("Adding " + klient.getNazwisko() + klient.getImie());
            return listaKlientowBanku.add(klient);
        }
        System.out.println("Klient " + klient.getNazwisko() + klient.getImie() + " already in bank");
        return false;
    }

    public String getNazwaBanku() {
        return nazwaBanku;
    }

    public void setNazwaBanku(String nazwaBanku) {
        this.nazwaBanku = nazwaBanku;
    }

    public List<OPT> getListaRachunkowBanku() {
        return listaRachunkowBanku;
    }

    public void setListaRachunkowBanku(List<OPT> listaRachunkowBanku) {
        this.listaRachunkowBanku = listaRachunkowBanku;
    }

    /*operacje:
    założenie klienta
    założenie rachunku dla klienta
    usunięcie rachunku dla klienta (jeśli stan środków = 0)
    usunięcie klienta (jeśli nie ma rachunków)

    wpłata na rachunek
    wypłata z rachunku

    lista klientów banku (z listą rachunków(z saldem lub bez))
    lista rachunków klienta (z saldem lub bez)
    OPT(lista rachunków (z saldami lub bez))*/
}
