public class Tortue {
    private String tortueCouleur;
    private char orientationTortue;

    public Tortue (String tortueCouleur, char orientationTortue) {
        this.tortueCouleur = tortueCouleur;
        this.orientationTortue = orientationTortue;
    }

    public String getTortueCouleur () {
        return tortueCouleur;
    }

    public void setTortueCouleur (String tortueCouleur) {
        this.tortueCouleur = tortueCouleur;
    }

    public char getOrientationTortue () {
        return orientationTortue;
    }

    public void setOrientationTortue (char orientationTortue) {
        this.orientationTortue = orientationTortue;
    }
}
