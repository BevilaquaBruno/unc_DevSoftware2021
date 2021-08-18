package recursividade;

public class Fatorial {

	public static void main(String[] args) {
		double num = 5;
		double result = getFatorial(num);
		System.out.println("O fatorial é: "+result);
		System.out.println("A chance de ganhar na megasena é: "+(getFatorial(60) / (getFatorial(6) * getFatorial(54))));
	}
	
	public static double getFatorial(double valor) {
		if(valor == 1)
			return valor;
		return valor * getFatorial(valor-1);
	}

}
