package FarmaciaUI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		showMenu();
	}

	private static void showMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|            Sistema Farmacêutico              |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Cadastro                                   |");
		System.out.println("|2. Estoque                                    |");
		System.out.println("|3. Relatórios                                 |");
		System.out.println("|4. Ajuda                                      |");
		System.out.println("|5. Sair                                       |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if (1 == opc) {
			showCadastros();
		}else if (3 == opc) {
			showRelatorios();
		}
		scan.close();
	}

	private static void showCadastros() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Cadastros                    |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Cliente                                    |");
		System.out.println("|2. Funcionario                                |");
		System.out.println("|3. Farmaceutico                               |");
		System.out.println("|4. Produtos                                   |");
		System.out.println("|5. Voltar                                     |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if (5 == opc) {
			showMenu();
		}else if (1 == opc){
			showCadastroCliente();
		}
		scan.close();
		
	}
	
	/*
	 * Cadastros
	 * */
	
	private static void showCadastroCliente() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Cliente                      |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.print("Nome:");
		String nome = scan.nextLine();
		System.out.print("CPF:");
		String cpf = scan.nextLine();
		System.out.print("RG:");
		String rg = scan.nextLine();
		System.out.print("Telefone:");
		String telefone = scan.nextLine();
		
		Cliente clienteCadastro = new Cliente(nome, cpf, rg, telefone);
		System.out.println("Deseja salvar o cliente ("+cpf+")"+nome+"? S - Sim | N - Não");
		System.out.print("Resposta: ");
		String opc = scan.next();
		if(opc.equals("S")) {
			Cliente.salvar(clienteCadastro);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showCadastros();
		scan.close();
	}
	
	private static void showRelatorios() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Relatórios                   |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Cliente                                    |");
		System.out.println("|2. Funcionario                                |");
		System.out.println("|3. Farmaceutico                               |");
		System.out.println("|4. Produtos                                   |");
		System.out.println("|5. Voltar                                     |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if (1 == opc) {
			List<Cliente> clientes = Cliente.lerTodosClientes();
			System.out.println("Imprimindo clientes:");
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
		}else if(5 == opc) {
			showMenu();
		}
		scan.close();
		
	}
}
