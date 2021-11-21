package commande;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XmlRead
{
    public static void readXml(String filename)
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
                        Client c = readClient(reader);

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
    static Client readClient(XMLStreamReader reader) throws XMLStreamException
    {
        int id = Integer.parseInt(reader.getAttributeValue(0));
        List<Planche> listPlanche = new ArrayList<>();
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "planche")
                {
                    System.out.println("nouvelle planche");
                    Planche p = readPlanche(reader);
                    listPlanche.add(p);
                }

            }
        }
        return new Client(id,listPlanche);
    }

    static Planche readPlanche(XMLStreamReader reader) throws XMLStreamException
    {
        int id=Integer.parseInt(reader.getAttributeValue(0));
        int nombre=Integer.parseInt(reader.getAttributeValue(1));
        String dates =(reader.getAttributeValue(2));
        System.out.println(dates);
        String[] allDates = dates.split("\\.");
        System.out.println(Arrays.toString(allDates));
        int date = Integer.parseInt(allDates[0]);
        System.out.println(date);
        float prix=Float.parseFloat(reader.getAttributeValue(3));;
        List<Dimensions> listDimensions = new ArrayList<>();
        while(reader.hasNext())
        {
            if(reader.next() == XMLStreamConstants.START_ELEMENT)
            {
                if(reader.getName().toString() == "dim")
                {
                    Dimensions dim=readDimensions(reader);
                    listDimensions.add(dim);
                }

            }
            if(reader.next() == XMLStreamConstants.END_ELEMENT){
                return new Planche(listDimensions.get(0),id,nombre,date,prix);
            }
        }
        return new Planche(listDimensions.get(0),id,nombre,date,prix);
    }
    static Dimensions readDimensions (XMLStreamReader reader) throws XMLStreamException{
        float L = Float.parseFloat(reader.getAttributeValue(0));
        float l = Float.parseFloat(reader.getAttributeValue(1));
        return new Dimensions(L,l);
    }
}
