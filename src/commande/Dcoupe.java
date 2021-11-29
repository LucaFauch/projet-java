package commande;

import java.util.ArrayList;

class Dcoupe implements Generable{
    private int idFournisseur;
    private int idPanneau;
    private int idClient;
    private int idPlanche;
    private int x;
    private int y;

    Dcoupe (int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        this.idClient=idClient;
        this.idPanneau=idPanneau;
        this.idPlanche=idPlanche;
        this.idFournisseur=idFournisseur;
        this.x=x;
        this.y=y;
    }
}
