public interface VitesseStrategy {
        int consommerCarburant();
        String getNom();

    class VitesseCroisiere implements VitesseStrategy {
        public int consommerCarburant() {
            return 10;
        }

        public String getNom() {
            return "Croisière";
        }
    }
}

