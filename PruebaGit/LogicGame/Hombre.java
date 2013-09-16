package LogicGame;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.C87C3EE6-F3A9-4D87-4164-E9F57E828A80]
// </editor-fold> 
public class Hombre extends Personaje {
    final float constante=(float) 2.82842712474619;
    protected int T[][];
    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7E7A2DE2-F86A-7B8F-E47C-C6C8AE3DEF35]
    // </editor-fold> 
    public Hombre (int PosX, int PosY, int Equipo) {
        super(PosX,PosY,Equipo);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CD4D3A4A-BAFA-164B-E016-1728362DFB5A]
    // </editor-fold> 
    public void setPosY (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6C1AEC94-D00E-4076-0DB4-DE309B71FF8B]
    // </editor-fold> 
    public int getPosY () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9371C0A1-3022-60A9-E3FB-E1A8758AFB9D]
    // </editor-fold> 
    public void setPosX (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D5E839C5-0171-058E-4035-C3A46A7AA408]
    // </editor-fold> 
    public int CapturarPersonaje () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AC7260D6-D9F8-B8BC-4A3E-10D2B61B2736]
    // </editor-fold> 
    public void Mover (int x, int y,boolean Equipo) {//Estado posterior
        if(Equipo){
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]<1)){
            if(Math.abs((y-PosY)/(x-PosX))==1){
                if(T[(x+PosX)/2][(y+PosY)/2]==0){
                    if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2*constante){
                    System.out.println("Muevete");
                    }
                }
            }
        }
       }else{
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]>-1)){
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9FC783CE-03C5-F126-AFC6-7017ABBB70E1]
    // </editor-fold> 
    public void setTipo (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3B17A058-B34F-1FBA-69DC-D45ABC200935]
    // </editor-fold> 
    public int getTipo () {
        return 0;
    }

}

