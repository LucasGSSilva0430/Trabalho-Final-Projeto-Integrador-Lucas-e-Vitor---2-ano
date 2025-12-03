package calculadoras;

import util.Validacoes;

public class GeometriaPlana{
	public static void executar(){
		int input = 0;
		double n = 0;
		double L = 0;
		double d = 0;
		double D = 0;
		double r = 0;
		double b = 0;
		double h = 0;
		double B = 0;
		double A = 0;
		System.out.println("Qual destes você deseja executar (insira o número correspondente):");
		System.out.println();
		System.out.println("1. Calcular um triângulo");
		System.out.println("2. Calcular um quadrado/retângulo");
		System.out.println("3. Calcular um losango");
		System.out.println("4. Calcular um trapézio");
		System.out.println("5. Calcular um polígono regular");
		System.out.println("6. Calcular um círculo");
		System.out.println();
		input = Validacoes.validarOpcoes(1, 6);
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println("              Observação:");
		System.out.println();
		System.out.println(" Só serão aceitos valores maiores que 0");
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println();
		switch (input){
			case 1:
				System.out.println("Digite a base:");
				System.out.println();
				b = Validacoes.validarDoubleMaior(0);
				System.out.println("Digite a altura:");
				System.out.println();
				h = Validacoes.validarDoubleMaior(0);
				A = (b * h) / 2;
				System.out.printf("Área = %.1f\n", A);
				break;
			case 2:
				System.out.println("Digite a base:");
				System.out.println();
				b = Validacoes.validarDoubleMaior(0);
				System.out.println("Digite a altura:");
				System.out.println();
				h = Validacoes.validarDoubleMaior(0);
				A = b * h;
				System.out.printf("Área = %.1f\n", A);
				break;
			case 3:
				System.out.println("Quais dados você têm (insira o número correspondente):");
				System.out.println();
				System.out.println("1. As diagonais");
				System.out.println("2. O lado e a altura");
				System.out.println();
				input = Validacoes.validarOpcoes(1, 2);
				switch (input){
					case 1:
						System.out.println("Digite a diagonal maior:");
						System.out.println();
						D = Validacoes.validarDoubleMaior(0);
						System.out.println("Digite a diagonal menor:");
						System.out.println();
						d = Validacoes.validarDoubleMaior(0);
						A = (D * d) / 2;
						System.out.printf("Área = %.1f\n\n", A);
						break;
					case 2:
						System.out.println("Digite o lado:");
						System.out.println();
						L = Validacoes.validarDoubleMaior(0);
						System.out.println("Digite a altura:");
						System.out.println();
						h = Validacoes.validarDoubleMaior(0);
						A = L * h;
						System.out.printf("Área = %.1f\n", A);
						break;
				}
				break;
			case 4:
				System.out.println("Digite a base maior:");
				System.out.println();
				B = Validacoes.validarDoubleMaior(0);
				System.out.println("Digite a base menor:");
				System.out.println();
				b = Validacoes.validarDoubleMaior(0);
				System.out.println("Digite a altura:");
				System.out.println();
				h = Validacoes.validarDoubleMaior(0);
				A = ((B + b) * h) / 2;
				System.out.printf("Área = %.1f\n", A);
				break;
			case 5:
				System.out.println("Digite a quantidade de lados:");
				System.out.println();
				n = Validacoes.validarDoubleMaior(0);
				System.out.println("Digite o tamanho de um lado:");
				System.out.println();
				L = Validacoes.validarDoubleMaior(0);
				A = (n * Math.pow(L, 2)) / (4 * Math.tan(Math.PI / n));
				System.out.printf("Área = %.1f\n", A);
				break;
			case 6:
				System.out.println("Digite o raio:");
				System.out.println();
				r = Validacoes.validarDoubleMaior(0);
				A = Math.PI * Math.pow(r, 2);
				System.out.printf("Área = %.1f\n", A);
				break;
		}
	}
}
