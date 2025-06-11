import java.util.Objects;

public class Oggetto {
    private String nome;

    public Oggetto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Oggetto oggetto = (Oggetto) o;
        return Objects.equals(nome, oggetto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return  nome;
    }
}


