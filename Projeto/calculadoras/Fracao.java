package calculadoras;

import util.Validacoes;
import util.MetodosAuxiliares;

public class Fracao{
	public static void executar(){
		int input = 0;
		double a = 0;
		double b = 0;
		double x = 0;
		double y = 0;
		double numerador = 0;
		double denominador = 0;
		double mdc = 0;
		System.out.println("Qual destes você deseja executar (insira o número correspondente):");
		System.out.println();
		System.out.println("1. Adição");
		System.out.println("2. Subtração");
		System.out.println("3. Multiplicação");
		System.out.println("4. Divisão");
		System.out.println();
		input = Validacoes.validarOpcoes(1, 4);
		System.out.println("Digite o valor a (numerador 1):");
		System.out.println();
		a = Validacoes.validarDouble();
		System.out.println("Digite o valor b (denominador 1):");
		System.out.println();
		b = Validacoes.validarDouble();
		System.out.println("Digite o valor x (numerador 2):");
		System.out.println();
		x = Validacoes.validarDouble();
		System.out.println("Digite o valor y (denominador 2):");
		System.out.println();
		y = Validacoes.validarDouble();
		switch (input){
			case 1:
				numerador = a * y + x * b;
				denominador = b * y;
				break;
			case 2:
				numerador = a * y - x * b;
				denominador = b * y;
				break;
			case 3:
				numerador = a * x;
				denominador = b * y;
				break;
			case 4:
				numerador = a * y;
				denominador = b * x;
				break;
		}
		mdc = MetodosAuxiliares.mdc(Math.abs(numerador), Math.abs(denominador));
		numerador /= mdc;
		denominador /= mdc;
		System.out.printf("Resultado: %.1f/%.1f\n", numerador, denominador);
		System.out.println();
	}
}
