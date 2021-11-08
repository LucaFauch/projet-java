package commande;
import commande.exceptions.IdInvalide;

public class Personne {
    int id;
    Prix prix;
    Bois bois;
    NbBois nombreBois;
    Date date;

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

    int getId(){
        return this.id;
    }

    Bois getBois(){
        return this.bois;
    }

    NbBois getNombreBois(){
        return this.nombreBois;
    }

    Date getDate(){
        return this.date;
    }

    void setId(int id) throws IdInvalide{
        if(id<0){
            throw new IdInvalide(id);
        }
        this.id=id;
    }

    void setBois(Bois bois){
        this.bois=bois;
    }

    void setNombreBois(NbBois nombreBois){
        this.nombreBois=nombreBois;
    }

    void setDate(Date date){
        this.date=date;
    }
}
