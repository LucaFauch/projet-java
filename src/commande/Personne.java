package commande;

class Personne {
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
