package commande;

import java.util.ArrayList;

/** Classe Fournisseur qui est un sous-type de la classe Personne
 * @see Personne
 * */
class Fournisseur extends Personne implements Generable{

    /** Constructeur de la classe Fournisseur
     * @param id : identifiant du fournisseur
     * @param prix : liste des prix de chaque panneau du Fournisseur
     * @param bois : liste des objets de classe Bois possédés par le fournisseur
     * @param nbBois : liste des objets de classe NbBois correspondant aux nombres de bois identiques du Fournisseur
     * @param date : liste des objets de classe Date
     * */
    Fournisseur(int id, ArrayList<Prix> prix, ArrayList<Bois> bois, ArrayList<NbBois> nbBois, ArrayList<Date> date){
        super(id, prix, bois, nbBois, date);
    }
}
