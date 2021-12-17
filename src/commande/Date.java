package commande;

/** Classe Date, correspondant à la date limite des commandes
 *
 */
class Date implements Validable,Generable{
    int jour;
    int mois;
    int annee;


    /** Vérification d'erreur  sur la date
     * @see InvalideDate
     * */
    public int isValid(){
        if(this.jour<1||this.jour>31||this.mois<1||this.mois>12||this.annee<=2021){
            return 0;
        }else{
            return 1;
        }
    }


    /** Constructeur de la classe Date
     * @param jour
     * @param mois
     * @param annee
     *
     * @throws InvalideDate : si jamais la date n'est pas correcte
     * */

    protected Date(int jour, int mois, int annee) throws InvalideDate{
        try {
            if (jour<1||jour>31||mois<1||mois>12||annee<=21)
                throw new IllegalArgumentException("La date suivante n'existe pas ou est dans le passé : "+jour+"/"+mois+"/"+annee);
            else {
                this.jour=jour;
                this.mois=mois;
                this.annee=annee;
            }
        }
        catch(IllegalArgumentException e) {
            System.out.println("La date suivante n'existe pas ou est dans le passé : "+jour+"/"+mois+"/"+annee);
        }
    }


    /** Transforme un objet de classe date en String
     *  @return : renvoie la date sous forme de string
     */
    public String toString(){
        return this.jour+"."+this.mois+"."+this.annee;
    }
}
