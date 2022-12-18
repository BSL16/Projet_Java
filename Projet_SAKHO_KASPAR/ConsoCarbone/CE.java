package consoCarbone;
/**Enumeration representant la classe énergétique d'un Logement*/
public enum CE {
	/**Classe A*/
    A(0.005), 
    /**Classe B*/
    B(0.01),
    /**Classe C*/
    C(0.02),
    /**Classe D*/
    D(0.035),
    /**Classe E*/ 
    E(0.055), 
    /**Classe F*/
    F(0.08),
    /**Classe G*/
    G(0.1);
    private final double alpha_ce;
    
    private CE (double alpha_ce){
        this.alpha_ce=alpha_ce;
    }
    
    /**Getter de alpha_ce
     * @return Coefficient associe à la classe energetique
     */
    public double getAlpha_ce() {
        return alpha_ce;
    }
}