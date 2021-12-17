package commande;

/** Classe NbBois, qui correspond au nombre de bois de la classe Bois */
class NbBois implements Validable,Generable{
    int nombre;

    /** Vérification d'erreur de la classe NbBois
     * @see InvalideNbBois
     * */
    public int isValid(){
        if(nombre<=0){
            return 0;
        }else{
            return 1;
        }
    }


    /** Constructeur de la classe NbBois*/
    NbBois(int nombre) {
        this.nombre = nombre;
    }
}