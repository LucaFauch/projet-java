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
        try {
            if (prix <=0)
                throw new IllegalArgumentException("Un prix doit être strictement positif.");
            else
                this.prix=prix;
        }
        catch(IllegalArgumentException e) {
            System.out.println("Un prix doit être strictement positif.");
        }
    }

}
