package commande;

import java.util.ArrayList;

/** Classe Dcoupe contenant toutes les informations relatives à la découpe de planche
 */
public class Dcoupe implements Generable{
    public int idFournisseur;
    public int idPanneau;
    public int largeurPanneau;
    public int longueurPanneau;
    public int idClient;
    public int idPlanche;
    public int largeurPlanche;
    public int longueurPlanche;
    public int x;
    public int y;


    /** Constructeur de la classe Dcoupe permettant de créer un objet Dcoupe, utilisé pour créer le fichier SVG
     * @param idFournisseur
     * @param idPanneau
     * @param largeurPanneau
     * @param longueurPanneau
     * @param idClient
     * @param idPlanche
     * @param largeurPlanche
     * @param longueurPlanche
     * @param x
     * @param y
     */
    Dcoupe (int idFournisseur,int idPanneau,int largeurPanneau,int longueurPanneau,int idClient,int idPlanche,int largeurPlanche,int longueurPlanche,int x,int y){
        this.idClient=idClient;
        this.idPanneau=idPanneau;
        this.idPlanche=idPlanche;
        this.largeurPanneau=largeurPanneau;
        this.longueurPanneau=longueurPanneau;
        this.largeurPlanche=largeurPlanche;
        this.longueurPlanche=longueurPlanche;
        this.idFournisseur=idFournisseur;
        this.x=x;
        this.y=y;
    }
}