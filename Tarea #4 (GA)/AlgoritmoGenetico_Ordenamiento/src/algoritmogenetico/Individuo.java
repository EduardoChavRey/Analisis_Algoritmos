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
import java.util.*;
	
	
public class Individuo {

    private int [] genes;
    private ArrayList<Integer> Arreglo;
    //Caché
    private int fitness = 0;

    //crear un individuo aleatorio
    public void generarIndividuo(ArrayList<Integer> pArreglo){
        Random rg = new Random();
        genes= new int[pArreglo.size()];
        for(int i =0; i < pArreglo.size(); i++){
            genes[i] = pArreglo.get(i);
        }
        setArreglo(pArreglo);
    }

    public int getGen(int index){
        return genes[index];
    }
    
    public void setArreglo(ArrayList<Integer> pArreglo){
        Arreglo=pArreglo;
    }
    
    public ArrayList<Integer> getArreglo(){
        return Arreglo;
    }
    
    public void setGen(int index,int value){
        genes[index]=value;
        fitness=0;
    }
    
    public int size(){
        return genes.length;
    }
        
    public int getFitness() {
        if (fitness == 0) {
            fitness = FitnessCalc.getFitness(this);
        }
        return fitness;
    }

	
    public String toString(){
        String geneString="";
        for (int i=0;i<size();i++){
            geneString +=getGen(i);
        }
        return geneString;
    }
}