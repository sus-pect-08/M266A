import java.util.Objects;

public class Personaggio {
    private String nome;
    private String domanda;
    private String opzioni;

    public Personaggio(String nome, String domanda, String opzioni) {
        this.nome = nome;
        this.domanda = domanda;
        this.opzioni = opzioni;
    }

    public String getNome() {
        return nome;
    }

    public String getDomanda() {
        return domanda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaggio that = (Personaggio) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome + ": " + domanda + "\n" + opzioni;
    }
}
