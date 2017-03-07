/**
 * Created by ELODE on 06/03/2017.
 */
package simu;

public class User {
    String id; // idendité de l'USER
    String premierBesoin; // Besoin pour lequel le USER viens à la CAF
    float performanceClient; // caractérise le degré de réalisation d'une tache en fonction du client, est lié par une lois exponentielel
    double heureArriveeDsAdmin;// donne l'heure de son arrivée au sein de l'administration
    double heureEntreeAlgoTrie;
    double heureArriveeGuichet;
    double heureSortie; // donne l'heure à laquelle il sort de l'admin, fin de traitement des taches
    String numeroDeGuichet; // numéro du guichet ou passele client

    public User(){
        System.out.println("Création d'un User");
        id = "0";
        premierBesoin = "0";
        performanceClient = 0;
        heureArriveeDsAdmin = 0;
        heureEntreeAlgoTrie = 0;
        heureArriveeGuichet = 0;
        heureSortie = 0;
        numeroDeGuichet = "0";
    }
}



