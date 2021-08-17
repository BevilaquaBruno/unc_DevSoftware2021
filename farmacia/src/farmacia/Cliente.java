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
	public List<Cliente> lerTodosClientes() {
		List<Cliente> lstClientes = new ArrayList<Cliente>();
		List<String[]> lstGeneric = Generico.lerArquivo(Cliente.ARQUIVO);
		for (String[] g : lstGeneric) {
			Cliente clienteAtual = new Cliente(g[0], g[1], g[2], g[3]);
			lstClientes.add(clienteAtual);
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
		Generico.escreverArquivo(Cliente.ARQUIVO, this);
	}
}
