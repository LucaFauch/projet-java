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

}
