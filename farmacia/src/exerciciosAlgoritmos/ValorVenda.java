package exerciciosAlgoritmos;

import java.util.Scanner;

public class ValorVenda {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe o pre�o unit�rio do produto: ");
		double preco_unitario = scan.nextDouble();
		
		System.out.print("Informe a quantidade do produto: ");
		double quantidade = scan.nextDouble();
		
		System.out.printf("O valor da venda � %s", (quantidade * preco_unitario));
		scan.close();
	}

}
