package commande;

class Prix {
    int prix;

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
