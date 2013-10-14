/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author OMAR
 */
public class CasillasGUIHMD extends javax.swing.JPanel implements MouseListener {
    
    private TableroGUIHMD tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    //private int seleccionar=1;
    private static int [] casillaMarcadaAnterior = new int[2];
    private  int  turno= 100 ;// -100 equipo  B
    public static final int casillaSelecta =1;
    public static final int casillaASeleccionar =2;
    public static final int turnoHumano =0;
    public static final int turnoMaquina =1;
    public CasillasGUIHMD() {        
        // este constructor no se usar&aacute;, se deja para poder crear el bean.        
    }
    
    public CasillasGUIHMD(TableroGUIHMD t) {
        initComponents();        
        this.tablero = t;
        if(this.tablero.getTipoTablero() == true){// tablero responde a clics?
            this.addMouseListener(this);
        }
    }
    
    public void setFondo(ImageIcon fondo){
        this.fondo = fondo;
    }
    
    public ImageIcon getFondo(){        
        return this.fondo;
    }
    
                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
    }                       
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(fondo.getImage(), 0,0,this.getWidth(),this.getHeight(),this);
    }
    
    public void mouseClicked(MouseEvent e){
        
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
          
            int valor=0;
            ///////////
            
            int Equipo=0;//Equipo A:0 inicializa las blancas
                         //Equipo B:1
            
            this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUIHMD)e.getComponent()));
             
            if(tablero.hayGanador()==0){
            
            switch(tablero.seleccionar){
                case casillaSelecta:
                            valor=tablero.devolverValorFichaSeleccionada();
                            if(valor>0 && tablero.restriccionA){
                                tablero.Equipo=turnoHumano;
                                tablero.restriccionA=false;
                                tablero.restriccionB=true;
                                tablero.marcarPosibilidades(valor,casillaMarcada[0],casillaMarcada[1]); 
                                tablero.pintar_tablero(false);
                                casillaMarcadaAnterior[0]=casillaMarcada[0];
                                casillaMarcadaAnterior[1]=casillaMarcada[1];
                                tablero.dibujarPosibilidades();
                                tablero.repaint();
                                tablero.seleccionar=casillaASeleccionar;//tiene que elegir sgte posicion
                                }
                         ;break;
                    
                case casillaASeleccionar:  
                    
                        if(tablero.evaluarMovimiento(casillaMarcada[0],casillaMarcada[1],tablero.Equipo)){
                            tablero.establecer_nueva_posicion(casillaMarcadaAnterior[0],casillaMarcadaAnterior[1], casillaMarcada[0],casillaMarcada[1]);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.actualizaMat(true);//copiar a la posibilidades
                            tablero.pintar_tablero(true);
                            tablero.pintar_tablero(false);
                            tablero.seleccionar=casillaSelecta;//vuelve a seleccionar;
                            tablero.Equipo=turnoMaquina;
                            movimientoMaquina(tablero.Equipo);
                        }else{
                            //Hace que se mantenga en el mismo turno
                            if(tablero.tablaPosibilidades[casillaMarcada[0]][casillaMarcada[1]]==10 && tablero.restriccionA){
                            tablero.actualizaMat(true);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.restriccionA=true;
                            //tablero.restriccionB=false;
                            tablero.seleccionar=casillaSelecta;//vuelve a seleccionar
                            }
                            
                           if(tablero.restriccionA){
                                tablero.restriccionA=false;
                                tablero.restriccionB=true;
                            }else{
                                tablero.restriccionA=true;
                                tablero.restriccionB=false;
                            }
                            tablero.actualizaMat(true);
                            tablero.redibujarTablero();
                            tablero.repaint();
                            tablero.seleccionar=casillaSelecta;
                        }       
                        ;break;
                      
        }
        }else{
                if(tablero.hayGanador()==4){
                    JOptionPane.showMessageDialog(null,"Gana  Jugador A");
                }else{
                    JOptionPane.showMessageDialog(null,"Gana  Jugador B");
                }
            }
            
            //this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1]);
            /******mas eventos*****/
    }
    public void movimientoMaquina(int equipo) {
        //Capturar todos los movimientos
        int tabla[][] = tablero.getTabla();
        ArrayList<Casillero> casillerosPiezasMaquinas = new ArrayList<Casillero>();
        Casillero provisional;
        int nroPosibilidades = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                provisional = new Casillero(i, j);
                if (tabla[i][j] == -1)//Pollo
                {
                    provisional.agregarPosibilidades(tablero.obtenerPosibilidadesPollo(i, j, equipo));
                    casillerosPiezasMaquinas.add(provisional);
                    nroPosibilidades=nroPosibilidades+provisional.tamPosibilidades();
                }
                if (tabla[i][j] == -2)//Cocodrilo
                {
                    provisional.agregarPosibilidades(tablero.obtenerPosibilidadesCocodrilo(i, j, equipo));
                    casillerosPiezasMaquinas.add(provisional);
                    nroPosibilidades=nroPosibilidades+provisional.tamPosibilidades();
                }
                if (tabla[i][j] == -3)//Humano
                {
                    provisional.agregarPosibilidades(tablero.obtenerPosibilidadesHumano(i, j, equipo));
                    casillerosPiezasMaquinas.add(provisional);
                    nroPosibilidades=nroPosibilidades+provisional.tamPosibilidades();
                }
                if (tabla[i][j] == -4)//Godzilla
                {
                    provisional.agregarPosibilidades(tablero.obtenerPosibilidadesGodzilla(i, j, equipo));
                    casillerosPiezasMaquinas.add(provisional);
                    nroPosibilidades=nroPosibilidades+provisional.tamPosibilidades();
                }
                if(tabla[i][j]==-5){
                //por implementar ...
                }
                tablero.actualizaMat(true);

            }


        }
        System.out.println("Nro Posibilidades: " + nroPosibilidades);
        int posibElegida;
        int nroPiezasMaquinas = casillerosPiezasMaquinas.size();
        int posibilidades = 0;
        int contador = 0;
        Double puntajeAdvancedMaximo=Double.MIN_VALUE;
        Casillero casilleroElegido=null;
        Casillero casilleroInicial=null;
        Casillero casilleroInicialMaximo=null;
        for (int a = 0; a < nroPiezasMaquinas; a++) {
            casilleroInicial = casillerosPiezasMaquinas.get(a);
            posibilidades = casilleroInicial.tamPosibilidades();
            for (int b = 0; b < posibilidades; b++) {
                contador++;
                if(puntajeAdvancedMaximo<casilleroInicial.obtenerPosibilidad(b).getPuntajeAdvanced()){
                    casilleroInicialMaximo=casilleroInicial;
                    puntajeAdvancedMaximo=casilleroInicialMaximo.obtenerPosibilidad(b).getPuntajeAdvanced();
                    casilleroElegido = casilleroInicialMaximo.obtenerPosibilidad(b);
                }
            }
        }
        tablero.establecer_nueva_posicion(casilleroInicialMaximo.getI(), casilleroInicialMaximo.getJ(), casilleroElegido.getI(), casilleroElegido.getJ());
        tablero.redibujarTablero();
        tablero.repaint();
        tablero.actualizaMat(true);//copiar a la posibilidades

        tablero.pintar_tablero(true);

        tablero.pintar_tablero(false);

        tablero.seleccionar = 1;//vuelve a seleccionar;
        tablero.Equipo = 0;//Turno del humano!
        tablero.restriccionA=true;
    }
    public void mouseReleased(MouseEvent e){}
    
    public static int[] getCasillaMarcada(){
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
}
