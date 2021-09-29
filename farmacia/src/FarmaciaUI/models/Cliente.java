package FarmaciaUI.models;

import java.io.Serializable;
import java.util.List;

import FarmaciaUI.Generico;
import FarmaciaUI.dao.ClienteDao;
import farmacia.Funcionario;

public class Cliente extends Pessoa implements Serializable, Comparable<Object>{
	public static Generico generico = new Generico();
	private static ClienteDao clienteDAO = new ClienteDao();
	private static final long serialVersionUID = 1L;
	/* Attributes */
	private Integer id;
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
	
	public Integer getId() {
		return this.id;
	}
	
	/* Setters */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* Methods */
	public static void salvar(Cliente cl) {
		//generico.salvarEntidade(cl, Cliente.ARQUIVO_SERIALIZACAO);
		clienteDAO.inserir(cl);
	}

	public static void atualizar(Cliente cl) {
		clienteDAO.atualizar(cl);
	}	

	public static void remover(Integer id) {
		clienteDAO.remover(id);
	}
	
	public static void show(Integer id) {
		Cliente c = clienteDAO.encontreId(id);
		System.out.println(c);
	}
	
	public static List<Cliente> lerTodos() throws ClassNotFoundException {
		//return generico.lerTodasEntidades(Cliente.ARQUIVO_SERIALIZACAO);
		List<Cliente> lstResult = clienteDAO.listarTodos();
		lstResult.sort(null);
		return lstResult;
	}
	
	public static void showAll() {
		List<Cliente> lstResult = clienteDAO.listarTodos();
		lstResult.sort(null);
		for (Cliente cl : lstResult) {
			System.out.println(cl);
		}
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return "id: "+this.id+" "+super.toString()+" Telefone:"+this.telefone;
	}
	
	@Override
	public int compareTo(Object o) {
		return this.getNome().compareTo(((Cliente) o).getNome());
	}
}
