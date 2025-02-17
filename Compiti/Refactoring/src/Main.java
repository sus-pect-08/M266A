//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double raggio = Double.parseDouble(args[0]);
        System.out.println(calcolaVolume(raggio));
    }
    public static double calcolaVolume(double raggio){
        double volume = 4/3 * Math.PI * raggio;
        return volume;
    }
}