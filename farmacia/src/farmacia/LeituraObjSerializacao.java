package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LeituraObjSerializacao {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();
		Funcionario funcDescerializado = (Funcionario) obj;
		System.out.print(funcDescerializado);
	}

}
