package commande;

/** Classe Prix, correspondant au prix de chaque Bois */
class Prix implements Validable,Generable{
    float prix;

    /** Vérification d'erreur de la classe Prix
     * @see InvalidePrix
     * */
    public int isValid(){
        if(this.prix<0){
            return 0;
        }else{
            return 1;
        }
    }

    Prix(float prix){
        try {
            if (prix <=0)
                throw new IllegalArgumentException("Le prix suivant doit être strictement positif : "+prix);
            else
                this.prix=prix;
        }
        catch(IllegalArgumentException e) {
            System.out.println("Le prix suivant doit être strictement positif : "+prix);
        }
    }

}
