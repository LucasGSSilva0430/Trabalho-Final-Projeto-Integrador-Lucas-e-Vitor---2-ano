package calculadoras;

import util.Validacoes;

public class NumerosPrimos{
	public static void executar(){
		double numero = 0;
		double divisor = 0;
		double resto = 0;
		System.out.println("Digite o valor a ser testado:");
		System.out.println();
		numero = Validacoes.validarDoubleMinimo(1);
		divisor = numero - 1;
		if (numero == 1){
			System.out.printf("%.0f não é primo!\n", numero);
			System.out.println();
		}
		else if (numero == 2){
			System.out.printf("%.0f é primo!\n", numero);
			System.out.println();
		}
		else{
			while (divisor > 1){
				resto = numero % divisor;
				if (resto == 0){
					System.out.printf("%.0f não é primo!\n", numero);
					System.out.println();
					break;
				}
				else{
					divisor = divisor - 1;
				}
				if (divisor == 1){
					System.out.printf("%.0f é primo!\n", numero);
					System.out.println();
				}
			}
		}
	}
}
