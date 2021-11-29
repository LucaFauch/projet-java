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

    public Bois initializeBois(Generable dimensions,int id){
        return new Bois((Dimensions)dimensions,id);
    }

    public NbBois initializeNbBois(int nombre){
        return new NbBois(nombre);
    }

    public Dimensions initializeDimensions(int longueur, int largeur){
        return new Dimensions(longueur, largeur);
    }

    public Fournisseur initializeFournisseur(int id, Generable prix, ArrayList<Generable> bois, Generable nombreBois, Generable date){
        ArrayList<Bois> listBois=new ArrayList<>();
        for (int i=0;i<bois.size();i++){
            listBois.add((Bois)bois.get(i));
        }
        return new Fournisseur(id,(Prix)prix,listBois,(NbBois)nombreBois,(Date)date);
    }

    public Client initializeClient(int id, Generable prix, ArrayList<Generable> bois, Generable nombreBois, Generable date){
        ArrayList<Bois> listBois=new ArrayList<>();
        for (int i=0;i<bois.size();i++){
            listBois.add((Bois)bois.get(i));
        }
        return new Client(id,(Prix)prix,listBois,(NbBois)nombreBois,(Date)date);
    }
    public Dcoupe initializeDcoupe(int idFournisseur,int idPanneau,int idClient,int idPlanche,int x,int y){
        return new Dcoupe(idFournisseur,idPanneau,idClient,idPlanche,x,y);
    }
    public Factory (){

    }

}