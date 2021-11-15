package commande;
import commande.exceptions.DateInvalide;

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

    private Date(int jour, int mois, int annee) throws DateInvalide{
        if(jour<1||jour>31||mois<1||mois>12||annee<=2021){
            throw new DateInvalide(this);
        }
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }

    private int getJour(){
        return this.jour;
    }

    private int getMois(){
        return this.mois;
    }

    private int getAnnee(){
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
