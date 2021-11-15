package commande;

class Prix implements Validable{
    int prix;

    public int isValid(){
        if(this.prix<0){
            return -1;
        }else{
            return 1;
        }
    }

    Prix(int prix){
        setPrix(prix);
    }

    int getPrix(){
        return this.prix;
    }

    private void setPrix(int prix) throws PrixInvalide {
        if(prix<0)
            throw new PrixInvalide(prix);
        this.prix=prix;
    }
}
