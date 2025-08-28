public class Helicoptere extends Appareil {
    private int nombreRotors;
    private boolean volStationnaire;
    private String type;
    private int altitudeMax;

    public Helicoptere(String nom, String type, int rotors, boolean volStationnaire, int altitudeMax) {
        this.nom = nom;
        this.type = type;
        this.nombreRotors = rotors;
        this.volStationnaire = volStationnaire;
        this.altitudeMax = altitudeMax;
        this.etatMoteur = new MoteurEteint(); // état initial
    }

    @Override
    public void demarrerMoteur() {
        etatMoteur.demarrer(this); // passe à "allumé" si possible
    }

    @Override
    public void arreterMoteur() {
        if (altitude == 0) {
            etatMoteur.arreter(this); // repasse à "éteint"
        } else {
            System.out.println("Impossible d'arrêter le moteur en vol.");
        }
    }

    @Override
    public void decoller() {
        if (etatMoteur instanceof MoteurAllume && altitude == 0) {
            altitude += 1000;
            carburant -= 5;
            System.out.println("🚁 Décollage de l'hélicoptère.");
        } else {
            System.out.println("Démarrer le moteur ou déjà en vol.");
        }
    }

    @Override
    public void monter() {
        if (etatMoteur instanceof MoteurAllume && altitude < altitudeMax) {
            altitude += 1000;
            carburant -= 10;
            System.out.println(" Montée à " + altitude + " pieds.");

            if (altitude == 10000) {
                System.out.println(" Alerte : altitude de 10 000 pieds !");
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
            etatMoteur = new MoteurEteint(); // réparé, moteur prêt
            System.out.println(" Hélicoptère réparé. Moteur maintenant éteint.");
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
        System.out.println(" État de l’hélicoptère :");
        System.out.println("Nom: " + nom);
        System.out.println("Type: " + type);
        System.out.println("Altitude: " + altitude);
        System.out.println("Carburant: " + carburant);
        System.out.println("Dégâts: " + degats + "%");
        System.out.println("Vitesse: " + vitesse);
        System.out.println("Moteur: " + etatMoteur.getNom());
    }
}


