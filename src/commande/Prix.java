package commande;

public class Prix {
    int prix;

    public Prix(int prix){
        setPrix(prix);
    }

    public void setPrix(int prix) throws PrixInvalide {
        if(prix<0)
            throw new PrixInvalide(prix);
        this.prix=prix;
    }


}
