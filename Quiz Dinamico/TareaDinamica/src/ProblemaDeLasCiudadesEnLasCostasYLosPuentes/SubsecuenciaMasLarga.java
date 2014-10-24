/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemaDeLasCiudadesEnLasCostasYLosPuentes;

import java.util.ArrayList;

/**
 *
 * @author curso
 */
public class SubsecuenciaMasLarga {
    
    public ArrayList<Integer> SubsecuenciaCreciente (ArrayList<Integer> Lista, ArrayList<Integer> Optima){
        if (Lista.isEmpty()){
            for (Integer L:Optima){
                System.out.println(L);
            }
            return Optima;
        }
        ArrayList<Integer> OptimaTemporal= new ArrayList<Integer>();
        if (!Optima.isEmpty()){
            if (Lista.get(0)>Optima.get(Optima.size()-1)){
                Optima.add(Lista.get(0));
                Lista.remove(0);
                return SubsecuenciaCreciente(Lista,Optima);
            }
            else{
                return max(Optima,SubsecuenciaCreciente(Lista,new ArrayList<Integer>()));
            }
        }
        else{
            Optima.add(Lista.get(0));
            Lista.remove(0);
            return SubsecuenciaCreciente(Lista,Optima);
        }
    }

    private ArrayList<Integer> max(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size()>b.size())
            return a;
        else
            return b;
    }
    
    public Costa SubsecuenciaCreciente (Costa Lista){
        if (validadNoRepeticion(Lista)){
            return SubsecuenciaCreciente ( Lista, new Costa(new ArrayList<Ciudad>()));
        }
        else{
            System.out.println("Error, las ciudades no deben tener valores ni nombres iguales.");
            return null;
        }
    }
    
    public Costa SubsecuenciaCreciente (Costa Lista, Costa Optima){
        if (Lista.CiudadesDeCosta.isEmpty()){
            for (Ciudad L:Optima.CiudadesDeCosta){
                System.out.println(L.numeroCiudad);
            }
            return Optima;
        }
        if (!Optima.CiudadesDeCosta.isEmpty()){
            if (Lista.CiudadesDeCosta.get(0).numeroCiudad>Optima.CiudadesDeCosta.get(Optima.CiudadesDeCosta.size()-1).numeroCiudad){
                Optima.CiudadesDeCosta.add(Lista.CiudadesDeCosta.get(0));
                Lista.CiudadesDeCosta.remove(0);
                return SubsecuenciaCreciente(Lista,Optima);
            }
            else{
                return max(Optima,SubsecuenciaCreciente(Lista,new Costa(new ArrayList<Ciudad>())));
            }
        }
        else{
            Optima.CiudadesDeCosta.add(Lista.CiudadesDeCosta.get(0));
            Lista.CiudadesDeCosta.remove(0);
            return SubsecuenciaCreciente(Lista,Optima);
        }
    }

    private Costa max(Costa a, Costa b) {
        if (a.CiudadesDeCosta.size()>b.CiudadesDeCosta.size())
            return a;
        else
            return b;
    }
    
    public boolean validadNoRepeticion(Costa Costa){
        Costa auxCosta= Costa;
        if (Costa.CiudadesDeCosta.isEmpty()){
            return true;
        }
        else{
            for (int i=0; i<Costa.CiudadesDeCosta.size();i++){
                Ciudad temporal= auxCosta.CiudadesDeCosta.get(0);
                auxCosta.CiudadesDeCosta.remove(0);
                for (int ii=0; ii<auxCosta.CiudadesDeCosta.size();ii++){
                    if(auxCosta.CiudadesDeCosta.get(ii).nombreCiudad.contentEquals(temporal.nombreCiudad) || 
                            auxCosta.CiudadesDeCosta.get(ii).numeroCiudad == temporal.numeroCiudad){
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    public boolean validaOrdenLista(Costa Costa){
        if (Costa.CiudadesDeCosta.isEmpty()){
            return true;
        }
        for (int i=0; i<Costa.CiudadesDeCosta.size();i++){
            if (i==0){
                
            }
            else{
                if (Costa.CiudadesDeCosta.get(i).numeroCiudad>Costa.CiudadesDeCosta.get(i-1).numeroCiudad){
                    
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
