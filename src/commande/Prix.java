package commande;

class Prix implements Validable,Generable{
    float prix;

    public int isValid(){
        if(this.prix<0){
            return 0;
        }else{
            return 1;
        }
    }

    Prix(float prix){
        this.prix=prix;
    }

}
