package commande;


import java.util.ArrayList;

import static ui.XmlRead.readXml;

class Decoupe {


    public static void main(String[] args) {
        String filename = args[0];
        Factory f=new Factory();
        ArrayList<Generable> listClient = new ArrayList<>();
        ArrayList<Generable> listFournisseur = new ArrayList<>();
        ArrayList<Generable> listDecoupe = new ArrayList<>();
        listClient = readXml(filename,f);
        listFournisseur = readXml(args[1],f);
        listDecoupe = readXml(args[2],f);

        Algo test = new Algo(3,listClient,listFournisseur,listDecoupe);
        //CHANGER LA LISTE CLIENT ET FOURNISSEUR DE XML READ
    }

}