package FarmaciaUI.models;

import java.io.Serializable;
import java.util.List;

import FarmaciaUI.Generico;

public class CategoriaProduto implements Serializable, Comparable<Object> {
	public static Generico generico = new Generico();
	private String nome;
	private String icone;
	private static final long serialVersionUID = 2L;
	
	public static String ARQUIVO_SERIALIZACAO = "C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/farmacia/database/2"
			+ ".obj";
	
	public CategoriaProduto(String nome, String icone) {
		this.nome = nome;
		this.icone = icone;
	}
	
	/* Getters */
	public String getNome() {
		return this.nome;
	}
	
	public String getIcone() {
		return this.icone;
	}
	
	/* Setters */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setIcone(String icone) {
		this.icone = icone;
	}
	
	/* Methods */
	public static void salvar(CategoriaProduto cp) {
		generico.salvarEntidade(cp, CategoriaProduto.ARQUIVO_SERIALIZACAO);
	}
	
	public static List<CategoriaProduto> lerTodosCategoriasProdutos() {
		return generico.lerTodasEntidades(CategoriaProduto.ARQUIVO_SERIALIZACAO);
	}

	public static void showCategoriasProdutos() {
		generico.showLista(CategoriaProduto.ARQUIVO_SERIALIZACAO);
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return "Nome: "+this.nome+" Icone: "+this.icone;
	}


	@Override
	public int compareTo(Object o) {
		return this.getNome().compareTo(((CategoriaProduto) o).getNome());
	}
}
