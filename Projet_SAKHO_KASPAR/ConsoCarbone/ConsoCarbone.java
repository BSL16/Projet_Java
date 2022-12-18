// classe abstraite car contient une méthode abstarite. Donc, on ne peut pas l'instancier
//il implémente l'interface génératrice ( de type Consocarone) Comparable. Ainsi, on doir redefinir la methode compareTo/
package consoCarbone;
/**consoCarbone represente un poste de consommation carbone generique
*@author marc kaspar
*@version 1
*/ 
public abstract class ConsoCarbone implements Comparable<ConsoCarbone> { 
    protected final int id;  // sera protected pour que les classes filles aient id
    protected double impact; // protected pour que les classes filles l'accédent. Dans ce cas, on peut supprimer l'attribut
    // impact dans les classes filles et ses getters et setters
    private static int cpt=0; //Compteur de l'id
    
    /**Constructeur par defaut de consoCarbone*/
    public ConsoCarbone(){
        cpt++;             //pour que le compteur commence par 1
        id=cpt;
        impact=0;
    }
    /**Constructeur de consoCarbone
	 * @param impact Impact en termes d emissions de GES en TCO2eq 
	 */
    public ConsoCarbone (double impact){ //id est unique
        this();
        this.impact=impact;
    }
    
    //getters et setters
    /**Getter d'ID
	 * @return ID de l'objet 
	 */
    public int get_id(){
        return id;
    }
    
    /**Getter d'impact
	 * @return Impact de l'objet 
	 */
    public double get_impact(){ //et on supprime les getters et setters d'impact dans les clasees filles
        return impact;
    }
    
    /**Setter d impact
     * @param new_impact Impact en termes d emissions de GES en TCO2eq a modifier
     */
    public void set_impact(double new_impact){
        impact=new_impact;
    }
    
    // on met ici les fonctions abstraites et on les redefinit ensuite dans les classes filles
    /**Calculateur abstrait de l'impact en fonction des autres attributs
	 */
    public abstract void EmpreinteC();
    
    /**Redefinition de toString pour consoCarbone
	 * @return Chaine de caracteres representative de l'objet
	 */
    @Override // on redéfinit la méthode toString de la classe object comme une méthode abstraite
    public abstract String toString();

    /**Redefinition de compareTO pour consoCarbone
	 * @return un entier negatif, zero, ou un entier positif si l'objet est inferieur, egal, ou superieur a l'objet specifie
	 */
    @Override
    public int compareTo(ConsoCarbone c2){
        if (this.impact>c2.impact) return 1;
        else if (this.impact<c2.impact) return -1;
        else return 0;
    }
    
    }