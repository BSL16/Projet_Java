package utilisateur;

import java.util.*;
import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;

/** est une classe population qui contient une liste d utilisateur */
public class Population {
    private List<Utilisateur> populat;

    /**Constructeur de Population par défaut*/
    public Population(){
        populat=new ArrayList<>();
    }
    /**Constructeur de Population 
     * @param ArrayList<Utilisateur> p qui est une liste d utilisateur
    */
    public Population(ArrayList<Utilisateur> p){
        populat=p;
    }

    /** getter de populat
     * @return List<Utilisateur> une liste d utilisateur
     */
    public List<Utilisateur> get_Populat() {
        return populat;
    }

    /**setter de populat 
     * @param List<Utilisateur> populat qui est une liste d utilisateur 
    */
    public void setPopulat(List<Utilisateur> populat) {
        this.populat = populat;
    }
    /**
     * info_Population est une methode qui donne des recommendations sur une population donnee pour reduire les emissions carbones
     */
    public void info_Population(){
        int cpt_al=0 , cpt_bc=0, cpt_lo=0 , cpt_tr=0, cpt_se=0;
        for (Utilisateur u : populat){ 
        
            if (u.Ordre_Info_ConsoCarbone() instanceof Alimentation)
                    cpt_al++;
            else if (u.Ordre_Info_ConsoCarbone() instanceof BienConso)
                    cpt_bc++;
            else if (u.Ordre_Info_ConsoCarbone() instanceof Logement)
                    cpt_lo++;
            else if (u.Ordre_Info_ConsoCarbone() instanceof Transport)
                    cpt_tr++;
            else
                    cpt_se++;
        
        }
        //pour avoir le max
        int[] tab_cpt = {cpt_al, cpt_bc, cpt_lo, cpt_tr, cpt_se};
        int max=cpt_al;
        for (int i : tab_cpt){
            if (i>=max){
                max=i;
            }
        }

        if(max==cpt_al)
            System.out.println("La population doit dimunier sa consommation de viande");
        else if(max==cpt_bc)
            System.out.println("La population doit dimunier ses dépenses en bien de consommations");
        else if(max==cpt_lo)
            System.out.println("La population doit dimunier sa consommation énergétique dans leurs maisons");
        else if(max==cpt_tr)
            System.out.println("La population doit diminuer ses kilomètres en voiture voire se passer de voiture et éviter l avion autant que possible");
        }
    }


