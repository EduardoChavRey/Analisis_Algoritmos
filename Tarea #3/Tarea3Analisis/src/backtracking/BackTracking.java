/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backtracking;

import java.util.ArrayList;

/**
 *
 * @author Maestro
 */
public class BackTracking {
    
    BackTracking(){
        
    }
    
    int MisionerosDeIsla1;
    int CanibalesDeIsla1;
    int MisionerosDelBote;
    int CanibalesDelBote;
    int IslaBote;
    int MisionerosDeIsla2;
    int CanibalesDeIsla2;
    ArrayList<Integer> TurnoActual= new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> EstadosExplorados = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> BackTrackEstadosExplorados = new ArrayList<ArrayList<Integer>>();
    boolean victoria= false;
    
    public void Inicio (int misionerosIniciales, int canibalesIniciales){
        MisionerosDeIsla1=misionerosIniciales;
        CanibalesDeIsla1=canibalesIniciales;
        MisionerosDelBote=0;
        CanibalesDelBote=0;
        IslaBote=1;
        MisionerosDeIsla2=0;
        CanibalesDeIsla2=0;
        TurnoActual.add(MisionerosDeIsla1);
        TurnoActual.add(CanibalesDeIsla1);
        TurnoActual.add(MisionerosDelBote);
        TurnoActual.add(MisionerosDelBote);
        TurnoActual.add(IslaBote);
        TurnoActual.add(MisionerosDeIsla2);
        TurnoActual.add(CanibalesDeIsla2);
    }
    
    public void guardarPartida(){
        ArrayList<Integer> Temporal= new ArrayList<Integer>();
        Temporal.add(MisionerosDeIsla1);
        Temporal.add(CanibalesDeIsla1);
        Temporal.add(MisionerosDelBote);
        Temporal.add(CanibalesDelBote);
        Temporal.add(IslaBote);
        Temporal.add(MisionerosDeIsla2);
        Temporal.add(CanibalesDeIsla2);
        BackTrackEstadosExplorados.add(Temporal);
        ShowTurno();
        IsVictory();
    }
    
    public void ShowTurno (){
        actualizarTurno();
        
        System.out.println("Isla 1: [Misioneros= "+TurnoActual.get(0).toString()+", Canivales= "+TurnoActual.get(1).toString()+"] \n"
                         +"Bote:  [Misioneros= "+TurnoActual.get(2).toString()+", Canivales= "+TurnoActual.get(3).toString()+", Isla= "+TurnoActual.get(4).toString()+"] \n"
                         +"Isla 2: [Misioneros= "+TurnoActual.get(5).toString()+", Canivales= "+TurnoActual.get(6).toString()+"] \n");
        System.out.println(BackTrackEstadosExplorados.toString());
    }
    
    public void BackTracking (){
        System.out.println("Estados ya explorados: "+EstadosExplorados.toString());
        if ((CanibalesDeIsla1>MisionerosDeIsla1 && MisionerosDeIsla1!=0) || (CanibalesDeIsla2>MisionerosDeIsla2 && MisionerosDeIsla2!=0)){
            System.out.println("Usando BackTracking");
            MisionerosDeIsla1= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(0);
            CanibalesDeIsla1= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(1);
            MisionerosDelBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(2);
            CanibalesDelBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(3);
            IslaBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(4);
            MisionerosDeIsla2= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(5);
            CanibalesDeIsla2= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(6);
            
            EstadosExplorados.add(BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-1));
            BackTrackEstadosExplorados.remove(BackTrackEstadosExplorados.size()-1);
            
            guardarPartida();
        }
        if (MisionerosDelBote==1 && (CanibalesDeIsla2>MisionerosDeIsla2 && CanibalesDeIsla2!=1)){
            System.out.println("Usando BackTracking");
            MisionerosDeIsla1= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(0);
            CanibalesDeIsla1= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(1);
            MisionerosDelBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(2);
            CanibalesDelBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(3);
            IslaBote= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(4);
            MisionerosDeIsla2= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(5);
            CanibalesDeIsla2= BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-2).get(6);
            
