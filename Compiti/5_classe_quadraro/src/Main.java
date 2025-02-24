public class Main {
    public static void main(String[] args) {
        Quadrato q1 = new Quadrato(8);
        Quadrato q2 = new Quadrato(12);
        Quadrato q3 = new Quadrato();

        System.out.println(q1);
        q1.draw();
        System.out.println(q2);
        q2.draw();
        System.out.println(q3);
        q3.draw();
    }
}