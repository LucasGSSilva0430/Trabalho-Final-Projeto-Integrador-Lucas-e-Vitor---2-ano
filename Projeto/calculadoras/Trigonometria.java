package calculadoras;

import util.Validacoes;

public class Trigonometria{
	public static void executar(){
		boolean testador = true;
		int input = 0;
		double c1 = 0;
		double c2 = 0;
		double h = 0;
		double angulo = 0;
		double rad = 0;
		System.out.println("Qual destes você deseja executar (insira o número correspondente):");
		System.out.println();
		System.out.println("1. Calcular seno, cosseno e tangente de um ângulo");
		System.out.println("2. Calcular um lado desconhecido de um triângulo retângulo a partir de dois lados conhecidos e seu seno, cosseno e tangente");
		System.out.println("3. Calcular um valor desconhecido de um triângulo usando uma razão trigonométrica");
		System.out.println();
		input = Validacoes.validarOpcoes(1, 3);
		switch (input){
			case 1:
				System.out.println("Digite o ângulo:");
				System.out.println();
				angulo = Validacoes.validarDoubleMaior(0);
				rad = Math.toRadians(angulo);
				System.out.printf("sen(%.1f°) = %.4f\n", angulo, Math.sin(rad));
				System.out.printf("cos(%.1f°) = %.4f\n", angulo, Math.cos(rad));
				System.out.printf("tan(%.1f°) = %.4f\n", angulo, Math.tan(rad));
				break;
			case 2:
				do{
					System.out.println("----------------------------------------------------------------------------");
					System.out.println();
					System.out.println("                                Observações:");
					System.out.println();
					System.out.println("  O lado desconhecido deve ser igual à 0;");
					System.out.println("  Somente um lado deve ser igual à 0, os outros devem ser valores positivos");
					System.out.println();
					System.out.println("----------------------------------------------------------------------------");
					System.out.println();
					System.out.println("Digite o valor do cateto adjacente:");
					System.out.println();
					c1 = Validacoes.validarDoubleMinimo(0);
					System.out.println("Digite o valor do cateto oposto:");
					System.out.println();
					c2 = Validacoes.validarDoubleMinimo(0);
					System.out.println("Digite o valor da hipotenusa:");
					System.out.println();
					h = Validacoes.validarDoubleMinimo(0);
					if ((c1 == 0 && c2 == 0) || (c1 == 0 && h == 0) || (c2 == 0 && h == 0) || (c1 > 0 && c2 > 0 && h > 0)){
						System.out.println("Erro: mais de um lado igual à 0 ou nenhum lado igual à 0");
						System.out.println("Por favor, tente novamente");
						System.out.println();
					}
					else{
						testador = false;
					}
				} while (testador == true);
				if (c1 == 0){
					c1 = Math.sqrt(Math.pow(h, 2) - Math.pow(c2, 2));
					System.out.printf("Cateto adjacente = %.1f\n", c1);
					System.out.println();
					System.out.printf("sen = %.3f\n", c2/h);
					System.out.printf("cos = %.3f\n", c1/h);
					System.out.printf("tg = %.3f\n", c2/c1);
				}
				else if (c2 == 0){
					c2 = Math.sqrt(Math.pow(h, 2) - Math.pow(c1, 2));
					System.out.printf("Cateto oposto = %.1f\n", c2);
					System.out.println();
					System.out.printf("sen = %.3f\n", c2/h);
					System.out.printf("cos = %.3f\n", c1/h);
					System.out.printf("tg = %.3f\n", c2/c1);
				}
				else{
					h = Math.sqrt(Math.pow(c1, 2) + Math.pow(c2, 2));
					System.out.printf("Hipotenusa = %.1f\n", h);
					System.out.println();
					System.out.printf("sen = %.3f\n", c2/h);
					System.out.printf("cos = %.3f\n", c1/h);
					System.out.printf("tg = %.3f\n", c2/c1);
				}
				break;
			case 3:
				System.out.println("O que você deseja calcular (insira o número correspondente):");
				System.out.println();
				System.out.println("1. Um lado (catetos ou hipotenusa)");
				System.out.println("2. Uma razão (sen, cos ou tg)");
				System.out.println();
				input = Validacoes.validarOpcoes(1, 2);
				switch (input){
					case 1:
						System.out.println("Qual lado você deseja calcular (insira o número correspondente):");
						System.out.println();
						System.out.println("1. Cateto adjacente");
						System.out.println("2. Cateto oposto");
						System.out.println("3. Hipotenusa");
						System.out.println();
						input = Validacoes.validarOpcoes(1, 3);
						switch (input){
							case 1:
								System.out.println("Qual razão você deseja utilizar (insira o número correspondente):");
								System.out.println();
								System.out.println("1. Cosseno");
								System.out.println("2. Tangente");
								System.out.println();
								input = Validacoes.validarOpcoes(1, 2);
								switch (input){
									case 1:
										System.out.println("Digite o valor da hipotenusa:");
										System.out.println();
										h = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										c1 = Math.cos(rad) * h;
										System.out.printf("Cateto adjacente = %.2f\n", c1);
										break;
									case 2:
										System.out.println("Digite o valor do cateto oposto:");
										System.out.println();
										c2 = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										c1 = c2 / Math.tan(rad);
										System.out.printf("Cateto adjacente = %.2f\n", c1);
										break;
								}
								break;
							case 2:
								System.out.println("Qual razão você deseja utilizar (insira o número correspondente):");
								System.out.println();
								System.out.println("1. Seno");
								System.out.println("2. Tangente");
								System.out.println();
								input = Validacoes.validarOpcoes(1, 2);
								switch (input){
									case 1:
										System.out.println("Digite o valor da hipotenusa:");
										System.out.println();
										h = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										c2 = Math.sin(rad) * h;
										System.out.printf("Cateto oposto = %.2f\n", c2);
										break;
									case 2:
										System.out.println("Digite o valor do cateto adjacente:");
										System.out.println();
										c1 = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										c2 = Math.tan(rad) * c1;
										System.out.printf("Cateto oposto = %.2f\n", c2);
										break;
								}
								break;
							case 3:
								System.out.println("Qual razão você deseja utilizar (insira o número correspondente):");
								System.out.println();
								System.out.println("1. Seno");
								System.out.println("2. Cosseno");
								System.out.println();
								input = Validacoes.validarOpcoes(1, 2);
								switch (input){
									case 1:
										System.out.println("Digite o valor do cateto oposto:");
										System.out.println();
										c2 = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										h = c2 / Math.sin(rad);
										System.out.printf("Hipotenusa = %.2f\n", h);
										break;
									case 2:
										System.out.println("Digite o valor do cateto adjacente:");
										System.out.println();
										c1 = Validacoes.validarDoubleMaior(0);
										System.out.println("Digite o valor do ângulo em graus:");
										System.out.println();
										angulo = Validacoes.validarDoubleMaior(0);
										rad = Math.toRadians(angulo);
										h = c1 / Math.cos(rad);
										System.out.printf("Hipotenusa = %.2f\n", h);
										break;
								}
								break;
						}
						break;
					case 2:
						System.out.println("Qual razão você deseja calcular (insira o número correspondente):");
						System.out.println();
						System.out.println("1. Seno");
						System.out.println("2. Cosseno");
						System.out.println("3. Tangente");
						System.out.println();
						input = Validacoes.validarOpcoes(1, 3);
						switch (input){
							case 1:
								System.out.println("Digite o valor do cateto oposto:");
								System.out.println();
								c2 = Validacoes.validarDoubleMaior(0);
								System.out.println("Digite o valor da hipotenusa:");
								System.out.println();
								h = Validacoes.validarDoubleMaior(0);
								System.out.printf("sen = %.3f\n", c2/h);
								break;
							case 2:
								System.out.println("Digite o valor do cateto adjacente:");
								System.out.println();
								c1 = Validacoes.validarDoubleMaior(0);
								System.out.println("Digite o valor da hipotenusa:");
								System.out.println();
								h = Validacoes.validarDoubleMaior(0);
								System.out.printf("cos = %.3f\n", c1/h);
								break;
							case 3:
								System.out.println("Digite o valor do cateto oposto:");
								System.out.println();
								c2 = Validacoes.validarDoubleMaior(0);
								System.out.println("Digite o valor do cateto adjacente:");
								System.out.println();
								c1 = Validacoes.validarDoubleMaior(0);
								System.out.printf("tg = %.3f\n", c2/c1);
								break;
						}
						break;
				}
		}
	}
}
