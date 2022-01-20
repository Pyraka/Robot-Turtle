import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jeu {
    Scanner clavier = new Scanner (System.in);

    private int nbJoueur;
    public static ArrayList<Joueur> listJoueurs = new ArrayList<Joueur> ();
    private Plateau plateau;


    public Jeu () {
        System.out.println ("Combien de joueur ?");
        nbJoueur = clavier.nextInt ();
        start ();

    }


    public void start () {
        Plateau plateau = new Plateau (nbJoueur);
        plateau.initPlateau (nbJoueur);
        createPlayer ();
        plateau.display ();

        do {
            for (int niemeJoueur = 0; niemeJoueur < this.nbJoueur; niemeJoueur++) {
                if(!plateau.getJoueurPlateau (listJoueurs.get (niemeJoueur)).equals (".")) {
                    System.out.println ("C'est à vous de jouer, Joueur" + (niemeJoueur + 1) + "\n"
                            + "(1) Si vous voulez compléter le programme\n"
                            + "(2) Si vous voulez construire un mûr\n"
                            + "(3) Si vous voulez exécuter le programme, taper 3\n");
                    int choix = clavier.nextInt ();

                    switch (choix) {
                        case 1:
                            System.out.println ("Voici vos cartes, Joueur" + (niemeJoueur + 1) + "\n");

                            for (int j = 0; j < 5; j++) { // compteur j permet d'indiquer toutes les cartes du joueur
                                System.out.println (this.listJoueurs.get (niemeJoueur).getHand ().get (j).getColor ());
                            }
                            System.out.println (" ");
                            this.listJoueurs.get (niemeJoueur).completeAlgorithm (); // complete l'algorithme  pour le joueuer qui est en train de joueur
                            this.listJoueurs.get (niemeJoueur).setCurrentAlgorithm (this.listJoueurs.get (niemeJoueur).getCurrentAlgorithm ());
                            break;
                        case 2:
                            plateau.poseBloc (listJoueurs.get (niemeJoueur));
                            break;
                        case 3:
                            for (int niemeCarte = 0; niemeCarte < this.listJoueurs.get (niemeJoueur).getCurrentAlgorithm ().size (); niemeCarte++) {
                                switch (this.listJoueurs.get (niemeJoueur).getCurrentAlgorithm ().get (niemeCarte).getColor ()) {
                                    case "bleue":
                                        plateau.deplacer (listJoueurs.get (niemeJoueur));
                                        break;
                                    case "jaune":
                                        plateau.tourneGauche (listJoueurs.get (niemeJoueur));
                                        break;
                                    case "violette":
                                        plateau.tourneDroite (listJoueurs.get (niemeJoueur));
                                        break;
                                    case "laser":
                                        break;
                                }
                            }
                            this.listJoueurs.get (niemeJoueur).clearAlgorithm ();
                            break;

                    }

                    plateau.display ();
                    switch (nbJoueur) {
                        case 2:
                            if (listJoueurs.size () >= 2) {
                                this.listJoueurs.get (niemeJoueur).setDefausseCarte ();
                                this.listJoueurs.get (niemeJoueur).setHand (this.listJoueurs.get (niemeJoueur).getHand ()); // permet de mettre en mémoire la main du joueur
                                System.out.println (" ");
                            }
                            break;
                        case 3:
                            if (listJoueurs.size () == 3) {
                                this.listJoueurs.get (niemeJoueur).setDefausseCarte ();
                                this.listJoueurs.get (niemeJoueur).setHand (this.listJoueurs.get (niemeJoueur).getHand ()); // permet de mettre en mémoire la main du joueur
                                System.out.println (" ");
                            }
                            if (listJoueurs.size () == 2) {
                                this.listJoueurs.get (niemeJoueur).setDefausseCarte ();
                                this.listJoueurs.get (niemeJoueur).setHand (this.listJoueurs.get (niemeJoueur).getHand ()); // permet de mettre en mémoire la main du joueur
                                System.out.println (" ");
                                nbJoueur -= 1;
                            }
                            break;

                    }

                }else{
                    listJoueurs.clear ();
                    break;
                }
            }


        } while (listJoueurs.size () >= 2);

        System.out.println ("La partie est fini");
    }

        public void createPlayer () {
            switch (nbJoueur) {
                case 2:
                    Joueur joueur1 = new Joueur (0, 1,1, new Tortue ("TV", 'S'), null, null, null, null, null);
                    listJoueurs.add (joueur1);
                    joueur1.initialisationCartes ();

                    Joueur joueur2 = new Joueur (0, 5,2, new Tortue ("TJ", 'S'), null, null, null, null, null);
                    listJoueurs.add (joueur2);
                    joueur2.initialisationCartes ();
                    break;
                case 3:
                    Joueur J1 = new Joueur (0, 0,1, new Tortue ("TV", 'S'), null, null, null, null, null);
                    listJoueurs.add (J1);
                    J1.initialisationCartes ();


                    Joueur J2 = new Joueur (0, 3,2, new Tortue ("TJ", 'S'), null, null, null, null, null);
                    listJoueurs.add (J2);
                    J2.initialisationCartes ();

                    Joueur J3 = new Joueur (0, 6,3, new Tortue ("TB", 'S'), null, null, null, null, null);
                    listJoueurs.add (J3);
                    J3.initialisationCartes ();
                    break;
                case 4:
                    Joueur player1 = new Joueur (0, 0,1, new Tortue ("TV", 'S'), null, null, null, null, null);
                    listJoueurs.add (player1);
                    player1.initialisationCartes ();

                    Joueur player2 = new Joueur (0,2 ,2, new Tortue ("TJ", 'S'), null, null, null, null, null);
                    listJoueurs.add (player2);
                    player2.initialisationCartes ();

                    Joueur player3 = new Joueur (0, 5,3, new Tortue ("TB", 'S'), null, null, null, null, null);
                    listJoueurs.add (player3);
                    player3.initialisationCartes ();

                    Joueur player4 = new Joueur (0, 7,4, new Tortue ("TR", 'S'), null, null, null, null, null);
                    listJoueurs.add (player4);
                    player4.initialisationCartes ();


            }
        }


        public void end(Joueur joueur){
        for(int i=0;i<nbJoueur;i++)
            if (!plateau.getJoueurPlateau (joueur).equals (".")){

            }
        }
    }