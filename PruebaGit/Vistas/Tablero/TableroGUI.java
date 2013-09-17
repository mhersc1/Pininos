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
    private ImageIcon cocodriloA,gozillaA,hombreA,polloA;
    private ImageIcon cocodriloB,gozillaB,hombreB,polloB;
    private ImageIcon agua, tocado;
    private boolean tipoTablero;
    private CasillasGUI [][] casillas ;
    
    private int filas,columnas;
    private final int anchoCasilla=70,alturaCasilla=70;
    Equipo equipoHumano,equipoMaquina;
    
    int turno_actual=100;//turnoA=100 ,turnoB=-100
    int fila_actual,columna_actual;
    
    public int getTurno_actual() {
        return turno_actual;
    }

    public void setTurno_actual(int turno_actual) {
        this.turno_actual = turno_actual;
    }
    

    public int getFila_actual() {
        return fila_actual;
    }

    public void setFila_actual(int fila_actual) {
        this.fila_actual = fila_actual;
    }

    public int getColumna_actual() {
        return columna_actual;
    }

    public void setColumna_actual(int columna_actual) {
        this.columna_actual = columna_actual;
    }
    private int[][] tabla;

    public int[][] getTabla() {
        return tabla;
    }
    
    public TableroGUI() {
        initComponents();
    }

    public TableroGUI(int filas,int columnas, boolean tipo) {
        initComponents();
        tabla=new int[5][8];
        for(int i =0;i <5;i++){
            for(int j =0;j <8;j++){
                tabla[i][j]=0;
            }
        }
        //Equipo A:
        tabla[0][0]=2;tabla[0][1]=1;
        tabla[1][0]=3;tabla[1][1]=1;
        tabla[2][0]=4;tabla[2][1]=1;
        tabla[3][0]=3;tabla[3][1]=1;
        tabla[4][0]=2;tabla[4][1]=1;
        
        //Equipo B:
        tabla[0][6]=-1;tabla[0][7]=-2;
        tabla[1][6]=-1;tabla[1][7]=-3;
        tabla[2][6]=-1;tabla[2][7]=-4;
        tabla[3][6]=-1;tabla[3][7]=-3;
        tabla[4][6]=-1;tabla[4][7]=-2;
        
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
        pintar_tablero();
        
    }
    void pintar_tablero(){
        for(int i =0;i <5;i++){
            for(int j =0;j <8;j++){
                System.out.print(" "+tabla[i][j]+" ");
            }
            System.out.println(" ");
        }
    }
    
    public void inicializarCampo(){
        int x,y,valor=0;
        
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++){
                casillas[i][j] = new CasillasGUI(this); 
                casillas[i][j].setFondo(agua);
                valor=tabla[i][j];
                switch( valor){
                    case -1: casillas[i][j].setFondo(polloB); break;
                    case -2: casillas[i][j].setFondo(cocodriloB);break;
                    case -3: casillas[i][j].setFondo(hombreB);break;
                    case -4: casillas[i][j].setFondo(gozillaB);break;
                    case 1: casillas[i][j].setFondo(polloA);break; 
                    case 2: casillas[i][j].setFondo(cocodriloA);break;
                    case 3: casillas[i][j].setFondo(hombreA);break;
                    case 4: casillas[i][j].setFondo(gozillaA);break;
                    default : casillas[i][j].setFondo(agua);  
                    
                }
                y = (i * (anchoCasilla+1))+1;
                x = (j * (alturaCasilla+1))+1;
                casillas[i][j].setBounds(x, y, anchoCasilla, alturaCasilla);
                this.add(casillas[i][j]);
            }
        }
    }
    
    boolean validarTuno(){
        int fila=this.fila_actual;
        int columna=this.columna_actual;
        boolean suTurno=false;
        if((tabla[fila][columna]>0 && turno_actual==100)||(tabla[fila][columna]<0 && turno_actual==-100)){
            suTurno=true;
            System.out.println("Es su turno");
        }
        return suTurno;
    }
    public int devolverValorFichaSeleccionada(){
        return tabla[this.fila_actual][this.columna_actual];
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
        
        this.gozillaA=this.cargarFondo("../../imagenes_jugadores/godzillaA.jpg");
        this.hombreA=this.cargarFondo("../../imagenes_jugadores/hombreA.gif");
        this.cocodriloA=this.cargarFondo("../../imagenes_jugadores/cocodriloA.gif");
        this.polloA=this.cargarFondo("../../imagenes_jugadores/polloA.gif");
        
        this.gozillaB=this.cargarFondo("../../imagenes_jugadores/godzillaA.jpg");
        this.hombreB=this.cargarFondo("../../imagenes_jugadores/hombreA.gif");
        this.cocodriloB=this.cargarFondo("../../imagenes_jugadores/cocodriloA.gif");
        this.polloB=this.cargarFondo("../../imagenes_jugadores/polloA.gif");
        
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
                    this.columna_actual=j;
                    this.fila_actual=i;
                    
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