package commande;

public class Algo {
    int benef;
    Client client;
    Fournisseur fournisseur;
    Panneau panneau;

    Algo(int benef, Client client, Fournisseur fournisseur, Panneau panneau){
        this.benef=benef;
        this.client=client;
        this.fournisseur=fournisseur;
        this.panneau=panneau;
    }

    int getBenef(){
        return this.benef;
    }

    Client getClient(){
        return this.client;
    }

    Fournisseur getFournisseur(){
        return this.fournisseur;
    }

    Panneau getPanneau(){
        return this.panneau;
    }

    void setBenef(int benef){
        this.benef=benef;
    }

    void setClient(Client client){
        this.client=client;
    }

    void setFournisseur(Fournisseur fournisseur){
        this.fournisseur=fournisseur;
    }

    void setPanneau(Panneau panneau){
        this.panneau=panneau;
    }
}
