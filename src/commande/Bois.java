package commande;

class Bois {
    Dimensions dimensions;

    private Bois(Dimensions dimensions){
        this.dimensions=dimensions;
    }

    private Dimensions getDimensions(){
        return this.dimensions;
    }

    private void setDimensions(Dimensions dimensions){
        this.dimensions=dimensions;
    }
}
