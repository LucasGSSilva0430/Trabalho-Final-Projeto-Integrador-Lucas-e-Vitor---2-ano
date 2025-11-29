import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Conteudo{
	String nome;
	File texto;

	static ArrayList<String> nomesConteudos = new ArrayList<>();
	static ArrayList<File> textosConteudos = new ArrayList<>();
	static ArrayList<Integer> contador = new ArrayList<>();
	static Integer select;
	static Scanner sc = new Scanner(System.in);

	public Conteudo(String nome, File texto){
		if (nome.length() > 2) {
			this.nome = nome;
			this.texto = texto;
			nomesConteudos.add(nome);
			textosConteudos.add(texto);
		}
		else {
			System.out.println("Nome inválido");
			System.out.println("Texto não registrado devido à invalidez do nome");
		}
	}

	public static void interface1(Map<Integer, Runnable> experimentos){
		boolean testador = true;
		System.out.println("Olá! Este é um programa de revisão/resolução de conteúdos de matemática.");
		do{
			System.out.println("No momento, estes são os conteúdos disponíveis:");
			System.out.println();
			contador.clear();
			for (int i = 0; i < nomesConteudos.size(); i++){
				System.out.println((i + 1) + ". " + nomesConteudos.get(i));
				contador.add(i + 1);
			}
			System.out.println();
			System.out.println("0. Fechar programa");
			System.out.println();
			System.out.print("Qual conteúdo você deseja acessar? (Digite o número correspondente):");
			System.out.println();
			System.out.println();
			int input;
			if (!sc.hasNextInt()){
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				sc.nextLine();
				System.out.println();
				continue;
			}
			input = sc.nextInt();
			sc.nextLine();
			if (contador.contains(input)){
				testador = false;
				interface2(input, experimentos);
			}
			else if (input == 0){
				System.out.println();
				System.out.print("Encerrando programa.....");
				testador = false;
			}
			else {
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				System.out.println();
			}
		}while(testador == true);
	}
	
	public static void interface2(int input, Map<Integer, Runnable> experimentos){
		select = input;
		boolean testador = true;
		System.out.println();
		System.out.println("--- " + nomesConteudos.get(input - 1) + " ---");
		System.out.println();
		try{
			File txt = textosConteudos.get(input - 1);
			Scanner leitor = new Scanner(txt);
			while (leitor.hasNextLine()){
				System.out.println(leitor.nextLine());
			}
			leitor.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Erro: Arquivo de texto não encontrado/existe");
			System.out.println(e.getMessage());
		}
		System.out.println();
		do{
			System.out.println("1. Experimentar");
			System.out.println("2. Voltar");
			System.out.println("0. Fechar programa");
			System.out.println();
			if (!sc.hasNextInt()){
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				System.out.println();
				sc.nextLine();
				continue;
			}
			input = sc.nextInt();
			sc.nextLine();
			if (input == 1){
				System.out.println();
				seletor(select, experimentos, sc);
				do{
					System.out.println();
					System.out.println("1. Voltar");
					System.out.println("0. Fechar programa");
					System.out.println();
					if (!sc.hasNextInt()){
						System.out.println();
						System.out.println("Opção inválida");
						System.out.println("Por favor, tente novamente");
						System.out.println();
						sc.nextLine();
						continue;
					}
					input = sc.nextInt();
					sc.nextLine();
					if (input == 1){
						testador = false;
						System.out.println();
						interface1(experimentos);
					}
					else if (input == 0){
						System.out.println();
						System.out.print("Encerrando programa.....");
						testador = false;
					}
					else {
						System.out.println();
						System.out.println("Opção inválida");
						System.out.println("Por favor, tente novamente");
						System.out.println();
					}
				}while (testador == true);
			}
			else if (input == 2){
				testador = false;
				System.out.println();
				interface1(experimentos);
			}
			else if (input == 0){
				System.out.println();
				System.out.print("Encerrando programa.....");
				testador = false;
			}
			else {
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				System.out.println();
			}
		}while (testador == true);
	}
	
	public static void seletor(Integer select, Map<Integer, Runnable> experimentos, Scanner sc){
		if(experimentos.containsKey(select)){
			experimentos.get(select).run();
		}
		else{
			System.out.println("Erro: Chave não encontrada");
		}
	}
	
	public static double validarDouble(){
		boolean testador = true;
		double x = 0;
		while (testador == true){
			if (!sc.hasNextDouble()){
				System.out.println();
				System.out.println("Valor inserido inválido");
				System.out.println("Por favor, tente novamente");
				System.out.println();
				sc.nextLine();
			}
			else{
				x = sc.nextDouble();
				sc.nextLine();
				System.out.println();
				testador = false;
			}
		}
		return x;
	}
	
	public static double validarDoubleMinimo(int minimo){
		boolean testador =true;
		double valor = 0;
		while (testador == true){
			if (!sc.hasNextDouble()){
				System.out.println();
				System.out.println("Valor inserido inválido");
				System.out.println("Por favor, tente novamente");
				System.out.println();
				sc.nextLine();
			}
			else{
				valor = sc.nextDouble();
				if(valor >= minimo){
					sc.nextLine();
					System.out.println();
					testador = false;
				}
				else{
					System.out.println();
					System.out.println("Valor inserido inválido");
					System.out.println("Por favor, tente novamente");
					System.out.println();
					sc.nextLine();
				}
			}
		}
		return valor;
	}
	
	public static int validarOpcoes(int minimo, int maximo){
		boolean testador = true;
		int input = 0;
		while (testador == true){
			if (!sc.hasNextInt()){
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				System.out.println();
				sc.nextLine();
			}
			else{
				input = sc.nextInt();
			    if (input >= minimo && input <= maximo){
			    	sc.nextLine();
			       	System.out.println();
			    	testador = false;
			    }
			    else{
				System.out.println();
				System.out.println("Opção inválida");
				System.out.println("Por favor, tente novamente");
				System.out.println();
				sc.nextLine();
			    }
			}
		}
		return input;
	}
	
	public static double mdc(double a, double b){
		double resto;
		while (b != 0){
			resto = a % b;
			a = b;
			b = resto;
		}
		return a;
	}
	
	public static void fracao(){
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
		input = validarOpcoes(1, 4);
		System.out.println("Digite o valor a (numerador 1):");
		System.out.println();
		a = validarDouble();
		System.out.println("Digite o valor b (denominador 1):");
		System.out.println();
		b = validarDouble();
		System.out.println("Digite o valor x (numerador 2):");
		System.out.println();
		x = validarDouble();
		System.out.println("Digite o valor y (denominador 2):");
		System.out.println();
		y = validarDouble();
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
		mdc = mdc(Math.abs(numerador), Math.abs(denominador));
		numerador /= mdc;
		denominador /= mdc;
		System.out.printf("Resultado: %.1f/%.1f\n", numerador, denominador);
		System.out.println();
	}
	
	public static void polinomios(){
		
	}
	
	public static void planoCartesiano(){
		
	}
	
	public static void regraDe3(){
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
		input = validarOpcoes(1, 2);
		System.out.println("Digite o valor a:");
		System.out.println();
		a = validarDouble();
		System.out.println("Digite o valor b:");
		System.out.println();
		b = validarDouble();
		System.out.println("Digite o valor c:");
		System.out.println();
		c = validarDouble();
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
	
	public static void jurosSimples(){
		double juros = 0;
		double P = 0;
		double i = 0;
		double t = 0;
		double M = 0;
		System.out.println("Digite o capital (P):");
		System.out.println();
		P = validarDoubleMinimo(1);
		System.out.println("Digite a taxa (i):");
		System.out.println();
		i = validarDoubleMinimo(1);
		System.out.println("Digite o tempo (t):");
		System.out.println();
		t = validarDoubleMinimo(1);
		juros = P * i * t;
		M = P + juros;
		System.out.printf("Juros: %.2f\n", juros);
		System.out.printf("Montante final: %.2f\n", M);
		System.out.println();
	}
	
	public static void jurosCompostos(){
		double juros = 0;
		double P = 0;
		double i = 0;
		double t = 0;
		double M = 0;
		System.out.println("Digite o capital (P):");
		System.out.println();
		P = validarDoubleMinimo(1);
		System.out.println("Digite a taxa (i):");
		System.out.println();
		i = validarDoubleMinimo(1);
		System.out.println("Digite o tempo (t):");
		System.out.println();
		t = validarDoubleMinimo(1);
		i = i / 100;
		M = P * Math.pow((1 + i), t);
		juros = M - P;
		System.out.printf("Juros: %.2f\n", juros);
		System.out.printf("Montante final: %.2f\n", M);
		System.out.println();
	}
	
	
	public static void potenciacao(){
		double a = 0;
		double b = 0;
		System.out.println("Digite o valor a (base):");
		System.out.println();
		a = validarDouble();
		System.out.println("Digite o valor b (expoente):");
		System.out.println();
		b = validarDouble();
		System.out.println("Resultado: " + Math.pow(a, b));
	}
	
	public static void numerosPrimos(){
		double numero = 0;
		double divisor = 0;
		double resto = 0;
		System.out.println("Digite o valor a ser testado:");
		System.out.println();
		numero = validarDoubleMinimo(1);
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
	
	public static void bhaskara(){
		double a = 0;
		double b = 0;
		double c = 0;
		double delta = 0;
		double xI = 0;
		double xII = 0;
		System.out.println("Digite o valor a:");
		System.out.println();
		a = validarDoubleMinimo(1);
		System.out.println("Digite o valor b:");
		System.out.println();
		b = validarDouble();
		System.out.println("Digite o valor c:");
		System.out.println();
		c = validarDouble();
		delta = (Math.pow(b, 2)) - (4 * a * c);
		if (delta >= 0){
			xI = (-b + Math.sqrt(delta)) / (2 * a);
			xII = (-b - Math.sqrt(delta)) / (2 * a);
			System.out.println("Resultado:");
			System.out.printf("xI = %.1f\n", xI);
			System.out.printf("xII = %.1f\n", xII);
			System.out.println();
		}
		else{
			System.out.println("Resultado:");
			System.out.println("xI = -(" + b + ") + sqrt(" + delta + ") / 2 · " + a);
			System.out.println("xII = -(" + b + ") - sqrt(" + delta + ") / 2 · " + a);
			System.out.println();
		}
	}
	
	public static void logaritmo(){
		double a = 0;
		double b = 0;
		double c = 0;
		System.out.println("Digite o valor a (logaritmando):");
		System.out.println();
		a = validarDoubleMinimo(1);
		System.out.println("Digite o valor b (base):");
		System.out.println();
		b = validarDoubleMinimo(2);
		c = Math.log(a) / Math.log(b);
		System.out.printf("Resultado: log_%.0f(%.0f) = %.1f", b, a, c);
		System.out.println();
	}
	
	public static void funcao1Grau(){
		
	}
	
	public static void geometriaPlana(){
		
	}
	
	public static void trigonometria(){
		
	}

	public static void main(String args[]){
		Map<Integer, Runnable> experimentos = new HashMap<>();
		experimentos.put(1, Conteudo::fracao);
		experimentos.put(2, Conteudo::polinomios);
		experimentos.put(3, Conteudo::planoCartesiano);
		experimentos.put(4, Conteudo::regraDe3);
		experimentos.put(5, Conteudo::jurosSimples);
		experimentos.put(6, Conteudo::jurosCompostos);
		experimentos.put(7, Conteudo::potenciacao);
		experimentos.put(8, Conteudo::numerosPrimos);
		experimentos.put(9, Conteudo::bhaskara);
		experimentos.put(10, Conteudo::logaritmo);
		experimentos.put(11, Conteudo::funcao1Grau);
		experimentos.put(12, Conteudo::geometriaPlana); 
		experimentos.put(13, Conteudo::trigonometria);
		Conteudo fracao = new Conteudo("Fração", new File("frc.txt"));
		Conteudo polinomios = new Conteudo("Polinômios", new File("plnm.txt"));
		Conteudo planoCartesiano = new Conteudo("Plano cartesiano", new File("pC.txt"));
		Conteudo regraDe3 = new Conteudo("Regra de 3", new File("rd3.txt"));
		Conteudo jurosSimples = new Conteudo("Juros simples", new File("jS.txt"));
		Conteudo jurosCompostos = new Conteudo("Juros compostos", new File("jC.txt"));
		Conteudo potenciacao = new Conteudo("Potenciação", new File("ptnc.txt"));
		Conteudo numerosPrimos = new Conteudo("Números primos", new File("nP.txt"));
		Conteudo bhaskara = new Conteudo("Bháskara", new File("bhkr.txt"));
		Conteudo logaritimo = new Conteudo("Logaritmo", new File("log.txt"));
		Conteudo funcao1Grau = new Conteudo("Função do 1° grau", new File("f1G.txt"));
		Conteudo geometriaPlana = new Conteudo("Geometria plana", new File("gP.txt"));
		Conteudo trigonometria = new Conteudo("Trigonometria", new File("trig.txt"));
		
		interface1(experimentos);
		
		sc.close();
    }
}


