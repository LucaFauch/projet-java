package commande;

public class Dimensions implements Validable,Generable{
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
        try {
            if (longueur < 0 || largeur < 0 || longueur < largeur)
                throw new IllegalArgumentException("Les longueurs et largeurs doivent être strictement positives et la longueur doit etre plus grande que la largeur.");
            else {
                this.longueur = longueur;
                this.largeur = largeur;
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("Les longueurs et largeurs doivent être strictement positives et la longueur doit etre plus grande que la largeur.");
        }

    }

}
