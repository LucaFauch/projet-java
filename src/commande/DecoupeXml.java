package commande;

import java.util.ArrayList;


/** Classe DecoupeXml utilisée pour écrire un fichier decoupes.xml
 */
public class DecoupeXml implements Generable{
    public int idFournisseur;
    public int idPanneau;
    public int idClient;
    public int idPlanche;
    public int x;
    public int y;


    /** Constructeur de la classe Decoupe Xml
     *
     * @param idFournisseur
     * @param idPanneau
     * @param idClient
     * @param idPlanche
     * @param x
     * @param y
     */
    DecoupeXml (int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        this.idClient=idClient;
        this.idPanneau=idPanneau;
        this.idPlanche=idPlanche;
        this.idFournisseur=idFournisseur;
        this.x=x;
        this.y=y;
    }
}