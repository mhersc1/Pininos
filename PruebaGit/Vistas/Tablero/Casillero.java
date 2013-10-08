/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero;

import java.util.ArrayList;
import java.util.Iterator;

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
    public Casillero(int i,int j){
        this.i=i;
        this.j=j;
        posibilidades=new ArrayList();
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

    public ArrayList<Casillero> getPosibilidadesOponente() {
        return posibilidadesOponente;
    }

    public void setPosibilidadesOponente(ArrayList<Casillero> posibilidadesOponente) {
        this.posibilidadesOponente = posibilidadesOponente;
    }
    public int obtenerMaxPuntajeHumanos(){
        Iterator<Casillero> iterador=posibilidadesOponente.iterator();
        int puntajeMayor=1000000;
       while(iterador.hasNext()){
           Casillero casillero=iterador.next();
            if(puntajeMayor<casillero.getPuntaje()){
                puntajeMayor=casillero.getPuntaje();
            }
        }
       System.out.println("El puntaje mayor es: "+puntajeMayor);
        return puntajeMayor;
    }
}
