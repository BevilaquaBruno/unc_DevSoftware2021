package farmacia;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Farmaceutico f = new Farmaceutico();
		Scanner scan = new Scanner(System.in);

		System.out.print("Digite seu nome: ");
		String nome = scan.nextLine();
		f.setNome(nome);
		System.out.println("Nome informado: " + f.getNome());

		scan.close();
	}

}