            EstadosExplorados.add(BackTrackEstadosExplorados.get(BackTrackEstadosExplorados.size()-1));
            BackTrackEstadosExplorados.remove(BackTrackEstadosExplorados.size()-1);
            
            guardarPartida();
        }
        
    }
    
    public boolean VerificarValidezEstados(int TMisionerosDeIsla1,int TCanibalesDeIsla1,int TMisionerosDelBote,int TCanibalesDelBote,int TIslaBote,int TMisionerosDeIsla2,int TCanibalesDeIsla2){
        actualizarTurno();
        ArrayList<Integer> Temporal= new ArrayList<Integer>();
        Temporal.add(TMisionerosDeIsla1);
        Temporal.add(TCanibalesDeIsla1);
        Temporal.add(TMisionerosDelBote);
        Temporal.add(TCanibalesDelBote);
        Temporal.add(TIslaBote);
        Temporal.add(TMisionerosDeIsla2);
        Temporal.add(TCanibalesDeIsla2);
        if (TMisionerosDeIsla1<0 || TCanibalesDeIsla1<0 || TMisionerosDelBote<0 || TCanibalesDelBote<0 || TIslaBote<=0 || TMisionerosDeIsla2<0 || TCanibalesDeIsla2<0){
            return false;
        }
        if (EstadosExplorados.isEmpty()){
            return true;
        }
        else{
            System.out.println("Validacion");
            System.out.println("Is "+Temporal.toString()+" in "+EstadosExplorados.toString());
        return !(EstadosExplorados.contains(Temporal));
        }
    }
    
    public void EntrarBote(){
        if (MisionerosDelBote + CanibalesDelBote < 2 && CanibalesDeIsla2+CanibalesDelBote<2){
            if (VerificarValidezEstados(MisionerosDeIsla1,CanibalesDeIsla1-1,MisionerosDelBote,CanibalesDelBote+1,IslaBote,MisionerosDeIsla2,CanibalesDeIsla2)){
                CanibalesDeIsla1--;
                CanibalesDelBote++;
                guardarPartida();
                return; 
                
            }
            if (VerificarValidezEstados(MisionerosDeIsla1-1,CanibalesDeIsla1,MisionerosDelBote+1,CanibalesDelBote,IslaBote,MisionerosDeIsla2,CanibalesDeIsla2)){
                MisionerosDeIsla1--;
                MisionerosDelBote++;
                guardarPartida();
                return; 
            }
        }
        else{
            if (VerificarValidezEstados(MisionerosDeIsla1-1,CanibalesDeIsla1,MisionerosDelBote+1,CanibalesDelBote,IslaBote,MisionerosDeIsla2,CanibalesDeIsla2)){
                MisionerosDeIsla1--;
                MisionerosDelBote++;
                guardarPartida();
                return; 
            }
            if (VerificarValidezEstados(MisionerosDeIsla1,CanibalesDeIsla1-1,MisionerosDelBote,CanibalesDelBote+1,IslaBote,MisionerosDeIsla2,CanibalesDeIsla2)){
                CanibalesDeIsla1--;
                CanibalesDelBote++;
                guardarPartida();
                return; 
                
            }
            
        }
    }
    
    public void IsVictory(){
        if (MisionerosDeIsla1==0 && CanibalesDeIsla1==0){
            victoria=true;
            MisionerosDeIsla2+=MisionerosDelBote;
            CanibalesDeIsla2+=CanibalesDelBote;
            MisionerosDelBote=MisionerosDelBote-MisionerosDelBote;
            CanibalesDelBote=CanibalesDelBote-CanibalesDelBote;
            ShowTurno();
        }
    }
    
    public void SalirBote(){
        if (MisionerosDelBote+CanibalesDelBote>1){
            if (VerificarValidezEstados(MisionerosDeIsla1,CanibalesDeIsla1,MisionerosDelBote-1,CanibalesDelBote,IslaBote,MisionerosDeIsla2+1,CanibalesDeIsla2)){
                MisionerosDelBote--;
                MisionerosDeIsla2++;
                guardarPartida();
                return; 
            }
            if (VerificarValidezEstados(MisionerosDeIsla1,CanibalesDeIsla1,MisionerosDelBote,CanibalesDelBote-1,IslaBote,MisionerosDeIsla2,CanibalesDeIsla2+1)){
                CanibalesDelBote--;
                CanibalesDeIsla2++;
                guardarPartida();
                return; 
            }
        if (MisionerosDeIsla1==0 && CanibalesDeIsla1==0){
            if (MisionerosDelBote>0){
                MisionerosDelBote--;
                MisionerosDeIsla2++;
                guardarPartida();
                return; 
            }
            if (CanibalesDelBote>0){
                CanibalesDelBote--;
                CanibalesDeIsla2++;
                guardarPartida();
                return; 
            }
        }
        else{
            BackTracking();
        }
        }
    }
    
    public void actualizarTurno (){
        ArrayList<Integer> Temporal= new ArrayList<Integer>();
        Temporal.add(MisionerosDeIsla1);
        Temporal.add(CanibalesDeIsla1);
        Temporal.add(MisionerosDelBote);
        Temporal.add(CanibalesDelBote);
        Temporal.add(IslaBote);
        Temporal.add(MisionerosDeIsla2);
        Temporal.add(CanibalesDeIsla2);
        TurnoActual= Temporal;
    }
    
    public void Win (){
        if (MisionerosDeIsla1<CanibalesDeIsla1){
            System.out.println("Es imposible ganar.");
            return ;
        }
        while (victoria!=true){
            EntrarBote();
            BackTracking ();
            SalirBote();
            BackTracking ();
        }
        System.out.println("Se ha terminado el algoritmo");
        return;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BackTracking Game = new BackTracking();
        Game.Inicio(5, 5);
        Game.Win();
        
        // TODO code application logic here
    }

    public int getMisionerosDeIsla1() {
        return MisionerosDeIsla1;
    }

    public void setMisionerosDeIsla1(int MisionerosDeIsla1) {
        this.MisionerosDeIsla1 = MisionerosDeIsla1;
    }

    public int getCanibalesDeIsla1() {
        return CanibalesDeIsla1;
    }

    public void setCanibalesDeIsla1(int CanibalesDeIsla1) {
        this.CanibalesDeIsla1 = CanibalesDeIsla1;
    }

    public int getMisionerosDelBote() {
        return MisionerosDelBote;
    }

    public void setMisionerosDelBote(int MisionerosDelBote) {
        this.MisionerosDelBote = MisionerosDelBote;
    }

    public int getCanibalesDelBote() {
        return CanibalesDelBote;
    }

    public void setCanibalesDelBote(int CanibalesDelBote) {
        this.CanibalesDelBote = CanibalesDelBote;
    }

    public int getIslaBote() {
        return IslaBote;
    }

    public void setIslaBote(int IslaBote) {
        this.IslaBote = IslaBote;
    }

    public int getMisionerosDeIsla2() {
        return MisionerosDeIsla2;
    }

    public void setMisionerosDeIsla2(int MisionerosDeIsla2) {
        this.MisionerosDeIsla2 = MisionerosDeIsla2;
    }

    public int getCanibalesDeIsla2() {
        return CanibalesDeIsla2;
    }

    public void setCanibalesDeIsla2(int CanibalesDeIsla2) {
        this.CanibalesDeIsla2 = CanibalesDeIsla2;
    }

    public ArrayList<Integer> getTurnoActual() {
        return TurnoActual;
    }

    public void setTurnoActual(ArrayList<Integer> TurnoActual) {
        this.TurnoActual = TurnoActual;
    }

    public ArrayList<ArrayList<Integer>> getEstadosExplorados() {
        return EstadosExplorados;
    }

    public void setEstadosExplorados(ArrayList<ArrayList<Integer>> EstadosExplorados) {
        this.EstadosExplorados = EstadosExplorados;
    }

    public ArrayList<ArrayList<Integer>> getBackTrackEstadosExplorados() {
        return BackTrackEstadosExplorados;
    }

    public void setBackTrackEstadosExplorados(ArrayList<ArrayList<Integer>> BackTrackEstadosExplorados) {
        this.BackTrackEstadosExplorados = BackTrackEstadosExplorados;
    }
    
}
