import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Carte {

    private String color;
    private String action;

    public Carte (String color, String action) {
        this.color = color;
        this.action = action;
    }

    public String getColor () {
        return color;
    }

    public String getAction () {
        return action;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public void setAction (String action) {
        this.action = action;
    }
}