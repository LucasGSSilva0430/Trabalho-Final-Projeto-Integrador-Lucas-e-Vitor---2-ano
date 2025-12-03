package calculadoras;

import util.Validacoes;

public class Bhaskara{
	public static void executar(){
		double a = 0;
		double b = 0;
		double c = 0;
		double delta = 0;
		double x1 = 0;
		double x2 = 0;
		System.out.println("Digite o valor a:");
		System.out.println();
		a = Validacoes.validarDoubleDiferente(0);
		System.out.println("Digite o valor b:");
		System.out.println();
		b = Validacoes.validarDouble();
		System.out.println("Digite o valor c:");
		System.out.println();
		c = Validacoes.validarDouble();
		delta = (Math.pow(b, 2)) - (4 * a * c);
		if (delta >= 0){
			x1 = (-b + Math.sqrt(delta)) / (2 * a);
			x2 = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("Resultado:");
			System.out.printf("x1 = %.1f\n", x1);
			System.out.printf("x2 = %.1f\n", x2);
			System.out.println();
		}
		else{
			System.out.println("Resultado:");
			System.out.println("x1 = -(" + b + ") + sqrt(" + delta + ") / 2 · " + a);
			System.out.println("x2 = -(" + b + ") - sqrt(" + delta + ") / 2 · " + a);
			System.out.println();
		}
	}
}

