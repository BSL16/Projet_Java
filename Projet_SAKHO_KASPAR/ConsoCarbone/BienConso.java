public class BienConso extends ConsoCarbone { 
    private double montant; //montant des depenses annuelles

    public BienConso(){
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        montant=0; 
    }
    public BienConso(double montant){
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        this.montant=montant;
        EmprunteC(); //pour mettre à jour this.impact
    }

    //getters et setters
    public double get_montant(){
        return montant;
    }
    public void set_montant(double new_mon){
        montant=new_mon;
        EmprunteC(); //pour mettre à jour this.impact
    }
    
    @Override
    public void EmprunteC(){
        impact=(montant)/1750;
    }

    public static void impactBienC_Moy(){
        System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis de ses dépenses par an  est 2 625kg avec"+"\n"+
        "Achat et usages Internet et technologies: 1 180kg,  Autres biens et services: 682kg,  Habillement: 763kg");
    }   

    @Override
    public String toString(){ //retourne les caractéristiques de l'objet courant
        return "Bien Consommation [ ID: "+id+",  Montant dépenses/an: "+montant+",  Impact en TCO2:"+impact+" ]";
    }





}