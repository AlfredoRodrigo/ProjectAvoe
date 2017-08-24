package Classes;

public class Teste {
    static int teste(String array[]) {
        int indice = 0;
        for (int i = 0; i < 10; i++) {
            if (array[i] == null) {
                for (int y = (i + 1); y < 10; y++) {
                    if (array[y] != null) {
                        array[i] = array[y];
                        array[y] = null;
                        break;
                    }
                }
            }
        }
        return indice;
    }

    public static void main(String[] args) {
        String[] array = new String[10];
        array[0] = "0";
        array[1] = "1";
        array[5] = "5";
        array[7] = "7";
        array[9] = "9";

        System.out.println("AT");
        for (int x = 0; x < 10; x++) {
            System.out.println(array[x]);
        }

        teste(array);

        System.out.println("\n\n\nDT");
        for (int x = 0; x < 10; x++) {
            System.out.println(array[x]);
        }
    }
}