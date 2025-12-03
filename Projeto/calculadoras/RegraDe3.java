package calculadoras;

import util.Validacoes;

public class RegraDe3{
	public static void executar(){
		int input = 0;
		double a = 0;
		double b = 0;
		double c = 0;
		double x = 0;
		System.out.println("Qual destes você deseja executar (insira o número correspondente):");
		System.out.println();
		System.out.println("1. Regra de três direta");
		System.out.println("2. Regra de três inversa");
		System.out.println();
		input = Validacoes.validarOpcoes(1, 2);
		System.out.println("Digite o valor a:");
		System.out.println();
		a = Validacoes.validarDouble();
		System.out.println("Digite o valor b:");
		System.out.println();
		b = Validacoes.validarDouble();
		System.out.println("Digite o valor c:");
		System.out.println();
		c = Validacoes.validarDouble();
		switch (input){
			case 1:
				x = c * b / a;
				break;
			case 2:
				x = a * b / c;
				break;
		}
		System.out.printf("Resultado: x = %.1f\n", x);
		System.out.println();
	}
}
