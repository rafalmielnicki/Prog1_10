package sda.prog1_10.bank;

public class OPT {

    private String typRachunku;
    private int stanRachunku; //ile jest na koncie

    public OPT(String typRachunku, int stanRachunku) {
        this.typRachunku = typRachunku;
        this.stanRachunku = stanRachunku;
    }

    public String getTypRachunku() {
        return typRachunku;
    }

    public void setTypRachunku(String typRachunku) {
        this.typRachunku = typRachunku;
    }

    public int getStanRachunku() {
        return stanRachunku;
    }

    public void setStanRachunku(int stanRachunku) {
        this.stanRachunku = stanRachunku;
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
