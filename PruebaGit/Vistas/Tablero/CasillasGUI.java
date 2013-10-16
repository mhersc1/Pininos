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
import javax.swing.JLabel;
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
    private  int  turno= 100 ;// -100 equipo  B
    
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
        
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
          
            int valor=0;
            ///////////
            
            int Equipo=0;//Equipo A:0 inicializa las blancas
                         //Equipo B:1
            
            this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI)e.getComponent()));
             
            if(tablero.hayGanador()==0){
            
            switch(tablero.seleccionar){//Casilla Selecta       : 0
                                        //Casilla a seleccionar : 1
                case 1:
                        
                   
                        //Por convencion empieza equipo humano
                        /*si has escogido una  ficha que corresponde al equipo con turno */
                        /*movimiento valido*/ 
                            
                            valor=tablero.devolverValorFichaSeleccionada();
                            //
                            if(valor>0 && tablero.restriccionA){
                                        tablero.Equipo=0;
                            //JOptionPane.showMessageDialog(null,"  Jugador A");
                                        tablero.restriccionA=false;
                                        tablero.restriccionB=true;
                                        JLabel turno=tablero.getJuegoHumanoHumano().getLabelTurno();
                                        //turno.setText("Turno A");
                                        tablero.getJuegoHumanoHumano().setLabelTurno(turno);
                                tablero.marcarPosibilidades(valor,casillaMarcada[0],casillaMarcada[1]); 
                                tablero.pintar_tablero(false);
                                
                                casillaMarcadaAnterior[0]=casillaMarcada[0];
                                casillaMarcadaAnterior[1]=casillaMarcada[1];
                                tablero.dibujarPosibilidades();
                                tablero.repaint();
                                tablero.seleccionar=2;//tiene que elegir sgte posicion
                                        System.out.println("A"+tablero.restriccionA);
                                        System.out.println("B"+tablero.restriccionB);
                                }//clave!!
                            
                                  
                            if(valor<0 && tablero.restriccionB){
                                        tablero.Equipo=1;
                                       // JOptionPane.showMessageDialog(null,"  Jugador B");
                                        tablero.restriccionB=false;
                                        tablero.restriccionA=true;
                                        JLabel turno=tablero.getJuegoHumanoHumano().getLabelTurno();
                                        //turno.setText("Turno B");
                                        tablero.getJuegoHumanoHumano().setLabelTurno(turno);
                                tablero.marcarPosibilidades(valor,casillaMarcada[0],casillaMarcada[1]); 
                                tablero.pintar_tablero(false);
                                casillaMarcadaAnterior[0]=casillaMarcada[0];
                                casillaMarcadaAnterior[1]=casillaMarcada[1];
                                tablero.dibujarPosibilidades();
                                tablero.repaint();
                                tablero.seleccionar=2;//tiene que elegir sgte posicion
                                        System.out.println("A"+tablero.restriccionA);
                                        System.out.println("B"+tablero.restriccionB);

                                }//clave!!
                            
                            
                     
                            ///


                            

                         ;break;
                    
                case 2:  
                    
                        if(tablero.evaluarMovimiento(casillaMarcada[0],casillaMarcada[1],tablero.Equipo)){
                            tablero.establecer_nueva_posicion(casillaMarcadaAnterior[0],casillaMarcadaAnterior[1], casillaMarcada[0],casillaMarcada[1]);

                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.actualizaMat(true);//copiar a la posibilidades
                            
                            tablero.pintar_tablero(true);

                            tablero.pintar_tablero(false);
                            if(tablero.hayGanador()!=0){
                                if(tablero.hayGanador()==4){
                                    JOptionPane.showMessageDialog(null,"Gana  Jugador A");
                                        }else{
                                    JOptionPane.showMessageDialog(null,"Gana  Jugador B");
                                }
                            }
                            if(tablero.restriccionA==true &&tablero.restriccionB==false){
                                JLabel turno=tablero.getJuegoHumanoHumano().getLabelTurno();
                                        turno.setText("Turno A");
                                        tablero.getJuegoHumanoHumano().setLabelTurno(turno);
                            }
                            if(tablero.restriccionB==true&&tablero.restriccionA==false){
                                JLabel turno=tablero.getJuegoHumanoHumano().getLabelTurno();
                                        turno.setText("Turno B");
                                        tablero.getJuegoHumanoHumano().setLabelTurno(turno);
                            }
                            
                            tablero.seleccionar=1;//vuelve a seleccionar;
                        }else{
                            if(tablero.tablaPosibilidades[casillaMarcada[0]][casillaMarcada[1]]==10 && tablero.restriccionA){
                            tablero.actualizaMat(true);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.restriccionA=true;
                            tablero.restriccionB=false;
                            if(valor==5){
                            tablero.dibujarPosibilidades();
                            }
                            tablero.seleccionar=1;//vuelve a seleccionar
                            }
                            if(tablero.tablaPosibilidades[casillaMarcada[0]][casillaMarcada[1]]==20 && tablero.restriccionB){
                            tablero.actualizaMat(true);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.restriccionA=false;
                            tablero.restriccionB=true;
                            if(valor==-5){
                            tablero.dibujarPosibilidades();
                            }
                            tablero.seleccionar=1;
                            }
                            ////////////////////////////////////////
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
                            tablero.seleccionar=1;
                        }       
                        
                        ;break;
                default: System.out.println("ola k ase?");   
                      
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
    public void mouseReleased(MouseEvent e){}
    
    public static int[] getCasillaMarcada(){
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
}