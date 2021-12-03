package commande;

import java.util.ArrayList;

class Fournisseur extends Personne implements Generable{
    Fournisseur(int id, ArrayList<Prix> prix, ArrayList<Bois> bois, ArrayList<NbBois> nbBois, ArrayList<Date> date){
        super(id, prix, bois, nbBois, date);
    }
}
