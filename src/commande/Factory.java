package commande;

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

    public Fournisseur initializeFournisseur(int id, Generable prix, Generable bois, Generable nombreBois, Generable date){
        return new Fournisseur(id,(Prix)prix,(Bois)bois,(NbBois)nombreBois,(Date)date);
    }

    public Client initializeClient(int id, Generable prix, Generable bois, Generable nombreBois, Generable date){
        return new Client(id,(Prix)prix,(Bois)bois,(NbBois)nombreBois,(Date)date);
    }
    public Factory (){

    }

}