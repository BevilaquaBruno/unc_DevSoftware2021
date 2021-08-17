package farmacia;

import java.io.IOException;
import java.util.List;

public class Principal {

	public static void main(String[] args) throws IOException {
		String[] lst = {"Brunoaa", "103.411.729-79", "6899388", "tere", "1", "444", "555555", "aaaaa"}; 
		Farmaceutico p = new Farmaceutico(lst[0],lst[1], lst[2], lst[3], lst[4], lst[5], lst[6], lst[7]);
		p.salvar();
		List<Farmaceutico> pl = p.lerTodosFarmaceuticos();
		for (Farmaceutico pi : pl) {
			System.out.println(pi.toString());
		}
	}
}
