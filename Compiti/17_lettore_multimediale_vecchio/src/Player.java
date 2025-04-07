public class Player {
    private String modello;
    private String marca;
    private Playlist playlist;

    public Player(String modello, String marca, Playlist playlist) {
        this.modello = modello;
        this.marca = marca;
        this.playlist = playlist;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String play() {
        return playlist.out();
    }
    public String succesivo(){
        return playlist.next();
    }
    public String precedente(){
        return playlist.previus();
    }

    @Override
    public String toString() {
        return "Player{" +
                ", playlist=" + playlist +
                '}';
    }
}
