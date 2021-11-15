package commande;
import commande.exceptions.NbBoisInvalide;

class NbBois implements Validable{
    int nombre;

    public int isValid(){
        if(nombre<=0){
            return 0;
        }else{
            return 1;
        }
    }

    private NbBois(int nombre) {
        if (nombre <= 0)
            throw new NbBoisInvalide(this);
        this.nombre = nombre;
    }

    public int getNombre() {
        return nombre;
    }

    public setNombre(int nombre) {
        if (nombre <= 0) {
            throw new NbBoisInvalide(this);
        }
        this.nombre = nombre;
    }
}