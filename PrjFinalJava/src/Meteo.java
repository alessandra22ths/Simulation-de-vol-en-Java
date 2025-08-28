
public class Meteo {
    private String condition;

    public Meteo() {
        String[] conditions = {"Ensoleillé", "Nuageux", "Orage", "Pluie", "Brouillard"};
        int randomIndex = (int) (Math.random() * conditions.length);
        this.condition = conditions[randomIndex];
    }

    public String getCondition() {
        return condition;
    }
}


