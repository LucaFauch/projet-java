package commande;

import java.util.ArrayList;

public class Factory {

    public Date initializeDate(int jour, int mois, int annee){
        return new Date(jour,mois,annee);
    }

    public Prix initializePrix(float prix){
        return new Prix(prix);
    }

    public Planche initializePlanche(Generable dimensions,int id){
        return new Planche((Dimensions)dimensions,id);
    }

    public Panneau initializePanneau(Generable dimensions,int id){
        return new Panneau((Dimensions)dimensions,id);
    }

    public Bois initializeBois(Generable dimensions,int id){
        return new Bois((Dimensions)dimensions,id);
    }

    public NbBois initializeNbBois(int nombre){
        return new NbBois(nombre);
    }

    public Dimensions initializeDimensions(int longueur, int largeur){
        return new Dimensions(longueur, largeur);
    }

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
    public Dcoupe initializeDcoupe(int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        return new Dcoupe(idFournisseur,idPanneau,idClient,idPlanche,x,y);
    }
    public Factory (){

    }

}