package commande;
import commande.exceptions.PrixInvalide;

class Prix {
    int prix;

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
