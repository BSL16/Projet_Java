public enum Taille {
    P(4.2), G(19);
    private final double emission;

    private Taille(double emission){ //le constructeur toujours en private
        this.emission= emission;
    }
    //getters et pas de setters car emmision est final
    public double get_emission(){
        return emission;
    }

}