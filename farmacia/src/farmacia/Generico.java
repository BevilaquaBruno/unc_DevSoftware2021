package farmacia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Generico {
	/**
	 * Resolver repeticao de codigo com generics
	 * @param <E>
	 * @param elementos
	 */
	public static <E> void imprimirArray(E[] elementos) {
		for(int i = 0; i < elementos.length; i++) {
			System.out.printf("\nValor: %s: %s", i, elementos[i]);
		}
	}
	
	public static<E> void escreverArquivo(String arquivo, E dados) {
		try {
			File f = new File(arquivo);
			FileOutputStream fos = new FileOutputStream(f, true);
			String txt = dados.toString();
			fos.write(txt.getBytes());
			fos.close();
			System.out.println("Gravado com sucesso.");
		}catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro ao gravar.");
		}
	}
}
