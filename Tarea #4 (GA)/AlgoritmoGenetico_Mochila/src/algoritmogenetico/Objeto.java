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
public class Objeto {
    private String nombreObjeto;
    private int pesoObjeto;
    private int valorObjeto;
    
    
    Objeto(){
        
    }
    
    Objeto(String pNombre,int pValor,int pPeso){
        setNombreObjeto(pNombre);
        setPesoObjeto(pPeso);
        setValorObjeto(pValor);
    }
    
    public void generarObjecto (String pNombre,int pPeso,int pValor){
        setNombreObjeto(pNombre);
        setPesoObjeto(pPeso);
        setValorObjeto(pValor);
    }

    /**
     * @return the nombreObjeto
     */
    public String getNombreObjeto() {
        return nombreObjeto;
    }

    /**
     * @param nombreObjeto the nombreObjeto to set
     */
    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    /**
     * @return the pesoObjeto
     */
    public int getPesoObjeto() {
        return pesoObjeto;
    }

    /**
     * @param pesoObjeto the pesoObjeto to set
     */
    public void setPesoObjeto(int pesoObjeto) {
        this.pesoObjeto = pesoObjeto;
    }

    /**
     * @return the valorObjeto
     */
    public int getValorObjeto() {
        return valorObjeto;
    }

    /**
     * @param valorObjeto the valorObjeto to set
     */
    public void setValorObjeto(int valorObjeto) {
        this.valorObjeto = valorObjeto;
    }
    
    
}
