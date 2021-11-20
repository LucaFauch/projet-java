package commande;

import java.util.Arrays;

class Personne implements Validable{
    int id;
    /*int prix;
    Bois bois;
    int nombreBois;
    Date date;*/
    Planche planche;

    public int isValid(){
        if(id<0){
            return 0;
        }else{
            return 1;
        }
    }

    /*Personne(int id, Prix prix, Bois bois, NbBois nombreBois, Date date) throws InvalideId{
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }
    */
    Personne(int id,Planche planche){
        this.id=id;
        this.planche=planche;
        System.out.println(planche.prix);
        System.out.println(planche.dimensions);
        //System.out.println(id);
    }
}
