package commande;
import commande.NbBois;


class InvalideNbBois extends RuntimeException{
    NbBois nbBois;

    public InvalideNbBois(NbBois nbBois){
        super("Nombre de bois invalide. Nombre fourni : ");
        this.nbBois=nbBois;
    }
}