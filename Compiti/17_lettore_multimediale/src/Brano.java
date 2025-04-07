import java.util.Objects;

public class Brano {
    public String titolo;
    public String autore;

    public Brano(String titolo, String autore) {
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brano brano = (Brano) o;
        return Objects.equals(titolo, brano.titolo) && Objects.equals(autore, brano.autore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titolo, autore);
    }

    @Override
    public String toString() {
        return  " " + titolo + " " + autore ;
    }
}
