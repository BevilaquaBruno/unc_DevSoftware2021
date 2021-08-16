package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
	/* Attributes */
	private String telefone;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/cliente.csv";
	
	/* Constructor */
	public Cliente (String nome, String cpf, String rg, String telefone) {
		super(nome, cpf, rg);
		this.telefone = telefone;
	}
	
	/* Getters */
	public String getTelefone() {
		return telefone;
	}
	
	/* Setters */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	/* Methods */
	public List<Cliente> lerTodos() {
		File f = new File(Cliente.ARQUIVO);
		FileInputStream fis;
		List<Cliente> lstClientes = new ArrayList<Cliente>();
		try {
			fis = new FileInputStream(f);
			Scanner scan = new Scanner(fis);
			
			while(scan.hasNext()) {
				String linha = scan.nextLine();
				String arr[] = linha.split(";");
				Cliente clienteAtual = new Cliente(arr[0], arr[1], arr[2], arr[3]);
				lstClientes.add(clienteAtual);
			}
			scan.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Erro ao Gravar");
		}
		return lstClientes;
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+";"+this.telefone;
	}
	
	@Override
	public void salvar() {
		try {
			File f = new File(Cliente.ARQUIVO);
			FileOutputStream fos = new FileOutputStream(f, true);
			String txt = this.toString()+"\n";
			fos.write(txt.getBytes());
			fos.close();
			System.out.println("Gravado com sucesso.");
		} catch (IOException e) {
			System.out.println("Erro ao gravar.");
		}
	}
}
