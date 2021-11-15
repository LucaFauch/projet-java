package commande;
import commande.exceptions.NbBoisInvalide;

class NbBois {
    int nombre;

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