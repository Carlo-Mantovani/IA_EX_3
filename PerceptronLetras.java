
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class PerceptronLetras {
    private NeuronioLetras neuronio;
    private NeuronioLetras neuronio2;
    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada C
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada T
    private double x3[] = { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 3a entrada O
    private double x4[] = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 4a entrada U
    private double d[] = { 0, 1, 2, 3 }; // saida desejada. C = 0, T = 1, O = 2, U = 3
    

    public PerceptronLetras() {
        neuronio = new NeuronioLetras();
        neuronio2 = new NeuronioLetras();

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
                    y2 = neuronio2.calculaY(x1);
                } else {
                    y1 = neuronio.calculaY(x2);
                    y2 = neuronio2.calculaY(x2);
                }
                // calcula do erro
                erro1 = 0;
                erro2 = 0;
                if (d[i] == 0) {
                    erro1 = 1 - y1;
                    erro2 = -y2;
                   
                } else {
                    erro1 = -y1;
                    erro2 = 1 - y2;
                
                }

                if (erro1 != 0) {
                    if (i == 0) {
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

                    } else {
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
                }
                if (erro2 != 0) {
                    if (i == 0) {
                        neuronio2.setWeights(erro2, x1, eta);
                        //neuronio2.setW0(neuronio2.getW0() + eta * erro2);
                        //neuronio2.setW1(neuronio2.getW1() + eta * erro2 * x2[0]);
                        //neuronio2.setW2(neuronio2.getW2() + eta * erro2 * x2[1]);
                        //neuronio2.setW3(neuronio2.getW3() + eta * erro2 * x2[2]);
                        //neuronio2.setW4(neuronio2.getW4() + eta * erro2 * x2[3]);
                        //neuronio2.setW5(neuronio2.getW5() + eta * erro2 * x2[4]);
                        //neuronio2.setW6(neuronio2.getW6() + eta * erro2 * x2[5]);
                        //neuronio2.setW7(neuronio2.getW7() + eta * erro2 * x2[6]);
                        //neuronio2.setW8(neuronio2.getW8() + eta * erro2 * x2[7]);
                        //neuronio2.setW9(neuronio2.getW9() + eta * erro2 * x2[8]);
                        //neuronio2.setW10(neuronio2.getW10() + eta * erro2 * x2[9]);
                        //neuronio2.setW11(neuronio2.getW11() + eta * erro2 * x2[10]);
                        //neuronio2.setW12(neuronio2.getW12() + eta * erro2 * x2[11]);

                    } else {
                        neuronio2.setWeights(erro2, x2, eta);

                        //neuronio2.setW0(neuronio2.getW0() + eta * erro2);
                        //neuronio2.setW1(neuronio2.getW1() + eta * erro2 * x1[0]);
                        //neuronio2.setW2(neuronio2.getW2() + eta * erro2 * x1[1]);
                        //neuronio2.setW3(neuronio2.getW3() + eta * erro2 * x1[2]);
                        //neuronio2.setW4(neuronio2.getW4() + eta * erro2 * x1[3]);
                        //neuronio2.setW5(neuronio2.getW5() + eta * erro2 * x1[4]);
                        //neuronio2.setW6(neuronio2.getW6() + eta * erro2 * x1[5]);
                        //neuronio2.setW7(neuronio2.getW7() + eta * erro2 * x1[6]);
                        //neuronio2.setW8(neuronio2.getW8() + eta * erro2 * x1[7]);
                        //neuronio2.setW9(neuronio2.getW9() + eta * erro2 * x1[8]);
                        //neuronio2.setW10(neuronio2.getW10() + eta * erro2 * x1[9]);
                        //neuronio2.setW11(neuronio2.getW11() + eta * erro2 * x1[10]);
                        //neuronio2.setW12(neuronio2.getW12() + eta * erro2 * x1[11]);
                    }
                }
                System.out.println("Neuronio1 - pesos: " + neuronio);
                System.out.println("Neuronio2 - pesos: " + neuronio2);
                erroGeral += abs(erro1) + abs(erro2);

            }
            if (erroGeral == 0 || epocas == 1000) {
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
        double[] p5 = { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // O
        double[] p6 = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // U
        // Conjunto de Teste: Cliente

         //System.out.println("Saida desejada: 0 em ambos ");
         //double saidaR = neuronio.calculaY(p1);
         //System.out.println("Saida Gerada pelo neuronio C para P1: " + saidaR);
         //double saidaR2 = neuronio2.calculaY(p1);
         //System.out.println("Saida Gerada pelo neuronio T para P1 : " + saidaR2);
         //saidaR = neuronio.calculaY(p2);
         //System.out.println("Saida Gerada pelo neuronio C para P2: " + saidaR);
         //saidaR2 = neuronio2.calculaY(p2);
         //System.out.println("Saida Gerada pelo neuronio T para P2: " + saidaR2);

        System.out.println("Saida desejada: 1 em Neuronio C e 0 em Neuronio T");
        double saidaR = neuronio.calculaY(p3);
        System.out.println("Saida Gerada pelo neuronio C para C: " + saidaR);
        double saidaR2 = neuronio2.calculaY(p3);
        System.out.println("Saida Gerada pelo neuronio T para C: " + saidaR2);
        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}

        System.out.println("Saida desejada: 0 em Neuronio C e 1 em Neuronio T");
        saidaR = neuronio.calculaY(p4);
        System.out.println("Saida Gerada pelo neuronio C para T: " + saidaR);
        saidaR2 = neuronio2.calculaY(p4);
        System.out.println("Saida Gerada pelo neuronio T para T: " + saidaR2);

        if (saidaR2 == 1){
            acertos++;
        } else {erros++;}
        if (saidaR == 0){
            acertos++;
        }else{erros++;}

        // cont++;
        // if (saidaD == saidaR || saidaD == saidaR2) {
        // acertos++;
        // } else {
        // erros++;
        // }

        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
