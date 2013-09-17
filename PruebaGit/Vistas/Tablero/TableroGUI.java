/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero;

import LogicGame.Equipo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author OMAR
 */
public class TableroGUI extends javax.swing.JPanel {
    private ImageIcon agua, tocado;
    private boolean tipoTablero;
    private CasillasGUI [][] casillas ;
    
    private int filas,columnas;
    private final int anchoCasilla=70,alturaCasilla=70;
    Equipo equipoHumano,equipoMaquina;
    
    private int[][] tablero;
    
    public TableroGUI() {
        initComponents();
    }

    public TableroGUI(int filas,int columnas, boolean tipo) {
        initComponents();
        tablero=new int[5][8];
        for(int i =0;i <5;i++){
            for(int j =0;j <8;j++){
                tablero[i][j]=0;
            }
        }
        //Equipo A:
        tablero[0][0]=2;tablero[0][1]=1;
        tablero[1][0]=3;tablero[1][1]=1;
        tablero[2][0]=4;tablero[2][1]=1;
        tablero[3][0]=3;tablero[3][1]=1;
        tablero[4][0]=2;tablero[4][1]=1;
        
        //Equipo B:
        tablero[0][6]=-1;tablero[0][7]=-2;
        tablero[1][6]=-1;tablero[1][7]=-3;
        tablero[2][6]=-1;tablero[2][7]=-4;
        tablero[3][6]=-1;tablero[3][7]=-3;
        tablero[4][6]=-1;tablero[4][7]=-2;
        
        setLayout(new java.awt.GridLayout(filas, columnas));
        this.tipoTablero = tipo;
        cargarImagenes();
        casillas = new CasillasGUI[filas][columnas];
        this.filas=filas;
        this.columnas=columnas;
        //Cargar equipos!!!!
        equipoHumano=new Equipo();
        equipoMaquina=new Equipo();
        inicializarCampo();
        inicializarEquipoHumano();
        inicializarEquipoMaquina();
        
    }
    public void inicializarCampo(){
        int x,y;
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                casillas[i][j] = new CasillasGUI(this); 
                casillas[i][j].setFondo(agua);
                y = (i * (anchoCasilla+1))+1;
                x = (j * (alturaCasilla+1))+1;
                casillas[i][j].setBounds(x, y, anchoCasilla, alturaCasilla);
                this.add(casillas[i][j]);
            }
        }
    }
    public void inicializarEquipoHumano(){
        //casillas[2][0]=new CasillasGUI(this);
        //casillas[2][0].setFondo(equipoHumano.godzilla.getImagen());
        
    
    }
    public void inicializarEquipoMaquina(){
        
    }
    public boolean getTipoTablero(){
        return this.isTipoTablero();
    }
    
    public void pintar(int x, int y){
        this.casillas[x][y].setFondo(tocado);
        this.repaint();
    }
    
    private void cargarImagenes() {
        
        this.agua = this.cargarFondo("../../imagenes/agua.jpg");
        this.tocado = this.cargarFondo("../../imagenes/tocado.jpg");
    }
    
    protected static ImageIcon cargarFondo(String ruta) {
        java.net.URL localizacion = TableroGUI.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.out.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    
    public int[] getCoordenadas(CasillasGUI casilla) {
        int [] coordenadas = new int[2];
        for (int i=0; i < filas; i++) {
            for (int j=0; j < columnas; j++) {
                if (this.casillas[i][j] == casilla) {
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                    System.out.println("coordenada (i: "+i+" , "+ j+ ")");
                    
                    
                }
            }
        }
        return coordenadas;
    }
    
    public CasillasGUI[][] getCasillas() {
        return casillas;
    }
    
    public void setCasillas(CasillasGUI[][] casillas) {
        this.casillas = casillas;
    }
    
    public boolean isTipoTablero() {
        return tipoTablero;
    }    
    public void setTipoTablero(boolean tipoTablero) {
        this.tipoTablero = tipoTablero;
    }
                              
    private void initComponents() {

        setLayout(null);

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    }                      
                     
}