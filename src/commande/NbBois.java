package commande;

class NbBois implements Validable,Generable{
    int nombre;

    public int isValid(){
        if(nombre<=0){
            return 0;
        }else{
            return 1;
        }
    }

    NbBois(int nombre) {
        this.nombre = nombre;
    }
}