public class Alimentation extends ConsoCarbone {
    private double txBoeuf; //les taux sont entre 0 et 1
    private double txVege;
    private double txVol; // car selon l'hypothèse 
    public static final double CBO=8; 
    public static final double CVO=1.6;
    public static final double CVE=0.9;
    
    
    public Alimentation (){ //Constructeur par defaut
        super(); // appelle au constructeur de la classe mère pour incrémenter id...
        txBoeuf=0; 
        txVege=0;
        txVol=0;
        impact=0;
    }

    public Alimentation (double txBoeuf, double txVege){ 
        this.txBoeuf=txBoeuf; 
        this.txVege=txVege;
        this.txVol=1-txBoeuf-txVege; 
        EmprunteC(); //pour mettre à jour this.impact

    }

    //les getters et les setteurs

    public double get_txBoeuf(){ 
        return txBoeuf;
    }
    public double get_txVege(){
        return txVege;
    }
    public double get_txVol(){ 
        return txVol;

    }

    public void set_txBoeuf(double new_txB){
        this.txBoeuf=new_txB;
        EmprunteC(); //pour mettre à jour this.impact
    }
    public void set_txVege(double new_txVe){
        this.txVege=new_txVe;
        EmprunteC(); //pour mettre à jour this.impact
    }

    @Override 
    public void EmprunteC(){ //calcul l'impact
        impact=CBO*txBoeuf + CVO*txVol + CVE*txVege; 
    }

    public static void impactA_Moy(){
        System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis de son alimentation par an  est 2 353kg avec"+"\n"+
        "Viandes et Poissons: 1 144kg,  Produits laitiers et oeufs: 408kg,  Boissons: 263kg,  Autres: 538kg ");
    }

    @Override //retourne les caractéristiques de l'objet courant
    public String toString(){
        return "Alimentation [ ID: "+id+",  Taux Boeufs: "+txBoeuf+",  taux végetariens:"+txVege+",  Impact en TCO2:"+impact+" ]";
    }
    
    

}