import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import calculadoras.*;
import util.*;

public class Conteudo{
	String nome;
	File texto;

	static ArrayList<String> nomesConteudos = new ArrayList<>();
	static ArrayList<File> textosConteudos = new ArrayList<>();

	public Conteudo(String nome, File texto){
		this.nome = nome;
		this.texto = texto;
		nomesConteudos.add(nome);
		textosConteudos.add(texto);
	}
	public static void main(String args[]){
		Map<Integer, Runnable> experimentos = new HashMap<>();
		experimentos.put(1, calculadoras.Fracao::executar);
		experimentos.put(2, calculadoras.PlanoCartesiano::executar);
		experimentos.put(3, calculadoras.RegraDe3::executar);
		experimentos.put(4, calculadoras.JurosSimples::executar);
		experimentos.put(5, calculadoras.JurosCompostos::executar);
		experimentos.put(6, calculadoras.Potenciacao::executar);
		experimentos.put(7, calculadoras.NumerosPrimos::executar);
		experimentos.put(8, calculadoras.Bhaskara::executar);
		experimentos.put(9, calculadoras.Logaritmo::executar);
		experimentos.put(10, calculadoras.Funcao1Grau::executar);
		experimentos.put(11, calculadoras.GeometriaPlana::executar); 
		experimentos.put(12, calculadoras.Trigonometria::executar);
		Conteudo fracao = new Conteudo("Fração", new File("frc.txt"));
		Conteudo planoCartesiano = new Conteudo("Plano cartesiano", new File("pC.txt"));
		Conteudo regraDe3 = new Conteudo("Regra de 3", new File("rd3.txt"));
		Conteudo jurosSimples = new Conteudo("Juros simples", new File("jS.txt"));
		Conteudo jurosCompostos = new Conteudo("Juros compostos", new File("jC.txt"));
		Conteudo potenciacao = new Conteudo("Potenciação", new File("ptnc.txt"));
		Conteudo numerosPrimos = new Conteudo("Números primos", new File("nP.txt"));
		Conteudo bhaskara = new Conteudo("Bháskara", new File("bhkr.txt"));
		Conteudo logaritmo = new Conteudo("Logaritmo", new File("log.txt"));
		Conteudo funcao1Grau = new Conteudo("Função do 1° grau", new File("f1G.txt"));
		Conteudo geometriaPlana = new Conteudo("Geometria plana", new File("gP.txt"));
		Conteudo trigonometria = new Conteudo("Trigonometria", new File("trig.txt"));
		
		Interfaces.interface1(experimentos, nomesConteudos, textosConteudos);
    }
}
