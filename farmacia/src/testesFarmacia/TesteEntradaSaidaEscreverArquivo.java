package testesFarmacia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteEntradaSaidaEscreverArquivo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/banco.txt");
		FileOutputStream fos = new FileOutputStream(f, true);
		String txt = "Teste bruno bevilaqua \n";
		fos.write(txt.getBytes());
		
		fos.close();
	}
}
