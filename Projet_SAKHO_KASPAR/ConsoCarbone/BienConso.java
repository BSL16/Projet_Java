package consoCarbone;
/**BienConso est la consommation carbone liee a la bienConso
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class BienConso extends ConsoCarbone { 
    private double montant; //montant des depenses annuelles
    
    /**Constructeur par defaut de BienConso*/
    public BienConso(){
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        montant=0; 
    }
    /**Constructeur de BienConso
	 * @param montant Somme attribue a la BienConso
	 */
    public BienConso(double montant){
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        if(montant>0) {
            this.montant=montant;
        }else {
        	this.montant=0;
        }

        EmpreinteC(); //pour mettre à jour this.impact
    }

    //getters et setters
    /**Getter de Montant
	 * @return Montant de l'objet
	 */
    public double get_montant(){
        return montant;
    }
    
    /**Setter de Montant
	 * @param new_mon Montant a modifier
	 */
    public void set_montant(double new_mon){
        if(new_mon>0) {
            montant=new_mon;
        }else {
        	montant=0;
        }
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
    /**Redefinition de EmpreinteC pour BienConso*/
    @Override
    public void EmpreinteC(){
        impact=(montant)/1750;
    }
    
    /**Affiche l'impact moyen d'un francais vis a vis de sa BienConso*/
    public static void impactBienC_Moy(){
        System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis de ses dépenses par an  est 2 625kg avec"+"\n"+
        "Achat et usages Internet et technologies: 1 180kg,  Autres biens et services: 682kg,  Habillement: 763kg");
    }   
    
    /**Redefinition de toString pour BienConso
	 * @return Chaine de caracteres representative de l'objet
	 */
    @Override
    public String toString(){ //retourne les caractéristiques de l'objet courant
        return "Bien Consommation [ ID: "+id+",  Montant dépenses/an: "+montant+",  Impact en TCO2:"+impact+" ]";
    }





}
