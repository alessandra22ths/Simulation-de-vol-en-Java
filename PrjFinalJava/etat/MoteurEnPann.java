public class MoteurEnPanne implements EtatMoteur {
    public void demarrer(Appareil appareil) {
        System.out.println("Moteur en panne !");
    }

    public void arreter(Appareil appareil) {
        System.out.println("Moteur en panne !");
    }

    public String getNom() {
        return "En Panne";
    }
}

