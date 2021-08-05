package farmacia;

public class Principal {

	public static void main(String[] args) {
		Farmaceutico f = new Farmaceutico();
		f.setNome("Maria");
		f.salvar();
		System.out.println(f.getNome());
	}

}
