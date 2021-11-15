package commande;
import commande.NbBois;


public class InvalideNbBois extends RuntimeException{
    NbBois nbBois;

    public InvalideNbBois(NbBois nbBois){
        super("Nombre de bois invalide. Nombre fourni : "+nbBois.getNombre());
        this.nbBois=nbBois;
    }
}