package utilisateur;

import java.util.TreeSet;

import consoCarbone.Alimentation;
import consoCarbone.BienConso;
import consoCarbone.ConsoCarbone;
import consoCarbone.Logement;
import consoCarbone.ServicesPublics;
import consoCarbone.Transport;

import java.util.List;
import java.util.SortedSet;

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
    
    /**ordonne les consommations carbone de l’utilisateur.rice dans une liste puis présente l’information obtenue à ce.tte dernier.e, puis fait des recommendations pour obtenir
un mode de vie plus durable*/
    public void ordonnerConso() {
    	SortedSet<ConsoCarbone> consoList = new TreeSet<ConsoCarbone>();
    	consoList.add(alimentation);
    	consoList.add(bienConso);
        for (Logement a: logement) {
        	consoList.add(a);
        }
        for (Transport a: transport) {
        	consoList.add(a);
        }
    	consoList.add(services);
    	System.out.println("Votre consommation la plus importante concerne la" + consoList.last().getClass().getSimpleName());
    	if(consoList.last() instanceof Alimentation) {
    		System.out.println("Consommez plus de plats à base de produits végétals");
    	}
    	if(consoList.last() instanceof Logement) {
    		System.out.println("Eteignez la lumière lorsque vous n'êtes pas présent dans une salle");
    	}
    	
    	if(consoList.last() instanceof Transport) {
    		System.out.println("Priviégiez l'utilisation des transports en communs ou du vélo lorsque cela est possible");
    	}
    	
    	if(consoList.last() instanceof BienConso) {
    		System.out.println("Réduisez votre consomation de biens");
    	}
    	
    	//On ne peut rien recommander si la consomation la plus importante est les services publics
    }
    
}