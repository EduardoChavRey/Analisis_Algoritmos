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

public class AlgoritmoGenetico{
    public static void main(String[] args) {
		// Set a candidate solution
        
        ArrayList<Integer> Arreglo = new ArrayList<>();
        Arreglo.add(1);Arreglo.add(5);Arreglo.add(4);Arreglo.add(8);Arreglo.add(2);Arreglo.add(9);
        
        
        FitnessCalc.setSolucion((Arreglo.size()-1)*2);
        // Create an initial population
        Poblacion Poblacion = new Poblacion(50,Arreglo, true);
        
        // Evolve our population until we reach an optimum solution
        int cuentaGeneracion = 1;
        while (Poblacion.getFittest().getFitness() < FitnessCalc.getSolucion()) {
            System.out.println("Generacion: " + cuentaGeneracion + " | Fittest (Individuo mas ideal): " + Poblacion.getFittest().getFitness());
            System.out.println(Poblacion.getFittest().toString());
            System.out.println();
            Poblacion = Algoritmo.evolucionarPoblacion(Poblacion);
            cuentaGeneracion++;
        }
        System.out.println("Solucion encontrada!");
        System.out.println("En la generacion: " + cuentaGeneracion);
        System.out.println("Con los Genes:");
        System.out.println(Poblacion.getFittest());
        //System.out.println(Poblacion.getFittest().getFitness());
    }
}