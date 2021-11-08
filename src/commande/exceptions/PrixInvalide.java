package commande.exceptions;

public class PrixInvalide extends RuntimeException{
    int prix;

    public PrixInvalide (int prix){
        super ("Prix invalide :"+prix);
        this.prix=prix;
    }
}
