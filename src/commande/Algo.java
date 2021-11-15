package commande;

class Algo {
    int benef;
    Client client;
    Fournisseur fournisseur;
    Panneau panneau;

    private Algo(int benef, Client client, Fournisseur fournisseur, Panneau panneau){
        this.benef=benef;
        this.client=client;
        this.fournisseur=fournisseur;
        this.panneau=panneau;
    }
}
