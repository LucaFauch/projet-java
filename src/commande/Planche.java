package commande;

/** Classe Planche, qui est le type de Bois manipulé par les clients */
class Planche extends Panneau implements Generable{
    int id;

    /** Constructeur de la classe Planche */
    Planche(Dimensions dimensions, int id){
        super(dimensions,id);
    }

}
