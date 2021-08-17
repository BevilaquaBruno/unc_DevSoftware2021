package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa{
	/* Attributes */
	private String pis;
	private String pasep;
	private String carteiraTrabalho;
	private Double salario;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/funcionario.csv";
	
	/* Constructor */
	public Funcionario (String a[]) {
		super(a[0], a[1], a[2]);
		this.pis = a[3];
		this.pasep = a[4];
		this.carteiraTrabalho = a[5];
		this.salario = Double.parseDouble(a[6]);
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
	public List<Funcionario> lerTodosFuncionarios() {
		File f = new File(Funcionario.ARQUIVO);
		FileInputStream fis;
		List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();
		try {
			fis = new FileInputStream(f);
			Scanner scan = new Scanner(fis);
			
			while(scan.hasNext()) {
				String linha = scan.nextLine();
				String arr[] = linha.split(";");
				Funcionario funcionarioAtual = new Funcionario(arr);
				lstFuncionarios.add(funcionarioAtual);
			}
			scan.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Erro ao Gravar");
		}
		return lstFuncionarios;
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
