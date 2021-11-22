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
    public static void readXml(String filename,Factory f)
    {
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
                        readClient(reader,f);

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
    }
    static ArrayList<Generable> readClient(XMLStreamReader reader, Factory f) throws XMLStreamException
    {
        ArrayList<Generable> list = new ArrayList<>();
        int idClient = Integer.parseInt(reader.getAttributeValue(0));
        int L=0;
        int l=0;
        int idPlanche=0;
        int nombre=1;
        int jour=0;
        int mois=0;
        int annee=0;
        float prix=0;
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "planche")
                {
                    try {
                        System.out.println("nouvelle planche");
                        idPlanche = Integer.parseInt(reader.getAttributeValue(0));
                        nombre = Integer.parseInt(reader.getAttributeValue(1));
                        String dates = (reader.getAttributeValue(2));
                        String[] allDates = dates.split("\\.");
                        jour = Integer.parseInt(allDates[0]);
                        mois = Integer.parseInt(allDates[1]);
                        annee = Integer.parseInt(allDates[2]);
                        prix=Float.parseFloat(reader.getAttributeValue(3));
                        if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                            if (reader.getName().toString() == "dim") {
                                String LString = (reader.getAttributeValue(0));
                                String lString = (reader.getAttributeValue(1));
                                String[] LDim = LString.split("\\.");
                                String[] lDim = lString.split("\\.");
                                L = Integer.parseInt(LDim[0]);
                                l = Integer.parseInt(lDim[0]);
                            }

                        }
                    }
                    catch (InvalideXmlRead e){
                        System.out.println("Mauvais Type");
                        prix=10.0;
                    }
                }
                
            }
        }
        list.add(f.initializeDimensions(L,l));
        list.add(f.initializeDate(jour, mois, annee));
        list.add(f.initializePlanche(list.get(0),idPlanche));
        list.add(f.initializePrix(prix));
        list.add(f.initializeBois(list.get(0),idPlanche));
        list.add(f.initializeNbBois(nombre));
        list.add(f.initializeClient(idClient,list.get(3),list.get(4),list.get(5),list.get(1)));
        return list;
    }
}
