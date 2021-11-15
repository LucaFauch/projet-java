package commande;
import commande.exceptions.IdInvalide;

class Personne implements Validable{
    int id;
    Prix prix;
    Bois bois;
    NbBois nombreBois;
    Date date;

    public int isValid(){
        if(id<0){
            return 0;
        }else{
            return 1;
        }
    }

    Personne(int id, Prix prix, Bois bois, NbBois nombreBois, Date date) throws IdInvalide{
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }

}
