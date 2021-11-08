package commande.exceptions;
import commande.NbBois;


public class NbBoisInvalide extends RuntimeException{
    NbBois nbBois;

    public NbBoisInvalide(NbBois nbBois){
        super("Nombre de bois invalide. Nombre fourni : "+nbBois.getNombre());
        this.nbBois=nbBois;
    }
}