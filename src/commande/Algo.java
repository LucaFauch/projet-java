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

    private int getBenef(){
        return this.benef;
    }

    private Client getClient(){
        return this.client;
    }

    private Fournisseur getFournisseur(){
        return this.fournisseur;
    }

    private Panneau getPanneau(){
        return this.panneau;
    }

    private void setBenef(int benef){
        this.benef=benef;
    }

    private void setClient(Client client){
        this.client=client;
    }

    private void setFournisseur(Fournisseur fournisseur){
        this.fournisseur=fournisseur;
    }

    private void setPanneau(Panneau panneau){
        this.panneau=panneau;
    }
}
