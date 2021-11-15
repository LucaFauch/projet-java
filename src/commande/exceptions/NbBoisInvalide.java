package commande.exceptions;
import commande.NbBois;


class NbBoisInvalide extends RuntimeException{
    NbBois nbBois;

    private NbBoisInvalide(NbBois nbBois){
        super("Nombre de bois invalide. Nombre fourni : "+nbBois.getNombre());
        this.nbBois=nbBois;
    }
}