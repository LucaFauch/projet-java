package commande;

public class InvalidePrix extends RuntimeException{
    int prix;

    public InvalidePrix(int prix){
        super ("Prix invalide :"+prix);
        this.prix=prix;
    }
}
