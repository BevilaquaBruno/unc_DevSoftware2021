package exerciciosAlgoritmos;

import java.util.Scanner;

public class MediaAritmetica {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o 1� n�mero: ");
		double n1 = scan.nextDouble();
		System.out.print("Informe o 2� n�mero: ");
		double n2 = scan.nextDouble();
		System.out.print("Informe o 3� n�mero: ");
		double n3 = scan.nextDouble();
		
		System.out.printf("A media aritm�tica �: %s", ((n1+n2+n3)/3));
		scan.close();
	}
}
