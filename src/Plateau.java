import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plateau {
    private int nbLigne = 8;
    private int nbColonne = 8;
    private String[][] plateau;
    public int end = 0;

    Scanner sc = new Scanner (System.in);

    public Plateau (int nbJoueur) {
        this.plateau = new String[nbLigne][nbColonne];
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                plateau[i][j] = ".";
            }
        }
    }


    public void display () {

        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
                System.out.print (" | " + plateau[i][j]);
            }
            System.out.println (" | ");
        }
        System.out.println (" ");
    }

    public String getCase (int x, int y) {
        return plateau[x][y];
    }

    public String getJoueurPlateau (Joueur joueur) {
        return plateau[joueur.getCoordX ()][joueur.getCoordY ()];
    }

    public void setJoueurPlateau (Joueur joueur) {
        plateau[joueur.getCoordX ()][joueur.getCoordY ()] = joueur.getTortue ().getTortueCouleur ();
    }

    public void setCaseBloc (int x, int y, String bloc) {
        plateau[x][y] = bloc;
    }

    public void setCaseVide (Joueur joueur) {
        plateau[joueur.getCoordX ()][joueur.getCoordY ()] = ".";
    } // permet de supprimer la case où il y avait initialement une tortue

    public void initPlateau (int nbJoueur) {
        switch (nbJoueur) {
            case 2:
                for (int i = 0; i < 8; i++) {
                    plateau[i][7] = "X";
                }
                Joueur joueur1 = new Joueur (0, 1,1, new Tortue ("TV", 'N'), null, null, null, null, null);
                setJoueurPlateau (joueur1);



                Joueur joueur2 = new Joueur (0, 5,2, new Tortue ("TJ", 'O'), null, null, null, null, null);
                setJoueurPlateau (joueur2);


                plateau[7][3] = "joyau";

                break;
            case 3:
                for (int i = 0; i < 8; i++) {
                    plateau[i][7] = "X";
                }

                Joueur J1 = new Joueur (0, 0,1, new Tortue ("TV", 'S'), null, null, null, null, null);
                setJoueurPlateau (J1);

                Joueur J2 = new Joueur (0, 3,2, new Tortue ("TJ", 'S'), null, null, null, null, null);
                setJoueurPlateau (J2);

                Joueur J3 = new Joueur (0, 6,3, new Tortue ("TB", 'S'), null, null, null, null, null);
                setJoueurPlateau (J3);

                plateau[7][0] = "joyau";
                plateau[7][3] = "joyau";
                plateau[7][6] = "joyau";
                break;
            case 4:
                Joueur player1 = new Joueur (0, 0,1, new Tortue ("TV", 'S'), null, null, null, null, null);
                setJoueurPlateau (player1);

                Joueur player2 = new Joueur (0, 2,2, new Tortue ("TJ", 'S'), null, null, null, null, null);
                setJoueurPlateau (player2);

                Joueur player3 = new Joueur (0, 5,3, new Tortue ("TB", 'S'), null, null, null, null, null);
                setJoueurPlateau (player3);

                Joueur player4 = new Joueur (0, 7,4, new Tortue ("TR", 'S'), null, null, null, null, null);
                setJoueurPlateau (player4);

                plateau[7][1] = "joyau";
                plateau[7][6] = "joyau";

                break;

        }
    }



    public void setBlocPlateau (Elmt bloc) {
        plateau[bloc.getCoordX ()][bloc.getCoordY ()] = bloc.getBloc ();
    }

    public void deplacer (Joueur joueur) {
        String tempo;
        switch (joueur.getTortue ().getOrientationTortue ()) {
            case 'S': // deplacement de la tortue vers le bas
                if (joueur.getCoordX () + 1 <= 7) {      // si le joueur ne sort pas du plateau

                    if (getCase (joueur.getCoordX () + 1, joueur.getCoordY ()).equals ("joyau")) { // si la case devant la tortue est un joyau
                        System.out.println ("Vous avez gagné !!!\n");
                        //Jeu.listJoueurs.remove (joueur);
                        setCaseVide (joueur);


                    } else if (getCase (joueur.getCoordX () + 1, joueur.getCoordY ()).equals (".")) { // si la case devant le joueur est vide
                        setCaseVide (joueur);
                        tempo = joueur.getTortue ().getTortueCouleur ();
                        joueur.setCoordX (joueur.getCoordX () + 1);
                        setJoueurPlateau (joueur);

                    } else {
                        System.out.println ("Vous ne pouvez pas passer par là !");
                    }
                } else {
                    System.out.println ("Vous ne pouvez pas sortir du plateau !\n");
                }
                break;
            case 'N': // deplacement de la tortue vers le haut
                if (joueur.getCoordX () - 1 >= 0) {
                    if (getCase (joueur.getCoordX () - 1, joueur.getCoordY ()).equals ("joyau")) { // si la case devant la tortue est un joyau
                        System.out.println ("Vous avez gagné !!!\n");
                        Jeu.listJoueurs.remove (joueur);
                        setCaseVide (joueur);

                    } else if (getCase (joueur.getCoordX () - 1, joueur.getCoordY ()).equals (".")) {
                        setCaseVide (joueur);
                        tempo = joueur.getTortue ().getTortueCouleur ();
                        joueur.setCoordX (joueur.getCoordX () - 1);
                        setJoueurPlateau (joueur);
                    } else {
                        System.out.println ("Vous ne pouvez pas passer par là !");
                    }
                } else {
                    System.out.println ("Vous ne pouvez pas sortir du plateau !\n");
                }
                break;
            case 'E': // deplacement de la tortue vers la droite
                if (joueur.getCoordY () + 1 <= 7) {
                    if (getCase (joueur.getCoordX (), joueur.getCoordY () + 1).equals ("joyau")) {
                        System.out.println ("Vous avez gagné !!!\n");
                        Jeu.listJoueurs.remove (joueur);
                        setCaseVide (joueur);

                    } else if (getCase (joueur.getCoordX (), joueur.getCoordY () + 1).equals (".")) {
                        System.out.println ("Section Est");
                        setCaseVide (joueur);
                        tempo = joueur.getTortue ().getTortueCouleur ();
                        joueur.setCoordY (joueur.getCoordY () + 1);
                        setJoueurPlateau (joueur);
                    } else {
                        System.out.println ("Vous ne pouvez pas passer par là !");
                    }
                } else {
                    System.out.println ("Vous ne pouvez pas sortir du plateau !\n");
                }
                break;
            case 'O': // deplacement de la tortue vers la gauche
                if (joueur.getCoordY () - 1 >=0) {
                    if (getCase (joueur.getCoordX (), joueur.getCoordY () - 1).equals ("joyau")) {
                        System.out.println ("Vous avez gagné !!!\n");
                        Jeu.listJoueurs.remove (joueur);
                        setCaseVide (joueur);

                    } else if (getCase (joueur.getCoordX (), joueur.getCoordY () - 1).equals (".")) {
                        System.out.println ("Section Ouest");
                        setCaseVide (joueur);
                        tempo = joueur.getTortue ().getTortueCouleur ();
                        joueur.setCoordY (joueur.getCoordY () - 1);
                        setJoueurPlateau (joueur);
                    } else {
                        System.out.println ("Vous ne pouvez pas passer par là !");
                    }
                } else {
                    System.out.println ("Vous ne pouvez pas sortir du plateau !\n");
                }
        }
    }


    public void poseBloc (Joueur joueur) {
        System.out.println ("Voici vos blocs \n");
        for (int a = 0; a < joueur.getBlocsList ().size (); a++) { // parcours la list de blocs dans la main du joueur
            System.out.println (joueur.getBlocsList ().get (a));
        }
        System.out.println ("Quel type de bloc voulez vous poser ?\n" +
                "(1) Bloc de pierre\n" +
                "(2) Bloc de Glace\n");
        int choixBloc = sc.nextInt ();
        System.out.println ("Où voulez-vous placer votre bloc? Indiquer X puis entrée puis Y puis entrée");
        int coordY = sc.nextInt ();
        int coordX = sc.nextInt ();

        if (getCase (coordX, coordY).equals (".")) {
            switch (choixBloc) {
                case 1:
                    setCaseBloc (coordX, coordY, "pierre");
                    joueur.getBlocsList ().remove ("blocPierre");
                    break;
                case 2:
                    setCaseBloc (coordX, coordY, "glace");
                    joueur.getBlocsList ().remove ("blocGlace");
                    break;
            }

        } else {
            System.out.println ("Vous ne pouvez pas poser un bloc ici !\n");
        }
    }

    public void tourneGauche (Joueur joueur) {
        switch (joueur.getTortue ().getOrientationTortue ()) {
            case 'S':
                joueur.getTortue ().setOrientationTortue ('E');
                break;
            case 'E':
                joueur.getTortue ().setOrientationTortue ('N');
                break;
            case 'N':
                joueur.getTortue ().setOrientationTortue ('O');
                break;
            case 'O':
                joueur.getTortue ().setOrientationTortue ('S');
                break;
        }
    }

    public void tourneDroite (Joueur joueur) {
        switch (joueur.getTortue ().getOrientationTortue ()) {
            case 'S':
                joueur.getTortue ().setOrientationTortue ('O');
                break;
            case 'O':
                joueur.getTortue ().setOrientationTortue ('N');
                break;
            case 'N':
                joueur.getTortue ().setOrientationTortue ('E');
                break;
            case 'E':
                joueur.getTortue ().setOrientationTortue ('S');
                break;
        }
    }
}
