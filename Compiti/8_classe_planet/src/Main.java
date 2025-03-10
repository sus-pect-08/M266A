public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth", 5.972 , 6.378, 260, 5.513, true, true,0.3f);
        Planet sun = new Planet();
        Planet nu = new Planet("pianeta sconosciuto", 0.0, 0.0, 0.0, 0.0, false, false, 0.0f);

        System.out.println(earth + "\n" + sun + "\n" + nu);
    }
}