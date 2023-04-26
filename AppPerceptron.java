
/**
 * Write a description of class AppPerceptron here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class AppPerceptron {
    public static void main(String args[]) {
        Perceptron rede = new Perceptron();//rede de bom/mau pagador com 2 neuronios

         //rede.treinamento();
         //rede.generalizacaoComTestes();

        PerceptronLetras rede2 = new PerceptronLetras();

        //rede2.treinamento();
        //rede2.generalizacaoComTestes();

        PerceptronLetras1N rede3 = new PerceptronLetras1N();

        //rede3.treinamento();
        //rede3.generalizacaoComTestes();

        PerceptronMultipleLetters rede4 = new PerceptronMultipleLetters();

        rede4.treinamento();
        rede4.generalizacaoComTestes();
    }
}
