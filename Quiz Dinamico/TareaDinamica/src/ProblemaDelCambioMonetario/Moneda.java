    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ProblemaDelCambioMonetario;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Maestro
 */
public class Moneda {
    private int valorMoneda;
    private String nombreMoneda;
    
 
    
    public void crearMoneda (int valor,String nombre){
        if (valor>0){
            setValorMoneda(valor);
            setNombreMoneda(nombre);
        }
        else{
            System.out.println("No se pueden crear monedas, con valores menores a uno.");
        }
    }
    
    public static String DesgloseCambioMonedas(ArrayList<Moneda> Monedas){
        String resultado= new String();
        int sumatoria=0;
        for (int i = 0; i < Monedas.size(); i++) {
            sumatoria++;
            if (Monedas.size()==i+1){
                resultado+=sumatoria+" moneda(s) de valor "+Monedas.get(i).getValorMoneda()+"\n";
            }
            else{
                if (Monedas.get(i).getValorMoneda()==(Monedas.get(i+1).getValorMoneda())){
                    sumatoria=sumatoria;
                }
                else{
                    resultado+=sumatoria+" moneda(s) de valor "+Monedas.get(i).getValorMoneda()+"\n";
                    sumatoria=0;
                }
            }
        }
        System.out.println(resultado);
        return resultado;
    }
    
        public void CambioMonedasInicio (ArrayList<Moneda> listaMonedas, int Cambio){
        if (listaMonedas.isEmpty()){
            System.out.println("La lista de monedas no puede ser vacía.");
            return ;
        }
        String nombreMonedas= listaMonedas.get(0).getNombreMoneda();
        Collections.sort(listaMonedas, new OrdenaMonedas());
        for (int i = 0; i < listaMonedas.size(); i++) {
            if (listaMonedas.get(i).getValorMoneda()<=0){
                System.out.println(listaMonedas.get(i).getValorMoneda());
                System.out.println("No pueden existir monedas, cuyos valores sean menores a uno.");
                return ;
            }
            if (!listaMonedas.get(i).getNombreMoneda().contentEquals(nombreMonedas)){
                System.out.println("Error, todas las monedas deben ser del mismo tipo.");
                return ;
            }
        }
        System.out.println("El cambio de "+Cambio+" unidades monetarias de "+listaMonedas.get(0).getNombreMoneda()+": ");
        CambioMonedas(listaMonedas,Cambio,new ArrayList<Moneda>());
    }
    
    public ArrayList<Moneda> CambioMonedas (ArrayList<Moneda> listaMonedas, int Cambio, ArrayList<Moneda> Resultado) {
        if (Cambio==0){
            DesgloseCambioMonedas (Resultado);
            return Resultado;
        }
        int indice=0;
        while(Cambio - listaMonedas.get(indice).getValorMoneda() < 0){
            if (indice+2>listaMonedas.size()){
                System.out.println("Error");
                return null;
            }
            indice++;
        }
        Resultado.add(listaMonedas.get(indice));
        Cambio-= listaMonedas.get(indice).getValorMoneda();
        return CambioMonedas (listaMonedas, Cambio, Resultado);
    }
    
    
    public String printMoneda (){
        return valorMoneda+", "+nombreMoneda;
    }

    /**
     * @return the valorMoneda
     */
    public int getValorMoneda() {
        return valorMoneda;
    }

    /**
     * @param valorMoneda the valorMoneda to set
     */
    public void setValorMoneda(int valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

    /**
     * @return the nombreMoneda
     */
    public String getNombreMoneda() {
        return nombreMoneda;
    }

    /**
     * @param nombreMoneda the nombreMoneda to set
     */
    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }
    
}
