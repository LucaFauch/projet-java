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
            throw new InvalideNbBois(this);
        this.nombre = nombre;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        if (nombre <= 0) {
            throw new InvalideNbBois(this);
        }
        this.nombre = nombre;
    }
}