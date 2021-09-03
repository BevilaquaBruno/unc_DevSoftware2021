package FarmaciaUI;

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
	public static void salvar(Funcionario func) throws IOException, FileNotFoundException, ClassNotFoundException {
		List<Funcionario> funcList = Funcionario.lerTodosFuncionarios();
		funcList.add(func);
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);

		/* Serializar lista de Funcionários */
		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(funcList);
		}
		System.out.println("O funcionário foi salvo!");
	}
	
	public static List<Funcionario> lerTodosFuncionarios() throws ClassNotFoundException {
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);
		FileInputStream fis;
		try {
			try {
				fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				return (List<Funcionario>) ois.readObject();
			} catch (FileNotFoundException e) {
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				List<Funcionario> fc = new ArrayList();
				return fc;
			}
		} catch (IOException e) {
			List<Funcionario> fc = new ArrayList();
			return fc;
		}
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+" PIS:"+this.pis+" PASEP:"+this.pasep+" Carteira Trabalho:"+this.carteiraTrabalho+" Salário:"+this.salario;
	}
}
