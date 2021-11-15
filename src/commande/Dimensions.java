package commande;
import commande.exceptions.DateInvalide;
import commande.exceptions.DimensionsInvalide;

class Dimensions {
    int longueur;
    int largeur;


    Dimensions(int longueur, int largeur) {
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

    private void setLongueur(int longueur){
        if(longueur<=0){
            throw new DimensionsInvalide(this);
        }
        this.longueur=longueur;
    }

    private void setLargeur(int largeur){
        if(largeur<=0){
            throw new DimensionsInvalide(this);
        }
        this.largeur=largeur;
    }

}
