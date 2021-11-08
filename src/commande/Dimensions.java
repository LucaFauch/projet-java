package commande;

public class Dimensions {
    private int longueur;
    private int largeur;


    public Dimensions(int longueur, int largeur) {
        if (longueur <= 0 || largeur <= 0)
            throw new IllegalArgumentException("Les dimensions doivent être strictement positives");
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

}
