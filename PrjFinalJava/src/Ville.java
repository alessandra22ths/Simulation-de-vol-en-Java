
public class Ville {
    private String nom;
    private int distance; // en kilomètres

    public Ville(String nom, int distance) {
        this.nom = nom;
        this.distance = distance;
    }

    public String getNom() {
        return nom;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return nom + " (" + distance + " km)";
    }
}



