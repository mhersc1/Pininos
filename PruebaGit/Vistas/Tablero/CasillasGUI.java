/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author OMAR
 */
public class CasillasGUI extends javax.swing.JPanel implements MouseListener {
    
    private TableroGUI tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    //private int seleccionar=1;
    private static int [] casillaMarcadaAnterior = new int[2];
    
    public CasillasGUI() {        
        // este constructor no se usar&aacute;, se deja para poder crear el bean.        
    }
    
    public CasillasGUI(TableroGUI t) {
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
        //System.out.println("segundo click");
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
            System.out.println("selecciona="+tablero.seleccionar);
            int valor=0;
            this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI)e.getComponent())); 
            switch(tablero.seleccionar){
                case 1:
                        System.out.println("selecciona una  ficha ***********************");
                        if(tablero.validarTuno()){/*si has escogido una  ficha que corresponde al equipo con turno */
                        /*movimiento valido*/ 
                            valor=tablero.devolverValorFichaSeleccionada();
                            if(tablero.getTurno_actual()==100){
                                tablero.marcarPosibilidades(valor,casillaMarcada[0],casillaMarcada[1]); 
                                tablero.pintar_tablero(false);
                                casillaMarcadaAnterior[0]=casillaMarcada[0];
                                casillaMarcadaAnterior[1]=casillaMarcada[1];
                                tablero.dibujarPosibilidades();
                                tablero.repaint();
                                //System.out.println("seleccionar=2");
                                tablero.seleccionar=2;//tiene que elegir sgte posicion
                                
                            }
        
                            if(tablero.getTurno_actual()==-100){
                            /*juega Equipo B*/
                            }
                            System.out.println("selecciona="+tablero.seleccionar);
                         };break;
                    
                case 2:  
                    
                        System.out.println("muever una  ficha **************************");                         
                        if(tablero.evaluarMovimiento(casillaMarcada[0],casillaMarcada[1])){
                            tablero.establecer_nueva_posicion(casillaMarcadaAnterior[0],casillaMarcadaAnterior[1], casillaMarcada[0],casillaMarcada[1]);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.actualizaMat(true);//copiar a la posibilidades
                            System.out.println("matriz tabla");
                            tablero.pintar_tablero(true);
                            System.out.println("matriz tablaposibles actualizada");
                            tablero.pintar_tablero(false);
                            tablero.seleccionar=1;//vuelve a seleccionar;
                        }else{
                            JOptionPane.showMessageDialog(null,"Movimiento ilegal");
                            tablero.actualizaMat(true);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            
                             tablero.seleccionar=1;
                        }       
                        ;break;
                default: System.out.println("que fue default");   
                      
        }
            //this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1]);
            /******mas eventos*****/
    }
    public void mouseReleased(MouseEvent e){}
    
    public static int[] getCasillaMarcada(){
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
}