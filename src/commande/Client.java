package commande;

import java.util.List;

class Client extends Personne{
    /*Client(int id, Prix prix, Bois bois, NbBois nombreBois, Date date){
        super(id,prix,bois,nombreBois,date);
    }*/
    Client(int id, List<Planche> listPlanche){
        super(id,listPlanche.get(0));

    }
}
