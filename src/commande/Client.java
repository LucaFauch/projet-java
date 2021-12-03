package commande;

import java.util.ArrayList;
import java.util.List;

class Client extends Personne implements Generable{
    Client(int id, ArrayList<Prix> prix, ArrayList<Bois> bois, ArrayList<NbBois> nombreBois, ArrayList<Date> date){
        super(id,prix,bois,nombreBois,date);
    }
}
