package commande;

class NbBois implements Validable{
    int nombre;

    public int isValid(){
        if(nombre<=0){
            return 0;
        }else{
            return 1;
        }
    }

    NbBois(int nombre) {
        if (nombre <= 0)
            throw new NbBoisInvalide(this);
        this.nombre = nombre;
    }

    int getNombre() {
        return nombre;
    }

    private void setNombre(int nombre) {
        if (nombre <= 0) {
            throw new NbBoisInvalide(this);
        }
        this.nombre = nombre;
    }
}