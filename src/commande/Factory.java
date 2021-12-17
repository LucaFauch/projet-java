package commande;

import java.util.ArrayList;

/** Classe Factory, comportant les méthodes qui permettent d'initialiser toutes les classes nécessaires à notre projet*/
public class Factory {


    /** Constructeur d'un objet de classe Date
     * @see Date
     * */

    public Date initializeDate(int jour, int mois, int annee){
        return new Date(jour,mois,annee);
    }

    /** Constructeur d'un objet de classe Prix
     * @see Prix
     * */

    public Prix initializePrix(float prix){
        return new Prix(prix);
    }

    /** Constructeur d'un objet de classe Planche
     * @see Planche
     * */

    public Planche initializePlanche(Generable dimensions,int id){
        return new Planche((Dimensions)dimensions,id);
    }

    /** Constructeur d'un objet de classe Panneau
     * @see Panneau
     * */

    public Panneau initializePanneau(Generable dimensions,int id){
        return new Panneau((Dimensions)dimensions,id);
    }

    /** Constructeur d'un objet de classe Bois
     * @see Bois
     * */

    public Bois initializeBois(Generable dimensions,int id){
        return new Bois((Dimensions)dimensions,id);
    }

    /** Constructeur d'un objet de classe NbBois
     * @see NbBois
     * */

    public NbBois initializeNbBois(int nombre){
        return new NbBois(nombre);
    }

    /** Constructeur d'un objet de classe Dimensions
     * @see Dimensions
     * */

    public Dimensions initializeDimensions(int longueur, int largeur){
        return new Dimensions(longueur, largeur);
    }

    /** Constructeur d'un objet de classe Fournisseur
     * @see Fournisseur
     * */

    public Fournisseur initializeFournisseur(int id, ArrayList<Generable> prix, ArrayList<Generable> bois, ArrayList<Generable> nombreBois, ArrayList<Generable> date){
        ArrayList<Bois> listBois=new ArrayList<>();
        ArrayList<Prix> listPrix = new ArrayList<>();
        ArrayList<NbBois> listNbBois = new ArrayList<>();
        ArrayList<Date> listDate = new ArrayList<>();
        for (int i=0;i<bois.size();i++){
            listBois.add((Bois)bois.get(i));
            listDate.add((Date)date.get(i));
            listNbBois.add((NbBois) nombreBois.get(i));
            listPrix.add((Prix) prix.get(i));
        }
        return new Fournisseur(id,listPrix,listBois,listNbBois,listDate);
    }

    /** Constructeur d'un objet de classe Client
     * @see Client
     * */

    public Client initializeClient(int id, ArrayList<Generable> prix, ArrayList<Generable> bois, ArrayList<Generable> nombreBois, ArrayList<Generable> date){
        ArrayList<Bois> listBois=new ArrayList<>();
        ArrayList<Prix> listPrix = new ArrayList<>();
        ArrayList<NbBois> listNbBois = new ArrayList<>();
        ArrayList<Date> listDate = new ArrayList<>();
        for (int i=0;i<bois.size();i++){
            listBois.add((Bois)bois.get(i));
            listDate.add((Date)date.get(i));
            listNbBois.add((NbBois) nombreBois.get(i));
            listPrix.add((Prix)prix.get(i));
        }
        return new Client(id,listPrix,listBois,listNbBois,listDate);
    }

    /** Constructeur d'un objet de classe Dcoupe
     * @see Dcoupe
     * */

    public DecoupeXml initializeDcoupe(int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        return new DecoupeXml(idFournisseur,idPanneau,idClient,idPlanche,x,y);
    }

    /** Constructeur associé à la classe Factory*/

    public Factory (){
    }

}