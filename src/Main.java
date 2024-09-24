import java.security.SecureRandom;
import java.util.*;

public class Main {

    static List<Integer> repereGagnantJoueur= new ArrayList<>();
    static List<Integer> repereGagnantCpu= new ArrayList<>();
    static List<Integer> tableauChiffre= Arrays.asList(1,2,3,4,5,6,7,8,9);

    static List<Integer> tableau= new ArrayList<>(tableauChiffre);

    static List<List> tableauMatrice= new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);


    public static List<List> tableauGagnant(){

        List<Integer> haut= (Arrays.asList(1,2,3));
        List<Integer> milieu= (Arrays.asList(4,5,6));
        List<Integer> bas= (Arrays.asList(7,8,9));
        List<Integer> gaucheVertical= (Arrays.asList(1,4,7));
        List<Integer> milieuVertical= (Arrays.asList(2,5,8));
        List<Integer> droiteVertical= (Arrays.asList(3,6,9));
        List<Integer> gaucheDroitOblique= (Arrays.asList(1,5,9));
        List<Integer> droiteGaucheOblique= (Arrays.asList(3,5,7));


        tableauMatrice.add(haut);
        tableauMatrice.add(milieu);
        tableauMatrice.add(bas);
        tableauMatrice.add(gaucheVertical);
        tableauMatrice.add(milieuVertical);
        tableauMatrice.add(droiteVertical);
        tableauMatrice.add(gaucheDroitOblique);
        tableauMatrice.add(droiteGaucheOblique);

        return tableauMatrice;
    }



    static Scanner sc= new Scanner(System.in);


    public static void placementPosition(String joueur, int nombre, char[][] planDeJeu){

        verifNombre(joueur, nombre);
        switch (nombre){
            case 1:
                if(!joueur.equals("Cpu")){
                    planDeJeu[0][0]='X';
                }
                else
                    planDeJeu[0][0]='0';
                break;
            case 2:
                if(!joueur.equals("Cpu")){
                    planDeJeu[0][2]='X';
                }
                else
                    planDeJeu[0][2]='0';
                break;
            case 3:
                if(!joueur.equals("Cpu")){
                    planDeJeu[0][4]='X';
                }
                else
                    planDeJeu[0][4]='0';
                break;
            case 4:
                if(!joueur.equals("Cpu")){
                    planDeJeu[2][0]='X';
                }
                else
                    planDeJeu[2][0]='0';
                break;
            case 5:
                if(!joueur.equals("Cpu")){
                    planDeJeu[2][2]='X';
                }
                else
                    planDeJeu[2][2]='0';
                break;
            case 6:
                if(!joueur.equals("Cpu")){
                    planDeJeu[2][4]='X';
                }
                else
                    planDeJeu[2][4]='0';
                break;
            case 7:
                if(!joueur.equals("Cpu")){
                    planDeJeu[4][0]='X';
                }
                else
                    planDeJeu[4][0]='0';
                break;
            case 8:
                if(!joueur.equals("Cpu")){
                    planDeJeu[4][2]='X';
                }
                else
                    planDeJeu[4][2]='0';
                break;
            case 9:
                if(!joueur.equals("Cpu")){
                    planDeJeu[4][4]='X';
                }
                else
                    planDeJeu[4][4]='0';
                break;
            default:
                System.out.println("erreur inattendue");
        }
    }

    public static void affichageDuJeu(char[][] planDeJeu) {
        for (char[] chars : planDeJeu) {
            System.out.println(chars);
        }
    }

    public static boolean verifQuigagnePartie(String joueur){
        for (List listGagnant : tableauGagnant()) {
            if(repereGagnantJoueur.containsAll(listGagnant)){
                System.out.println(joueur+" vous avez gagné ( ✜‿✜ )");
                return true;
            }
            else if (repereGagnantCpu.containsAll(listGagnant)){
                System.out.println("Cpu win the game ┌П┐(ಠ_ಠ)");
                return true;
            }
            else if (repereGagnantCpu.size()+ repereGagnantJoueur.size()==9) {
                System.out.println("Personne ne gagne sur cette manche (╥﹏╥)");
                return true;
            }

        }
        return false;
    }

    public static boolean verifNombre(String joueur, int nombre){


        while (true){

            if(tableau.size()>0){
                if(tableau.contains(nombre)){
                    if(!joueur.equals("Cpu")){
                        repereGagnantJoueur.add(nombre);
                    }
                    else
                        repereGagnantCpu.add(nombre);

                    for (int i = 0; i < tableau.size(); i++) {
                        if(nombre == tableau.get(i))
                            tableau.remove(i);
                    }
                    return false;
                }
                else {
                    if (joueur.equals("Cpu")){
                        randomNombreCpu();
                    }
                    else {
                        System.err.println("Ce nombre: "+nombre+" est deja utilisé");
                        System.out.print("Entrez un des nombres de cette liste "+ tableau+" : ");
                        nombre= sc.nextInt();
                    }
                }
                sc.nextLine();
            }
        }

    }

    public static int randomNombreCpu(){

        SecureRandom rand= new SecureRandom();
       int nombre= rand.nextInt(tableau.size());
       return tableau.get(nombre);

    }


    public static void main(String[] args) {
//        char[][] planDeJeu= {
//                {' ','│',' ', '│', ' '},
//                {'─','┼','─', '┼', '─'},
//                {' ','│',' ', '│', ' '},
//                {'─','┼','─', '┼', '─'},
//                {' ','│',' ', '│', ' '}
//        };
//
//
//
//        boolean recommencer= true;
//        System.out.println("Bienvenue dans le jeu TIC TAC TOE\n\t");
//        affichageDuJeu(planDeJeu);
//
//        System.out.println("Veuillez entrer votre prénom:");
//        String joueur= sc.next();
//
//        System.out.println("La partie peut commencer");
//
//
//
//        while(recommencer){
//
//            System.out.print("Entrez un nombre au choix "+ Arrays.toString(tableau.toArray())+" :");
//            int nombre = sc.nextInt();
//
//            placementPosition(joueur,nombre,planDeJeu);
//            System.out.println("Au tour de la machine de jouer");
//
//            placementPosition("Cpu",randomNombreCpu(),planDeJeu);
//
//            affichageDuJeu(planDeJeu);
//            sc.nextLine();
//
//            if(!verifQuigagnePartie(joueur)){
//                continue;
//            }
//
//                System.out.println("Voulez-vous recommencer?: Oui/Non");
//                recommencer= sc.next().equalsIgnoreCase("Oui") ? true: false;
//
//            sc.nextLine();
//
//        }
//

        boolean recommencer= true;

        while(recommencer){

            System.out.print("Enter your name: ");
            String playerName = scanner.next();
            TicTacToe game = new TicTacToe(playerName);

            game.startGame();

            System.out.println("Voulez-vous recommencer?: Oui/Non");
            recommencer= sc.next().equalsIgnoreCase("Oui");

            sc.nextLine();

        }





    }
}

