package commande;
import commande.exceptions.NbBoisInvalide;

public class NbBois {
    int nombre;

    public NbBois(int nombre) {
        if (nombre <= 0)
            throw new NbBoisInvalide(this);
        this.nombre=nombre;
    }

    public int getNombre() {
        return nombre;
    }

    void setNombre(int nombre){
        this.nombre=nombre;
        if(nombre<=0){
            throw new NbBoisInvalide(this);
        }
    }
}