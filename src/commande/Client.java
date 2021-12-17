package commande;

import java.util.ArrayList;
import java.util.List;

/** Classe Client qui est un sous-type de la classe Personne
 * @see Personne
 * */

class Client extends Personne implements Generable{

    /** Constructeur de la classe Client
     * @param id : identifiant du Client
     * @param prix : liste des prix de chaque panneau du Client
     * @param bois : liste des objets de classe Bois demandés par le Client
     * @param nombreBois : liste des objets de classe NbBois correspondant aux nombres de bois identiques du Client
     * @param date : liste des objets de classe Date
     * */
    Client(int id, ArrayList<Prix> prix, ArrayList<Bois> bois, ArrayList<NbBois> nombreBois, ArrayList<Date> date){
        super(id,prix,bois,nombreBois,date);
    }
}
