public class MoteurEteint implements EtatMoteur {
    public void demarrer(Appareil appareil) {
        appareil.setEtatMoteur(new MoteurAllume());
        System.out.println("Moteur démarré (Allumé)");
    }

    public void arreter(Appareil appareil) {
        System.out.println("Moteur déjà éteint");
    }

    public String getNom() {
        return "Éteint";
    }
}

