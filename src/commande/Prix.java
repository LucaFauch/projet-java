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

    private Prix(int prix){
        setPrix(prix);
    }

    private void setPrix(int prix) throws PrixInvalide {
        if(prix<0)
            throw new PrixInvalide(prix);
        this.prix=prix;
    }

    private int getPrix(){
        return this.prix;
    }

}
