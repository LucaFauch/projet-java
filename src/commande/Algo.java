package commande;

import ui.Reader;

class Algo{
    int benef;
    Client client;
    //Fournisseur fournisseur;
    Panneau panneau;

    private Algo(int benef, Client client, Panneau panneau){
        this.benef=benef;
        this.client=client;
        //this.fournisseur=fournisseur;
        this.panneau=panneau;
    }
    /*void initializeProblem(String client,String fournisseur){
        Client c=readXml("client.xml");
        System.out.println(c);
    }*/
}
