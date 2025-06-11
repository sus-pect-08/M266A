import java.util.Objects;

public class Stanza {
    private String nome;
    private String descrizione;
    private String collegamento1;
    private String collegamento2;


    public Stanza(String nome, String descrizione, String collegamento1, String collegamento2) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.collegamento1 = collegamento1;
        this.collegamento2 = collegamento2;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getCollegamento1() {
        return collegamento1;
    }

    public String getCollegamento2() {
        return collegamento2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stanza stanza = (Stanza) o;
        return Objects.equals(nome, stanza.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return "l'insegna indica " + nome + " " + descrizione + " ci sono due vie " + collegamento1 + " e " + collegamento2;
    }
}
