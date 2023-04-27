
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;


public class PerceptronLetras1N {
    private NeuronioLetras neuronio;

    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada
    private double d[] = { 0, 1 }; // saida desejada. C = 0, T = 1
  

    
    public PerceptronLetras1N() {
        neuronio = new NeuronioLetras();

        inicializacao();
    }

    private void inicializacao() {

    }

    public void treinamento() { // algoritmo Regra Delta
        // Treinamento
        int epocas = 0, i;
        double y1,erro1,  erroGeral = 1;
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
               

                erro1 = d[i] - y1;// erro = saida desejada - saida da rede

                // ajuste dos pesos
                if (erro1 != 0 && i == 0) {

                    neuronio.setWeights(erro1, x1, eta);
                 

                }
                if (erro1 != 0 && i == 1) {
                    neuronio.setWeights(erro1, x2, eta);
                   
                }

                System.out.println("Neuronio1 - pesos: " + neuronio);

                erroGeral += abs(erro1);// calcula o erro geral

            }
            System.out.println("Erro geral: " + erroGeral);
            if (erroGeral == 0) {
                break;
            }

        }
    }



    public void generalizacaoComTestes() {

        System.out.println("\n--- GENERALIZACAO");
        int acertos = 0;
        int erros = 0;
        
        double[] p1 = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // C
        double[] p2 = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // T
       

        // Teste C
        System.out.println("Saida desejada: 0 (C) ");
        double saidaR = neuronio.calculaY(p1);
        System.out.println("Saida Gerada pelo neuronio  para C: " + saidaR);
        
         if (saidaR == 0) {
         acertos++;
         } else {
         erros++;
         }

        // Teste T
        System.out.println("Saida desejada: 1 (T)");
        saidaR = neuronio.calculaY(p2);
        System.out.println("Saida Gerada pelo neuronio para T: " + saidaR);
        if (saidaR == 1) {
            acertos++;
            } else {
            erros++;
            }

     

        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
