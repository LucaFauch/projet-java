package commande;

class NbBois {
    int nombre;

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