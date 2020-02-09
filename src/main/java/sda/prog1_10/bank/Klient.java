package sda.prog1_10.bank;

import sda.prog1_10.team.Team;

import java.util.List;

public class Klient {

    private String imie;
    private String nazwisko;
    private String pesel;
    private int nrKlienta;
    private List<OPT> listaRachunkowKlienta;

    public Klient(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getNrKlienta() {
        return nrKlienta;
    }

    public void setNrKlienta(int nrKlienta) {
        this.nrKlienta = nrKlienta;
    }

    public List<OPT> getListaRachunkowKlienta() {
        return listaRachunkowKlienta;
    }

    public void setListaRachunkowKlienta(List<OPT> listaRachunkowKlienta) {
        this.listaRachunkowKlienta = listaRachunkowKlienta;
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
