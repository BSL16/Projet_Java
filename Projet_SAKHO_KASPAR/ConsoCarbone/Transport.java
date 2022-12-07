public class Transport extends ConsoCarbone {
    private boolean possede;
    private Taille taille;
    private int kilomAnnee;
    private int amortissement;

    public Transport(){
        super(); //appelle au constructeur de la classe mère pour incrémenter id...
        possede=false;
    }
    public Transport(boolean possede, Taille taille, int kilomAnnee, int amortissement){ 
            super(); //appelle au constructeur de la classe mère pour incrémenter id...
            this.possede=possede;
            this.taille=taille;
            this.kilomAnnee=kilomAnnee;
            this.amortissement=amortissement;
            EmprunteC(); //pour mettre à jour this.impact

        }
    
        // getters et setters 
        public boolean get_possede(){
            return possede;
        }
        public Taille get_taille(){
            return taille;
        }
        public int get_kilomAnne(){
            return kilomAnnee;
        }
        public int get_amortissement(){
            return amortissement;
        }
        
        public void set_possede(boolean poss){
            possede=poss;
            EmprunteC(); //pour mettre à jour this.impact
        }
        public void set_taille(Taille t){
            taille=t;
            EmprunteC(); //pour mettre à jour this.impact
        }
        public void set_kilomAnnee(int KA){
            kilomAnnee=KA;
            EmprunteC(); //pour mettre à jour this.impact
        }
        public void set_amortissement(int amor){
            amortissement=amor;
            EmprunteC(); //pour mettre à jour this.impact
        }
        
        @Override
        public void EmprunteC(){
            if(possede){
                impact=(kilomAnnee)*(1.93*0.0001) + taille.get_emission()/amortissement;
            }
            else {
                impact=0;
                }
            }
        
        public static void impactT_Moy(){
            System.out.println("l’empreinte carbone moyenne d’un.e français.e vis-à-vis de son Transport par an  est 2 920kg avec"+"\n"+
            "Voiture: 1 972kg,  Avion: 480kg,  Fret et messagerie: 383kg,  Train et bus: 85kg");
        }   

        @Override
        public String toString(){ //retourne les caractéristiques de l'objet courant
            return "Transport [ ID: "+id+",  Possede une voiture: "+possede+",  Taille:"+taille+ "\n"+
            ",  Kilomètres parcourues/an: "+kilomAnnee+",  amortissement: "+amortissement+" Impact en TCO2: "+impact+" ]";
        }
    }

