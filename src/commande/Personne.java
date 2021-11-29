package commande;

import java.util.ArrayList;
import java.util.Arrays;

class Personne implements Validable{
    int id;
    Prix prix;
    ArrayList<Bois> bois;
    NbBois nombreBois;
    Date date;

    public int isValid(){
        if(id<0){
            return 0;
        }else{
            return 1;
        }
    }

    Personne(int id, Prix prix, ArrayList<Bois>  bois, NbBois nombreBois, Date date) throws InvalideId{
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }
    
}
