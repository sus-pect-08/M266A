import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Gioco {
    //questo metodo l'ho creato con l'aiuto dell'inelligenza artificiale
    public static void portaNera(Scanner gioco, List<Oggetto> oggetti, List<Oggetto> oggetto, Inventario inventario, Path path) {
        System.out.println("Davanti alla porta c'e un cavi... \n lo raccogli (s/n)?");
        String risposta = gioco.nextLine();
        if(risposta.equalsIgnoreCase("s")){
            oggetto.add(oggetti.get(1));
            System.out.println("inventario aggiornato: " + inventario);
            Gioco.inventarioAgg(path, inventario);
        }
        System.out.println("Entri...");
        gioco.nextLine();
    }
    public static void portaCavi(Scanner gioco, List<Oggetto> oggetti, List<Oggetto> oggetto, Inventario inventario,  Path path) {
        System.out.println("Devi sostituire i cavi rotti con cavi nuovi");
        for(Oggetto o: oggetto){
             if (o.equals(oggetti.get(1))){
                System.out.println("colleghi il " + oggetti.get(1).getNome());
                oggetto.remove(o);
                System.out.println("inventario aggiornato: " + inventario);
                Gioco.inventarioAgg(path, inventario);
            }
        }
        System.out.println("La porta si è aperta... Entri...");
        gioco.nextLine();
    }
    public static void portaVerde(Scanner gioco, List<Stanza> stanze, List<Personaggio> personaggi, String risposta, Path path) {
        System.out.println("l'insegna indica: " + stanze.get(9).getNome() + stanze.get(9).getDescrizione() + "C'è solamente una porta d'entrata");
        System.out.println("Ti avvicini a Poncini \n" + personaggi.get(6));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("a")){

            System.out.println("Bravo/a ti lascio uscire dalla porta senza preocupazioni...");
            Gioco.rispostaCorretta(path, personaggi, 6);

            System.out.println("Complimenti... hai conluso il gioco con successo... per vedere vedere i tuoi progressi vai nel file in out risultati.txt");
            gioco.close();
            Gioco.fine(path);
        }else{
            Gioco.rispostaSbagliata(path, personaggi, 6);
            System.out.println("Molto male dopo tutte le lezioni di teoria, adesso devi aiutarmi a mettere a posto");
            System.out.println("dopo qualche ora sei riuscito ad uscire...");
            System.out.println("Complimenti... hai conluso il gioco... per vedere vedere i tuoi progressi vai nel file in out risultati.txt");
            gioco.close();
            Gioco.fine(path);
        }

    }
    public static void morte(Scanner gioco, Path path){
        System.out.println("Sei morto... \n  GAME OVER \n");
        gioco.close();
        try {
            Files.writeString(path, "sei morto \n GAME OVER", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
        Gioco.fine(path);
    }

    //tutti metodi per la scrittura all'interno del file
    public static void start(Path path){
        try {
            if(Files.exists(path)){
                if (Files.isWritable(path)) {
                    //queste linee le ho fatte con aiuto di IA
                    LocalDateTime time = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
                    String timeFormattata = time.format(formatter);

                    StringBuilder line1 = new StringBuilder("Gioco " + timeFormattata + "\n");
                    Files.writeString(path, line1);
                }
            }
            else {
                System.out.println("non funziona");
            }
        }catch (IOException e){
            System.out.println("errore nella scrittura file");
        }

    }
    public static void giocatore(Path path, Giocatore giocatore){
        StringBuilder line2 = new StringBuilder("Nome: " + giocatore.getNome() + "\n");
        line2.append("Inventario: " + giocatore.getInventario() + "\n");
        try {
            Files.writeString(path, line2, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }
    public static void rispostaCorretta(Path path, List<Personaggio> personaggi, int idx){
        StringBuilder line = new StringBuilder("Hai risposto correttamente a ");
        line.append((personaggi.get(idx)).getNome());
        line.append("\n");
        try {
            Files.writeString(path, line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }
    public static void rispostaSbagliata(Path path, List<Personaggio> personaggi, int idx){
        StringBuilder line = new StringBuilder("Hai risposto sbagliato a ");
        line.append((personaggi.get(idx)).getNome());
        line.append("\n");
        try {
            Files.writeString(path, line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }
    public static void inventarioAgg(Path path, Inventario inventario){
        String line = "inventario aggiornato: " + inventario + "\n";

        try {
            Files.writeString(path, line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }
    public static void portaScelta(Path path, List<Stanza> stanze, int idx, boolean coll){
        StringBuilder line = new StringBuilder("Hai scelto ");
        if (coll == false){
            line.append((stanze.get(idx)).getCollegamento1());
        } else if (coll == true) {
            line.append((stanze.get(idx)).getCollegamento2());
        }
        line.append("\n");

        try {
            Files.writeString(path, line, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
}
    public static void torni(Path path){
        try {
            Files.writeString(path, "Sei tornato indietro \n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }
    public static void fine(Path path){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
        String timeFormattata = time.format(formatter);
        StringBuilder line = new StringBuilder("Gioco Finito alle" + timeFormattata + "\n");

        try {
            Files.writeString(path, line, StandardOpenOption.APPEND);
        }
        catch (IOException e) {
            System.out.println("errore nella scrittura file");
        }
    }

}
