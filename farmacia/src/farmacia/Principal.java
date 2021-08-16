package farmacia;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws IOException {
		List<Pessoa> lstPessoa = Pessoa.lerTodos();
		for (Pessoa pessoa : lstPessoa) {
			System.out.println("Nome: "+pessoa.getNome()+" CPF: "+pessoa.getCpf()+" RG: "+pessoa.getRg());
		}
		/*
		 * Scanner scan = new Scanner(System.in);
		 * Cliente p = new Cliente(); System.out.print("Digite seu nome: ");
		 * p.setNome(scan.nextLine()); System.out.print("Digite seu CPF: ");
		 * p.setCpf(scan.nextLine()); System.out.print("Digite seu RG: ");
		 * p.setRg(scan.nextLine()); System.out.print("Digite seu telefone: ");
		 * p.setTelefone(scan.nextLine());
		 * 
		 * 
		 * p.salvar(); scan.close();
		 */
	}

}
