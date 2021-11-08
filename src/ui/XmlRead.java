package ui;
import commande.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlRead {
    public int prix;
    public int jour;
    public int mois;
    public int annee;

    public void XmlRead() {
        FileInputStream file = null;
        try {
            file = new FileInputStream("C:/Users/Charles/IdeaProjects/projet-java/Etape 1/clients.xml");
            XMLInputFactory xmlInFact = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInFact.createXMLStreamReader(file);
            if (reader.hasNext()) {

                reader.next(); // On regarde la liste des clients

                reader.nextTag(); //On regarde le premier client
                reader.nextTag(); //On regarde la première commande de planche demandée

                //String commande = "Commande n°" + reader.getAttributeValue(0) + " de " + reader.getAttributeValue(1) + " planches à livrer pour le " + reader.getAttributeValue(2) + " au prix maximal de " + reader.getAttributeValue(3);
                this.prix = Integer.parseInt(reader.getAttributeValue(3));
                String[] date = reader.getAttributeValue(2).split(".");
                this.jour = Integer.parseInt(date[0]);
                this.mois = Integer.parseInt(date[1]);
                this.annee = Integer.parseInt(date[2]);
                //System.out.println(commande);
            }
        } catch (IOException exc) {

            System.out.print("Erreur IO: " + exc.toString());
        } catch (XMLStreamException exc) {
            System.out.print("Erreur XML: " + exc.toString());

        }
    }

}
