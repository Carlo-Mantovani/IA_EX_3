
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;
import java.util.Scanner;

public class PerceptronMultipleLetters {
    private NeuronioLetras neuronio;
    private NeuronioLetras neuronio2;
    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada C
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada T
    private double x3[] = { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 3a entrada O
    private double x4[] = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 4a entrada U
    private double d[] = { 0, 1, 2, 3 }; // saida desejada. C = 0, T = 1, O = 2, U = 3
    

    public PerceptronMultipleLetters() {
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
            for (i = 0; i < 4; i++) {
                // propagação
                switch (i){
                    case 0:
                    y1 = neuronio.calculaY(x1);
                    y2 = neuronio2.calculaY(x1);
                    break;

                    case 1:
                    y1 = neuronio.calculaY(x2);
                    y2 = neuronio2.calculaY(x2);
                    break;

                    case 2:
                    y1 = neuronio.calculaY(x3);
                    y2 = neuronio2.calculaY(x3);
                    break;

                    default:
                    y1 = neuronio.calculaY(x4);
                    y2 = neuronio2.calculaY(x4);
                    break;
                }
                
                // calcula do erro
                erro1 = 0;
                erro2 = 0;

                
                switch ((int)(d[i])){

                    case 0:
                        erro1 = 1 - y1;
                        erro2 = -y2;
                        break;

                    case 2:
                        erro1 = 1 - y1;
                        erro2 = -y2;
                        break;

                    default:
                        erro1 = -y1;
                        erro2 = 1 - y2;
                        break;



                }

                if (erro1 != 0) {

                    switch (i){

                        case 0:
                         
                            neuronio.setWeights(erro1, x1, eta);
                            break;

                        case 1:
                            neuronio.setWeights(erro1, x2, eta);
                            break;

                        case 2:
                            neuronio.setWeights(erro1, x3, eta);
                            break;

                        default: 
                            neuronio.setWeights(erro1, x4, eta);
                            break;

                    }
                    
                }
                if (erro2 != 0) {


                    switch (i){

                        case 0:
                            neuronio2.setWeights(erro2, x1, eta);
                            break;
                        case 1: 
                            neuronio2.setWeights(erro2, x2, eta);   
                            break;

                        case 2:
                            neuronio2.setWeights(erro2, x3, eta);
                            break;

                        default:
                            neuronio2.setWeights(erro2, x4, eta);
                            break;
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

        System.out.println("Saida desejada (C): 1 em Neuronio 1 e 0 em Neuronio 2");
        double saidaR = neuronio.calculaY(p3);
        System.out.println("Saida Gerada pelo neuronio 1 para C: " + saidaR);
        double saidaR2 = neuronio2.calculaY(p3);
        System.out.println("Saida Gerada pelo neuronio 2 para C: " + saidaR2);
        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}


        System.out.println("Saida desejada (T): 0 em Neuronio 1 e 1 em Neuronio 2");
        saidaR = neuronio.calculaY(p4);
        System.out.println("Saida Gerada pelo neuronio 1 para T: " + saidaR);
        saidaR2 = neuronio2.calculaY(p4);
        System.out.println("Saida Gerada pelo neuronio 2 para T: " + saidaR2);

        if (saidaR2 == 1){
            acertos++;
        } else {erros++;}
        if (saidaR == 0){
            acertos++;
        }else{erros++;}

        System.out.println("Saida desejada (O): 1 em Neuronio 1 e 0 em Neuronio 2");
        saidaR = neuronio.calculaY(p5);
        System.out.println("Saida Gerada pelo neuronio 1 para O: " + saidaR);
        saidaR2 = neuronio2.calculaY(p5);
        System.out.println("Saida Gerada pelo neuronio 2 para O: " + saidaR2);

        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}


        System.out.println("Saida desejada (U): 0 em Neuronio 1 e 1 em Neuronio 2");
        saidaR = neuronio.calculaY(p6);
        System.out.println("Saida Gerada pelo neuronio 1 para U: " + saidaR);
        saidaR2 = neuronio2.calculaY(p6);
        System.out.println("Saida Gerada pelo neuronio 2 para U: " + saidaR2);

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
