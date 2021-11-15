package ui;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

class XmlRead {
    int cost;
    int day;
    int month;
    int year;

    private void XmlRead() {
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
                setCost(Integer.parseInt(reader.getAttributeValue(3)));
                String[] date = reader.getAttributeValue(2).split(".");
                setDay(Integer.parseInt(date[0]));
                setMonth(Integer.parseInt(date[1]));
                setYear(Integer.parseInt(date[2]));
                //System.out.println(commande);
            }
        } catch (IOException exc) {

            System.out.print("Erreur IO: " + exc.toString());
        } catch (XMLStreamException exc) {
            System.out.print("Erreur XML: " + exc.toString());

        }
    }

    void setCost (int cost){
        this.cost=cost;
    }
    void setDay(int day){
        this.day=day;
    }
    void setMonth(int month){
        this.month=month;
    }
    void setYear(int year){
        this.year=year;
    }
    int getDay(){
        return this.day;
    }
    int getMonth(){
        return this.month;
    }
    int getYear(){
        return this.year;
    }
    int getCost(){
        return this.cost;
    }
}
