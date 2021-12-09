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
        if (type==2){
            this.listDcoupe=Etape3(listC, listF);
        }
    }

    public static void print_list(ArrayList<Generable> listClient){
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        for (int j=0;j<listClient.size();j++) {
            b =(ArrayList<Bois>) ((Client)listClient.get(j)).bois;
            System.out.println("Client "+j);
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i).dimensions.longueur + " ");
            }
            System.out.println(" ");
            for (int i = 0; i < b.size(); i++) {
                System.out.print(b.get(i).dimensions.largeur + " ");
            }
            System.out.println(" ");
        }
    }

    ArrayList<Generable> remove_fournisseur_zeros (ArrayList<Generable> listFournisseur) {
        Fournisseur c=(Fournisseur)listFournisseur.get(0);
        ArrayList<Bois> b=c.bois;
        ArrayList<Prix> p=c.prix;
        ArrayList<Date> d=c.date;
        for (int i = 0; i < listFournisseur.size(); i++) {
            b = (ArrayList<Bois>) ((Fournisseur) listFournisseur.get(i)).bois;
            p=(ArrayList<Prix>)((Fournisseur) listFournisseur.get(i)).prix;
            d=(ArrayList<Date>)((Fournisseur) listFournisseur.get(i)).date;
            int k = 0;
            while (k < p.size()) {
                if (p.get(k).prix == 0 ) {
                    ((Fournisseur) listFournisseur.get(i)).bois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).prix.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).nombreBois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            k=0;
            while (k < p.size()) {
                if (d.get(k).jour == 0 ) {
                    ((Fournisseur) listFournisseur.get(i)).bois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).prix.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).nombreBois.remove(k);
                    ((Fournisseur) listFournisseur.get(i)).date.remove(k);
                    k--;
                }
                k++;
            }
            k=0;
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
                if (b.get(k).dimensions.longueur <= 0) {
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
        System.out.println(((Fournisseur)listF.get(1)).date.get(0).annee);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        ArrayList<Bois> b = ((Client)listC.get(0)).bois;
        Bois bois;
        int index=-1;
        int finito=0;
        int x=0;
        int action=0;
        while (x!=listC.size()+1 && finito ==0)
        {
            index=0;
            test:
            for (Generable g:listF){
                bois=b.get(0);
                Fournisseur f = (Fournisseur) g;
                if (f.bois.size()==0){
                    listF.remove(index);
                    break;
                }
                System.out.println("il y a "+f.bois.size());
                for (int k=0;k<f.bois.size();k++){
                    Bois b1 = (Bois) f.bois.get(k);
                    for (int i=0;i<((Client) listC.get(0)).nombreBois.get(0).nombre;i++) {
                        if (b1.dimensions.longueur >= bois.dimensions.longueur && b1.dimensions.largeur >= bois.dimensions.largeur) {
                            action =1;
                            Dcoupe Decoupe2Do = new Dcoupe(f.id, b1.id, b1.dimensions.longueur, b1.dimensions.largeur, ((Client) listC.get(0)).id, bois.id, bois.dimensions.largeur, bois.dimensions.longueur, 0, 0);
                            listDcoupe.add(Decoupe2Do);
                            if (f.nombreBois.get(k).nombre > 1){
                                f.nombreBois.get(k).nombre--;
                            }
                            else{
                                f.nombreBois.remove(k);
                                f.bois.remove(k);
                            }
                            /*if (b.size()>=1){
                                b.remove(0);
                                ((Client)listC.get(0)).nombreBois.remove(0);
                                System.out.println("taille b " +b.size());
                            }*/
                            /*if (b.size()==0){
                                listC.remove((0));
                                System.out.println("ca remove ");
                                if (listC.size()>=1){
                                    System.out.println("nouvo mec");
                                    b = ((Client) listC.get(0)).bois;
                                    break;
                                }
                            }*/
                        }
                    }
                    if (action==1){
                        b.remove(0);
                        action=0;
                    }
                }
                index++;
            }
            x++;
        }
         Dcoupe c=(Dcoupe) listDcoupe.get(0);
         for (int j=0;j<listDcoupe.size();j++) {
             System.out.println("planche id " +listDcoupe.get(j).idPlanche+ " longueur planche "+listDcoupe.get(j).heightPlanche+" largeur "+listDcoupe.get(j).widthPlanche + " id panneau "+listDcoupe.get(j).idPanneau+" longueur panneau "+listDcoupe.get(j).heightPanneau+" largeur panneau "+listDcoupe.get(j).widthPanneau);
         }
        System.out.println(listDcoupe.size());
        return listDcoupe;
    }


    public ArrayList<Dcoupe> Etape3 (ArrayList <Generable> listClient, ArrayList<Generable> listF){
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        //On retire toutes les valeurs en 0 dues à une mauvaise écriture dans le fichier clients.xml
        System.out.println("-----------------------------------------------");
        print_list(listClient);
        listClient = remove_client_zeros(listClient);
        listF = remove_fournisseur_zeros(listF);
        ArrayList<Dcoupe> listDcoupe = new ArrayList<>();
        System.out.println("-----------------------------------------------");
        System.out.println("après retirer 0");
        print_list(listClient);
        System.out.println("-----------------------------------------------");
        //On trie la liste des bois en fonction de la longueur puis la largeur
        for (int i=0;i<listClient.size();i++){
            b =(ArrayList<Bois>) ((Client)listClient.get(i)).bois;
            for (int k=0;k<b.size();k++) {
                int cle=b.get(k).dimensions.longueur;
                int cle2=b.get(k).dimensions.largeur;
                Bois key=b.get(k);
                int j=k;
                while(j>0 && ((b.get(j-1).dimensions.longueur>cle) || ( b.get(j-1).dimensions.longueur==cle && b.get(j-1).dimensions.largeur>cle2))){
                    b.set(j,b.get(j-1));
                    j=j-1;
                }
                b.set(j,key);
            }
            ((Client) listClient.get(i)).bois=b;
        }
        print_list(listClient);
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