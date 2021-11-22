package commande;


import static ui.XmlRead.readXml;

class Decoupe {

    public static void main(String[] args) {
        String filename = args[0];
        readXml(filename);
    }

}