package commande;

class Fournisseur extends Personne{
    private Fournisseur(int id, Prix prix, Bois bois, NbBois nbBois, Date date){
        super(id, prix, bois, nbBois, date);
    }
}
