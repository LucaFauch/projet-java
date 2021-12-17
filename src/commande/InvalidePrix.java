package commande;


/** Classe InvalidePrix, permettant de vérifier si un prix est correct et renvoyant un message dans la console
 * @see Prix
 * */
public class InvalidePrix extends RuntimeException{
    int prix;

    public InvalidePrix(int prix){
        super ("Prix invalide :"+prix);
        this.prix=prix;
    }
}
