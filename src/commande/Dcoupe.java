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
     * @param largeurPanneau : largeur du panneau appartenant au Fournisseur
     * @param longueurPanneau : longueur du panneau appartenant au Fournissueur
     * @param idClient
     * @param idPlanche
     * @param largeurPlanche : largeur de la planche appartenant au Client
     * @param longueurPlanche : longueur de la planche appartenant au Client
     * @param x : position de la planche par rapport au panneau sur l'axe des x
     * @param y  : position de la planche par rapport au panneau sur l'axe des y
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