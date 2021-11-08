package commande;
import commande.exceptions.DateInvalide;

public class Date {
    int jour;
    int mois;
    int annee;

    Date(int jour, int mois, int annee) throws DateInvalide{
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
        if(jour<1||jour>31||mois<1||mois>12||annee<2021){
            throw new DateInvalide(this);
        }
    }

    public int getJour(){
        return this.jour;
    }

    public int getMois(){
        return this.mois;
    }

    public int getAnnee(){
        return this.annee;
    }

    void setJour(int jour){
        this.jour=jour;
        if(jour<1||jour>31){
            throw new DateInvalide(this);
        }
    }

    void setMois(int mois){
        this.mois=mois;
        if(mois<1||mois>12){
            throw new DateInvalide(this);
        }
    }

    void setAnnee(int annee){
        this.annee=annee;
        if(annee<2021){
            throw new DateInvalide(this);
        }
    }
}
