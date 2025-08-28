import java.util.Scanner;

public class Simulation {
    public void lancer() {
        Scanner scanner = new Scanner(System.in);

        // Liste de villes
        Ville[] villes = {
                new Ville("Montreal", 0),
                new Ville("Quebec", 90),
                new Ville("Ottawa", 290),
                new Ville("Calgary", 240),
                new Ville("Toronto", 340)
        };

        System.out.println("=== SIMULATION DE VOL ===");
        System.out.println("Choisissez le type d'appareil : avion / helicoptere");
        String type = scanner.nextLine();
        Appareil appareil = AppareilFactory.creerAppareil(type);

        // Choix des villes
        System.out.println("Choisissez la ville de départ (0 à 4) :");
        for (int i = 0; i < villes.length; i++) {
            System.out.println(i + " - " + villes[i]);
        }
        int indexDepart = scanner.nextInt();

        System.out.println("Choisissez la ville d’arrivée (0 à 4, différente de départ) :");
        int indexArrivee;
        do {
            indexArrivee = scanner.nextInt();
        } while (indexArrivee == indexDepart);

        Ville depart = villes[indexDepart];
        Ville arrivee = villes[indexArrivee];

        Vol vol = new Vol(appareil, depart, arrivee);

        appareil.demarrerMoteur();
        appareil.changerVitesse(String.valueOf(new VitesseStrategy.VitesseCroisiere()));

        vol.monter(5000);
        vol.monter(4000);
        vol.monter(3000); // Peut exploser ici

        vol.descendre(2000);
        vol.descendre(6000); // Peut exploser si pas de mode atterrissage

        scanner.nextLine(); // vider le buffer
        System.out.println("Activer le mode atterrissage ? (oui/non)");
        String atterrissage = scanner.nextLine();
        if (atterrissage.equalsIgnoreCase("oui")) {
            vol.activerModeAtterrissage();
        }

        vol.descendre(5000); // atterrissage ou explosion

        System.out.println("\n--- État final du vol ---");
        vol.afficherEtatVol();

        scanner.close();
    }
}


