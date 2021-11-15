package commande;
import commande.exceptions.PrixInvalide;

class Prix implements Validable{
    int prix;

    public int isValid(){
        if(this.prix<0){
            return -1;
        }else{
            return 1;
        }
    }

    Prix(int prix){
        this.prix=prix;
    }

}