import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
    LinkedList<Brano> Brani = new LinkedList<Brano>();
    Brani.add(new Brano("highway to hell", "ACDC"));
    Brani.add(new Brano("pleaca", "vunk"));
    Brani.add(new Brano("nobody wants to be lonely", "ricky martin"));
    Brani.add(new Brano("mamma mia", "maneskin"));



    Playlist playlist1 = new Playlist("favs", Brani);
    Player player = new Player("H56zz", "xiaomi", playlist1);
        System.out.println(player.play());
        System.out.println(player.succesivo());
        System.out.println(player.precedente());
        System.out.println(player.SelezionaBrano(3));
    }
}