package commande;

class Date {
    int jour;
    int mois;
    int annee;

    private Date(int jour, int mois, int annee) throws DateInvalide{
        if(jour<1||jour>31||mois<1||mois>12||annee<=2021){
            throw new DateInvalide(this);
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
            throw new DateInvalide(this);
        }
        this.jour=jour;
    }

    private void setMois(int mois){
        if(mois<1||mois>12){
            throw new DateInvalide(this);
        }
        this.mois=mois;
    }

    private void setAnnee(int annee){
        if(annee<=2021){
            throw new DateInvalide(this);
        }
        this.annee=annee;
    }

    public String toString(){
        return this.jour+"."+this.mois+"."+this.annee;
    }
}
