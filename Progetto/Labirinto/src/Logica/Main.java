import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.Scanner;
/**
*Progetto labirinto
*
* @author Sofia Niederhauser I2AA
* @version 11.06.2025
* */

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("risultati.txt");

        LinkedList<Personaggio> personaggi = new LinkedList<>();
        personaggi.add(new Personaggio("Valsangiacomo", "cosa significa l'acronimo SSID ?", "a) Service Set IDentifier b) Security Scanner Inenal Domain c) Security Service ID"));
        personaggi.add(new Personaggio("Montalbetti", "Qual'è la differenza tra WORM  enterprise e compilance ?", "a) enterprise è sotto legge intoccabile e compilance è più flessibile b) compilance è sotto legge intoccabile e enterprice è più flessibile c) compilance è la versione vecchia e enterprice è quella nuova"));
        personaggi.add(new Personaggio("Bernaschina", "Quale forma normale è sempre raggiungibile ?", "a) BCNF b) 2NF c) 3NF"));
        personaggi.add(new Personaggio("Pallucci", "Come si confrontano due oggetti o stringhe ?", "a) == b) equals c) ="));
        personaggi.add(new Personaggio("Mussi", "Che porte si utilizzano su arduino uno per attachInterrupt() ?", "a) tutte b) 0,1,2,3 c) 2,3"));
        personaggi.add(new Personaggio("Sartori", "Come si esegue una FULL outer JOIN in MYsql ?", "a) FULL JOIN b) LEFT JOIN UNION RIGHT JOIN c) JOIN"));
        personaggi.add(new Personaggio("Poncini", "Cosa fa il DNS ?", "a) assegna i nomi ai pc in dominio b) assegna indirizzi IP c) legge le MAC address"));

        LinkedList<Stanza> stanze = new LinkedList<>();
        stanze.add(new Stanza(", Aula 421,", "sul pavimento si trovano dei router e, degli switch distrutti... \n e, sembrano esserci anche dei buchi neri nel pavimento... \n c'è Valsangiacomo nell'angolo, ", "una porta nera", "una porta ricoperta di fiori"));
        stanze.add(new Stanza("Aula 425", "ci sono dei NAS... \n e degli occhiali distrutti di qualcuno per terra... \n c'è Montalbetti che cerca i propri occhiali nell'angolo, ", "una porta con dei cavi rotti", "una porta grigia"));
        stanze.add(new Stanza ("Aula 347", "la stanza ha un buco che ricopre maggior parte della stanza... \n e, c'è una valigetta che sta per cadere piena di libri di inglese, ", "una porta irragiungibile", "la porta di arrivo"));
        stanze.add(new Stanza("Aula 341", "l'aula è vuota... \n qualcuno sembra essere scappatto attraverso il muro... \n aspetta un cellulare... \n lo raccogli, è il tuo..., ", "il muro", "la porta d'arrivo"));
        stanze.add(new Stanza("Aula 421b", "ci sono dei diagrammi ER e degli schemi logici sul pavimento \n  c'è la Bernaschina a destra della stanza", "una porta di metallo, ", "un buco nella parete"));
        stanze.add(new Stanza("Aula 413", "sul muro sono ancora appesi i pc... \n ma i tavoli sono tutti distrutti \n sembra che Pallucci ti stia aspettando, ", "una porta di legno", "una porta di vetro"));
        stanze.add(new Stanza("Aula 441", "nella stanza si trovano pezzi di lego sparpagliati per terra... \n sembra che Mussi stia dormendo, ", "un arco centrale", ""));
        stanze.add(new Stanza("Aula 430", "è relativamente vuoto... \n solo qualche insetto... \n e un ragno", "una porta di rame, ", "una porta verde"));
        stanze.add(new Stanza("", "non c'è nulla.. \n bene", "",""));
        stanze.add(new Stanza("Aula 417", "ci sono alcuni server per terra...", "una porta di entrata", ""));

        LinkedList<Oggetto> oggetti = new LinkedList<>();
        oggetti.add(new Oggetto("telefono"));
        oggetti.add(new Oggetto("cavo verde"));
        oggetti.add(new Oggetto("occhiali rotti"));

        Scanner gioco = new Scanner(System.in);
        Gioco.start(path);
        LinkedList<Oggetto> oggetto = new LinkedList<>();
        Inventario inventario = new Inventario(oggetto);

        System.out.print("Inserisci il tuo nome, giocatore: ");
        String nomeGiocatore = gioco.nextLine();

        Giocatore giocatore = new Giocatore(nomeGiocatore, inventario);

        System.out.println("Benvenuta/o, " + giocatore);
        Gioco.giocatore(path, giocatore);

        System.out.println("GAME START");
        try {
            Thread.sleep(2000); // due secondi di attesa
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Ti sei appena svegliato... \n" + stanze.get(0));
        gioco.nextLine();

        System.out.println("Non hai il cellulare in tasca, Vai da Valsangiacomo...\n" );
        gioco.nextLine();

        System.out.println(personaggi.get(0));

        if(gioco.nextLine().equalsIgnoreCase("a")){
            System.out.println((personaggi.get(0)).getNome() +": brava/o ora posso rivelarti che la porta nera è quella che ti porta alla libertà");
            Gioco.rispostaCorretta(path, personaggi, 0);
        }else{
            System.out.println((personaggi.get(0)).getNome() +": cof.. cof.. la porta corretta e quella ricoperta di fiori");
            Gioco.rispostaSbagliata(path, personaggi, 0);
        }
        System.out.println("Quale porta scegli? (n/f)");
        String risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("n")){
            Gioco.portaNera(gioco, oggetti, oggetto, inventario, path);
            Gioco.portaScelta(path, stanze, 0, false);
        }else if (risposta.equalsIgnoreCase("f")){
            Gioco.portaScelta(path, stanze, 0, true);
            System.out.println(stanze.get(2));
            System.out.println("Vuoi provare a saltare? (s/n)");
            risposta = gioco.nextLine();
            if(risposta.equalsIgnoreCase("s")) {
                try {
                    Files.writeString(path, "Hai provato a saltare \n", StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("errore nella scrittura file");
                }
                Gioco.morte(gioco, path);
            }else {
                System.out.println("Torni indietro...");
                Gioco.torni(path);
                Gioco.portaNera(gioco, oggetti, oggetto, inventario, path);
            }
        }
        System.out.println(stanze.get(1));
        gioco.nextLine();

        System.out.println("Vuoi raccogliere gli occhiali da terra? (s/n)" );
        risposta =gioco.nextLine();

        if(risposta.equalsIgnoreCase("s")){
            oggetto.add(oggetti.get(2));
            System.out.println("inventario aggiornato: " + inventario);
            Gioco.inventarioAgg(path, inventario);
        }
        System.out.println("Ti dirigi verso Montalbetti...");
        gioco.nextLine();

        System.out.println((personaggi.get(1)).getNome() + ": Per caso hai visto i miei occhiali?");
        for(Oggetto o: oggetto){
            if (o.equals(oggetti.get(2))){
                System.out.println(giocatore.getNome() + ": Sì ecco qua");
                System.out.println((personaggi.get(1)).getNome() +"Grazie mille giovanotto...");
                try {
                    Files.writeString(path, "Hai portato gli occhiali da Montalbetti \n", StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("errore nella scrittura file");
                }
                oggetto.remove(o);
                System.out.println("inventario aggiornato: " + inventario);
                Gioco.inventarioAgg(path, inventario);
                break;
            }
        }
        gioco.nextLine();

        System.out.println(personaggi.get(1));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("b")){
            System.out.println((personaggi.get(1)).getNome() +": brava/o, sono abbastanza sicuro che la porta corretta sia quella con i cavi rotti");
            Gioco.rispostaCorretta(path, personaggi, 1);
        }else{
            System.out.println((personaggi.get(1)).getNome() +": male, queste cose dovresti saperle... ad ogni modo la risposta corretta è la b... e la porta corretta è quella grigia");
            Gioco.rispostaSbagliata(path, personaggi, 1);
        }
        System.out.println("Quale porta scegli? (g/c)");
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("c")){
            Gioco.portaCavi(gioco, oggetti, oggetto, inventario, path);
            Gioco.portaScelta(path, stanze, 1, false);
        }else if (risposta.equalsIgnoreCase("g")){
            Gioco.portaScelta(path, stanze, 1, true);
            System.out.println(stanze.get(3));
            oggetto.add(oggetti.get(0));
            System.out.println("inventario aggiornato: " + inventario);
            Gioco.inventarioAgg(path, inventario);
            System.out.println("vuoi provare a passare per il muro? (s/n)");
            risposta = gioco.nextLine();
            if(risposta.equalsIgnoreCase("s")) {
                System.out.println("Ahia... ");
                try {
                    Files.writeString(path, "Hai provato a passare per il muro \n", StandardOpenOption.APPEND);
                } catch (IOException e) {
                    System.out.println("errore nella scrittura file");
                }
            }
            System.out.println("Torni indietro...");
            Gioco.torni(path);
            Gioco.portaCavi(gioco, oggetti, oggetto, inventario, path);
        }

        System.out.println(stanze.get(4));
        System.out.println("Vai da Bernaschina... \n" + personaggi.get(2));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("c")){
            System.out.println((personaggi.get(2)).getNome() +": Vedo che ascolti durante le mie ore... \n la porta corretta è quella di metallo");
            Gioco.rispostaCorretta(path, personaggi, 2);
        }else{
            System.out.println((personaggi.get(2)).getNome() +": Vedo che non stai attento/a durante le mie lezioni... \n la via corretta è il buco nella parete");
            Gioco.rispostaSbagliata(path, personaggi, 2);
        }
        System.out.println("Quale porta scegli? (m/b)");
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("b")){
            Gioco.portaScelta(path, stanze, 4, true);
            for(Oggetto o: oggetto){
                if (o.equals(oggetti.get(0))){
                    System.out.println("Accendi la torcia del telefono... presto però ti spaventi e decidi di indietreggiare");
                    break;
                }
            }
            System.out.println("Torni indietro... \n un rango gigante ti attacca...");
            Gioco.morte(gioco, path);
        }else if(risposta.equalsIgnoreCase("m")){
            Gioco.portaScelta(path, stanze, 4, false);
            System.out.println("Stai spingendo fortemente, senza alcun successo... \n Poi si unisce anche La Bernaschina... \n si è aperta");
        }
        System.out.println(stanze.get(5));
        System.out.println("Ti avvicini a Pallucci");
        System.out.println(personaggi.get(3));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("b")){
            System.out.println((personaggi.get(3)).getNome() + ": Complimenti ti ricordi bene tutte le cose importanti... \n La porta corretta è quella di vetro");
            Gioco.rispostaSbagliata(path, personaggi, 3);
        }else {
            System.out.println((personaggi.get(3)).getNome() + ": Fa niente ma quella corretta sarebbe  \n La porta corretta è quella di legno");
            Gioco.rispostaSbagliata(path, personaggi, 3);
        }
        System.out.println("Quale porta scegli? (v/l)");
        risposta = gioco.nextLine();
        if(risposta.equalsIgnoreCase("l")){
            Gioco.portaScelta(path, stanze, 5, false);
            System.out.println("la porta sembra essere bloccata... \n decidi di prendere quella di vetro");
        }
        Gioco.portaScelta(path, stanze, 5, true);
        System.out.println("attraverso la porta si intravede una figura sfocata");
        System.out.println("l'insegna indica: " + stanze.get(6).getNome() + stanze.get(6).getDescrizione() + "C'è solamente un arco al centro...");
        System.out.println(personaggi.get(4));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("c")){
            System.out.println((personaggi.get(4)).getNome() + ": Dai che almeno qualcuno sta attento quando spiego... \n devi proseguire per l'arco centrale");
            Gioco.rispostaSbagliata(path, personaggi, 4);
        }else{
            System.out.println((personaggi.get(4)).getNome() + ": Si vede che dormi quando spiego... \n comunque devi proseguire per l'arco centrale");
            Gioco.rispostaSbagliata(path, personaggi, 4);
        }
        Gioco.portaScelta(path, stanze, 6, false);
        System.out.println("Passi per l'arco... \n" + stanze.get(7));
        System.out.println("Vai verso Sartori... \n" + personaggi.get(5));
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("b")) {
            System.out.println((personaggi.get(5)).getNome() + ": ok, ti è andata bene \n devi proseguire per la porta verde");
            Gioco.rispostaCorretta(path, personaggi, 5);
        }else{
            System.out.println((personaggi.get(5)).getNome() + ": ok, ti è andata bene \n devi proseguire per la porta di rame");
            Gioco.rispostaSbagliata(path, personaggi, 5);
        }

        System.out.println("Che porta scegli? (r/v)");
        risposta = gioco.nextLine();

        if(risposta.equalsIgnoreCase("r")){
            Gioco.portaScelta(path, stanze, 7, false);
            System.out.println(stanze.get(8).getDescrizione());
            System.out.println("Torni indietro...");
            Gioco.torni(path);
            Gioco.portaVerde(gioco, stanze, personaggi, risposta, path);
        }else if (risposta.equalsIgnoreCase("v")){
            Gioco.portaScelta(path, stanze, 7, true);
            Gioco.portaVerde(gioco, stanze, personaggi, risposta, path);
        }
        gioco.close();
    }
}