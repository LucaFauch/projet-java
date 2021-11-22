package commande;

import java.util.List;

class Client extends Personne implements Generable{
    Client(int id, Prix prix, Bois bois, NbBois nombreBois, Date date){
        super(id,prix,bois,nombreBois,date);
    }
}
