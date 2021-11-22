package commande;

class Planche extends Panneau implements Generable{
    int id;

    Planche(Dimensions dimensions, int id){
        super(dimensions,id);
    }
    
    // Planche(Dimensions dimensions,int id,int nombre,int date,float prix){
    //     super(dimensions);
    //     this.date=date;
    //     this.id=id;
    //     this.prix=prix;
    //     this.nombre=nombre;
    // }
}
