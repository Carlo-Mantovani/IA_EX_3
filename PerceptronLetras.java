
//Exemplo - Rede Perceptron com apenas 1 neuronio
import static java.lang.Math.*;


public class PerceptronLetras {
    private NeuronioLetras neuronio;
    private NeuronioLetras neuronio2;
    private double x1[] = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // 1a entrada C
    private double x2[] = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // 2a entrada T
   
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
                    if (i == 0) {// atualiza os pesos
                        neuronio.setWeights(erro1, x1, eta);

                    
                    } else {
                        neuronio.setWeights(erro1, x2, eta);

                       
                    }
                }
                if (erro2 != 0) {// atualiza os pesos
                    if (i == 0) {
                        neuronio2.setWeights(erro2, x1, eta);
                     

                    } else {
                        neuronio2.setWeights(erro2, x2, eta);

                       
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

    

    public void generalizacaoComTestes() {

        System.out.println("\n--- GENERALIZACAO");
        int acertos = 0;
        int erros = 0;
       
        double[] p1 = { 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }; // C
        double[] p2 = { 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 }; // T
       
        //testa com C
        System.out.println("Saida desejada: 1 em Neuronio C e 0 em Neuronio T");
        double saidaR = neuronio.calculaY(p1);
        System.out.println("Saida Gerada pelo neuronio C para C: " + saidaR);
        double saidaR2 = neuronio2.calculaY(p1);
        System.out.println("Saida Gerada pelo neuronio T para C: " + saidaR2);

        //contabiliza acertos e erros
        if (saidaR == 1){
            acertos++;
        } else {erros++;}
        if (saidaR2 == 0){
            acertos++;
        }else{erros++;}

        //testa com T
        System.out.println("Saida desejada: 0 em Neuronio C e 1 em Neuronio T");
        saidaR = neuronio.calculaY(p2);
        System.out.println("Saida Gerada pelo neuronio C para T: " + saidaR);
        saidaR2 = neuronio2.calculaY(p2);
        System.out.println("Saida Gerada pelo neuronio T para T: " + saidaR2);

        //contabiliza acertos e erros
        if (saidaR2 == 1){
            acertos++;
        } else {erros++;}
        if (saidaR == 0){
            acertos++;
        }else{erros++;}

   

        System.out.println("Acertos: " + acertos);
        System.out.println("Erros: " + erros);
    }
}
