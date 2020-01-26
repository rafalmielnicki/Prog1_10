package sda.prog1_10.methods;

public class Silnia {

    //TODO

    public static void main(String[] args) {
        System.out.println("silnia 6 = " + silnia(6));
        System.out.println("silnia 6 = " + silniaRecursive(6));
    }

    public static int silnia(int arg) {
        int silnia = 1;
        while (arg > 1) {
            silnia *= arg--;
        }
        return silnia;
    }

    //FIXME
    //postać rekurencyjna
    public static int silniaRecursive(int arg) {
        return arg > 1
                ? silniaRecursive(arg - 1) * arg
                : 1;
    }

}
