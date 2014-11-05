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
        ArrayList<Objeto> Objetos = new ArrayList<Objeto>();
        Objeto Zapato= new Objeto("Zapato", 2 , 10);
        Objeto Collar= new Objeto("Collar", 3 , 20);
        Objeto Lapiz= new Objeto("Lapiz", 1 , 2);
        Objeto Hoja= new Objeto("Hoja", 1 , 1);
        Objeto Computador= new Objeto("Computador", 20 , 500);
        Objeto Galleta= new Objeto("Galleta", 1 , 10);
        Objeto Mouse= new Objeto("Mouse", 4 , 8);
        Objeto DiscoDuro= new Objeto("Disco Duro", 10 , 30);
        Objeto MemoriaRam= new Objeto("Memoria Ram", 4 , 20);
        Objeto Procesador= new Objeto("Procesador", 1 , 70);
        Objeto Teclado= new Objeto("Teclado", 10 , 10);
        Objeto Microfono= new Objeto("Microfono", 1 , 10);
        Objeto Audifonos= new Objeto("Audifonos", 22 , 3);
        Objeto PS3Controller= new Objeto("Control de PS3", 5 , 20);
        
        Objetos.add(Zapato);Objetos.add(Collar);Objetos.add(Lapiz);Objetos.add(Hoja);
        Objetos.add(Computador);Objetos.add(Galleta);Objetos.add(Mouse);Objetos.add(DiscoDuro);
        Objetos.add(MemoriaRam);Objetos.add(Procesador);Objetos.add(Teclado);Objetos.add(Microfono);
        Objetos.add(Audifonos);Objetos.add(PS3Controller);

        // Se indica el maximo peso soportado por la mochila
        FitnessCalc.setPesoMaximo(64);
        // Se indica el limite de generaciones a dar.
        int limiteGeneraciones=1000;
        
        // Create an initial population
        Poblacion Poblacion = new Poblacion(50,Objetos, true);
        
        // Evolve our population until we reach an optimum solution
        int cuentaGeneracion = 1;
        while (cuentaGeneracion<limiteGeneraciones) {
            System.out.println("Generacion: " + cuentaGeneracion + " | Fittest (Individuo mas ideal): " + Poblacion.getFittest().getFitness());
            System.out.println(Poblacion.getFittest().toString());
            System.out.println();
            Poblacion = Algoritmo.evolucionarPoblacion(Poblacion);
            cuentaGeneracion++;
        }
        System.out.println("Solucion encontrada!");
        System.out.println("En la generacion: " + cuentaGeneracion);
        System.out.println("Con los Genes:" + Poblacion.getFittest());
        System.out.println("Con el valor total de " + Poblacion.getFittest().getFitness());
        System.out.println("Con el peso total de " + Poblacion.getFittest().getPeso());
        
        //System.out.println(Poblacion.getFittest().getFitness());
    }
}