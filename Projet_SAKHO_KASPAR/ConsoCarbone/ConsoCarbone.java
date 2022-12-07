// classe abstraite car contient une méthode abstarite. Donc, on ne peut pas l'instancier
/*il implémente l'interface génératrice ( de type Consocarone) Comparable. Ainsi, on doir redefinir la methode compareTo
*/
public abstract class ConsoCarbone implements Comparable<ConsoCarbone> { 
    protected final int id;  // sera protected pour que les classes filles aient id
    protected double impact; // protected pour que les classes filles l'accédent. Dans ce cas, on peut supprimer l'attribut
    // impact dans les classes filles et ses getters et setters
    public static int cpt=0; //le compteur de l'id 
    public ConsoCarbone(){ // constructeur par défaut
        cpt++;             //pour que le compteur commence par 1
        id=cpt;
        impact=0;
    }
    public ConsoCarbone (double impact){ //id est unique
        this();
        this.impact=impact;
    }
    
    //getters et setters
    public int get_id(){
        return id;
    }
    public double get_impact(){ //et on supprime les getters et setters d'impact dans les clasees filles
        return impact;
    }

    public void set_impact(double new_impact){
        impact=new_impact;
    }
    // on met ici les fonctions abstraites et on les redefinit ensuite dans les classes filles
    public abstract void EmprunteC();
    @Override // on redéfinit la méthode toString de la classe object comme une méthode abstraite
    public abstract String toString();

    //redéfinition de compareTo
    @Override
    public int compareTo(ConsoCarbone c2){
        if (this.impact>c2.impact) return 1;
        else if (this.impact<c2.impact) return -1;
        else return 0;
    }
    
    }
