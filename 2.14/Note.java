/**
*Esercizio 2.14
*Programma che calcola la nota finale con pesi
*
* @author Sofia Niederhauser
* @version 03.02.2025
*/
public class Note{
	public static void main(String[] args){
		float nota1 = Float.parseFloat(args[0]);
		float nota2 = Float.parseFloat(args[1]);
		float nota3 = Float.parseFloat(args[2]);
		float nota4 = Float.parseFloat(args[3]);
		float notafin = (nota1 * 0.10f + nota2 * 0.3f + nota3 * 0.3f + nota4 * 0.3f);
		System.out.println("Nota Finale: " + notafin);
	}
}