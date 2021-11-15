package commande;

public class InvalideId extends RuntimeException{
    int id;

    public InvalideId(int id){
        super("Id invalide. Id fourni : "+id);
        this.id=id;
    }
}
