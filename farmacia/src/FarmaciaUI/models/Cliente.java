package FarmaciaUI.models;

import java.io.Serializable;
import java.util.List;

import FarmaciaUI.Generico;
import farmacia.Funcionario;

public class Cliente extends Pessoa implements Serializable, Comparable<Object>{
	public static Generico generico = new Generico();
	private static final long serialVersionUID = 1L;
	/* Attributes */
	private String telefone;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/cliente.csv";
	public static String ARQUIVO_SERIALIZACAO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/cliente.obj";
	
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
	public static void salvar(Cliente cl) {
		generico.salvarEntidade(cl, Cliente.ARQUIVO_SERIALIZACAO);
	}
	
	public static List<Cliente> lerTodos() throws ClassNotFoundException {
		return generico.lerTodasEntidades(Cliente.ARQUIVO_SERIALIZACAO);
	}
	
	public static void showAll() {
		generico.showLista(Cliente.ARQUIVO_SERIALIZACAO);
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+" Telefone:"+this.telefone;
	}
	
	@Override
	public int compareTo(Object o) {
		return this.getNome().compareTo(((Cliente) o).getNome());
	}
}
