
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class PerceptronLetras1N {
    private NeuronioLetras neuronio;

    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada
    private double d[] = { 0, 1 }; // saida desejada. C = 0, T = 1
    private double maior1 = 0;
    private double maior2 = 0;

    public PerceptronLetras1N() {
        neuronio = new NeuronioLetras();

        inicializacao();
    }

    private void inicializacao() {

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
            for (i = 0; i < 2; i++) {
                // propagação
                if (i == 0) {
                    y1 = neuronio.calculaY(x1);

                } else {
                    y1 = neuronio.calculaY(x2);

                }
                // calcula do erro
                erro1 = 0;
                erro2 = 0;

                erro1 = d[i] - y1;

                if (erro1 != 0 && i == 0) {

                    neuronio.setWeights(erro1, x1, eta);
                    //neuronio.setW0(neuronio.getW0() + eta * erro1);
                    //neuronio.setW1(neuronio.getW1() + eta * erro1 * x1[0]);
                    //neuronio.setW2(neuronio.getW2() + eta * erro1 * x1[1]);
                    //neuronio.setW3(neuronio.getW3() + eta * erro1 * x1[2]);
                    //neuronio.setW4(neuronio.getW4() + eta * erro1 * x1[3]);
                    //neuronio.setW5(neuronio.getW5() + eta * erro1 * x1[4]);
                    //neuronio.setW6(neuronio.getW6() + eta * erro1 * x1[5]);
                    //neuronio.setW7(neuronio.getW7() + eta * erro1 * x1[6]);
                    //neuronio.setW8(neuronio.getW8() + eta * erro1 * x1[7]);
                    //neuronio.setW9(neuronio.getW9() + eta * erro1 * x1[8]);
                    //neuronio.setW10(neuronio.getW10() + eta * erro1 * x1[9]);
                    //neuronio.setW11(neuronio.getW11() + eta * erro1 * x1[10]);
                    //neuronio.setW12(neuronio.getW12() + eta * erro1 * x1[11]);

                }
                if (erro1 != 0 && i == 1) {
                    neuronio.setWeights(erro1, x2, eta);
                    //neuronio.setW0(neuronio.getW0() + eta * erro1);
                    //neuronio.setW1(neuronio.getW1() + eta * erro1 * x2[0]);
                    //neuronio.setW2(neuronio.getW2() + eta * erro1 * x2[1]);
                    //neuronio.setW3(neuronio.getW3() + eta * erro1 * x2[2]);
                    //neuronio.setW4(neuronio.getW4() + eta * erro1 * x2[3]);
                    //neuronio.setW5(neuronio.getW5() + eta * erro1 * x2[4]);
                    //neuronio.setW6(neuronio.getW6() + eta * erro1 * x2[5]);
                    //neuronio.setW7(neuronio.getW7() + eta * erro1 * x2[6]);
                    //neuronio.setW8(neuronio.getW8() + eta * erro1 * x2[7]);
                    //neuronio.setW9(neuronio.getW9() + eta * erro1 * x2[8]);
                    //neuronio.setW10(neuronio.getW10() + eta * erro1 * x2[9]);
                    //neuronio.setW11(neuronio.getW11() + eta * erro1 * x2[10]);
                    //neuronio.setW12(neuronio.getW12() + eta * erro1 * x2[11]);

                }

                System.out.println("Neuronio1 - pesos: " + neuronio);

                erroGeral += abs(erro1);

            }
            System.out.println("Erro geral: " + erroGeral);
            if (erroGeral == 0) {
                break;
            }

        }
    }

    // public void generalizacao() { // uso da rede
    // // Generalizacao - Teste da rede
    // int entrada1, entrada2;
    // Scanner dados = new Scanner(System.in);
    // System.out.println("\n--- GENERALIZACAO");
    // while (true) {
    // // digita novas entradas
    // System.out.println("Digite -100 para encerrar");
    // System.out.print("Digite a entrada (x1): ");
    // entrada1 = dados.nextInt();
    // if (entrada1 == -100)
    // break;
    //
    // System.out.print("Digite a entrada (x2): ");
    // entrada2 = dados.nextInt();
    // if (entrada2 == -100)
    // break;
    //
    // // propagação
    // System.out.println("Saida Gerada pela rede: " + neuronio.calculaY(entrada1,
    // entrada2));
    // }
    //
    // }

    public void generalizacaoComTestes() {

        System.out.println("\n--- GENERALIZACAO");
        int acertos = 0;
        int erros = 0;
        double[] p1 = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        double[] p2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        double[] p3 = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // C
        double[] p4 = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // T
        // Conjunto de Teste: Cliente

        // System.out.println("Saida desejada: 0 ");
        // double saidaR = neuronio.calculaY(p1);
        // System.out.println("Saida Gerada pelo neuronio para P1: " + saidaR);
        //
        // saidaR = neuronio.calculaY(p2);
        // System.out.println("Saida Gerada pelo neuronio para P2: " + saidaR);

        System.out.println("Saida desejada: 0 (C) ");
        double saidaR = neuronio.calculaY(p3);
        System.out.println("Saida Gerada pelo neuronio  para C: " + saidaR);
        
         if (saidaR == 0) {
         acertos++;
         } else {
         erros++;
         }
        System.out.println("Saida desejada: 1 (T)");
        saidaR = neuronio.calculaY(p4);
        System.out.println("Saida Gerada pelo neuronio para T: " + saidaR);
        if (saidaR == 1) {
            acertos++;
            } else {
            erros++;
            }

        // cont++;

        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
