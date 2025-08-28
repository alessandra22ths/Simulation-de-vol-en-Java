import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoiteNoire {
    private List<String> journal = new ArrayList<>();

    public void ajouter(String action) {
        journal.add("[" + new Date() + "] " + action);
    }

    public void afficher() {
        for (String ligne : journal) {
            System.out.println(ligne);
        }
    }
}

