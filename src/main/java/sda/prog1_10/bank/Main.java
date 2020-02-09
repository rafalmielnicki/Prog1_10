package sda.prog1_10.bank;

import sda.prog1_10.team.FootballTeam;
import sda.prog1_10.team.LeagueTeam;
import sda.prog1_10.team.Team;
import sda.prog1_10.team.VolleyballTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    Bank bank1 = new Bank("Alior");
    Bank bank2 = new Bank("City handlowy");

    Klient klient1 = new Klient("Jan", "Kowalski", "123456789");
    Klient klient2 = new Klient("Tomasz", "Kowal", "987654321");
    Klient klient3 = new Klient("Mateusz", "Nowak", "129834763");
    Klient klient4 = new Klient("Marek", "Mi", "434343435");

    OPT rachunek1 = new OPT("oszczędnościowy", 0);
    OPT rachunek2 = new OPT("walutowy", 0);
    OPT rachunek3 = new OPT("VIP", 0);
    OPT rachunek4 = new OPT("oszczędnościowy", 0);

    Bank<Klient> listaKlientowBanku = new Bank("City handlowy");



    /*operacje:
    założenie rachunku dla klienta
    usunięcie rachunku dla klienta (jeśli stan środków = 0)
    usunięcie klienta (jeśli nie ma rachunków)

    wpłata na rachunek
    wypłata z rachunku

    lista klientów banku (z listą rachunków(z saldem lub bez))
    lista rachunków klienta (z saldem lub bez)
    OPT(lista rachunków (z saldami lub bez))*/
}
