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
public class Algoritmo {

    /* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int torneoSize = 5;
    private static final boolean elitism = true;

    /* Public methods */
    
    // Evolve a population
    public static Poblacion evolucionarPoblacion(Poblacion pop) {
        Poblacion newPoblacion = new Poblacion(pop.size(),pop.getIndividuo(0).getArreglo(), false);

        // Keep our best individual
        if (elitism) {
            newPoblacion.guardarIndividuo(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new individuals with
        // cruce
        for (int i = elitismOffset; i < pop.size(); i++) {
            Individuo indiv1 = torneoSeleccion(pop);
            Individuo indiv2 = torneoSeleccion(pop);
            Individuo newIndiv = cruce(indiv1, indiv2);
            newPoblacion.guardarIndividuo(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPoblacion.size(); i++) {
            mutar(newPoblacion.getIndividuo(i));
        }

        return newPoblacion;
    }

    // Crossover individuals
    private static Individuo cruce(Individuo indiv1, Individuo indiv2) {
        Individuo newSol = new Individuo();
        // Loop through genes
        newSol.generarIndividuo(indiv1.getArreglo());
        for (int i = 0; i < indiv1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGen(i, indiv1.getGen(i));
            } else {
                newSol.setGen(i, indiv2.getGen(i));
            }
        }
        return newSol;
    }

    // Mutate an individual
    private static void mutar(Individuo indiv) {
        // Loop through genes
        for (int i = 0; i < indiv.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
                int ran1 = (int)(Math.random()*indiv.size()) + 0;
                System.out.println(ran1);
                int ran2 = (int)(Math.random()*indiv.size()) + 0;
                System.out.println(ran2);
               indiv.setGen(ran1, indiv.getGen(ran2));
               indiv.setGen(ran2, indiv.getGen(ran1));
            }
        }
    }

    // Select individuals for cruce
    private static Individuo torneoSeleccion(Poblacion pop) {
        // Create a torneo population
        Poblacion torneo = new Poblacion(torneoSize,pop.getIndividuo(0).getArreglo(), false);
        // For each place in the torneo get a random individual
        for (int i = 0; i < torneoSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            torneo.guardarIndividuo(i, pop.getIndividuo(randomId));
        }
        // Get the fittest
        Individuo fittest = torneo.getFittest();
        return fittest;
    }
}