package commande;


import static ui.XmlRead.readXml;

class Decoupe {

    public static void main(String[] args) {
        String filename = args[0];
        Factory f=new Factory();
        readXml(filename,f);
        readXml(args[1],f);
        readXml(args[2],f);
    }

}