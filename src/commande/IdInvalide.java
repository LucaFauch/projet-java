package commande;

public class IdInvalide extends RuntimeException{
    int id;

    public IdInvalide(int id){
        super("Id invalide. Id fourni : "+id);
        this.id=id;
    }
}
