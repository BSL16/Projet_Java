package consoCarbone;

/**Logement est la consommation carbone liee au Logement
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class Logement extends ConsoCarbone {
    private int superficie; 
    private CE ce;
    
    /**Constructeur par defaut de Logement*/
    public Logement(){ //constructeur par défaut
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        superficie=0; 
        ce=CE.A; 
    }
    
    /**Constructeur de Logement
	 * @param superficie Superficie du logement
	 * @param ce Classe energetique du logement
	 */
    public Logement(int superficie, CE ce){ 
        this.superficie=superficie; 
        this.ce=ce;
        EmpreinteC(); //pour avoir this.impact
    }

    /**Getter de superficie
	 * @return Superficie du logement
	 */
    public int get_superficie(){
        return superficie;
    }
    
    /**Getter de CE
	 * @return Classe energetique du logement
	 */
    public CE get_ce(){
        return ce;
    }

    /**Setter de Superficie
	 * @param new_sup Superficie du logement a modifier
	 */
    public void set_superficie(int new_sup){
        superficie=new_sup;
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
    /**Setter de CE
	 * @param new_ce Classe energetique du logement a modifier
	 */
    public void set_ce(CE new_ce){
        ce=new_ce;
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
    /**Redefinition de EmpreinteC pour Logement*/
    @Override// calcul l'impact 
    public void EmpreinteC(){ 
        impact=ce.getAlpha_ce()*superficie;      
    }
    
    /**Affiche l'impact moyen d'un francais vis a vis de son logement*/
    public static void impactL_Moy(){
        System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis du logement par an  est 2 706kg avec"+"\n"+
        "Energie et utilités : 1696kg,  Construction et gros entretien :675kg,  Equipement des logements: 335kg");
    }
    
    /**Redefinition de toString pour Logement
	 * @return Chaine de caracteres representative de l'objet
	 */
    @Override //retourne les caractéristiques de l'objet courant
    public String toString(){
        return "Logement [ ID: "+id+",  Superficie: "+superficie+"m^2,  Classe Energétique:"+ce+",  Impact en TCO2:"+impact+" ]";
    }

}