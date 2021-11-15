package commande;

public class Date implements Validable{
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

    private Date(int jour, int mois, int annee) throws InvalideDate{
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }

    public String toString(){
        return this.jour+"."+this.mois+"."+this.annee;
    }
}
