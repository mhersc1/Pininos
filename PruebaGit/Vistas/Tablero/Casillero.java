/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero;

import java.util.ArrayList;
import java.util.Iterator;
import java.lang.NullPointerException;
/**
 *
 * @author OMAR
 */
public class Casillero {
    private int i;
    private int j;
    private ArrayList<Casillero> posibilidades;
    private ArrayList<Casillero> posibilidadesOponente;
    private int puntaje;
    private double puntajeAdvanced;
    public Casillero(int i,int j){
        this.i=i;
        this.j=j;
        posibilidades=new ArrayList();
        posibilidadesOponente=new ArrayList();
        
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public void setPosibilidades(ArrayList<Casillero> posibilidades) {
        this.posibilidades = posibilidades;
    }
    public void agregarPosibilidades(ArrayList<Casillero> posibilidades){
        this.posibilidades=posibilidades;
    }
    public void removerPosibilidades(){
        posibilidades.removeAll(posibilidades);
    }
    public int tamPosibilidades() {
        return posibilidades.size();
    }
    public Casillero obtenerPosibilidad(int nroPosibilidad){
        return posibilidades.get(nroPosibilidad);
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public ArrayList<Casillero> getPosibilidades() {
        return posibilidades;
    }

    public double getPuntajeAdvanced() {
        return puntajeAdvanced;
    }

    public void setPuntajeAdvanced(double puntajeAdvanced) {
        this.puntajeAdvanced = puntajeAdvanced;
    }

    public ArrayList<Casillero> getPosibilidadesOponente() {
        return posibilidadesOponente;
    }

    public void setPosibilidadesOponente(ArrayList<Casillero> posibilidadesOponente) {
        this.posibilidadesOponente = posibilidadesOponente;
    }
    
    public double obtenerMaxPuntajeHumanos(){
        //El maximo puntaje para los humanos va a ser negativo OJO!!!
        
        Iterator<Casillero> iterador=posibilidadesOponente.iterator();
        double puntajeMayor=1000000;
        while(iterador.hasNext()){
           //Cada uno de las piezas de juego del humano
           Casillero casillero=iterador.next();
           Iterator<Casillero> iterador2;
            iterador2 = casillero.getPosibilidades().iterator();
            //NoGraba aquiiiiiiiiiiiiiii
           while(iterador2.hasNext()){
                Casillero casiElegiPorHumano=iterador2.next();
              System.out.println("Entre al primer iterador 2!!!");
                if(puntajeMayor>casiElegiPorHumano.getPuntajeAdvanced())
               {
                 puntajeMayor=casiElegiPorHumano.getPuntajeAdvanced();
                }
           }
        }
       
        return puntajeMayor;
    }
}
