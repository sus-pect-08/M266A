import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Giocatore {
    private String nome;
    private Inventario inventario;

    public Giocatore(String nome, Inventario inventario) {
        this.nome = nome;
        this.inventario = inventario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Inventario getInventario() {
        return inventario;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Giocatore giocatore = (Giocatore) o;
        return Objects.equals(nome, giocatore.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome + "\n Inventario: " + inventario;
    }
}
