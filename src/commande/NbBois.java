package commande;

public class NbBois {
    private int nombre;

    public NbBois(int nombre) {
        if (nombre <= 0)
            throw new IllegalArgumentException("Le nombre de bois doit être strictement positif");
        this.nombre=nombre;
    }

    public int getNombre() {
        return nombre;
    }
}
