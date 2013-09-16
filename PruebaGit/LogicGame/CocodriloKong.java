package LogicGame;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.5263A67D-9EA7-A62E-207A-858A086FD791]
// </editor-fold> 
public class CocodriloKong extends Personaje {
    protected int T[][];
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.66E3D691-E585-A584-D63F-7FF5ADCF1384]
    // </editor-fold> 
    public CocodriloKong (int PosX, int PosY, int Equipo) {
        super(PosX,PosY,Equipo);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C7EF7507-5EA9-8583-320B-CF902D3D2BA3]
    // </editor-fold> 
    public void Mover (int x, int y,boolean Equipo) {
        if(Equipo){
         if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]<1)){
            if(Math.abs(y-PosY)==0 || Math.abs(x-PosX)==0){
                if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2){
                    System.out.println("Muevete");
                }
            }
        }
        }else{
        if((0<=x && x<5)&&(0<=y && y<8)&&(T[x][y]>-1)){
            if(Math.abs(y-PosY)==0 || Math.abs(x-PosX)==0){
                if(Math.sqrt((x-PosX)^2+(y-PosY)^2)==2){
                    System.out.println("Muevete");
                }
            }
        }
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3D56E199-2E4B-16CE-8FA3-3EC1DF844375]
    // </editor-fold> 
    public int CapturarPersonaje () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.63BE4AC1-0415-938D-0119-525EA859A0F1]
    // </editor-fold> 
    public void setPosX (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4AEC4DA9-8D46-8EF7-D57C-E8D509C66D13]
    // </editor-fold> 
    public int getPosY () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AA801D6E-A0C9-7D78-8635-3B79B3327D7B]
    // </editor-fold> 
    public void setPosY (int val) {
    }

}

