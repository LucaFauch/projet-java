package commande;

/** Classe InvalideId, permettant de vérifier si un id est correct et renvoyant un message dans la console
 * @see InvalideId
 * */

public class InvalideId extends RuntimeException{
    int id;

    public InvalideId(int id){
        super("Id invalide. Id fourni : "+id);
        this.id=id;
    }
}
