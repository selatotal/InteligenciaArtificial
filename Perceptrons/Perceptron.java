//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class Perceptron {
	public static void main(String args[]) {
		Neuronio neuronio = new Neuronio();

		int x1[] = new int[4]; // 1a entrada
		int x2[] = new int[4]; // 2a entrada
		int d[] = new int[4]; // saida desejada

		// Conjunto de Treino : OR
		x1[0] = 0;
		x2[0] = 0;
		d[0] = 0;

		x1[1] = 0;
		x2[1] = 1;
		d[1] = 1;
		
		x1[2] = 1;
		x2[2] = 0;
		d[2] = 1;
		
		x1[3] = 1;
		x2[3] = 1;
		d[3] = 1;

		// Treinamento
		int epocas = 0, i;
		double y, erro, erroGeral;
		double eta = 1d; 
		// eta e a constante (taxa) de aprendizagem

		System.out.println("--- TREINAMENTO");
		while (true) {
			epocas++;
			erroGeral = 0;

			System.out.println("Epoca: " + epocas);
			for (i = 0; i < x1.length; i++) {

				// propagacao
				y = neuronio.calculaY(x1[i], x2[i]);
				
				// calcula do erro
				erro = d[i] - y;
				
				// ajuste dos pesos
				if (erro != 0) {
					neuronio.setW0(neuronio.getW0() + eta * erro);
					neuronio.setW1(neuronio.getW1() + eta * erro * x1[i]);
					neuronio.setW2(neuronio.getW2() + eta * erro * x2[i]);
				}
				System.out.println("Neuronio - pesos: " + neuronio);
				erroGeral = erroGeral + abs(erro);
			}
			
			// para quando para todas as entradas o erro for zero
			if (erroGeral == 0)
				break;
		}

		// Generalizacao - Teste da rede
		int entrada1, entrada2;
		Scanner dados = new Scanner(System.in);
		System.out.println("\n--- GENERALIZACAO");

		while (true) {
			// digita novas entradas
			System.out.println("Digite -100 para encerrar");
			System.out.print("Digite a entrada (x1): ");
			entrada1 = dados.nextInt();
			if (entrada1 == -100)
				break;

			System.out.print("Digite a entrada (x2): ");
			entrada2 = dados.nextInt();
			if (entrada2 == -100)
				break;

			// propagacao
			System.out.println("Saida Gerada pela rede: "
					+ neuronio.calculaY(entrada1, entrada2));
		}
	}
}
