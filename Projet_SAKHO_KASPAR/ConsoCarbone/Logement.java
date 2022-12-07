public class Logement extends ConsoCarbone {
    private int superficie; 
    private CE ce;
    
    public Logement(){ //constructeur par défaut
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        superficie=0; 
        ce=CE.A; 
    }
    public Logement(int superficie, CE ce){ 
        this.superficie=superficie; 
        this.ce=ce;
        EmprunteC(); //pour avoir this.impact
    }

    //getters et setters
    public int get_superficie(){
        return superficie;
    }
    public CE get_ce(){
        return ce;
    }

    public void set_superficie(int new_sup){
        superficie=new_sup;
        EmprunteC(); //pour mettre à jour this.impact
    }
    public void set_ce(CE new_ce){
        ce=new_ce;
        EmprunteC(); //pour mettre à jour this.impact
    }
    
    @Override// calcul l'impact 
    public void EmprunteC(){ 
        impact=ce.getAlpha_ce()*superficie;      
    }
    public static void impactL_Moy(){
        System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis du logement par an  est 2 706kg avec"+"\n"+
        "Energie et utilités : 1696kg,  Construction et gros entretien :675kg,  Equipement des logements: 335kg");
    }
    @Override //retourne les caractéristiques de l'objet courant
    public String toString(){
        return "Logement [ ID: "+id+",  Superficie: "+superficie+"m^2,  Classe Energétique:"+ce+",  Impact en TCO2:"+impact+" ]";
    }

}