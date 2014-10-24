/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tareadinamica;

import ProblemaDeLasCiudadesEnLasCostasYLosPuentes.*;
import ProblemaDeLasCiudadesEnLasCostasYLosPuentes.SubsecuenciaMasLarga;
import ProblemaDelCambioMonetario.Moneda;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Maestro
 */
public class TareaDinamica {

    public int Fibonacci (int numero){
        if (numero==0){
            return 0;
        }
        if (numero==1){
            return 1;
        }
        else{
            return Fibonacci(numero-1)+Fibonacci(numero-2);
        }
    }
    
    public void PrimerEjercicio (ArrayList<Moneda> listaMonedas, int Cambio){
        Moneda Inicio= new Moneda();
        Inicio.CambioMonedasInicio(listaMonedas, Cambio);
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TareaDinamica Nueva= new TareaDinamica();
        
        System.out.println("Fibonacci: "+Nueva.Fibonacci(10));
        
        Moneda UnColon = new Moneda();
        UnColon.crearMoneda(1, "Colón");
        
        Moneda CincoColones = new Moneda();
        CincoColones.crearMoneda(5, "Colón");
        
        Moneda DiezColones = new Moneda();
        DiezColones.crearMoneda(10, "Colón");
        
        Moneda VeinticincoColones = new Moneda();
        VeinticincoColones.crearMoneda(25, "Colón");
        
        Moneda CincuentaColones = new Moneda();
        CincuentaColones.crearMoneda(50, "Colón");
        
        Moneda CienColones = new Moneda();
        CienColones.crearMoneda(100, "Colón");
        
        Moneda QuinientosColones = new Moneda();
        QuinientosColones.crearMoneda(500, "Colón");
        
        ArrayList<Moneda> ListaMonedas= new ArrayList<>();
        ListaMonedas.add(UnColon);
        ListaMonedas.add(CincoColones);
        ListaMonedas.add(DiezColones);
        ListaMonedas.add(VeinticincoColones);
        ListaMonedas.add(CincuentaColones);
        ListaMonedas.add(CienColones);
        ListaMonedas.add(QuinientosColones);
        //Collections.sort(ListaMonedas, new OrdenaMonedas());
        //for(Moneda moneda:ListaMonedas){
        //    System.out.println(moneda.getValorMoneda());
        //}
        Nueva.PrimerEjercicio(ListaMonedas,4999);
        Nueva.PrimerEjercicio(ListaMonedas,4);
        Nueva.PrimerEjercicio(ListaMonedas,500);
        
        SubsecuenciaMasLarga Sub= new SubsecuenciaMasLarga();

        
        Ciudad C1N=new Ciudad("Ciudad 1 (Norte)",1);
        Ciudad C2N=new Ciudad("Ciudad 2 (Norte)",2);
        Ciudad C3N=new Ciudad("Ciudad 3 (Norte)",3);
        Ciudad C4N=new Ciudad("Ciudad 4 (Norte)",2);
        Ciudad C5N=new Ciudad("Ciudad 5 (Norte)",16);
        Ciudad C6N=new Ciudad("Ciudad 6 (Norte)",74);
        Ciudad C7N=new Ciudad("Ciudad 7 (Norte)",10);
        Ciudad C8N=new Ciudad("Ciudad 8 (Norte)",12);
        Ciudad C9N=new Ciudad("Ciudad 9 (Norte)",13);
        ArrayList<Ciudad> Costa = new ArrayList<Ciudad>();
        Costa.add(C1N);Costa.add(C2N);Costa.add(C3N);Costa.add(C4N);Costa.add(C5N);
        Costa.add(C6N);Costa.add(C7N);Costa.add(C8N);Costa.add(C9N);
        Costa CostaA = new Costa(Costa);
        
        Sub.SubsecuenciaCreciente(CostaA, new Costa(new ArrayList<Ciudad>()));
    }
}
    
