package utilisateur;

import java.util.*;
import java.io.*;
import java.lang.*;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;


/**Utilisateur est la consommation carbone d un individu
*@author Marc Kaspar et Bamba SAKHO
*@version 1
*/
public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private List<Logement> logement;
    private List<Transport> transport;
    private ServicesPublics services;
    
    /**Constructeur d Utilisateur
     * @param alimentation Alimentation de l individu
     * @param bienConso BienConso de l individu
     * @param logement Logement de l individu
     * @param transport Transport de l individu
     * @param services Services Publics de l individu
     */
    public Utilisateur(Alimentation alimentation, BienConso bienConso , List<Logement> logement, List<Transport> transport, ServicesPublics services){
        this.alimentation=alimentation;
        this.bienConso=bienConso;
        this.logement=logement;
        this.transport=transport;
        this.services=services;
    }

    /**
     * constructeur de la classe Utilisateur pour initialiser un utilisateur ou une utilisatrice a partir de fichiers textes
     * @param File f_A fichier qui contiennent l'objet de type Alimentation.
     *  @param File f_BC fichier qui contiennent l'objet de type BienConso.
     *  @param File f_Lo fichier qui contiennent l'objet de type List<Logement>.
     *  @param File f_Tr fichier qui contiennent l'objet de type List<Transport>.
     *  @param File f_SP fichier qui contiennent l'objet de type ServicesPublics.
     * @throws IOException exception levee s il existe un fichier en argument qui n existe pas ou n est pas accessible
     * @throws Exception donne le parcours complet de l'exception levee avec la methode printStackTrace
     */
    public  Utilisateur(File f_A, File f_BC, File f_Lo, File f_Tr, File f_SP) throws IOException, Exception {
        try{
        ObjectInputStream ois_A = new ObjectInputStream(new FileInputStream(f_A));
        ObjectInputStream ois_BC = new ObjectInputStream(new FileInputStream(f_BC));
        ObjectInputStream ois_Lo = new ObjectInputStream(new FileInputStream(f_Lo));
        ObjectInputStream ois_Tr = new ObjectInputStream(new FileInputStream(f_Tr));
        ObjectInputStream ois_SP = new ObjectInputStream(new FileInputStream(f_SP));
        } catch (IOException e){
            System.out.println ("il existe un fichier en argument qui n'existe pas ou n'est pas accessible");
        } catch (Exception e){
            e.printStackTrace();
        }
        ObjectInputStream ois_A = new ObjectInputStream(new FileInputStream(f_A));
        ObjectInputStream ois_BC = new ObjectInputStream(new FileInputStream(f_BC));
        ObjectInputStream ois_Lo = new ObjectInputStream(new FileInputStream(f_Lo));
        ObjectInputStream ois_Tr = new ObjectInputStream(new FileInputStream(f_Tr));
        ObjectInputStream ois_SP = new ObjectInputStream(new FileInputStream(f_SP));

        alimentation = (Alimentation) ois_A.readObject();
        bienConso = (BienConso) ois_BC.readObject();
        logement = (List<Logement>) ois_Lo.readObject();
        transport=(List<Transport>) ois_Tr.readObject();
        services=(ServicesPublics) ois_SP.readObject();
        ois_A.close();
        ois_BC.close();
        ois_Lo.close();
        ois_Tr.close();
        ois_SP.close();

    }



    //getters et setters
    /**Getter de Alimentation
     * @return Alimentation de l individu
     */
    public Alimentation getAlimentation() {
        return alimentation;
    }
    /**Getter de BienConso
     * @return BienConso de l individu
     */
    public BienConso getBienconso(){
        return bienConso;
    }
    /**Getter de Logement
     * @return Logement de l individu
     */
    public List<Logement> getLogement() {
        return logement;
    }
    /**Getter de Transport
     * @return Transport de l individu
     */
    public List<Transport> getTransport() {
        return transport;
    }
    /**Getter de Services Publics
     * @return Services Publics de l individu
     */
    public ServicesPublics getServices() {
        return services;
    }

    /**Setter de Alimentation
     * @param alimentation Alimentation de l individu a modifier
     */
    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }
    
    /**Setter de BienConso
     * @param bienConso BienConso de l individu a modifier
     */
    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }
    
    /**Setter de Logement
     * @param logement Logement de l individu a modifier
     */
    public void setLogement(List<Logement> logement) {
        this.logement = logement;
    }
    
    /**Setter de Transport
     * @param transport Transport de l individu a modifier
     */
    public void setTransport(List<Transport> transport) {
        this.transport = transport;
    }
    
    /**Calculateur de l impact de l utilisateur
	 * @return l empreinte de l individu
	 */
    public double calculerEmpreinte(){
        double impactlog = 0;
        for (Logement a: logement) {
        	impactlog+=a.get_impact();
        }
        double impacttrans = 0;
        for (Transport a: transport) {
        	impacttrans+=a.get_impact();
        }
        return alimentation.get_impact()+bienConso.get_impact()+impactlog+impacttrans+services.get_impact();
    }
    
    /**Detaille l empreinte de l individu*/
    public void detaillerEmpreinte(){
        double impactlog = 0;
        for (Logement a: logement) {
        	impactlog+=a.get_impact();
        }
        double impacttrans = 0;
        for (Transport a: transport) {
        	impacttrans+=a.get_impact();
        }
        System.out.println("L'utilisateur a un empreinte carbone (en TCO2 equivalente par an) de :\n"+
        alimentation.get_impact()+" concernant son alimentation\n"+
        bienConso.get_impact()+" concernant ses dépenses en biens de consommation\n"+
        impactlog + " concernant son logement\n"+
        impacttrans + " concernant ses déplacements\n"+
        services.get_impact()+" concernant son utilisation des services publics");
    }
    
    /**
     * Ordre_Info_ConsoCarbone ordonne les consommations carbone de l utilisateur.rice dans une liste
    puis presente l information obtenue a ce.tte dernier.e, puis fait des recommendations pour obtenir un mode de vie plus durable
     * @return ConsoCarbone l objet de type ConsoCarbone qui a le plus grand impact carbone pour l utilisateur donnee 
     */
    public ConsoCarbone Ordre_Info_ConsoCarbone(){
        List<ConsoCarbone> List_Conso = new ArrayList<>();
        List_Conso.add(alimentation);
        List_Conso.add(bienConso);
        List_Conso.add(logement);
        List_Conso.add(transport);
        List_Conso.add(services);
        List_Conso.sort(null); // car ConsoCarbone implémente l'interface Comparable 
        System.out.println("L'ordre croissant de votre consommation carbone est" + List_Conso);
        n=List_Conso.size();
        switch(List_Conso.get(n-1).getClass()){
            case Alimentation:
            System.out.println("Diminuez votre consommation de viande");
            return List_Conso.get(n-1);
            
            case BienConso :
            System.out.println("Réduisez vos dépenses annuelles");
            return List_Conso.get(n-1);
            
            case Logement :
            System.out.println("Réduisez la consommatrion énergétique à la maison en éteignez les lampes,isolez votre maison...");
            return List_Conso.get(n-1);
            
            case Transport :
            System.out.println("Diminuez vos kilomètres en voiture voire se passer de voiture, Eviter l avion autant que possible");
            return List_Conso.get(n-1);

            //si c'est les services publiques qui consomment le plus, on ne peut rien conseiller
        }

        
    }
    
    
}
