/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmogenetico;

/**
 *
 * @author Maestro
 */

public class FitnessCalc {
    static int solucion; // n-1 * 2

    /* Public methods */
    // Set a candidate solucion as a byte array
    public static void setSolucion(int newSolucion) {
        solucion = newSolucion;
    }

    static int getSolucion() {
        return solucion;
    }

    // Calculate inidividuals fittness by comparing it to our candidate solucion
    static int getFitness(Individuo individuo) {
        int fitness = 0;
        // Loop through our individuos genes and compare them to our cadidates
        for (int i = 0; i < individuo.getArreglo().size(); i++) {
            if (i==0) {
                if (individuo.getGen(i)< individuo.getGen(i+1) )
                    fitness++;
            }
            
            if (i==individuo.size()-1){
                    if (individuo.getGen(i)> individuo.getGen(i-1) )
                    fitness++;
            }
            else{
                if (i!=0 && i!=individuo.size()-1){
                    if (individuo.getGen(i)< individuo.getGen(i+1)){
                        fitness++;
                    }
                    if (individuo.getGen(i)> individuo.getGen(i-1)){
                        fitness++;
                    }
                }
            }
        }
        return fitness;
    }
    

}