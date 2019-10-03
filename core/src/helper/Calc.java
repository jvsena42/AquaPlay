package helper;

public class Calc {

    private static double coefHazenWillians;
    private static double vazao;
    private static double[] diametro;
    private static double comprimento;

    public static void main(String[] args) {

        //Parâmetros iniciais

        diametro  = new double [] {0.05,0.075,0.1}; /* Diâmetros em metro para PVC PBA*/
        coefHazenWillians=150; /*Valor para PVC*/
        vazao=0.00008125; /* Vazão em m³/s */
        comprimento = 200; /*Comprimento em metros*/

        double perdaDeCargaAB = perdaDeCargaTrecho(vazao,coefHazenWillians, diametro[2] ,comprimento);

        System.out.println("A perda de carga do trecho é: " + perdaDeCargaAB + " metros");
    }

    public static double perdaDeCargaTrecho(double q, double c , double d, double l) {

        double perdaDeCargaNoTrecho = (10.65 * Math.pow (q, 1.85)*l/(Math.pow (c, 1.85)*Math.pow (d, 4.87)));

        return perdaDeCargaNoTrecho;

    }

    public static double calculoVelocidade (double q, double d) {

        double area = Math.PI*Math.pow(d, 2)/4;
        double v = q/area;
        return v;
    }
}
