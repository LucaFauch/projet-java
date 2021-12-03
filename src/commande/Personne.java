package commande;

import java.util.ArrayList;
import java.util.Arrays;

class Personne implements Validable{
    int id;
    ArrayList<Prix> prix;
    ArrayList<Bois> bois;
    ArrayList<NbBois> nombreBois;
    ArrayList<Date> date;

    public int isValid(){
        if(id<0){
            return 0;
        }else{
            return 1;
        }
    }

    Personne(int id, ArrayList<Prix> prix, ArrayList<Bois>  bois, ArrayList<NbBois> nombreBois, ArrayList<Date> date) throws InvalideId{
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }
    
}
