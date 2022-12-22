package consoCarbone;

/**Logement est la consommation carbone liee au Logement
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class Logement extends ConsoCarbone {
    private int superficie; 
    private CE ce;
    
    /**Constructeur par defaut de Logement*/
    public Logement(){ 
        super(); 
        superficie=0; 
        ce=CE.A; 
    }
    
    /** 
      * Constructeur de Logement
      * @param int superficie la superficie du logement
      * @param CE ce la classe energetique du logement
      * @throws IllegalArgumentException exception levee si la superficie est strictement negative
    */
    public Logement(int superficie, CE ce) throws IllegalArgumentException{ 
        super();

        if (superficie<0) 
            throw new IllegalArgumentException("superficie doit être positive ou null. Cependant, La superficie en argument est" + superficie);

        this.superficie=superficie; 
        this.ce=ce;
        EmpreinteC(); //pour avoir this.impact
    }

    /**Getter de superficie
	 * @return  int Superficie du logement
	 */
    public int get_superficie(){
        return superficie;
    }
    
    /**Getter de CE
	 * @return CE Classe energetique du logement
	 */
    public CE get_ce(){
        return ce;
    }
 /**
     * setter de superficie
     * @param int new_sup la nouvelle superficie
     * @throws IllegalArgumentException exception levee si la nouvelle superficie est strictement negative
     */
    public void set_superficie(int new_sup) throws IllegalArgumentException{
        if (new_sup<0)
            throw new IllegalArgumentException("superficie doit être positive ou null. Cependant, La nouvelle superficie en argument est" + new_sup);
        superficie=new_sup;
        /**pour mettre à jour this.impact*/
        EmpreinteC(); 
        }
    
    /**Setter de CE
	 * @param new_ce Classe energetique du logement a modifier
	 */
    public void set_ce(CE new_ce){
        ce=new_ce;
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
    /**Redefinition de EmpreinteC pour Logement qui calcule l impact*/
    @Override
    public void EmpreinteC(){ 
        set_impact(ce.getAlpha_ce()*superficie);      
    }
    
    /**Affiche l impact moyen d un francais vis a vis de son logement*/
    public static void impactL_Moy(){
        System.out.println("l'empreinte carbone moyenne d'un.e français.e vis-à-vis du logement par an  est 2 706kg avec"+"\n"+
        "Energie et utilités : 1696kg,  Construction et gros entretien :675kg,  Equipement des logements: 335kg");
    }
    
    /**Redefinition de toString pour Logement qui retourne les caracteristiques de l objet courant
	 * @return String Chaine de caracteres representative de l objet
	 */
    @Override 
    public String toString(){
        return "Logement [ ID: "+get_id()+",  Superficie: "+superficie+"m^2,  Classe Energétique:"+ce+",  Impact en TCO2:"+get_impact()+" ]";
    }

}