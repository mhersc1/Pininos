package LogicGame;

//tipo <<>> T(x,y)
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.3E1AF4BA-91A2-EA55-884E-4B2E333D1F92]
// </editor-fold> 
public class Pollo extends Personaje {
    protected int T[][];
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.286A9746-3A32-3A69-5967-15D84237A61C]
    // </editor-fold> 
    public Pollo (int PosX, int PosY, int Equipo) {
        super(PosX,PosY,Equipo);
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5909D204-E3A1-2BBC-A515-C6E8BCA28218]
    // </editor-fold> 
    public void Mover (int x, int y,boolean Equipo) {
        if(Equipo){
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]<1)){
             if((y-PosX)==0 && Math.abs(x-PosX)==1){    
                 System.out.println("Muevete arriba abajo");
             }else if((x-PosX)==0 && (y-PosY)==1){
                 System.out.println("Muevete derecha");
                }else{
                 System.out.println("Sin movimiento");
                 
                    }
            
        }
        }else{
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]>-1)){
             if((y-PosX)==0 && Math.abs(x-PosX)==1){    
                 System.out.println("Muevete arriba abajo");
             }else if((x-PosX)==0 && (y-PosY)==-1){
                 System.out.println("Muevete derecha");
                }else{
                 System.out.println("Sin movimiento");
                    }
            
        }
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A375C2DA-F3CC-DC50-D51A-30487FF93930]
    // </editor-fold> 
    public int CapturarPersonaje () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.86D38C03-F2AC-8613-5477-699729366E54]
    // </editor-fold> 
    public void setPosX (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F036D6DA-9C4E-336B-F654-E737974F1F3D]
    // </editor-fold> 
    public int getPosY () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5052B3D6-5ED0-39B3-301F-4430A6F60873]
    // </editor-fold> 
    public void setPosY (int val) {
    }

}

