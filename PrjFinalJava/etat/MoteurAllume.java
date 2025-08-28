public class MoteurAllume implements EtatMoteur {

    // Si le moteur est déjà allumé, inutile de le redémarrer
    public void demarrer(Appareil appareil) {
        System.out.println("Moteur déjà allumé");
    }

    // Permet d'arrêter le moteur : on passe à l'état MoteurEteint
    public void arreter(Appareil appareil) {
        appareil.setEtatMoteur(new MoteurEteint());
        System.out.println("Moteur arrêté (Éteint)");
    }

    // Retourne le nom de l'état courant
    public String getNom() {
        return "Allumé";
}
}

