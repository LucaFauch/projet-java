package commande;

import java.util.ArrayList;

public class DecoupeXml implements Generable{
    public int idFournisseur;
    public int idPanneau;
    public int idClient;
    public int idPlanche;
    public int x;
    public int y;

    DecoupeXml (int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        this.idClient=idClient;
        this.idPanneau=idPanneau;
        this.idPlanche=idPlanche;
        this.idFournisseur=idFournisseur;
        this.x=x;
        this.y=y;
    }
}