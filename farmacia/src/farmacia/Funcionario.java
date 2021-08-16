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
	private String salario;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/funcionario.csv";
	
	/* Constructor */
	public Funcionario (String nome, String cpf, String rg,
			String pis, String pasep, String carteiraTrabalho, String salario) {
		super(nome, cpf, rg);
		this.pis = pis;
		this.pasep = pasep;
		this.carteiraTrabalho = carteiraTrabalho;
		this.salario = salario;
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
	
	public String getSalario() {
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
		this.salario = salario;
	}
	
	/* Methods */
	public List<Funcionario> lerTodosF() {
		File f = new File(Funcionario.ARQUIVO);
		FileInputStream fis;
		List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();
		try {
			fis = new FileInputStream(f);
			Scanner scan = new Scanner(fis);
			
			while(scan.hasNext()) {
				String linha = scan.nextLine();
				String arr[] = linha.split(";");
				Funcionario funcionarioAtual = new Funcionario(arr[0], arr[1], arr[2], arr[3],
					arr[4], arr[5], arr[6]);
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
		try {
			File f = new File(Funcionario.ARQUIVO);
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
