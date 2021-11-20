package commande;

public class Dimensions implements Validable{
    float longueur;
    float largeur;

    public int isValid(){
        if (this.longueur < 0 || this.largeur < 0 || this.longueur < this.largeur){
            return 0;
        }else{
            return 1;
        }
    }
    
    Dimensions(float longueur, float largeur) {
        this.longueur=longueur;
        this.largeur=largeur;
    }

}
