package farmacia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EscritaObjSerializacao {

	public static void main(String[] args) throws IOException {
		Funcionario func = new Funcionario("Bruno1", "10341172979", "6899388", "21312", "5555", "rrr", "1000");
		
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);
		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(func);
		}
	}

}
