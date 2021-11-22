package commande;

class Bois implements Generable{
    Dimensions dimensions;
    int id;

    Bois(Dimensions dimensions,int id){
        this.dimensions=dimensions;
        this.id=id;
    }
    
}
