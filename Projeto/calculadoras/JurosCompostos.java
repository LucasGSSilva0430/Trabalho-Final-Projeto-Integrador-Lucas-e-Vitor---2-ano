package calculadoras;

import util.Validacoes;

public class JurosCompostos{
	public static void executar(){
		double juros = 0;
		double P = 0;
		double i = 0;
		double t = 0;
		double M = 0;
		System.out.println("Digite o capital (P):");
		System.out.println();
		P = Validacoes.validarDoubleMinimo(1);
		System.out.println("Digite a taxa (i):");
		System.out.println();
		i = Validacoes.validarDoubleMinimo(1);
		System.out.println("Digite o tempo (t):");
		System.out.println();
		t = Validacoes.validarDoubleMinimo(1);
		i = i / 100;
		M = P * Math.pow((1 + i), t);
		juros = M - P;
		System.out.printf("Juros: %.2f\n", juros);
		System.out.printf("Montante final: %.2f\n", M);
		System.out.println();
	}
}
