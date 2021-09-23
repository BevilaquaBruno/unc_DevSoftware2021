package FarmaciaUI;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import FarmaciaUI.models.CategoriaProduto;
import FarmaciaUI.models.Cliente;
import FarmaciaUI.models.Farmaceutico;
import FarmaciaUI.models.Funcionario;
import FarmaciaUI.models.Produto;

public class Principal {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		showMenu();
	}

	private static void showMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|            Sistema Farmacêutico              |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Sair                                       |");
		System.out.println("|2. Cadastro                                   |");
		System.out.println("|3. Estoque                                    |");
		System.out.println("|4. Relatórios                                 |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if (2 == opc) {
			showCadastros();
		}else if (4 == opc) {
			showRelatorios();
		}
		scan.close();
	}

	private static void showCadastros() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Cadastros                    |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Voltar                                     |");
		System.out.println("|2. Cliente                                    |");
		System.out.println("|3. Funcionario                                |");
		System.out.println("|4. Farmaceutico                               |");
		System.out.println("|5. Cat. Produto                               |");
		System.out.println("|6. Produto                                    |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if (1 == opc) {
			showMenu();
		}else if (2 == opc){
			showCadastroCliente();
		}else if (3 == opc) {
			showCadastroFuncionario();
		}else if (4 == opc) {
			showCadastroFarmaceutico();
		}else if(5 == opc) {
			showCadastroCategoriaProduto();
		}else if (6 == opc) {
			showCadastroProduto();
		}
		scan.close();
		
	}
	
	/*
	 * Cadastros
	 * */
	
	private static void showCadastroProduto() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|               Produto                        |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.println("Código de barra: ");
		String codBarra = scan.nextLine();
		System.out.println("Lote: ");
		String lote = scan.nextLine();
		System.out.println("Data Fabricação: ");
		String dataFab = scan.nextLine();
		Date dataFabricacao = new Date(Integer.parseInt(dataFab.split("/")[2]), Integer.parseInt(dataFab.split("/")[1])-1, Integer.parseInt(dataFab.split("/")[0]));
		System.out.println("Data Validade: ");
		String dataVal = scan.nextLine();
		Date dataValidade = new Date(Integer.parseInt(dataVal.split("/")[2]), Integer.parseInt(dataVal.split("/")[1])-1, Integer.parseInt(dataVal.split("/")[0]));
		System.out.println("Valor: ");
		Float valor = scan.nextFloat();
		System.out.println("Idade Mánima: ");
		Integer idadeMinima = scan.nextInt();
		System.out.println("Idade Míxima: ");
		Integer idadeMaxima = scan.nextInt();
		System.out.println("Categoria de produto - Nome: ");
		String catProdNome = scan.nextLine();
		System.out.println("Categoria de produto - ícone: ");
		String catProdIcone = scan.nextLine();
		
		CategoriaProduto catProd = new CategoriaProduto(catProdNome, catProdNome);
		Produto prod = new Produto(codBarra, lote, dataFabricacao, dataValidade, valor, idadeMinima, idadeMaxima, catProd);
		System.out.println("Deseja salvar o  produto? S - Sim | N - Não");
		System.out.print("Resposta: ");
		String opc = scan.next();
		if(opc.equals("S")) {
			Produto.salvar(prod);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showCadastros();
		scan.close();
	}
	
	private static void showCadastroCategoriaProduto() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|               Cat. Produto                   |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("ícone: ");
		String icone = scan.nextLine();
		
		CategoriaProduto catprod = new CategoriaProduto(nome, icone);
		System.out.println("Deseja salvar a categoria de produto "+catprod.getNome()+"? S - Sim | N - Não");
		System.out.print("Resposta: ");
		String opc = scan.next();
		if(opc.equals("S")) {
			CategoriaProduto.salvar(catprod);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showCadastros();
		scan.close();
	}
	
	private static void showCadastroFuncionario() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|               Funcionario                    |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("CPF: ");
		String cpf = scan.nextLine();
		System.out.print("RG: ");
		String rg = scan.nextLine();
		System.out.print("PIS: ");
		String pis = scan.nextLine();
		System.out.print("PASEP:");
		String pasep = scan.nextLine();
		System.out.print("Carteira Trabalho: ");
		String carteiraTrabalho = scan.nextLine();
		System.out.print("Salário: ");
		String salario = scan.nextLine();
		
		Funcionario func = new Funcionario(nome, cpf, rg, pis, pasep, carteiraTrabalho, salario);
		System.out.println("Deseja salvar o funcionário ("+cpf+")"+nome+"? S - Sim | N - Não");
		System.out.print("Resposta: ");
		String opc = scan.next();
		if(opc.equals("S")) {
			Funcionario.salvar(func);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showCadastros();
		scan.close();
	}
	
	private static void showCadastroCliente() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Cliente                      |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("CPF: ");
		String cpf = scan.nextLine();
		System.out.print("RG: ");
		String rg = scan.nextLine();
		System.out.print("Telefone: ");
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
	
	private static void showCadastroFarmaceutico() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|               Farmaceutico                   |");
		System.out.println("|__Digite______________________________________|");
		Scanner scan = new Scanner(System.in);
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("CPF: ");
		String cpf = scan.nextLine();
		System.out.print("RG: ");
		String rg = scan.nextLine();
		System.out.print("PIS: ");
		String pis = scan.nextLine();
		System.out.print("PASEP:");
		String pasep = scan.nextLine();
		System.out.print("Carteira Trabalho: ");
		String carteiraTrabalho = scan.nextLine();
		System.out.print("Salário: ");
		String salario = scan.nextLine();
		System.out.print("Anvisa: ");
		String anvisa = scan.nextLine();
		
		Farmaceutico farmaceuticoCadastro = new Farmaceutico(nome, cpf, rg, pis, pasep, carteiraTrabalho, salario, anvisa);
		System.out.println("Deseja salvar o farmacêutico ("+cpf+")"+nome+"? S - Sim | N - Não");
		System.out.print("Resposta: ");
		String opc = scan.next();
		if(opc.equals("S")) {
			Farmaceutico.salvar(farmaceuticoCadastro);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		showCadastros();
		scan.close();
	}
	
	/**
	 * Relatórios
	 */
	
	private static void showRelatorios() throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("________________________________________________");
		System.out.println("|                 Relatórios                   |");
		System.out.println("|______________________________________________|");
		System.out.println("|1. Voltar                                     |");
		System.out.println("|2. Cliente                                    |");
		System.out.println("|3. Funcionario                                |");
		System.out.println("|4. Farmaceutico                               |");
		System.out.println("|5. Cat. Produto                               |");
		System.out.println("|6. Produto                                    |");
		System.out.print("Digite uma opção: ");
		Scanner scan = new Scanner(System.in);
		Integer opc = scan.nextInt();
		if(1 == opc) {
			showMenu();
		} else if (2 == opc) {
			Cliente.showAll();
		}else if (3 == opc) {
			Funcionario.showFuncionarios();
		}else if(4 == opc) {
			Farmaceutico.showFarmaceuticos();
		}else if (5 == opc) {
			CategoriaProduto.showCategoriasProdutos();
		}else if (6 == opc) {
			Produto.showProdutos();
		}
		if(1 != opc) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			showRelatorios();
		}
		scan.close();
		
	}
}
