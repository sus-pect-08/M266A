public class Main {
    public static void main(String[] args) {
    Brano Brani[] = new Brano[5];
    Brani[0] = new Brano("sharks", "imagine drangons");
    Brani[1] = new Brano("highway to hell", "ACDC");
    Brani[2] = new Brano("pleaca", "vunk");
    Brani[3] = new Brano("what hurts the most", "cascada");
    Brani[4] = new Brano("nobody wants to be lonely", "ricky martin");

    Playlist playlist = new Playlist("something", Brani);
    Player player = new Player("bho", "marshall", playlist);

        System.out.println(player.play());
        System.out.println(player.succesivo());
        System.out.println(player.precedente());
        System.out.println(player.succesivo());

    }
}