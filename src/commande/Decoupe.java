package commande;


import java.util.ArrayList;

import static ui.XmlRead.readXml;

class Decoupe {

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
    public static void main(String[] args) {
        String filename = args[0];
        Factory f=new Factory();
        ArrayList<Generable> listClient = new ArrayList<>();
        ArrayList<Generable> listFournisseur = new ArrayList<>();
        ArrayList<Generable> listDecoupe = new ArrayList<>();
        listClient = readXml(filename,f);
        listFournisseur = readXml(args[1],f);
        //listDecoupe = readXml(args[2],f);

        Algo test = new Algo(1,listClient,listFournisseur);
        Client c=(Client)listClient.get(0);
        ArrayList<Bois> b=c.bois;
        //On retire toutes les valeurs en 0 dues à une mauvaise écriture dans le fichier clients.xml
        //PROBLEME UNE DES VALEURS NE DOIT PAS VALOIR 0 ET DONC N'EST PAS ENLEVEE
        /*for (int i=0;i<listClient.size();i++) {
            b =(ArrayList<Bois>) ((Client)listClient.get(i)).bois;
            int k=0;
            while(k<b.size()){
                if (b.get(k).dimensions.longueur==0 || b.get(k).dimensions==null) {
                    b.remove(k);
                    k--;
                }
                k++;
            }
            ((Client) listClient.get(i)).bois=b;
        }

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
                    System.out.println(b.get(j-1).dimensions.longueur);
                    b.set(j,b.get(j-1));
                    j=j-1;
                    print_list(listClient);
                }
                b.set(j,key);
                print_list(listClient);
            }
            ((Client) listClient.get(i)).bois=b;
        }

        System.out.println("-----------------------------------------------");
        print_list(listClient);
*/
    //CHANGER LA LISTE CLIENT ET FOURNISSEUR DE XML READ
    }

}