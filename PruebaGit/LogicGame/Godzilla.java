package LogicGame;

import javax.swing.ImageIcon;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.147FEAC2-35B2-46DD-2880-B81F3D332961]
// </editor-fold> 
public class Godzilla extends Personaje {
    protected int T[][];
    final float constante =(float)2.82842712474619;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.36568848-2E61-C435-0815-F1C9D93F8DCC]
    // </editor-fold> 
    public Godzilla(){
        cargarImagen();
    }
    public Godzilla (int PosX, int PosY, int Equipo) {
        super(PosX,PosY,Equipo);
    }
    @Override
    public ImageIcon cargarImagen(){
        
        return cargarFondo("../imagenes/jugadores/godzilla.jpg");
    }
    public ImageIcon cargarFondo(String ruta){
        java.net.URL localizacion = Godzilla.class.getResource(ruta);
        if (localizacion != null) {
            return new ImageIcon(localizacion);
        } else {
            System.out.println("No se ha encontrado el archivo: " + ruta);
            return null;
        }
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.250415B5-B9E5-1460-BEAA-DC2BDA50C667]
    // </editor-fold> 
    public void Mover (int x, int y,boolean Equipo,int mov) {
        /*
         mov 0: Recta
         mov 1: Diagonal
         */
        //Mover Rectamente 
        if(mov==0){
        if(Equipo){
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]==0 || T[x][y]==4)){
            if(Math.abs(y-PosY)==0 || Math.abs(x-PosX)==0){
               if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2){
                        System.out.println("Muevete");
                    }
                
            }
        }
        }else{
            if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]==0 || T[x][y]==4)){
            if(Math.abs(y-PosY)==0 || Math.abs(x-PosX)==0){
               if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2){
                        System.out.println("Muevete");
                    }
                
            }
        }
        }
        }
        //Mover diagonalmente
        if(mov==1){
        if(Equipo){
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]<1 || T[x][y]==4)){
            if(Math.abs((y-PosY)/(x-PosX))==1){
                if(T[(x+PosX)/2][(y+PosY)/2]==0){
                    if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2*constante){
                    System.out.println("Muevete");
                    }
                }
            }
        }
       }else{
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]>-1 || T[x][y]==-4)){
            if(Math.abs((y-PosY)/(x-PosX))==1){
                if(T[(x+PosX)/2][(y+PosY)/2]==0){
                    if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2*constante){
                    System.out.println("Muevete");
                    }
                }
            }
        }
        }
       }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A12EDB8E-02D2-01C7-5649-A0F0F03D85BC]
    // </editor-fold> 
    public int CapturarPersonaje () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B6F66662-9CAC-6857-790C-5138261976A4]
    // </editor-fold> 
    public void setPosX (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.905275F8-687A-3A9C-1E6C-E901EEEFB120]
    // </editor-fold> 
    public int getPosY () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.776DD135-8088-0A6C-0DE2-90288CBA50A2]
    // </editor-fold> 
    public void setPosY (int val) {
    }

}

