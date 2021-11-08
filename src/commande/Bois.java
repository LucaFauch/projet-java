package commande;

public class Bois {
    Dimensions dimensions;

    Bois(Dimensions dimensions){
        this.dimensions=dimensions;
    }

    Dimensions getDimensions(){
        return this.dimensions;
    }

    void setDimensions(Dimensions dimensions){
        this.dimensions=dimensions;
    }
}
