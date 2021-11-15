package commande;

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

    Personne(int id, Prix prix, Bois bois, NbBois nombreBois, Date date) throws InvalideId {
        if(id<0){
            throw new InvalideId(id);
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

    private void setId(int id) throws InvalideId {
        if(id<0){
            throw new InvalideId(id);
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
