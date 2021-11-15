package commande;
import commande.Dimensions;

public class DimensionsInvalide extends RuntimeException{
    Dimensions dimensions;

    public DimensionsInvalide(Dimensions dimensions){
        super("Dimensions invalides. Dimensions fournies : "+dimensions.getLongueur()+"."+dimensions.getLargeur());
        this.dimensions=dimensions;
    }
}
