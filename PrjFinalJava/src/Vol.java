public class Vol {
    private Appareil appareil;
    private Ville depart;
    private Ville arrivee;
    private Meteo meteo;
    private boolean modeAtterrissage = false;
    private boolean explose = false;

    public Vol(Appareil appareil, Ville depart, Ville arrivee) {
        this.appareil = appareil;
        this.depart = depart;
        this.arrivee = arrivee;
        this.meteo = new Meteo();
    }

    public void activerModeAtterrissage() {
        modeAtterrissage = true;
        System.out.println("Mode atterrissage activé.");
    }

    public void monter(int pieds) {
        if (explose) {
            System.out.println("L'appareil est détruit, impossible de monter.");
            return;
        }
        appareil.altitude += pieds;
        System.out.println("Montée de " + pieds + " pieds. Altitude actuelle : " + appareil.altitude);

        if (appareil.altitude >= 12000) {
            explose = true;
            System.out.println(" Explosion à 12 000 pieds !");
        } else if (appareil.altitude >= 10000) {
            System.out.println("⚠ Alerte : Altitude critique atteinte (10 000 pieds)");
        }
    }

    public void descendre(int pieds) {
        if (explose) {
            System.out.println("L'appareil est détruit, impossible de descendre.");
            return;
        }

        appareil.altitude -= pieds;
        if (appareil.altitude < 0) appareil.altitude = 0;

        System.out.println("Descente de " + pieds + " pieds. Altitude actuelle : " + appareil.altitude);

        if (appareil.altitude == 0) {
            if (modeAtterrissage) {
                System.out.println(" Atterrissage réussi à " + arrivee.getNom());
            } else {
                explose = true;
                System.out.println(" Explosion : descente brutale sans mode atterrissage !");
            }
        }
    }

    public void afficherEtatVol() {
        appareil.afficherEtat();
        System.out.println("Départ : " + depart);
        System.out.println("Arrivée : " + arrivee);
        System.out.println("Distance à parcourir : " + (arrivee.getDistance() - depart.getDistance()) + " km");
        System.out.println("Météo : " + meteo.getCondition());
        if (explose) {
            System.out.println("️ Statut : L'appareil a explosé.");
        }
    }
}
