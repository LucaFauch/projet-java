package commande;

class Bois {
    Dimensions dimensions;

    Bois(Dimensions dimensions){
        this.dimensions=dimensions;
    }

    Dimensions getDimensions(){
        return this.dimensions;
    }

    private void setDimensions(Dimensions dimensions){
        this.dimensions=dimensions;
    }
}
