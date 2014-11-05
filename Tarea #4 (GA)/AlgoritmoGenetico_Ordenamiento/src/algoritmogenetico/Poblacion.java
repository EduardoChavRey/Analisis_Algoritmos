/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmogenetico;

import java.util.ArrayList;

/**
 *
 * @author Maestro
 */

public class Poblacion {

    Individuo[] individuos;

    /*
     * Constructors
     */
    // Create a population
    public Poblacion(int tamanoPoblacion,ArrayList<Integer> pArreglo,boolean inicializar) {
        individuos = new Individuo [tamanoPoblacion];
        // Initialise population
        if (inicializar){
            // Loop and create individuals
            for (int i=0;i<tamanoPoblacion;i++){
		Individuo nuevoIndividuo = new Individuo();
		nuevoIndividuo.generarIndividuo(pArreglo);
		guardarIndividuo(i,nuevoIndividuo);
            }
        }
    }

    /* Getters */
    public Individuo getIndividuo(int index){
            return individuos[index];
	}

    public Individuo getFittest(){
	Individuo fittest = individuos[0];
	for (int i=0;i<size();i++){
            if (fittest.getFitness()<= getIndividuo(i).getFitness()){
		fittest=getIndividuo(i);
            }
	}
	return fittest;
    }

    /* Public methods */
    // Get population size
    public int size(){
	return individuos.length;
    }
    
    public void guardarIndividuo(int index,Individuo indiv){
	individuos[index] = indiv;
    }
}