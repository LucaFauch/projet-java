package commande;

class Date implements Validable{
    int jour;
    int mois;
    int annee;

    public int isValid(){
        if(this.jour<1||this.jour>31||this.mois<1||this.mois>12||this.annee<=2021){
            return 0;
        }else{
            return 1;
        }
    }

    private Date(int jour, int mois, int annee) throws InvalideDate {
        if(jour<1||jour>31||mois<1||mois>12||annee<=2021){
            throw new InvalideDate(this);
        }
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }

    int getJour(){
        return this.jour;
    }

    int getMois(){
        return this.mois;
    }

    int getAnnee(){
        return this.annee;
    }

    private void setJour(int jour){
        if(jour<1||jour>31){
            throw new InvalideDate(this);
        }
        this.jour=jour;
    }

    private void setMois(int mois){
        if(mois<1||mois>12){
            throw new InvalideDate(this);
        }
        this.mois=mois;
    }

    private void setAnnee(int annee){
        if(annee<=2021){
            throw new InvalideDate(this);
        }
        this.annee=annee;
    }

    public String toString(){
        return this.jour+"."+this.mois+"."+this.annee;
    }
}
