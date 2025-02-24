import java.util.Arrays;

/**
 *Esercizio 4.9
 * ordina il numero di stringhe conteneti nell'args
 *
 * @author Sofia Niederhauser
 * version 17.02.2025
 */
public class Main {
    public static void main(String[] args) {

        System.out.print("Stampa di args = ");
        for(String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("Array:");
        /*questa parte di codice l'ho tratta da intenet*/
        Arrays.sort(args, (a, ar) -> Integer.compare(a.length(), ar.length()));

        for(String arg : args) {
            System.out.println(arg);
        }
    }
}