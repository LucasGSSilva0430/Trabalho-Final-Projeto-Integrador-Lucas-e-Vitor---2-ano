package util;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class MetodosAuxiliares{
	
	public static double mdc(double a, double b){
		double resto;
		while (b != 0){
			resto = a % b;
			a = b;
			b = resto;
		}
		return a;
	}
	
	public static List<String> transformarEmRPN (String expr){
		List<String> saida = new ArrayList<>();
		Stack<String> operadores = new Stack<>();
		String regex = "(?<=\\d)(?=[+\\-*/^()])|(?<=[+\\-*/^()])";
		String[] caracteres = expr.split(regex);
		for (String caracter : caracteres){
			if (caracter.matches("-?\\d+(\\.\\d+)?")){
				saida.add(caracter);
			}
			else if (caracter.matches("[+\\-*/^]")){
				while (!operadores.isEmpty() && ordem(operadores.peek()) >= ordem(caracter)) {
					saida.add(operadores.pop());
				}
				operadores.push(caracter);
			}
			else if (caracter.equals("(")){
				operadores.push(caracter);
			}
			else if (caracter.equals(")")){
				while (!operadores.isEmpty() && !operadores.peek().equals("(")){
					saida.add(operadores.pop());
				}
				operadores.pop();
			}
        }
			while (!operadores.isEmpty()){
			saida.add(operadores.pop());
		}
		return saida;
	}
	
	public static int ordem(String opc){
		switch (opc){
			case "^":
				return 3;
			case "*":
				return 2;
			case "/":
				return 2;
			case "+":
				return 1;
			case "-":
				return 1;
			default:
				return 0;
		}
	}
	
	public static double resolverRPN(List<String> rpn){
		double b = 0;
		double a = 0;
		Stack<Double> valores = new Stack<>();
		for (String caracter : rpn){
			if (caracter.matches("-?\\d+(\\.\\d+)?")){
				valores.push(Double.parseDouble(caracter));
			}
			else{
				b = valores.pop();
				a = valores.pop();
				switch (caracter) {
					case "+":
						valores.push(a + b);
						break;
					case "-":
						valores.push(a - b);
						break;
					case "*":
						valores.push(a * b);
						break;
					case "/":
						valores.push(a / b);
						break;
					case "^":
						valores.push(Math.pow(a, b));
						break;
				}
			}
		}
		return valores.pop();
	}
}
