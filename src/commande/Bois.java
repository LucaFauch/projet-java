package commande;

/** Classe Bois, possédant des sous-types Planche et Panneau
 * @see Planche
 * @see Panneau
 */

class Bois implements Generable{
    Dimensions dimensions;
    int id;

    /** Constructeur de la classe Bois
     * @param dimensions : les dimensions du bois
     * @param id : l'identifiant du bois
     * */

    Bois(Dimensions dimensions,int id){
        this.dimensions=dimensions;
        this.id=id;
    }
    
}
