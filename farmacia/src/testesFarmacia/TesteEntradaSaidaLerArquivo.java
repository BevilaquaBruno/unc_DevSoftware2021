package testesFarmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TesteEntradaSaidaLerArquivo {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/bruno/UNC/2_fase/desenvolvimento_software/unc_DevSoftware2021/banco.txt");
		FileInputStream fis = new FileInputStream(f);
		Scanner scan = new Scanner(fis);
		
		while(scan.hasNext()) {
			System.out.println(scan.nextLine());
		}
		
		scan.close();
		fis.close();
	}
}
