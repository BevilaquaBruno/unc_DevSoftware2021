package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Attributes */
	private String pis;
	private String pasep;
	private String carteiraTrabalho;
	private Double salario;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/funcionario.csv";
	public static String ARQUIVO_SERIALIZACAO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/funcionario.obj";
	
	/* Constructor */
	public Funcionario (String nome,String cpf, String rg,
			String pis, String pasep, String carteiraTrabalho, String salario) {
		super(nome, cpf, rg);
		this.pis = pis;
		this.pasep = pasep;
		this.carteiraTrabalho = carteiraTrabalho;
		this.salario = Double.parseDouble(salario);
	}
	
	/* Getters */
	public String getPis() {
		return this.pis;
	}
	
	public String getPasep() {
		return this.pasep;
	}
	
	public String getCarteiraTrabalho() {
		return this.carteiraTrabalho;
	}
	
	public Double getSalario() {
		return this.salario;
	}
	
	/* Setters */
	public void setPis(String pis) {
		this.pis = pis;
	}
	
	public void setPasep(String pasep) {
		this.pasep = pasep;
	}
	
	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}
	
	public void setSalario(String salario) {
		this.salario = Double.parseDouble(salario);
	}
	
	/* Methods */
	public static List<Funcionario> lerTodosFuncionarios() {
		List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();
		List<String[]> lstGeneric = Generico.lerArquivo(Funcionario.ARQUIVO);
		for (String[] g : lstGeneric) {
			Funcionario funcionarioAtual = new Funcionario(g[0], g[1], g[2], g[3], g[4], g[5], g[6]);
			lstFuncionarios.add(funcionarioAtual);
		}
		return lstFuncionarios;	
	}

	public static void serialize() throws IOException, FileNotFoundException {
		/* Pegando lista de funcionários */
		List<Funcionario> funcListCsv = Funcionario.lerTodosFuncionarios();
		System.out.println("Funcionários pegos do csv.");
		System.out.println("---------------------------------------");
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);

		/* Serializar lista de Funcionários */
		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(funcListCsv);
		}
	}
	
	public static void unserialize() throws IOException, FileNotFoundException, ClassNotFoundException {
		System.out.println("Funcionários serializados.");
		System.out.println("---------------------------------------");
		/* Ler Arquivo Serializado */
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);
		FileInputStream fis = new FileInputStream(f);
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			List<Funcionario> funcListSerialized;
			try {
				funcListSerialized = (List<Funcionario>) ois.readObject();
				System.out.println("Funcionários depois de serializado: ");
				System.out.println(funcListSerialized);
				System.out.println("---------------------------------------");	
				for (Funcionario funcionario : funcListSerialized) {
					System.out.print("To String do funcionário da lista: ");
					System.out.println(funcionario.toString());
				}
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+";"+this.pis+";"+this.pasep+";"+this.carteiraTrabalho+";"+this.salario;
	}
	
	@Override
	public void salvar() {
		Generico.escreverArquivo(Funcionario.ARQUIVO, this);
	}
}
