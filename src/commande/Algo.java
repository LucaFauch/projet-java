package commande;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Algo{
    ArrayList<Dcoupe> listDcoupe;

    Algo(int type,ArrayList <Generable> listC, ArrayList<Generable> listF){
        if (type==1){
            this.listDcoupe=Etape2( listC, listF);
        }
    }
    ArrayList<Generable> remove_fournisseur_zeros (ArrayList<Generable> listFournisseur) {
        Fournisseur c=(Fournisseur)listFournisseur.get(0);
        ArrayList<Bois> b=c.bois;
        for (int i = 0; i < listFournisseur.size(); i++) {
            b = (ArrayList<Bois>) ((Fournisseur) listFournisseur.get(i)).bois;
            int k = 0;
            while (k < b.size()) {
                if (b.get(k).dimensions.longueur == 0 ) {
                    b.remove(k);
                    k--;
                }
                k++;
            }
            ((Fournisseur) listFournisseur.get(i)).bois = b;
        }
        return listFournisseur;
    }

    ArrayList<Generable> remove_client_zeros (ArrayList<Generable> listClient) {
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        for (int i = 0; i < listClient.size(); i++) {
            b = (ArrayList<Bois>) ((Client) listClient.get(i)).bois;
            int k = 0;
            while (k < b.size()) {
                if (b.get(k).dimensions.longueur == 0 || b.get(k) == null) {
                    b.remove(k);
                    k--;
                }
                k++;
            }
            ((Client) listClient.get(i)).bois = b;
        }
        return listClient;
    }

     public ArrayList<Dcoupe> Etape2 (ArrayList <Generable> listC, ArrayList<Generable> listF){
        listC = remove_client_zeros(listC);
        listF = remove_fournisseur_zeros(listF);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        for (int i = 0; i < listC.size(); i++){
            for (int l = 0;l<((Client)listC.get(i)).bois.size();l++) {
                outerloop:
                for (int j = 0; j < listF.size(); j++) {
                    for (int k = 0; k < ((Fournisseur)listF.get(j)).bois.size(); k++) {
                        if (((Fournisseur)listF.get(j)).bois.get(k).dimensions.longueur >= ((Client)listC.get(i)).bois.get(l).dimensions.longueur && ((Fournisseur)listF.get(j)).bois.get(k).dimensions.largeur >= ((Client)listC.get(i)).bois.get(l).dimensions.largeur){
                            if (((Fournisseur)listF.get(j)).nombreBois.get(k).nombre >= ((Client)listC.get(i)).nombreBois.get(l).nombre){
                                Dcoupe Decoupe2Do = new Dcoupe(((Fournisseur)listF.get(j)).id,((Fournisseur)listF.get(j)).bois.get(k).id,((Fournisseur)listF.get(j)).bois.get(k).dimensions.longueur,((Fournisseur)listF.get(j)).bois.get(k).dimensions.largeur,((Client)listC.get(i)).id,((Client)listC.get(i)).bois.get(l).id,((Client)listC.get(i)).bois.get(l).dimensions.longueur,((Client)listC.get(i)).bois.get(l).dimensions.largeur,0,0);
                                listDcoupe.add(Decoupe2Do);
                            }
                        }
                    }
                }
            }
        }
        return listDcoupe;
    }
    /*public optimise(List <Client> listC, List<Fournisseur> listF){
        for (Client value : listC) {
            //Ordonner selon la Longueur puis la largeur
            // https://www.codejava.net/java-core/collections/sorting-arrays-examples-with-comparable-and-comparator
        }

        int i = 0;
        int k = 0;
        int j = 0;
        for (Client value : listC) {
            int coordL=0;

            while(coordL<=listF.get(i).bois.get(k).dimensions.longueur){


                coordL=coordL+value.bois(j).dimensions.longueur;
            }
        }



        return listD;
    }*/


    /*public ArrayList<Integer> AlgoEtapeUne(ArrayList<Client> listClient, ArrayList<Fournisseur> listFournisseur){

    }*/
}