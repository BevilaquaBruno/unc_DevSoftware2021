package testesFarmacia;

import java.util.Scanner;

public class TesteEntradaSaidaConsole {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = scan.nextLine();
		System.out.println("Seu nome é: " + nome);

		scan.close();
	}

}
