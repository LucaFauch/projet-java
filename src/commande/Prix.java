package commande;

class Prix implements Validable{
    int prix;

    public int isValid(){
        if(this.prix<0){
            return 0;
        }else{
            return 1;
        }
    }

    Prix(int prix){
        this.prix=prix;
    }

}
