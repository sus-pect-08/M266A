import java.util.Objects;

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

    int n = 0;
    String result;
    public String play() {
        return "playing: " + playlist.getTitolo() +
                playlist.getBrani(n);
    }
    public String succesivo(){
        try{
            n ++;
            return "playing: " + playlist.getTitolo() +
                playlist.getBrani(n);
        }catch (IndexOutOfBoundsException e){
            return "non è presente alcun brano successivo";
        }
    }
    public String precedente(){
        try {
            n--;
            return "playing: " + playlist.getTitolo() +
                    playlist.getBrani(n);
        }catch (IndexOutOfBoundsException e){
            return "non è presente alcun brano precednete";
        }
    }
    public String SelezionaBrano(int m){
        try {
            return "playing: " + playlist.getTitolo() +
                    playlist.getBrani(m);
        }catch (IndexOutOfBoundsException e){
            return "non è presente quel numero di brano";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(modello, player.modello) && Objects.equals(marca, player.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modello, marca);
    }

    @Override
    public String toString() {
        return "Player{" +
                ", playlist=" + playlist +
                '}';
    }
}
