package calculadoras;

import util.Validacoes;

public class Potenciacao{
	public static void executar(){
		double a = 0;
		double b = 0;
		System.out.println("Digite o valor a (base):");
		System.out.println();
		a = Validacoes.validarDouble();
		System.out.println("Digite o valor b (expoente):");
		System.out.println();
		b = Validacoes.validarDouble();
		System.out.println("Resultado: " + Math.pow(a, b));
	}
}
