package Utilisateur;
public class Utilisateur {
    private Alimentation alimentation;
    private BienConso bienConso;
    private Logement logement;
    private Transport transport;
    private ServicesPublics services;
    //Constructeur
    public Utilisateur(Alimentation alimentation, Bienconso bienConso , Logement logement, Transport transport, ServicesPublics services){
        this.alimentation=alimentation;
        this.bienConso=bienConso;
        this.logement=logement;
        this.transport=transport;
        this.services=services;
    }
    //getters et setters
    public Alimentation getAlimentation() {
        return alimentation;
    }
    public Bienconso getBienconso(){
        return bienConso;
    }
    public Logement getLogement() {
        return logement;
    }
    public Transport getTransport() {
        return transport;
    }
    public ServicesPublics getServices() {
        return services;
    }

    public void setAlimentation(Alimentation alimentation) {
        this.alimentation = alimentation;
    }
    public void setBienConso(BienConso bienConso) {
        this.bienConso = bienConso;
    }
    public void setLogement(Logement logement) {
        this.logement = logement;
    }
    public void setTransport(Transport transport) {
        this.transport = transport;
    }
    
    
    public double calculerEmpreinte(){
        return alimentation.get_impact()+bienConso.get_impact()+logement.get_impact()+transport.get_impact()+services.get_impact();
    }
    public void detaillerEmpreinte(){
        System.out.println("L'utilisateur a un empreinte carbone (en TCO2 equivalente par an) de :\n"+
        alimentation.get_impact()+" concernant son alimentation\n"+
        bienConso.get_impact()+" concernant ses dépenses en biens de consommation\n"+
        logement.get_impact()+" concernant son logement\n"+
        transport.get_impact()+" concernant ses déplacements\n"+
        services.get_impact()+" concernant son utilisation des services publics");
    }
}
