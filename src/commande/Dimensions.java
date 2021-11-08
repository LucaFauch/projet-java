package commande;
import commande.exceptions.DateInvalide;
import commande.exceptions.DimensionsInvalide;

public class Dimensions {
    int longueur;
    int largeur;


    public Dimensions(int longueur, int largeur) {
        if (longueur < 0 || largeur < 0 || longueur < largeur)
            throw new DimensionsInvalide(this);
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    void setLongueur(int longueur){
        this.longueur=longueur;
        if(longueur<=0){
            throw new DimensionsInvalide(this);
        }
    }

    void setLargeur(int largeur){
        this.largeur=largeur;
        if(largeur<=0){
            throw new DimensionsInvalide(this);
        }
    }

}
