package commande;

import java.util.ArrayList;

public class Dcoupe implements Generable{
    public int idFournisseur;
    public int idPanneau;
    public int widthPanneau;
    public int heightPanneau;
    public int idClient;
    public int idPlanche;
    public int widthPlanche;
    public int heightPlanche;
    public int x;
    public int y;

    Dcoupe (int idFournisseur,int idPanneau,int widthPanneau,int heightPanneau,int idClient,int idPlanche,int widthPlanche,int heightPlanche,int x,int y){
        this.idClient=idClient;
        this.idPanneau=idPanneau;
        this.idPlanche=idPlanche;
        this.widthPanneau=widthPanneau;
        this.heightPanneau=heightPanneau;
        this.widthPlanche=widthPlanche;
        this.heightPlanche=heightPlanche;
        this.idFournisseur=idFournisseur;
        this.x=x;
        this.y=y;
    }
}