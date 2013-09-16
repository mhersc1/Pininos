package LogicGame;

import javax.swing.ImageIcon;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E8C27A59-5758-3C9A-6B4D-97FA012B1013]
// </editor-fold> 
public class Personaje {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.887FEA6C-1C3B-AC79-0073-37B8085CFCB9]
    // </editor-fold> 
    private int Tipo;
    private ImageIcon imagen;
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1A9692EB-3967-DD67-1A85-CB4595DC9C5E]
    // </editor-fold> 
    public int PosX;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.01B25455-8335-0F04-99C8-00260ADFAB7F]
    // </editor-fold> 
    public int PosY;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.640F87B7-716A-3BE8-9D4A-638643CACA63]
    // </editor-fold> 
    public int Equipo;
    public Personaje(){
        
    }
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.96602F46-9234-483B-B813-31C2E765ACAF]
    // </editor-fold> 
    public Personaje (int PosX, int PosY,int Equipo) {
        this.PosX=PosX;
        this.PosY=PosY;
    }
    public ImageIcon cargarImagen(){
        return imagen;
    }
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.E80109C0-B862-EF77-F72A-B96459D9AFA7]
    // </editor-fold> 
    public void Mover (int x, int y,int Equipo) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CC3D72F5-2060-0756-FFAC-B2CC42D3174B]
    // </editor-fold> 
    public int CapturarPersonaje () {
        
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DDE6646D-6986-47BE-69D9-0FC402302F2E]
    // </editor-fold> 
    public void setPosX (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.877BF704-C647-5428-CCED-E9C36720E87E]
    // </editor-fold> 
    public int getPosY () {
        return 0;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D8BC188C-1759-0C8C-18AB-0AD7BD64E561]
    // </editor-fold> 
    public void setPosY (int val) {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.99418B08-68B8-6A67-2441-4FFB94FA8B64]
    // </editor-fold> 
    public int getTipo () {
        return Tipo;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.964465C6-2DF2-7101-6FF5-B41E356120F5]
    // </editor-fold> 
    public void setTipo (int val) {
        this.Tipo = val;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

}

