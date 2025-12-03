package calculadoras;

import util.Validacoes;

public class Logaritmo{
	public static void executar(){
		double a = 0;
		double b = 0;
		double c = 0;
		System.out.println("Digite o valor a (logaritmando):");
		System.out.println();
		a = Validacoes.validarDoubleMinimo(1);
		System.out.println("Digite o valor b (base):");
		System.out.println();
		b = Validacoes.validarDoubleMinimo(2);
		c = Math.log(a) / Math.log(b);
		System.out.printf("Resultado: log_%.0f(%.0f) = %.1f", b, a, c);
		System.out.println();
	}
}

