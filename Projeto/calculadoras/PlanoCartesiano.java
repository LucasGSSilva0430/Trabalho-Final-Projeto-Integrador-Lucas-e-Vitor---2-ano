package calculadoras;

import util.Validacoes;

public class PlanoCartesiano{
	public static void executar(){
		int input = 0;
		double b = 0;
		double x1 = 0;
		double x2 = 0;
		System.out.println("Qual destes você deseja executar (insira o número correspondente):");
		System.out.println();
		System.out.println("1. Equação da reta (dados dois pontos)");
		System.out.println("2. Equação da parábola (dados coeficientes a, b, c)");
		System.out.println();
		input = Validacoes.validarOpcoes(1, 2);
		switch (input){
			case 1:
				double y1 = 0;
				double y2 = 0;
				double distancia = 0;
				double m = 0;
				System.out.println("Digite o valor de x1:");
				System.out.println();
				x1 = Validacoes.validarDouble();
				System.out.println("Digite o valor de y1:");
				System.out.println();
				y1 = Validacoes.validarDouble();
				System.out.println("Digite o valor de x2:");
				System.out.println();
				x2 = Validacoes.validarDouble();
				System.out.println("Digite o valor de y2:");
				System.out.println();
				y2 = Validacoes.validarDouble();
				distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
				System.out.printf("Distância entre os pontos: %.2f\n", distancia);
				if (x1 == x2){
					System.out.println("A reta é vertical: x = " + x1);
				}
				else{
					m = (y2 - y1) / (x2 - x1);
					b = y1 - m * x1;
					System.out.printf("Equação da reta: y = %.2fx + %.2f\n", m, b);
				}
				break;
			case 2:
				double a = 0;
				double c = 0;
				double x = 0;
				double xv = 0;
				double yv = 0;
				double delta = 0;
				System.out.println("Digite o coeficiente a:");
				System.out.println();
				a = Validacoes.validarDoubleDiferente(0);
				System.out.println("Digite o coeficiente b:");
				System.out.println();
				b = Validacoes.validarDouble();
				System.out.println("Digite o coeficiente c:");
				System.out.println();
				c = Validacoes.validarDouble();
				System.out.printf("Equação da parábola: y = %.1fx² + %.1fx + %.1f\n", a, b, c);
				System.out.println();
				delta = (Math.pow(b, 2)) - (4 * a * c);
				xv = -b / (2 * a);
				yv = -delta / (4 * a);
				System.out.printf("Vértice: (%.2f, %.2f)\n", xv, yv);
				if (a < 0){
					System.out.printf("A parábola tem a concavidade voltada para baixo e o vértice é um ponto de máximo.");
					System.out.println();
				}
				else{
					System.out.printf("a parábola tem a concavidade voltada para cima e o vértice é um ponto de mínimo.");
					System.out.println();
				}
				System.out.println();
				if (delta > 0){
					x1 = (-b + Math.sqrt(delta)) / (2 * a);
					x2 = (-b - Math.sqrt(delta)) / (2 * a);
					System.out.printf("Raízes reais: x1 = %.2f, x2 = %.2f\n", x1, x2);
					System.out.println();
				}
				else if (delta == 0){
					x = -b / (2 * a);
					System.out.printf("Raiz única: x = %.2f\n", x);
					System.out.println();
				}
				else {
					System.out.println("Não existem raízes reais (delta < 0).");
					System.out.println();
				}
		}
	}
}
