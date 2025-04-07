import java.util.LinkedList;
import java.util.Objects;

public class Playlist {
    private String titolo;
    private LinkedList<Brano> Brani;

    public Playlist(String titolo, LinkedList<Brano> Brani) {
        this.titolo = titolo;
        this.Brani = Brani;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Brano getBrani(int index) {
        return Brani.get(index);
    }

    public void setBrani(LinkedList<Brano> Brani) {
        this.Brani = Brani;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(titolo, playlist.titolo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titolo);
    }
}
