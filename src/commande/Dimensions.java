package commande;

public class Dimensions implements Validable{
    int longueur;
    int largeur;

    public int isValid(){
        if (this.longueur < 0 || this.largeur < 0 || this.longueur < this.largeur){
            return 0;
        }else{
            return 1;
        }
    }
    
    Dimensions(int longueur, int largeur) {
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
