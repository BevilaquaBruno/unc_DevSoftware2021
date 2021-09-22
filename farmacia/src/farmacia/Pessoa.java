package farmacia;

public class Pessoa {
	/* Attributes */
	private String nome;
	private String cpf;
	private String rg;
	
	public Pessoa(String nome, String cpf, String rg) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
	}
	
	/* Getters */
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getRg() {
		return this.rg;
	}
	
	/* Setters */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	/* Methods */
	public void salvar() {
		System.out.println(this.nome + " foi salva.");
	}
	
}