package exerciciosAlgoritmos;

import java.util.ArrayList;
import java.util.Scanner;

public class Multiplicacao {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o 1° número:");
		double n1 = scan.nextDouble();
		System.out.print("Informe o 2° número:");
		double n2 = scan.nextDouble();
		
		double result = n1 * n2;
		
		System.out.printf("%s * %s = %s", n1, n2, result);

	}

}
