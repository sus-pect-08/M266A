/**
*Esercizio 3.8
*Programma calcolatrice
*
* @author Sofia Niederhauser
* @version 10.02.2025
*/
public class Calcolatrice{
	public static void main(String[] args){
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int calcolo;
		String operatore = args[2];
		if (operatore.equals("/")){
			calcolo = n1 / n2;
			System.out.println(n1 + "/" + n2 + " = " + calcolo );
		}
		else if (operatore.equals("x")){
			calcolo = n1 * n2;
			System.out.println(n1 + " x " + n2 + " = " + calcolo );
		}
		else if (operatore.equals("-")){
			calcolo = n1 - n2;
			System.out.println(n1 + " - " + n2 + " = " + calcolo );
		}
		else if (operatore.equals("+")){
			calcolo = n1 + n2;
			System.out.println(n1 + " + " + n2 + " = " + calcolo );
		}
		else {
			System.out.println("L'operatore inserito non è riconosciuto");
		}
	}
}