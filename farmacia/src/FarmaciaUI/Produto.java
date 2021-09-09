package FarmaciaUI;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String codBarra;
	private String lote;
	private Date dataFabricacao;
	private Date dataValidade;
	private Float valor;
	private Integer idadeMinima;
	private Integer idadeMaxima;
	private CategoriaProduto categoriaProduto;
	
	public Produto(String codBarra, String lote, Date dataFabricacao, Date dataValidade, Float valor, Integer idadeMinima, Integer idadeMaxima, CategoriaProduto categoriaproduto) {
		this.setCodBarra(codBarra);
		this.setLote(lote);
		this.setDataFabricacao(dataFabricacao);
		this.setDataValidade(dataValidade);
		this.setValor(valor);
		this.setIdadeMinima(idadeMinima);
		this.setIdadeMaxima(idadeMaxima);
		this.setCategoriaProduto(categoriaproduto);
	}

	public String getCodBarra() {
		return codBarra;
	}

	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getIdadeMinima() {
		return idadeMinima;
	}

	public void setIdadeMinima(Integer idadeMinima) {
		this.idadeMinima = idadeMinima;
	}

	public Integer getIdadeMaxima() {
		return idadeMaxima;
	}

	public void setIdadeMaxima(Integer idadeMaxima) {
		this.idadeMaxima = idadeMaxima;
	}
	
	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	
	/* Overrides */
	@Override
	public String toString() {
		return "C�d. Barra: "+this.codBarra+" Lote: "+this.lote+" Fab.: "+this.dataFabricacao.toString()
			+" Validade: "+this.dataValidade.toString()+" Valor: "+this.valor
			+" Idade M�nima: "+this.idadeMinima+ " idade M�xima: "+this.idadeMaxima;
	}
}
