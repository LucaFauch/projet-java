package commande;
import commande.Dimensions;

/** Classe InvalideDimensions, permettant de vérifier si les dimensions sont correctes et renvoyant un message dans la console
 * @see InvalideDimensions
 * */

public class InvalideDimensions extends RuntimeException{
    Dimensions dimensions;

    public InvalideDimensions(Dimensions dimensions){
        super("Dimensions invalides. Dimensions fournies : ");
        this.dimensions=dimensions;
    }
}
