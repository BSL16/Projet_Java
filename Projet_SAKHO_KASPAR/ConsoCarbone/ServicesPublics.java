package consoCarbone;

/*  Comme que tous les français ont la même empreunteC de ServicesPublics, on peutt utiliser le design pattern Singleton. Ainsi, 
la classe va avoir qu'une seul instance.pour cela on utilisera la classe comme une énumération d'un seul attribut
*/
/**ServicesPublics est la consommation carbone liee aux services publics
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class ServicesPublics extends ConsoCarbone {
    private static final double IMP=1.5;
    private ServicesPublics(){ // car c'est un singleton 
        super();
        EmpreinteC();
    }
    
    /**Redefinition de EmpreinteC pour ServicesPublics*/
    @Override 
    public void EmpreinteC(){
        this.impact=IMP;
    }
    
    /**Affiche l'impact moyen d'un francais vis a vis de ses services*/
    public static void impactSP_Moy(){
        System.out.println("l’empreinte carbone d’un.e français.e vis-à-vis des Services Publics et Santé par an  est 1 489kg ");
    }
    
    /**Redefinition de toString pour ServicesPublics 
	 * @return Chaine de caracteres representative de l'objet
	 */
    @Override
    public String toString(){
        return "Logement [ ID: "+id+", impact en TCO2: "+impact+"  ]";
    }
    
}

/* Un exemple de Singleton qu'on peut implémenter

public enum ServicesPublics {IMPACT;
    public static final double imp=1.5;
    //constructeur par défaut définie
    public ServicesPublics getInstance(){
        return ServicesPublics.IMPACT;

    
    }
*/

