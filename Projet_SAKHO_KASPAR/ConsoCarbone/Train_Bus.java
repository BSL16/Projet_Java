package consoCarbone;
/** Train_Bus est une extension de la classe Consocarbone. Cette classe herite de Transport qui elle meme herite de Consocarbone*/
public class Train_Bus extends Transport {
    /** Constructeur par défaut */
    public Train_Bus(){
        super();
    }
    /**
     * Constructeur de Train Bus
     * @param possede
     * @param taille
     * @param kilomAnnee
     * @param amortissement
     */
    public Train_Bus(boolean possede, Taille taille, int kilomAnnee, int amortissement){
        super(possede, taille, kilomAnnee, amortissement);
    }
    /** modifie la valeur de l impact en ajoutant 85 à l empreinte du transport si l utilisateur a une voiture, sinon impact est à 85*/
    @Override   
    public void EmpreinteC(){
        if(get_possede()){
            set_impact((get_kilomAnne())*(1.93*0.0001) + get_taille().get_emission()/get_amortissement() + 85);
        }
        else {
            set_impact(85);
            }
        }
    /** 
     * renvoie les caractéristiques de l'utilisateur vis a vis de son utilisation de Train
     * @return String  */
    @Override
    public String toString(){ 
    return "Train_Bus [ ID: "+get_id()+",  Impact en TCO2: "+get_impact()+" ]";
    }
}
