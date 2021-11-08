package commande.exceptions;

public class PrixInvalide extends RuntimeException{
    private int prix;

    public PrixInvalide (int prixinvalide){
        super ("Prix invalide :"+prixinvalide);
        this.prix=prixinvalide;
    }
}
