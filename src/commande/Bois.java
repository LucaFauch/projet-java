package commande;

class Bois {
    Dimensions dimensions;

    Bois(Dimensions dimensions){
        this.dimensions=dimensions;
    }

    public Dimensions getDimensions(){
        return this.dimensions;
    }

    private void setDimensions(Dimensions dimensions){
        this.dimensions=dimensions;
    }
}
