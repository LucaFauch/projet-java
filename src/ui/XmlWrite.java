package ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;

import commande.Dcoupe;

import org.w3c.dom.*;

public class XmlWrite {
    public void writeXML(String filename, ArrayList<Dcoupe> l){
        Document doc;
        Element decoupe = null;
        Element client = null;
        Element fournisseur = null;
        Element position = null;

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        
            doc = docBuilder.newDocument();
            
            Element firstElement = doc.createElement("decoupes");

            for (Dcoupe d : l) {
                decoupe=doc.createElement("decoupe");

                client=doc.createElement("client");
                // client.setAttribute("id", d.client.id.toString()); Récupérer les infos de découpe
                decoupe.appendChild(client);

                fournisseur=doc.createElement("fournisseur");
                // fournisseur.setAttribute("id", d.fournisseur.id.toString()); Récupérer les infos de découpe
                decoupe.appendChild(fournisseur);

                position=doc.createElement("position");
                // position.setAttribute("x", d.x.toString()); Récupérer les infos de découpe
                // position.setAttribute("y", d.y.toString()); Récupérer les infos de découpe
                decoupe.appendChild(position);

                firstElement.appendChild(decoupe);
            }

            doc.appendChild(firstElement);
            try{
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty(OutputKeys.METHOD, "xml");
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(filename)));
            }
            catch(TransformerException e){
                System.out.println(e.getMessage());
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
        catch(ParserConfigurationException e){
            System.out.println("Error instantiating the DocumentBuilder "+e);
        }
    }
}
