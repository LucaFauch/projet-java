package commande;
import commande.NbBois;

/** Classe InvalideNbBois, permettant de vérifier si un NbBois est correct et renvoyant un message dans la console
 * @see NbBois
 * */

class InvalideNbBois extends RuntimeException{
    NbBois nbBois;

    public InvalideNbBois(NbBois nbBois){
        super("Nombre de bois invalide. Nombre fourni : ");
        this.nbBois=nbBois;
    }
}