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

    static int solucion;
    static int pesoMaximo;

    /* Public methods */
    // Set a candidate solucion as a byte array
    public static void setSolucion(int newSolucion) {
        solucion = newSolucion;
    }
    
    static int getSolucion(){
        return solucion;
    }
    
    public static void setPesoMaximo(int newPeso) {
        pesoMaximo = newPeso;
    }
    
    static int getPesoMaximo(){
        return pesoMaximo;
    }

    
    // Calculate inidividuals fittness by comparing it to our candidate solucion
    static int getFitness(Individuo individuo) {
        int fitness = 0;
        int peso=0;
        // Loop through our individuos genes and compare them to our cadidates
        for (int i = 0; i < individuo.size(); i++) {
            if (individuo.getGen(i)==1) {
                fitness+=individuo.getObjetos().get(i).getValorObjeto();
                peso+=individuo.getObjetos().get(i).getPesoObjeto();
            }
        }
        if (peso>pesoMaximo){
            fitness=0;
        }
        return fitness;
    }
    
    static int getPeso(Individuo individuo) {
        int peso=0;
        // Loop through our individuos genes and compare them to our cadidates
        for (int i = 0; i < individuo.size(); i++) {
            if (individuo.getGen(i)==1) {
                peso+=individuo.getObjetos().get(i).getPesoObjeto();
            }
        }
        return peso;
    }
    

}