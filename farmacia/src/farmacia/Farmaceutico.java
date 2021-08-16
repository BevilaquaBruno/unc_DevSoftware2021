package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Farmaceutico extends Funcionario{
	/* Attributes */
	private String registroAnvisa;
	private static String ARQUIVO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/farmaceutico.csv";
	
	public Farmaceutico(String nome, String cpf, String rg,
		String pis, String pasep, String carteiraTrabalho, String salario,
		String registroAnvisa) {
		super(nome, cpf, rg, pis, pasep, carteiraTrabalho, salario);
		this.registroAnvisa = registroAnvisa;
	}
	
	/* Getters */
	public String getRegistroAnvisa() {
		return registroAnvisa;
	}
	
	/* Setters */
	public void setRegistroAnvisa(String registroAnvisa) {
		this.registroAnvisa = registroAnvisa;
	}
	
	/* Methods */
	public List<Farmaceutico> lerTodos() {
		File f = new File(Farmaceutico.ARQUIVO);
		FileInputStream fis;
		List<Farmaceutico> lstFarmaceuticos = new ArrayList<Farmaceutico>();
		try {
			fis = new FileInputStream(f);
			Scanner scan = new Scanner(fis);
			
			while(scan.hasNext()) {
				String linha = scan.nextLine();
				String arr[] = linha.split(";");
				Farmaceutico farmaceuticoAtual = new Farmaceutico(arr[0], arr[1], arr[2], arr[3],
					arr[4], arr[5], arr[6], arr[7]);
				lstFarmaceuticos.add(farmaceuticoAtual);
			}
			scan.close();
			fis.close();
		} catch (IOException e) {
			System.out.println("Erro ao Gravar");
		}
		return lstFarmaceuticos;
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return super.toString()+";"+this.registroAnvisa;
	}
	
	@Override
	public void salvar() {
		try {
			File f = new File(Farmaceutico.ARQUIVO);
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
