public class AppareilFactory {
    public static Appareil creerAppareil(String type) {
        if (type.equalsIgnoreCase("avion")) {
            return new Avion("Air Canada", "Boeing 737", 180, 2, 3000, 12000);
        } else if (type.equalsIgnoreCase("helicoptere")) {
            return new Helicoptere("Forces Royales", "Black Hawk", 2, true, 10000);
        } else {
            System.out.println("Type inconnu, avion par défaut créé.");
            return new Avion("Avion par défaut", "Cessna", 4, 1, 1000, 8000);
        }
    }
}

