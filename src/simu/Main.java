package simu;


import com.sun.deploy.util.SystemUtils;

import java.util.ArrayList;
import java.util.List;

public class Main{

    //////// Déclaration variables globales
            int nbPersJour[] = {0,0,0,0,5,5,5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
            float reparBesoin[] = {5,5,10,10,10,10,10,10,10,10,10}; //répartition en pourcentage des besoin


    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Fonction création choixBesoinRandom:
    //permet attribuer un besoin de facon aléatoire
    ////////////////////////////////////////////////////////////////////////////////////////////

            private static String choixBesoinRandom(float[] repartBesoin){
                String besoin;
                besoin = "0";
                float rdm;
                rdm = (float)Math.random();
                float controle = 0;
                float cpt;

                for(int i=0; i<repartBesoin.length; i++){//blindage
                    controle += repartBesoin[i];
                }
                if(controle != 1) {
                    System.out.println("ERREUR choixBesoinRandom, SOMME DES PROBA NON EGALE A 1 dans repartBesoin \n"); //blindage
                }

                if(rdm> 0 && rdm <=repartBesoin[0]){
                        besoin = "1";
                }
                cpt = repartBesoin[0];

                for(int i=0; i<repartBesoin.length; i++){
                    if(rdm >= cpt && rdm < (cpt + repartBesoin[i])) {
                        besoin = String.valueOf(i+1);
                    }
                cpt+=repartBesoin[i];
                }
                return besoin;
            }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // Fonction création User:
    // Renvoie un User créé random en prenant en compte le string compt( pour l'ID) et le tableau d'entier parametreCreaUser[]
    ////////////////////////////////////////////////////////////////////////////////////////////

            private static User creationUser(String compt, int heure, float[] repartBesoin){
                User user = new User();
                user.id = compt;
                //user.heureArriveeDsAdmin = (double)(heure*10000 + Math.random()*60*100 + Math.random()*60);
                user.performanceClient = (int)(Math.random()*0.5 - 0.5);
                user.premierBesoin = choixBesoinRandom(repartBesoin);
                return user;
            }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Fonction création ListJour:
    //Renvoie un User[] en prenant en compte le  nombre de personne par créneau de 1h
    ////////////////////////////////////////////////////////////////////////////////////////////

            private static List<User> creationListJour( int[] nbPersJour, float[] repartBesoin){
            int compteur = 0;
            int varPers = 10; // Pourcentage variation nombre personne dans un créneau
            int nbPersTot = 0;
            for( int i = 0; i < nbPersJour.length; i++){//calcul le nombre de personne total se rendant par jour
                nbPersTot += nbPersJour[i];
            }
            List<User> listUserJour = new ArrayList<>();

            for(int i = 0; i < nbPersJour.length ; i++){
                int inter = (int)(((Math.random() * 2 * varPers) - varPers)/100 * nbPersJour[i]); // nouveau nombre de personne dans créneaux en prenant compte le pourcentage de variation
                nbPersJour[i] = inter;
                for (int j = 1; j<= nbPersJour[i] ; j++){
                    String compt = String.valueOf(compteur);
                    listUserJour.add(creationUser(compt, i, repartBesoin));
                    compteur++;
                }
            }
            return listUserJour;
        }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    //Fonction afficherListJour:
    //affiche les infos de ListJour
    ////////////////////////////////////////////////////////////////////////////////////////////
    public static void afficherListJour(List<User> listJour){
                for(User anUser: listJour){
                    System.out.println("*****************************************\nUser n°" + anUser.id + "\n");
                    System.out.println(anUser.id + "  " + anUser.premierBesoin + "  " + anUser.heureArriveeDsAdmin + "  " + anUser.performanceClient +"\n \n");
                }
    }

///////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////
// Fonction MAIN.................................................................
/////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////
    public static void main (String[] args){
        System.out.println("Hello World!");
        int nbPersJour[] = {0,0,0,0,5,5,5,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        float repartBesoin[] = {5,5,10,10,10,10,10,10,10,10,10}; //répartition en pourcentage des besoin
        List<User> listUserJour = new ArrayList<>();
        listUserJour.addAll(creationListJour(nbPersJour, repartBesoin));
        afficherListJour(listUserJour);
        System.out.println("Fin du programme");
    }
}
