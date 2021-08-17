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
	public List<Funcionario> lerTodosFuncionarios() {
		List<Funcionario> lstFuncionarios = new ArrayList<Funcionario>();
		List<String[]> lstGeneric = Generico.lerArquivo(Funcionario.ARQUIVO);
		for (String[] g : lstGeneric) {
			Funcionario funcionarioAtual = new Funcionario(g[0], g[1], g[2], g[3], g[4], g[5], g[6]);
			lstFuncionarios.add(funcionarioAtual);
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
