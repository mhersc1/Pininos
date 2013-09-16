/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicGame;

/**
 *
 * @author Omar
 */
public class Equipo {
    public Godzilla godzilla;
    public Hombre hombre[];
    public CocodriloKong cocodrilo[];
    public Pollo pollo[];
    public Equipo(){
        godzilla=new Godzilla();
            godzilla.setPosX(2);
            godzilla.setPosY(0);
        hombre=new Hombre[2];
        cocodrilo=new CocodriloKong[2];
        pollo=new Pollo[5];
    }
    
}
