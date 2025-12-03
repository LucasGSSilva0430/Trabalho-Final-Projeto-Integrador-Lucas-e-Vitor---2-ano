package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class Interfaces{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> contador = new ArrayList<>();
	public static Integer select;
	
	public static void interface1(Map<Integer, Runnable> experimentos, ArrayList<String> nomesConteudos, ArrayList<File> textosConteudos){
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
				interface2(input, experimentos, nomesConteudos, textosConteudos);
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
	
	public static void interface2(int input, Map<Integer, Runnable> experimentos, ArrayList<String> nomesConteudos, ArrayList<File> textosConteudos){
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
						interface1(experimentos, nomesConteudos, textosConteudos);
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
				interface1(experimentos, nomesConteudos, textosConteudos);
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
}
