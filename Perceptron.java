
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class Perceptron {
    private Neuronio neuronio;
    private Neuronio neuronio2;
    private double x1[]; // 1a entrada
    private double x2[]; // 2a entrada
    private double d[]; // saida desejada
    private double maior1 = 0;
    private double maior2 = 0;

    public Perceptron() {
        neuronio = new Neuronio();
        neuronio2 = new Neuronio();
        x1 = new double[21];
        x2 = new double[21];
        d = new double[21];
        inicializacao();
    }

    private void inicializacao() {
        // Conjunto de Treino : OR
        // x1[0] = 0; x2[0] = 0; d[0] = 0;
        // x1[1] = 0; x2[1] = 1; d[1] = 1;
        // x1[2] = 1; x2[2] = 0; d[2] = 1;
        // x1[3] = 1; x2[3] = 1; d[3] = 1;

        // Conjunto de Treino : AND
        // x1[0] = 0; x2[0] = 0; d[0] = 0;
        // x1[1] = 0; x2[1] = 1; d[1] = 0;
        // x1[2] = 1; x2[2] = 0; d[2] = 0;
        // x1[3] = 1; x2[3] = 1; d[3] = 1;

        // Conjunto de Treino : XOR
        // x1[0] = 0; x2[0] = 0; d[0] = 0;
        // x1[1] = 0; x2[1] = 1; d[1] = 1;
        // x1[2] = 1; x2[2] = 0; d[2] = 1;
        // x1[3] = 1; x2[3] = 1; d[3] = 0;

        // Conjunto de Treino: Cliente
        x1[0] = 2800;
        x2[0] = 550;
        d[0] = 1;
        x1[1] = 1300;
        x2[1] = 500;
        d[1] = 0;
        x1[2] = 1400;
        x2[2] = 80;
        d[2] = 1;
        x1[3] = 500;
        x2[3] = 200;
        d[3] = 0;
        x1[4] = 1100;
        x2[4] = 270;
        d[4] = 0;
        x1[5] = 1800;
        x2[5] = 450;
        d[5] = 1;
        x1[6] = 2400;
        x2[6] = 650;
        d[6] = 1;
        x1[7] = 1950;
        x2[7] = 600;
        d[7] = 1;
        x1[8] = 450;
        x2[8] = 70;
        d[8] = 0;
        x1[9] = 2750;
        x2[9] = 730;
        d[9] = 1;
        x1[10] = 850;
        x2[10] = 90;
        d[10] = 0;
        x1[11] = 1300;
        x2[11] = 200;
        d[11] = 0;
        x1[12] = 2100;
        x2[12] = 750;
        d[12] = 1;
        x1[13] = 900;
        x2[13] = 300;
        d[13] = 0;
        x1[14] = 2700;
        x2[14] = 250;
        d[14] = 1;
        x1[15] = 1600;
        x2[15] = 500;
        d[15] = 0;
        x1[16] = 1900;
        x2[16] = 150;
        d[16] = 1;
        x1[17] = 2500;
        x2[17] = 800;
        d[17] = 1;
        x1[18] = 1600;
        x2[18] = 700;
        d[18] = 0;
        x1[19] = 2300;
        x2[19] = 500;
        d[19] = 1;
        x1[20] = 2100;
        x2[20] = 250;
        d[20] = 1;

        for (int i = 0; i < 21; i++) {// normalizando os dados de entrada
            if (x1[i] > maior1) {
                maior1 = x1[i];
            }
            if (x2[i] > maior2) {
                maior2 = x2[i];
            }
        }
        for (int i = 0; i < 21; i++) {
            x1[i] = x1[i] / maior1;
            x2[i] = x2[i] / maior2;
            System.out.println("x1: " + x1[i] + " x2: " + x2[i] + " d: " + d[i]);
        }
    }

    public void treinamento() { // algoritmo Regra Delta
        // Treinamento
        int epocas = 0, i;
        double y1, y2, erro1, erro2, erroGeral = 1;
        double eta = 1; // eta é a constante (taxa) de aprendizagem
        System.out.println("--- TREINAMENTO");
        while (true) {
            epocas++;
            erroGeral = 0;

            System.out.println("Epoca: " + epocas);
            for (i = 0; i < 14; i++) {
                // propagação
                y1 = neuronio.calculaY(x1[i], x2[i]);
                y2 = neuronio2.calculaY(x1[i], x2[i]);
                // calcula do erro
                erro1 = 0;
                erro2 = 0;

                if (d[i] == 0) {// se a saída desejada for 0 (ruim)
                    erro1 = 1 - y1;
                    erro2 = -y2;
                } else {// se a saída desejada for 1 (bom)
                    erro1 = -y1;
                    erro2 = 1 - y2;
                }

                // ajuste dos pesos
                if (erro1 != 0) {
                    neuronio.setW0(neuronio.getW0() + eta * erro1);
                    neuronio.setW1(neuronio.getW1() + eta * erro1 * x1[i]);
                    neuronio.setW2(neuronio.getW2() + eta * erro1 * x2[i]);
                }
                // ajuste dos pesos
                
                if (erro2 != 0) {
                    neuronio2.setW0(neuronio2.getW0() + eta * erro2);
                    neuronio2.setW1(neuronio2.getW1() + eta * erro2 * x1[i]);
                    neuronio2.setW2(neuronio2.getW2() + eta * erro2 * x2[i]);
                }
                System.out.println("Neuronio1 - pesos: " + neuronio);
                System.out.println("Neuronio2 - pesos: " + neuronio2);
                erroGeral = erroGeral + abs(erro1) + abs(erro2);
            }
            // pára quando para todas as entradas o erro for zero
            if (erroGeral == 0)
                break;
        }
    }

    public void generalizacao() { // uso da rede
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

            // propagação
            System.out.println("Saida Gerada pela rede: " + neuronio.calculaY(entrada1, entrada2));
        }
        dados.close();

    }

    public void generalizacaoComTestes() {// uso da rede testando com os dados de teste

        int cont = 15;
        System.out.println("\n--- GENERALIZACAO");
        int acertos = 0;
        int erros = 0;
        // Conjunto de Teste: Cliente
        while (cont < 21) {
            double saidaD = d[cont];
            System.out.println("Saida desejada (responde 1 o neuronio associado a categoria da saida): " + saidaD);
            double saidaR = neuronio.calculaY(x1[cont], x2[cont]);
            System.out.println("Saida Gerada pelo neuronio treinado para categoria RUIM (0): " + saidaR);
            double saidaR2 = neuronio2.calculaY(x1[cont], x2[cont]);
            System.out.println("Saida Gerada pelo neuronio treinado para categoria BOM (1) : " + saidaR2);
            cont++;
            if (saidaD == saidaR || saidaD == saidaR2) {// se a saida desejada for igual a saida gerada
                acertos++;
            } else {
                erros++;
            }

        }
        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
