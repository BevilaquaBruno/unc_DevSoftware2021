package farmacia;

import java.io.IOException;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] lst = {"Bruno Fernando Bevilaqua22", "103411.729-79", "689938", "12345", "13", "444555", "12441"}; 
		Funcionario f = new Funcionario(lst[0],lst[1], lst[2], lst[3], lst[4], lst[5], lst[6]);
		f.salvar();
		Funcionario.serialize();
		Funcionario.unserialize();
	}
}
