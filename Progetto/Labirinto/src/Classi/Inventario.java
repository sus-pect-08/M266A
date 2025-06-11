import java.util.LinkedList;

public class Inventario {
    private LinkedList<Oggetto> oggetti;

    public Inventario(LinkedList<Oggetto> oggetti) {
        this.oggetti = oggetti;
    }

    public LinkedList<Oggetto> getOgetti() {
        return oggetti;
    }
    public void setOgetti(LinkedList<Oggetto> oggetti) {
        this.oggetti = oggetti;
    }

    @Override
    public String toString() {
        return oggetti.toString();
    }
}
