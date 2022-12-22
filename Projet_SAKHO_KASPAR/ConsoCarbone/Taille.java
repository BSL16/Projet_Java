package consoCarbone;

/**Enumeration representant la taille du vehicule*/
public enum Taille {
	/**Petite*/
    P(4.2), 
    /**Grosse*/
    G(19);
    private final double emission;

    private Taille(double emission){ //le constructeur toujours en private
        this.emission= emission;
    }
    //pas de setters car emmision est final
    /**Getter d Emission
	 * @return double Emission correspondant a cette taille de vehicule
	 */
    public double get_emission(){
        return emission;
    }

}
