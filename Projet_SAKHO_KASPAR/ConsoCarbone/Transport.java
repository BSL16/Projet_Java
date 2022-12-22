package consoCarbone;

/**Transport est la consommation carbone liee au Transport
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class Transport extends ConsoCarbone {
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;
    
    /**Constructeur par defaut de Transport*/
    public Transport(){
        super(); 
        possede=false;
    }
    /**Constructeur de Transport
	 * @param possede Possession ou non d'un vehicule
	 * @param taille Taille du vehicule
	 * @param kilomAnnee Nombre de kilometre parcourus par an
	 * @param amortissement Duree de conservation du vehicule
     * @throws IllegalArgumentException le cas kilomAnne ou ammortissement est negatif
	 */
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement)throws IllegalArgumentException{ 
            super(); 

            if (kilomAnnee<0 | amortissement<0)
                throw new IllegalArgumentException("kilomAnne et ammortissement doivent être positive");

            this.possede=possede;
            this.taille=taille;
            this.kilomAnnee=kilomAnnee;
            this.amortissement=amortissement;
            EmpreinteC(); //pour mettre à jour this.impact

        }
    
    	/**Getter de Possede
    	 * @return Possession ou non d'un vehicule
    	 */
        public boolean get_possede(){
            return possede;
        }
        
        /**Getter de Taille
    	 * @return Taille du vehicule
    	 */
        public Taille get_taille(){
            return taille;
        }
        
        /**Getter de KilomAnnee
    	 * @return Nombre de kilometre parcourus par an
    	 */
        public int get_kilomAnne(){
            return kilomAnnee;
        }
        
        /**Getter de Amortissement
    	 * @return Duree de conservation du vehicule
    	 */
        public int get_amortissement(){
            return amortissement;
        }
        
        /**Setter de Possede
    	 * @param poss Possession ou non d'un vehicule a modifier
    	 */
        public void set_possede(boolean poss){
            possede=poss;
            EmpreinteC(); //pour mettre à jour this.impact
        }
        
        /**Setter de Taille
    	 * @param t Taille du vehicule a modifier
    	 */
        public void set_taille(Taille t){
            taille=t;
            EmpreinteC(); //pour mettre à jour this.impact
        }
        
        /**Setter de KilomAnnee
    	 * @param KA Nombre de kilometre parcourus par an a modifier
         * @throws IllegalArgumentException le cas ou kilomAnne est negatif
    	 */
        public void set_kilomAnnee(int KA)throws IllegalArgumentException{
            if (KA<0)
                throw new IllegalArgumentException("le nouveau kilomAnne doit être positive. Cependant, kilomAnne est "+KA);

            kilomAnnee=KA;
            EmpreinteC(); //pour mettre à jour this.impact
        }
        
        /**Setter d'Amortissement 
    	 * @param amor Duree de conservation du vehicule a modifier
         * @throws IllegalArgumentException le cas ou amortissement est negatif
    	 */
        public void set_amortissement(int amor)throws IllegalArgumentException{
            if (amor<0)
                throw new IllegalArgumentException("le nouveau ammortissement doit être positive. Cependant, l'ammortissement est "+amor);

            amortissement=amor;
            EmpreinteC(); //pour mettre à jour this.impact
        }
        
        /**Redefinition de EmpreinteC pour Transport qui calcule l empreinte carbone*/
        @Override
        public void EmpreinteC(){
            if(possede){
                set_impact((kilomAnnee)*(1.93*0.0001) + taille.get_emission()/amortissement);
            }
            else {
                set_impact(0);
                }
            }
        
        /**Affiche l impact moyen d'un francais vis a vis de son transport*/
        public static void impactT_Moy(){
            System.out.println("l'empreinte carbone moyenne d'un.e français.e vis-à-vis de son Transport par an  est 2 920kg avec"+"\n"+
            "Voiture: 1 972kg,  Avion: 480kg,  Fret et messagerie: 383kg,  Train et bus: 85kg");
        }   

        /**Redefinition de toString pour Transport qui retourne les caracteristiques de l objet courant
    	 * @return Chaine de caracteres representative de l objet
    	 */
        @Override
        public String toString(){ 
            return "Transport [ ID: "+get_id()+",  Possede une voiture: "+possede+",  Taille:"+taille+ "\n"+
            ",  Kilomètres parcourues/an: "+kilomAnnee+",  amortissement: "+amortissement+" Impact en TCO2: "+get_impact()+" ]";
        }
    }
