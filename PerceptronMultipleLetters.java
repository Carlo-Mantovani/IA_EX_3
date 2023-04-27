
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;


public class PerceptronMultipleLetters {
    private NeuronioLetras neuronio;
    private NeuronioLetras neuronio2;
    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada C
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada T
    private double x3[] = { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 3a entrada O
    private double x4[] = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // 4a entrada U
    private double d[] = { 0, 1, 2, 3 }; // saida. C = 0, T = 1, O = 2, U = 3
    

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

                switch (i){// calculo conforme a entrada
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

                
                switch ((int)(d[i])){// calculo conforme a saida

                    case 0:
                        erro1 = -y1;
                        erro2 = -y2;
                        break;

                    case 1:
                        erro1 = -y1;
                        erro2 = 1 - y2;
                        break;

                    case 2:
                        erro1 = 1-y1;
                        erro2 = -y2;
                        break;

                    default:
                        erro1 = 1 -y1;
                        erro2 = 1 -y2;
                        break;



                }

                if (erro1 != 0) {// ajuste dos pesos

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
                if (erro2 != 0) {// ajuste dos pesos


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
            if (erroGeral == 0 || epocas == 100000) {
                break;
            }

        }
    }

   

    public void generalizacaoComTestes() {

        System.out.println("\n--- GENERALIZACAO");
        int acertos = 0;
        int erros = 0;
       
        double[] c = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // C
        double[] t = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // T
        double[] o = { 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // O
        double[] u = { 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1 }; // U
        // Conjunto de Teste: Cliente

         
        // Teste C
        System.out.println("Saida desejada (C): 0 em Neuronio A e 0 em Neuronio B");
        double saidaR = neuronio.calculaY(c);
        System.out.println("Saida Gerada pelo neuronio A para C: " + saidaR);
        double saidaR2 = neuronio2.calculaY(c);
        System.out.println("Saida Gerada pelo neuronio B para C: " + saidaR2);
        if (saidaR == 0){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}


        // Teste T
        System.out.println("Saida desejada (T): 0 em Neuronio A e 1 em Neuronio B " );
        saidaR = neuronio.calculaY(t);
        System.out.println("Saida Gerada pelo neuronio A para T: " + saidaR);
        saidaR2 = neuronio2.calculaY(t);
        System.out.println("Saida Gerada pelo neuronio B para T: " + saidaR2);

        if (saidaR == 0){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 1){
            acertos++;
        }else{erros++;}

        // Teste O
        System.out.println("Saida desejada (O): 1 em Neuronio A e 0 em Neuronio B");
        saidaR = neuronio.calculaY(o);
        System.out.println("Saida Gerada pelo neuronio A para O: " + saidaR);
        saidaR2 = neuronio2.calculaY(o);
        System.out.println("Saida Gerada pelo neuronio B para O: " + saidaR2);

        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}


        // Teste U
        System.out.println("Saida desejada (U): 1 em Neuronio A e 1 em Neuronio B");
        saidaR = neuronio.calculaY(u);
        System.out.println("Saida Gerada pelo neuronio A para U: " + saidaR);
        saidaR2 = neuronio2.calculaY(u);
        System.out.println("Saida Gerada pelo neuronio B para U: " + saidaR2);

        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 1){
            acertos++;
        }else{erros++;}


        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
