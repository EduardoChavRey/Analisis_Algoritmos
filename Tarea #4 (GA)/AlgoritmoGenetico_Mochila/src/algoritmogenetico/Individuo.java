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
    ArrayList<Objeto> Objetos = new ArrayList<Objeto>();
    byte [] genes;
    //Caché
    private int fitness = 0;

    //crear un individuo aleatorio
    public void generarIndividuo(ArrayList<Objeto> pObjetos){
        Random rg = new Random();
        genes = new byte[pObjetos.size()];
        for(int i =0; i < pObjetos.size() ; i++){
            byte gene = (byte) rg.nextInt(2);
            genes[i] = gene;
        }
        this.setObjetos(pObjetos);
    }
    
    public void setObjetos(ArrayList<Objeto> pObjetos){
        Objetos= pObjetos;
    }
    
    public ArrayList<Objeto> getObjetos(){
        return Objetos;
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    
    public byte getGen(int index){
        return genes[index];
    }
    
    public void setGen(int index,byte value){
        genes[index]=value;
        fitness=0;
    }
    
    public int size(){
        return genes.length;
    }
        
    public int getFitness() {

        return fitness = FitnessCalc.getFitness(this);
    }
    
    public int getPeso() {

        return fitness = FitnessCalc.getPeso(this);
    }

	
    public String toString(){
        String geneString="";
        for (int i=0;i<size();i++){
            geneString +=getGen(i);
        }
        return geneString;
    }
}