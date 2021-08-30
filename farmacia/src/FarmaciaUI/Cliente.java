package FarmaciaUI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import farmacia.Funcionario;

public class Cliente extends Pessoa {
	/**
	 * 
	 */
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
	public static void salvar(Cliente cl) throws IOException, FileNotFoundException, ClassNotFoundException {
		List<Cliente> clieList = Cliente.lerTodosClientes();
		clieList.add(cl);
		File f = new File(Cliente.ARQUIVO_SERIALIZACAO);

		/* Serializar lista de Funcionários */
		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(clieList);
		}
		System.out.println("O cliente foi salvo!");
	}
	
	public static List<Cliente> lerTodosClientes() throws IOException, FileNotFoundException, ClassNotFoundException {
		File f = new File(Cliente.ARQUIVO_SERIALIZACAO);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		return (List<Cliente>) ois.readObject();
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+";"+this.telefone;
	}
}
