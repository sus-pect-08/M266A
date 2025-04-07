import java.util.Objects;

public class Room {
    private String nome;
    private double superfice;

    public Room(String nome, double superfice) {
        this.nome = nome;
        this.superfice = superfice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSuperfice() {
        return superfice;
    }

    public void setSuperfice(double superfice) {
        this.superfice = superfice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Double.compare(superfice, room.superfice) == 0 && Objects.equals(nome, room.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, superfice);
    }

    @Override
    public String toString() {
        return  nome + " " + superfice;
    }
}
