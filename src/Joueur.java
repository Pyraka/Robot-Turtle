import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Joueur {
    private Tortue tortue;
    private ArrayList<Carte> deck;
    private ArrayList<Carte> cimetiere;
    private ArrayList<Carte> hand;
    private ArrayList<Carte> currentAlgorithm; //algorithme caché
    private ArrayList<String> blocsList;
    private int coordX;
    private int coordY;
    private int jouerJ;

    public Joueur (int coordX, int coordY,int jouerJ, Tortue tortue, ArrayList<Carte> deck, ArrayList<Carte> cimetiere, ArrayList<Carte> hand, ArrayList<Carte> currentAlgorithm, ArrayList<Carte> blocsList) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.tortue = tortue;
        this.deck = deck;
        this.jouerJ = jouerJ;
        //this.cimetiere = new ArrayList<> ();
        this.hand = new ArrayList<> ();
        this.currentAlgorithm = new ArrayList<> ();
        this.blocsList = new ArrayList<> ();
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

    public int getJouerJ () {
        return jouerJ;
    }

    public void setJouerJ (int jouerJ) {
        this.jouerJ = jouerJ;
    }

    public Tortue getTortue () {
        return tortue;
    }

    public void setTortue (Tortue tortue) {
        this.tortue = tortue;
    }

    public ArrayList<Carte> getDeck () {
        return deck;
    }

    public void setDeck (ArrayList<Carte> deck) {
        this.deck = deck;
    }

    public ArrayList<Carte> getCimetiere () {
        return cimetiere;
    }

    public void setCimetiere (ArrayList<Carte> cimetiere) {
        //this.cimetiere = cimetiere;
    }

    public ArrayList<Carte> getHand () {
        return hand;
    }

    public void setHand (ArrayList<Carte> hand) {
        this.hand = hand;
    }

    public ArrayList<Carte> getCurrentAlgorithm () {
        return currentAlgorithm;
    }

    public void setCurrentAlgorithm (ArrayList<Carte> currentAlgorithm) {
        this.currentAlgorithm = currentAlgorithm;
    }

    public ArrayList<String> getBlocsList () {
        return blocsList;
    }

    public void setBlocsList (ArrayList<String> blocsList) {
        this.blocsList = blocsList;
    }

    public void initialisationDeck () {
        this.deck = new ArrayList<> ();
        //initialisation du deck avec les 37 cartes
        /*if(deck.size ()==0){
            for(int i=0; i<cimetiere.size ();i++){
                deck.add (cimetiere.get (i));
            }
        }*/
        for (int i = 0; i < 18; i++) {
            Carte carteBleue = new Carte ("bleue", "moveForward");
            this.deck.add (carteBleue);
        }
        for (int i = 0; i < 8; i++) {
            Carte carteViolette = new Carte ("violette", "sensHoraire");
            this.deck.add (carteViolette);
        }
        for (int i = 0; i < 8; i++) {
            Carte carteJaune = new Carte ("jaune", "sensAntiHoraire");
            this.deck.add (carteJaune);
        }
        for (int i = 0; i < 3; i++) {
            Carte carteLaser = new Carte ("laser", "destroy");
            this.deck.add (carteLaser);
        }
        //Fonction pour mélanger le deck
        Collections.shuffle (this.deck);
    }

    public void initialisationHand () {
        for (int i = 0; i < 5; i++) {
            this.hand.add (i, this.deck.get (i));
            this.deck.remove (i);
        }
    }

    public void initialisationBlockList () {
        for (int i = 0; i < 3; i++) {
            String blocPierre;
            this.blocsList.add ("blocPierre");
        }
        for (int i = 0; i < 2; i++) {
            String  blocGlace;
            this.blocsList.add ("blocGlace");
        }
    }

    public void completeHand () { // complete la main du joueur à la fin de son tour avec le nombre de cartes qu'il lui manque
        int i = 0;
        while (this.hand.size () < 5) {
            this.hand.add (i, this.deck.get (i));
            this.deck.remove (i);
            i += 1;
        }
    }

    public void shuffleCimetiere(){
        Collections.shuffle (this.cimetiere);
    }

    public ArrayList<Carte> setDefausseCarte () {

        // refaire cet algorithme avec une boucle for et faire indice - 1 pour la saisie

        System.out.println ("Voici votre main actuel\n");
        for (int i = 0; i < this.getHand ().size (); i++) {
            System.out.println (this.hand.get (i).getColor ());
        }
        System.out.println (" ");

        // rajouter que les cartes defausser vont au cimetiere

        Scanner clavier = new Scanner (System.in);
        System.out.println ("De combien de cartes voulez-vous vous défausser ?");
        int nbrCarteDef = clavier.nextInt ();
        switch (nbrCarteDef) {
            case 0:
                System.out.println ("Vous ne voulez donc pas vous défausser de cartes.\n");
                break;
            case 1:
                System.out.println ("De quelle carte voulez-vous vous défausser ? Choisissez 1 pour la premiere carte par exemple\n");
                int carteDefausse = clavier.nextInt ();
                //this.cimetiere.add(carteDefausse,null);
                this.hand.remove (carteDefausse - 1);
                break;
            case 2:
                System.out.println ("De quelles cartes voulez-vous vous défausser ? Choisissez 0 pour la premiere carte par exemple\n");
                int carteDefausse1 = clavier.nextInt ();
                //this.cimetiere.add(carteDefausse1,null);
                this.hand.remove (carteDefausse1);
                this.hand.add (carteDefausse1, null); //on ajoute un élément qui remplace la carte détruite
                int carteDefausse2 = clavier.nextInt ();
                //this.cimetiere.add(carteDefausse2,null);
                this.hand.remove (carteDefausse2);
                this.hand.add (carteDefausse2, null);
                this.hand.remove (null); //on retire l'élément inexistant, cela permet de garder la même longueure de liste
                this.hand.remove (null);
                break;
            case 3:
                System.out.println ("De quelles cartes voulez-vous vous défausser ? Choisissez 0 pour la premiere carte par exemple\n");
                int carteDefausse3 = clavier.nextInt ();
                ////this.cimetiere.add(carteDefausse3,null);
                this.hand.remove (carteDefausse3);
                this.hand.add (carteDefausse3, null);
                int carteDefausse4 = clavier.nextInt ();
                this.hand.remove (carteDefausse4);
                this.hand.add (carteDefausse4, null);
                int carteDefausse5 = clavier.nextInt ();
                this.hand.remove (carteDefausse5);
                this.hand.add (carteDefausse5, null);
                this.hand.remove (null);
                this.hand.remove (null);
                this.hand.remove (null);
                //this.cimetiere.add(carteDefausse4,null);
                //this.cimetiere.add(carteDefausse5,null);
                break;
            case 4:
                System.out.println ("De quelles cartes voulez-vous vous défausser ? Choisissez 0 pour la premiere carte par exemple\n");
                int carteDefausse6 = clavier.nextInt ();
                this.hand.remove (carteDefausse6);
                this.hand.add (carteDefausse6, null);
                int carteDefausse7 = clavier.nextInt ();
                this.hand.remove (carteDefausse7);
                this.hand.add (carteDefausse7, null);
                int carteDefausse8 = clavier.nextInt ();
                this.hand.remove (carteDefausse8);
                this.hand.add (carteDefausse8, null);
                int carteDefausse9 = clavier.nextInt ();
                this.hand.remove (carteDefausse9);
                this.hand.add (carteDefausse9, null);
                this.hand.remove (null);
                this.hand.remove (null);
                this.hand.remove (null);
                this.hand.remove (null);
                //this.cimetiere.add(carteDefausse6,null);
                //this.cimetiere.add(carteDefausse7,null);
                //this.cimetiere.add(carteDefausse8,null);
                //this.cimetiere.add(carteDefausse9,null);
                break;
            case 5:
                for(int i= 0; i< hand.size ();i++){
                    //this.cimetiere.add(hand.get (i));
                }
                this.hand.clear ();
                break;
        }
        completeHand ();
        System.out.println ("Voici votre nouvelle main\n");
        for (int i = 0; i < 5; i++) {
            System.out.println (this.hand.get (i).getColor ());
        }
        return this.hand;
    }

    public ArrayList<Carte> completeAlgorithm () {


        //le joueur choisi une carte à rajouter à l'algorithme
        System.out.println ("Combien de carte veux tu rajouter à ton algorithme? Les choisir dans l'ordre par numérotation\n");
        Scanner clavier = new Scanner (System.in);
        int nbrAlgo = clavier.nextInt (); // le nombre de carte choisis à mettre dans l'algorithme

        switch (nbrAlgo) {
            case 0:
                System.out.println ("Tu as choisi de ne pas compléter ton algorithme\n");
                break;
            case 1:
                System.out.println ("Quel est l'indiceCarte de la carte choisie en partant de 0 ?\n");
                int indiceCarte = clavier.nextInt (); // indice de l carte à choisir de défausser -1
                this.currentAlgorithm.add (this.hand.get (indiceCarte));
                this.hand.remove (indiceCarte);
                break;

            case 2:
                System.out.println ("Choisis l'indiceCarte des cartes choisis en partant de 0 puis cliques sur entrée\n");
                for (int i = 0; i < 2; i++) {
                    int indCarte = clavier.nextInt ();
                    this.currentAlgorithm.add (this.hand.get (indCarte));
                    this.hand.remove (indCarte);
                    this.hand.add (indCarte, null);//on rajoute un élément null pour que les indices des cartes restent les memes (ils sertont de toutes facons supprimés à la fin)
                }
                for (int compteur = 0; compteur < 2; compteur++) {
                    this.hand.remove (null);
                }
                break;

            case 3:
                System.out.println ("Choisis l'indiceCarte des cartes choisis en partant de 0 puis cliques sur entrée\n");
                for (int i = 0; i < 3; i++) {
                    int indCarte = clavier.nextInt ();
                    this.currentAlgorithm.add (this.hand.get (indCarte));
                    this.hand.remove (indCarte);
                    this.hand.add (indCarte, null);//on rajoute un élément null pour que les indices des cartes restent les memes (ils sertont de toutes facons supprimés à la fin)
                }
                for (int compteur = 0; compteur < 3; compteur++) {
                    this.hand.remove (null);
                }
                break;
            case 4:
                System.out.println ("Choisis l'indiceCarte des cartes choisis en partant de 0 puis cliques sur entrée\n");
                for (int i = 0; i < 4; i++) {
                    int indCarte = clavier.nextInt ();
                    this.currentAlgorithm.add (this.hand.get (indCarte));
                    this.hand.remove (indCarte);
                    this.hand.add (indCarte, null);//on rajoute un élément null pour que les indices des cartes restent les memes (ils sertont de toutes facons supprimés à la fin)
                }
                for (int compteur = 0; compteur < 4; compteur++) {
                    this.hand.remove (null);
                }
                break;
            case 5:
                System.out.println ("Choisis l'indiceCarte des cartes choisis en partant de 0 puis cliques sur entrée\n");
                for (int i = 0; i < 5; i++) {
                    int indCarte = clavier.nextInt ();
                    this.currentAlgorithm.add (this.hand.get (indCarte));
                    this.hand.remove (indCarte);
                    this.hand.add (indCarte, null);//on rajoute un élément null pour que les indices des cartes restent les memes (ils sertont de toutes facons supprimés à la fin)
                }
                for (int compteur = 0; compteur < 5; compteur++) {
                    this.hand.remove (null);
                }
                break;
        }
        return this.hand;
    }

    public void clearAlgorithm () {
        if (this.currentAlgorithm != null) {
            this.currentAlgorithm.clear ();
        }
    }

    public void initialisationCartes () { // permet d'initialiser tout du joueur d'un coup
        initialisationDeck ();
        initialisationHand ();
        initialisationBlockList ();
    }
}

