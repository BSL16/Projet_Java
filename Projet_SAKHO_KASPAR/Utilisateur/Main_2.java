package utilisateur;

import java.util.*;
import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;
import consoCarbone.Taille;
import consoCarbone.CE;
import consoCarbone.Train_Bus;



public class Main_2 {
    //Menu interactif pour Bienconso par exemple
    public static void main (String[] args){
        Scanner scan = new Scanner (System.in);

        System.out.println("Quelle est votre Nom :");
        String nom = scan.nextLine();

        System.out.println("Quelle est votre montant de dépense annuelle");
        double montant_= scan.nextDouble();

        BienConso bc = new BienConso(montant_);
        System.out.println("L'empreinte carbone vis à vis de votre bien de consommation de "+nom+" est : "+ bc.get_impact());

        //Menu interactif pour Transport par exemple

        System.out.println("Possedez-vous une voiture ? True or False : ");
        Boolean possede_= scan.nextBoolean();

        System.out.println("Quelle est le nombre de kilomètre ( saisir un entier) parcourus dans l'année : ");
        int KilAnnee_= scan.nextInt();

        System.out.println("Quelle est la durée de conservation de votre véhicule, veuillez saisir un entier : ");
        int amor_= scan.nextInt();

        Transport trp = new Transport(possede_,Taille.P, KilAnnee_, amor_);
        System.out.println("L'empreinte carbone vis à vis de votre transport de "+nom+" est : "+ trp.get_impact());

        scan.close();
        
    }
}

