package helper;

import com.badlogic.gdx.math.Interpolation;

import pipes.Pipe;

public class Calc {

    private float coefHazenWillians;
    private float flow;
    private float diameter[];


    public Calc() {

        //Initial parameters
        diameter  = new float[] {0.05f,0.075f,0.1f}; /* Diameters in meters to PVC PBA*/
        coefHazenWillians=150f; /*PVC*/
        flow=0.00008125f; /* Flow rate in m³/s */


        //System.out.println("A perda de carga do trecho é: " + perdaDeCarga + " metros");
    }

    public float downStreamEnergy (float upStreamEnergy,float l){
        float perdaDeCarga =perdaDeCargaTrecho(flow,coefHazenWillians,0.075f,l);
        float energy = 0;
        return energy = upStreamEnergy-perdaDeCarga;
    }


    public float perdaDeCargaTrecho(float q, float c , float d, float l) {

        float perdaDeCargaNoTrecho = 22f;//(float) (10.65f * Math.pow (q, 1.85f)*l/(Math.pow (c, 1.85f)*Math.pow (d, 4.87f)));
        return perdaDeCargaNoTrecho;

    }

   /* public double calculoVelocidade (float q, float d) {

        float area = 3.14f*Math.pow(d, 2f)/4f;
        float v = q/area;
        return v;
    }*/
}
