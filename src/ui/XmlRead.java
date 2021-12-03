package ui;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import commande.Factory;
import commande.Generable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlRead
{
    public static ArrayList<Generable> readXml(String filename,Factory f)
    {
        ArrayList<Generable> list = new ArrayList<>();
        try
        {
            FileInputStream file = new FileInputStream(filename);
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(file);

            while(reader.hasNext())
            {
                if(reader.next() == XMLStreamConstants.START_ELEMENT)
                {
                    if(reader.getName().toString() == "client")
                    {
                        System.out.println("nouveau client");
                        list = readClient(reader,f);
                        break;
                    }
                    if (reader.getName().toString() == "fournisseur"){
                        System.out.println("nouveau fournisseur");
                         list = readFournisseur(reader,f);
                        break;
                    }
                    if (reader.getName().toString() == "decoupe"){
                        System.out.println("Nouvelle découpe");
                        list = readDecoupe(reader,f);
                        break;
                    }
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (XMLStreamException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    static ArrayList<Generable> readClient(XMLStreamReader reader, Factory f) throws XMLStreamException
    {
        ArrayList<Generable> listClient = new ArrayList<>();
        ArrayList<Generable> listPlanche = new ArrayList<>();
        ArrayList<Generable> listPrix = new ArrayList<>();
        ArrayList<Generable> listDate = new ArrayList<>();
        ArrayList<Generable> listNbBois = new ArrayList<>();
        int idClient = Integer.parseInt(reader.getAttributeValue(0));
        int L=0;
        int l=0;
        int idPlanche=0;
        int nombre=0;
        int jour=0;
        int mois=0;
        int annee=0;
        float prix=0;
        int nbClient=1;
        Generable dateGen=null;
        Generable prixGen=null;
        Generable nbBoisGen=null;
        Generable boisGen=null;
        Generable dimGen=null;
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "client"){
                    System.out.println("nouveau client");
                    listClient.add(f.initializeClient(idClient,listPrix,listPlanche,listNbBois,listDate));
                    listPlanche.clear();
                    listDate.clear();
                    listPrix.clear();
                    listNbBois.clear();
                    idClient = Integer.parseInt(reader.getAttributeValue(0));
                }
                if(reader.getName().toString() == "planche")
                {
                    try {
                        nombre++;
                        System.out.println("nouvelle planche");
                        idPlanche = Integer.parseInt(reader.getAttributeValue(0));
                        nombre = Integer.parseInt(reader.getAttributeValue(1));
                        String dates = (reader.getAttributeValue(2));
                        String[] allDates = dates.split("\\.");
                        jour = Integer.parseInt(allDates[0]);
                        mois = Integer.parseInt(allDates[1]);
                        annee = Integer.parseInt(allDates[2]);
                        dateGen = f.initializeDate(jour, mois, annee);
                        listDate.add(dateGen);
                        prix=Float.parseFloat(reader.getAttributeValue(3));
                        prixGen = f.initializePrix(prix);
                        listPrix.add(prixGen);
                        nbBoisGen = f.initializeNbBois(nombre);
                        listNbBois.add(nbBoisGen);
                    }
                    catch (NumberFormatException e){
                        listNbBois.add(null);
                        listPrix.add(null);
                        listDate.add(null);
                        System.out.println("Mauvais Type dans les arguments de planche");
                        dateGen=null;
                        prixGen=null;
                        nbBoisGen=null;
                        boisGen=null;
                        dimGen=null;
                    }
                }
                if (reader.getName().toString() == "dim") {
                    try {
                        String LString = (reader.getAttributeValue(0));
                        String lString = (reader.getAttributeValue(1));
                        String[] LDim = LString.split("\\.");
                        String[] lDim = lString.split("\\.");
                        L = Integer.parseInt(LDim[0]);
                        l = Integer.parseInt(lDim[0]);
                        dimGen = f.initializeDimensions(L,l);
                        listPlanche.add(f.initializePlanche(dimGen,idPlanche));
                        //boisGen=f.initializeBois(dimGen,idPlanche);

                    }
                    catch (NumberFormatException e){
                        listPlanche.add(null);
                        System.out.println("Mauvais Type dans les arguments de dim");
                    }
                }
            }
        }
        listClient.add(f.initializeClient(idClient,listPrix,listPlanche,listNbBois,listDate));
        return listClient;
    }

    static ArrayList<Generable> readFournisseur(XMLStreamReader reader, Factory f) throws XMLStreamException
    {
        ArrayList<Generable> listFournisseur = new ArrayList<>();
        ArrayList<Generable> listPanneau = new ArrayList<>();
        ArrayList<Generable> listPrix = new ArrayList<>();
        ArrayList<Generable> listDate = new ArrayList<>();
        ArrayList<Generable> listNbBois = new ArrayList<>();
        int idFournisseur = Integer.parseInt(reader.getAttributeValue(0));
        int L=0;
        int l=0;
        int idPanneau=0;
        int nombre=0;
        int jour=0;
        int mois=0;
        int annee=0;
        float prix=0;
        Generable dateGen=null;
        Generable prixGen=null;
        Generable nbBoisGen=null;
        Generable boisGen=null;
        Generable dimGen=null;
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "fournisseur"){
                    System.out.println("nouveau fournisseur");
                    listFournisseur.add(f.initializeFournisseur(idFournisseur,listPrix,listPanneau,listNbBois,listDate));
                    listPanneau.clear();
                    listDate.clear();
                    listPrix.clear();
                    listNbBois.clear();
                    idFournisseur = Integer.parseInt(reader.getAttributeValue(0));
                }
                if(reader.getName().toString() == "panneau")
                {
                    try {
                        nombre++;
                        System.out.println("nouveau panneau");
                        idPanneau = Integer.parseInt(reader.getAttributeValue(0));
                        nombre = Integer.parseInt(reader.getAttributeValue(1));
                        String dates = (reader.getAttributeValue(2));
                        String[] allDates = dates.split("\\.");
                        jour = Integer.parseInt(allDates[0]);
                        mois = Integer.parseInt(allDates[1]);
                        annee = Integer.parseInt(allDates[2]);
                        dateGen = f.initializeDate(jour, mois, annee);
                        listDate.add(dateGen);
                        prix=Float.parseFloat(reader.getAttributeValue(3));
                        prixGen = f.initializePrix(prix);
                        listPrix.add(prixGen);
                        nbBoisGen = f.initializeNbBois(nombre);
                        listNbBois.add(nbBoisGen);
                    }
                    catch (NumberFormatException e){
                        listNbBois.add(null);
                        listPrix.add(null);
                        listDate.add(null);
                        System.out.println("Mauvais Type dans les arguments de panneau");
                        dateGen=null;
                        prixGen=null;
                        nbBoisGen=null;
                        boisGen=null;
                        dimGen=null;
                    }
                }
                if (reader.getName().toString() == "dim") {
                    try {
                        String LString = (reader.getAttributeValue(0));
                        String lString = (reader.getAttributeValue(1));
                        String[] LDim = LString.split("\\.");
                        String[] lDim = lString.split("\\.");
                        L = Integer.parseInt(LDim[0]);
                        l = Integer.parseInt(lDim[0]);
                        dimGen = f.initializeDimensions(L,l);
                        listPanneau.add(f.initializePanneau(dimGen,idPanneau));

                    }
                    catch (NumberFormatException e){
                        listPanneau.add(null);
                        System.out.println("Mauvais Type dans les arguments de dim");
                    }
                }
            }
        }
        listFournisseur.add(f.initializeClient(idFournisseur,listPrix,listPanneau,listNbBois,listDate));
        return listFournisseur;
    }

    static ArrayList<Generable> readDecoupe(XMLStreamReader reader, Factory f) throws XMLStreamException{
        ArrayList<Generable> list = new ArrayList<>();
        int idFournisseur =0;
        int idClient =0;
        int x=0;
        int y=0;
        int idPlanche=0;
        int idPanneau=0;
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "fournisseur"){
                    try {
                        idFournisseur=Integer.parseInt(reader.getAttributeValue(0));
                        String StringIdPanneau = (reader.getAttributeValue(1));
                        String[] idPannneaux = StringIdPanneau.split("\\.");
                        idPanneau = Integer.parseInt(idPannneaux[0]);
                        int l = Integer.parseInt(idPannneaux[1]);

                    }
                    catch (NumberFormatException e){
                        System.out.println("Mauvais Type dans les arguments de fournisseur");
                    }
                }
                if(reader.getName().toString() == "client")
                {
                    try {
                        idClient=Integer.parseInt(reader.getAttributeValue(0));
                        String StringIdPanneau = (reader.getAttributeValue(1));
                        String[] idPlanches = StringIdPanneau.split("\\.");
                        idPlanche = Integer.parseInt(idPlanches[0]);
                        int l = Integer.parseInt(idPlanches[1]);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Mauvais Type dans les arguments de client");
                    }
                }
                if (reader.getName().toString() == "position") {
                    try {
                        x=Math.round(Float.parseFloat(reader.getAttributeValue(0)));
                        y=Math.round(Float.parseFloat(reader.getAttributeValue(1)));
                    }
                    catch (NumberFormatException e){
                        System.out.println("Mauvais Type dans les arguments de position");
                    }
                }

            }
        }
        list.add(f.initializeDcoupe(idFournisseur,idPanneau,idClient,idPlanche,x,y));
        return list;
    }
}
