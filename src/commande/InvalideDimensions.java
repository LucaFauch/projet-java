package commande;
import commande.Dimensions;

public class InvalideDimensions extends RuntimeException{
    Dimensions dimensions;

    public InvalideDimensions(Dimensions dimensions){
        super("Dimensions invalides. Dimensions fournies : ");
        this.dimensions=dimensions;
    }
}
