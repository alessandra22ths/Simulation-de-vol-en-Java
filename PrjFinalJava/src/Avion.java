public class Avion extends Appareil {
    private int nombrePassagers;
    private int nombreMoteurs;
    private String modele;
    private int autonomie;
    private int altitudeMax;

    public Avion(String nom, String modele, int passagers, int moteurs, int autonomie, int altitudeMax) {
        this.nom = nom;
        this.modele = modele;
        this.nombrePassagers = passagers;
        this.nombreMoteurs = moteurs;
        this.autonomie = autonomie;
        this.altitudeMax = altitudeMax;
        this.etatMoteur = new MoteurEteint(); // état initial
    }

    @Override
    public void demarrerMoteur() {
        etatMoteur.demarrer(this); // délégué à l’état courant
    }

    @Override
    public void arreterMoteur() {
        if (altitude == 0) {
            etatMoteur.arreter(this);
        } else {
            System.out.println("Impossible d'arrêter le moteur en vol.");
        }
    }

    @Override
    public void decoller() {
        if (etatMoteur instanceof MoteurAllume && altitude == 0) {
            altitude += 1000;
            carburant -= 5;
            System.out.println("Décollage effectué.");
        } else {
            System.out.println("Démarrer le moteur ou déjà en vol.");
        }
    }

    @Override
    public void monter() {
        if (etatMoteur instanceof MoteurAllume && altitude < altitudeMax) {
            altitude += 1000;
            carburant -= 10;
            System.out.println("Montée à " + altitude + " pieds.");

            if (altitude == 10000) {
                System.out.println("⚠ Alerte : altitude de 10 000 pieds atteinte !");
            } else if (altitude >= 12000) {
                degats = 100;
                etatMoteur = new MoteurEnPanne();
                System.out.println(" Explosion à 12 000 pieds !");
            }
        } else {
            System.out.println("Impossible de monter.");
        }
    }

    @Override
    public void descendre(boolean modeAtterrissage) {
        if (!modeAtterrissage) {
            degats = 100;
            System.out.println("Descente sans mode atterrissage :  Explosion !");
        } else {
            altitude -= 1000;
            carburant -= 5;
            if (altitude <= 0) {
                altitude = 0;
                System.out.println("✈ Atterrissage automatique effectué.");
            } else {
                System.out.println("Descente à " + altitude + " pieds.");
            }
        }
    }

    @Override
    public void reparer() {
        if (etatMoteur instanceof MoteurEnPanne) {
            degats = 0;
            etatMoteur = new MoteurEteint(); // revient à l’état initial après réparation
            System.out.println(" Avion réparé. Moteur maintenant éteint.");
        } else {
            System.out.println("Aucune réparation nécessaire.");
        }
    }

    @Override
    public void changerVitesse(String vitesse) {
        this.vitesse = vitesse;
        System.out.println("Vitesse changée à " + vitesse);
    }

    @Override
    public void afficherEtat() {
        System.out.println(" État de l’avion :");
        System.out.println("Nom: " + nom);
        System.out.println("Modèle: " + modele);
        System.out.println("Altitude: " + altitude);
        System.out.println("Carburant: " + carburant);
        System.out.println("Dégâts: " + degats + "%");
        System.out.println("Vitesse: " + vitesse);
        System.out.println("Moteur: " + etatMoteur.getNom());
    }
}


