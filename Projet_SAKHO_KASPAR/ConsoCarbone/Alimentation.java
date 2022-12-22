package consoCarbone;
/**Alimentation est la consommation carbone liee a l Alimentation
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class Alimentation extends ConsoCarbone {
    private double txBoeuf;
    private double txVege;
    private static final double CBO=8; 
    private static final double CVO=1.6;
    private static final double CVE=0.9;
    
    /**Constructeur par defaut d Alimentation*/
    public Alimentation (){
        super(); 
        txBoeuf=0; 
        txVege=0;
        set_impact(0);
    }
    
	/**Constructeur d'Alimentation
	 * @param txBoeuf Proportion de repas a base de boeuf consommes
	 * @param txVege Proportion de repas vegetarien consommes
     * @throws on a gere l exception dans le cas ou taux boeuf ou taux vege ne sont pas entre 0 et 1 en le mettant a 0
	 */
    public Alimentation (double txBoeuf, double txVege){
        this.txBoeuf=txBoeuf; 
        this.txVege=txVege;
        if(txBoeuf>1 | txBoeuf<0) {
    		this.txBoeuf = 0;
    	}
    	if(txVege>1 | txVege<0) {
    		this.txVege=0;
    	}
    	if(this.txBoeuf+this.txVege>1) {
    		this.txBoeuf=0;
    		this.txVege=0;
    	}
        EmpreinteC(); //pour mettre à jour this.impact

    }
    
    /**Getter de txBoeuf
	 * @return Proportion de repas a base de boeuf consommes
	 */
    public double get_txBoeuf(){ 
        return txBoeuf;
    }
    
    /**Getter de txVege
	 * @return Proportion de repas vegetarien consommes
	 */
    public double get_txVege(){
        return txVege;
    }
    
    /**Getter de txVol
     * @return Proportion de repas a base de volaille
     */
    public double get_txVol(){ 
        return 1-txVege-txBoeuf;
    }
    
    /**Setter de txBoeuf
	 * @param new_txB Proportion de repas a base de boeuf consommes a modifier
     * @throws on a gere l exception dans le cas ou le nouveau taux boeuf n est pas entre 0 et 1 en le mettant a 0
	 */
    public void set_txBoeuf(double new_txB){
    	if(new_txB>1 | new_txB<0) {
    		txBoeuf = 0;
    	}else {
    		txBoeuf=new_txB;
    	}
    	if(txBoeuf+txVege>1) {
    		txBoeuf=0;
    		txVege=0;
    	}
    	
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
    /**Setter de txVege
	 * @param new_txVe Proportion de repas vegetarien consommes a modifier
     * @throws on a gere l exception dans le cas ou le nouveau taux vege n est pas entre 0 et 1 en le mettant a 0
	 */
    public void set_txVege(double new_txVe){
    	if(new_txVe>1 | new_txVe<0) {
    		txVege = 0;
    	}else {
    		txVege=new_txVe;
    	}
    	if(txBoeuf+txVege>1) {
    		txBoeuf=0;
    		txVege=0;
    	}
        EmpreinteC(); //pour mettre à jour this.impact
    }
    
	/**Redefinition de EmpreinteC pour Alimentation qui calcul l impact*/
    @Override 
    public void EmpreinteC(){ 
        set_impact(CBO*txBoeuf + CVO*(1-txVege-txBoeuf) + CVE*txVege); 
    }
    
    /**Affiche l impact moyen d un francais vis a vis de sa consomation alimentaire*/
    public static void impactA_Moy(){
        System.out.println("l'empreinte carbone moyenne d'un.e français.e vis-à-vis de son alimentation par an  est 2 353kg avec"+"\n"+
        "Viandes et Poissons: 1 144kg,  Produits laitiers et oeufs: 408kg,  Boissons: 263kg,  Autres: 538kg ");
    }

    /**Redefinition de toString pour Alimentation qui retourne les caracteristiques de l objet courant
	 * @return Chaine de caracteres representative de l objet
	 */
    @Override 
    public String toString(){
        return "Alimentation [ ID: "+get_id()+",  Taux Boeufs: "+txBoeuf+",  taux végetariens:"+txVege+",  Impact en TCO2:"+get_impact()+" ]";
    }
    
    

}
