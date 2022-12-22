package consoCarbone;
/**  Comme que tous les français ont la meme empreunteC de ServicesPublics, on peut utiliser le design pattern Singleton. Ainsi, 
la classe va avoir qu une seul instance .Pour cela, on peut considerer la classe comme une énumération d un seul attribut
De plus, son constructeur sera private
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
        set_impact(IMP);
    }
    
    /**Affiche l impact moyen d un francais vis a vis de ses services*/
    public static void impactSP_Moy(){
        System.out.println("l'empreinte carbone d'un.e français.e vis-à-vis des Services Publics et Santé par an  est 1 489kg ");
    }
    
    /**Redefinition de toString pour ServicesPublics qui retourne les caracteristiques de l objet courant
	 * @return String Chaine de caracteres representative de l objet
	 */
    @Override
    public String toString(){
        return "Logement [ ID: "+get_id()+", impact en TCO2: "+get_impact()+"  ]";
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

