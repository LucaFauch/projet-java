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
        if(id<0){
            throw new IdInvalide(id);
        }
        this.id=id;
        this.prix=prix;
        this.bois=bois;
        this.nombreBois=nombreBois;
        this.date=date;
    }

    public int getId(){
        return this.id;
    }

    public Bois getBois(){
        return this.bois;
    }

    public NbBois getNombreBois(){
        return this.nombreBois;
    }

    public Date getDate(){
        return this.date;
    }

    private void setId(int id) throws IdInvalide{
        if(id<0){
            throw new IdInvalide(id);
        }
        this.id=id;
    }

    private void setBois(Bois bois){
        this.bois=bois;
    }

    private void setNombreBois(NbBois nombreBois){
        this.nombreBois=nombreBois;
    }

    private void setDate(Date date){
        this.date=date;
    }
}
