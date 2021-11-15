package commande;

class Dimensions {
    int longueur;
    int largeur;


    Dimensions(int longueur, int largeur) {
        if (longueur < 0 || largeur < 0 || longueur < largeur)
            throw new InvalideDimensions(this);
        this.longueur=longueur;
        this.largeur=largeur;
    }

    int getLongueur() {
        return longueur;
    }

    int getLargeur() {
        return largeur;
    }

    private void setLongueur(int longueur){
        if(longueur<=0){
            throw new InvalideDimensions(this);
        }
        this.longueur=longueur;
    }

    private void setLargeur(int largeur){
        if(largeur<=0){
            throw new InvalideDimensions(this);
        }
        this.largeur=largeur;
    }

}
