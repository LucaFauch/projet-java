package commande;

import java.util.ArrayList;

class Fournisseur extends Personne{
    Fournisseur(int id, Prix prix, ArrayList<Bois> bois, NbBois nbBois, Date date){
        super(id, prix, bois, nbBois, date);
    }
}
