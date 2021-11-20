package commande;

class Planche extends Panneau{
    float prix;
    int date;
    int nombre;
    int id;
    /*Planche(Dimensions dimensions){
        super(dimensions);
    }*/
    Planche(Dimensions dimensions,int id,int nombre,int date,float prix){
        super(dimensions);
        this.date=date;
        this.id=id;
        this.prix=prix;
        this.nombre=nombre;
    }
}
