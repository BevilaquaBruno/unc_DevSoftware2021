package FarmaciaUI;

import java.io.File;
import java.util.List;

public interface SerializacaoGenerica {
	public <E> boolean salvarEntidade(E entidade, String strArquivo);
	public <E> List<E> lerTodasEntidades(String strArquivo);
	public <E> boolean salvarListaEntidades(List<E> lstEntidades, String strArquivo);
	public <E> List<E> criarListaVazia(File f);
	<E extends Comparable<E>> void showLista(String strArquivo);
}
