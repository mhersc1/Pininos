/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Tablero.Maquina;

//import Vistas.Tablero.CasillasGUI;
//import Vistas.Tablero.TableroGUI;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CasillasGUI_Maquina extends javax.swing.JPanel implements MouseListener{
    private TableroGUI_Maquina tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    //private int seleccionar=1;
    private static int [] casillaMarcadaAnterior = new int[2];
    private  int  turno= 100 ;// -100 equipo  B
    
    public CasillasGUI_Maquina() {        
        // este constructor no se usar&aacute;, se deja para poder crear el bean.        
    }
    
    public CasillasGUI_Maquina(TableroGUI_Maquina t) {
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
            ///////////
            
            int Equipo=0;//Equipo A:0 inicializa las blancas
                         //Equipo B:1
            
            this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI_Maquina)e.getComponent()));
             
            if(tablero.hayGanador()==0){
            
            switch(tablero.seleccionar){//Casilla Selecta       : 0
                                        //Casilla a seleccionar : 1
                case 1:
                        System.out.println("selecciona una  ficha ***********************");
                        //Por convencion empieza equipo humano
                        /*si has escogido una  ficha que corresponde al equipo con turno */
                        /*movimiento valido*/ 
                            
                            valor=tablero.devolverValorFichaSeleccionada();
                            
                            if(valor<0){tablero.Equipo=1;
                                        tablero.restriccionA=false;
                                        tablero.restriccionB=true;
                                }//clave!!
                            
                            System.out.println("rest"+tablero.restriccionA);
                            System.out.println("res"+tablero.restriccionB);
                            
                            if(valor>0){tablero.Equipo=0;
                                        tablero.restriccionB=false;
                                        tablero.restriccionA=true;
                                }
                            
                            
                            System.out.println("rest"+tablero.restriccionA);
                            System.out.println("rest"+tablero.restriccionA);
                            ///
                            System.out.println("Equipo"+tablero.Equipo);
                            System.out.println("valor"+valor);
                                tablero.marcarPosibilidades(valor,casillaMarcada[0],casillaMarcada[1]); 
                                tablero.pintar_tablero(false);
                                casillaMarcadaAnterior[0]=casillaMarcada[0];
                                casillaMarcadaAnterior[1]=casillaMarcada[1];
                                tablero.dibujarPosibilidades();
                                tablero.repaint();
                                tablero.seleccionar=2;//tiene que elegir sgte posicion
                            
                         System.out.println("selecciona="+tablero.seleccionar);
                         ;break;
                    
                case 2:  
                    
                        System.out.println("muever una  ficha **************************");        
                        System.out.println("equipo"+tablero.Equipo);        
                        if(tablero.evaluarMovimiento(casillaMarcada[0],casillaMarcada[1],tablero.Equipo)){
                            tablero.establecer_nueva_posicion(casillaMarcadaAnterior[0],casillaMarcadaAnterior[1], casillaMarcada[0],casillaMarcada[1]);
                            System.out.println("anteriorx"+casillaMarcadaAnterior[0]);
                            System.out.println("anteriorx"+casillaMarcadaAnterior[1]);
                            System.out.println("anteriorx"+casillaMarcada[0]);
                            System.out.println("anteriorx"+casillaMarcada[1]);
                            tablero.redibujarTablero();
                            tablero.repaint();                         
                            tablero.actualizaMat(true);//copiar a la posibilidades
                            System.out.println("matriz tabla");
                            tablero.pintar_tablero(true);
                            System.out.println("matriz tablaposibles actualizada");
                            tablero.pintar_tablero(false);
                            
                            tablero.seleccionar=1;//vuelve a seleccionar;
                        }else{
                            System.out.println("Movimiento ilegal!!!");
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
