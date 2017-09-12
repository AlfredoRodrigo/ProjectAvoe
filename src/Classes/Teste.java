package Classes;

public class Teste {
    public static void main (String[] args) {
        int a = 100;
        String b;
        if (a < 10) {
            b = "00" + a;
        } else if (a < 100 && a >= 10) {
            b = "0" + a;
        } else {
            b = "" + a;
        }
        System.out.println(b);
    }
}