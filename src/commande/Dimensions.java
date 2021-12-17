package commande;

/** Classe Dimension, qui correspond aux dimensions d'un objet de classe Bois (planche/panneau)
 * @see Bois
 * */

class Dimensions implements Validable,Generable{
    int longueur;
    int largeur;

    /** Vérification d'erreur de la classe NbBois
     *
     */

    public int isValid(){
        if (this.longueur < 0 || this.largeur < 0 || this.longueur < this.largeur){
            return 0;
        }else{
            return 1;
        }
    }

    /** Constructeurs de la classe Dimensions
     *
     * @param longueur : longueur du bois
     * @param largeur : largeur du bois
     */

    Dimensions(int longueur, int largeur) {
        try {
            if (longueur<0){
                throw new IllegalArgumentException("La longueur suivante doit être strictement positive : "+longueur);
            }
            else if (largeur<0){
                throw new IllegalArgumentException("La largeur suivante doit être strictement positive : "+largeur);
            }
            else if (longueur<largeur){
                throw new IllegalArgumentException("La longueur "+longueur+" doit être strictement plus grande que la largeur "+largeur);
            }
            else {
                this.longueur = longueur;
                this.largeur = largeur;
            }
        }
        catch(IllegalArgumentException e) {
            if (longueur<0){
                System.out.println("La longueur suivante doit être strictement positive : "+longueur);
            }
            else if (largeur<0){
                System.out.println("La largeur suivante doit être strictement positive : "+largeur);
            }
            else{
                System.out.println("La longueur "+longueur+" doit être strictement plus grande que la largeur "+largeur);
            }
        }

    }

}
