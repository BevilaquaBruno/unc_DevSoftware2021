package farmacia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class PrincipalAtvSerializacao {

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
		/* Pegando lista de funcion�rios */
		List<Funcionario> funcListCsv = Funcionario.lerTodosFuncionarios();
		System.out.println("Funcion�rios pegos do csv.");
		System.out.println("---------------------------------------");
		File f = new File(Funcionario.ARQUIVO_SERIALIZACAO);

		/* Serializar lista de Funcion�rios */
		FileOutputStream fos = new FileOutputStream(f);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(funcListCsv);
		}
		System.out.println("Funcion�rios serializados.");
		System.out.println("---------------------------------------");
		/* Ler Arquivo Serializado */
		FileInputStream fis = new FileInputStream(f);
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			List<Funcionario> funcListSerialized = (List<Funcionario>) ois.readObject();
			System.out.println("Funcion�rios depois de serializado: ");
			System.out.println(funcListSerialized);
			System.out.println("---------------------------------------");	
			for (Funcionario funcionario : funcListSerialized) {
				System.out.print("To String do funcion�rio da lista: ");
				System.out.println(funcionario.toString());
			}
		}
	}

}
