package util;

import java.util.Scanner;

public class Validacoes{
	static Scanner sc = new Scanner(System.in);
	
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
	
	public static double validarDoubleDiferente(int diferente){
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
				if(valor != diferente){
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
	
	public static double validarDoubleMaior(int minimo){
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
				if(valor > minimo){
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
	
	public static String validarNumerosOperacoes(){
		boolean testador = true;
		String expressao = "";
		int parenteses = 0;
		boolean erroParenteses = false;
		while (testador == true){
			expressao = sc.nextLine().replaceAll("\\s+", "");
			if (!expressao.matches("[0-9+\\-*/^().]+")){
				System.out.println();
				System.out.println("Expressão inválida! Use apenas números, operadores (+ - * / ^) e parênteses.");
				System.out.println("Por favor, tente novamente.");
				System.out.println();
				continue;
			}
			if (expressao.matches(".*[+\\-*/^]{2,}.*")){
				System.out.println();
				System.out.println("Erro: Dois operadores consecutivos não são permitidos.");
				System.out.println("Por favor, tente novamente.");
				System.out.println();
				continue;
			}
			for (char c : expressao.toCharArray()){
				if (c == '('){
					parenteses++;
				}
				else if (c == ')'){
					parenteses--;
					if (parenteses < 0){
						erroParenteses = true;
						break;
					}
				}
			}
			if (parenteses != 0 || erroParenteses){
				System.out.println();
				System.out.println("Erro: Parênteses não estão balanceados.");
				System.out.println("Por favor, tente novamente.");
				System.out.println();
				continue;
			}
			if (expressao.matches(".*[+\\-*/^]$")) {
				System.out.println();
				System.out.println("Erro: A expressão não pode terminar com um operador.");
				System.out.println("Por favor, tente novamente.");
				System.out.println();
				continue;
			}
			testador = false;
		}
		return expressao;
	}
}
