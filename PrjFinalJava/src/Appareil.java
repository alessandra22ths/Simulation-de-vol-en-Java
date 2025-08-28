public abstract class Appareil {
    protected String nom;
    protected int altitude = 0;
    protected int carburant = 100;
    protected int degats = 0;
    protected String vitesse = "Lente";

    protected EtatMoteur etatMoteur;

    public Appareil() {
        this.etatMoteur = new MoteurEteint();
    }

    public EtatMoteur getEtatMoteur() {
        return etatMoteur;
    }

    public void setEtatMoteur(EtatMoteur etat) {
        this.etatMoteur = etat;
    }

    public void demarrerMoteur() {
        etatMoteur.demarrer(this); // délègue à l’état courant
    }

    public void arreterMoteur() {
        etatMoteur.arreter(this);
    }

    public abstract void decoller();
    public abstract void monter();
    public abstract void descendre(boolean modeAtterrissage);
    public abstract void reparer();
    public abstract void changerVitesse(String vitesse);
    public abstract void afficherEtat();
}



