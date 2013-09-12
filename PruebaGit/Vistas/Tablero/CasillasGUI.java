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
import javax.swing.JPanel;

/**
 *
 * @author OMAR
 */
public class CasillasGUI extends javax.swing.JPanel implements MouseListener {
    
    private TableroGUI tablero;
    private ImageIcon fondo;
    private static int [] casillaMarcada = new int[2];
    
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
    
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
            this.setCasillaMarcada(tablero.getCoordenadas((CasillasGUI)e.getComponent())); 
            this.tablero.pintar(this.getCasillaMarcada()[0],this.getCasillaMarcada()[1]);
    }
    public void mouseReleased(MouseEvent e){}
    
    public static int[] getCasillaMarcada() {
        return casillaMarcada;
    }
    public static void setCasillaMarcada(int[] aCasillaMarcada) {
        casillaMarcada = aCasillaMarcada;
    }                  
    
}