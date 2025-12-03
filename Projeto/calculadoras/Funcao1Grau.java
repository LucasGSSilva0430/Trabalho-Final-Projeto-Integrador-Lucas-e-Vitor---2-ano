package calculadoras;

import java.util.List;
import util.Validacoes;
import util.MetodosAuxiliares;

public class Funcao1Grau{
	public static void executar(){
		double resultado = 0;
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("        *Intruções*");
		System.out.println();
		System.out.println("  As operações disponíveis são:");
		System.out.println();
		System.out.println("   - Adição: +");
		System.out.println("   - Subtração: -");
		System.out.println("   - Multiplicação: *");
		System.out.println("   - Divisão: /");
		System.out.println("   - Potenciação: ^");
		System.out.println();
		System.out.println(" - Serão aceitos somente números e caracteres de operação;");
		System.out.println(" - Não serão aceitas expressões que tenham duas operações seguidas (Ex.: ++);");
		System.out.println(" - Não serão aceitas expressões que terminem com uma operação (Ex.: 2 + 2 -)");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Digite a expressão");
		System.out.println();
		String expressao = Validacoes.validarNumerosOperacoes();
		List<String> rpn = MetodosAuxiliares.transformarEmRPN(expressao);
		resultado = MetodosAuxiliares.resolverRPN(rpn);
		System.out.println();
		System.out.println("Resultado = " + resultado);
	}
}
