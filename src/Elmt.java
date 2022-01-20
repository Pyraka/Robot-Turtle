public class Elmt {
    //sert a différencier un element joyau du reste pour etre autroriser à remplacer un joyau mais pas un autre element

    private String typeElmt; // joyau , bloc de glace ou de pierre/
    private int coordX;
    private int coordY;
    private String bloc;

    public Elmt (String typeElmt, String bloc, int coordX, int coordY) {
        this.bloc = bloc;
        this.typeElmt = typeElmt;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getBloc () {
        return bloc;
    }

    public void setBloc (String bloc) {
        this.bloc = bloc;
    }

    public String getTypeElmt () {
        return typeElmt;
    }

    public void setTypeElmt (String typeElmt) {
        this.typeElmt = typeElmt;
    }

    public int getCoordX () {
        return coordX;
    }

    public void setCoordX (int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY () {
        return coordY;
    }

    public void setCoordY (int coordY) {
        this.coordY = coordY;
    }
}