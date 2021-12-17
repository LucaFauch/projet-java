package commande;


import java.util.ArrayList;

import ui.XmlWrite;

import static ui.XmlRead.readXml;

/** Classe Decoupe permettant de lancer le programme et de créer un objet de type Dcoupe
 * @see Dcoupe
 * */
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

        int type = 4;
        Algo test = new Algo(type,listClient,listFournisseur,listDecoupe);
        if (type >1) {
            XmlWrite.writeXML(".",test.listDcoupe);
            XmlWrite.writeSVG(".",test.listDcoupe);
        }
    }

}