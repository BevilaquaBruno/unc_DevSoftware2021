package exerciciosAlgoritmos;

import java.util.Scanner;

public class MediaAritmetica {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o 1° número: ");
		double n1 = scan.nextDouble();
		System.out.print("Informe o 2° número: ");
		double n2 = scan.nextDouble();
		System.out.print("Informe o 3° número: ");
		double n3 = scan.nextDouble();
		
		System.out.printf("A media aritmética é: %s", ((n1+n2+n3)/3));
		scan.close();
	}
}
