package ui;

import java.io.FileOutputStream;
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
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        doc = docBuilder.newDocument();

        Element firstElement = doc.createElement("decoupes");

        for (Dcoupe d : l) {
            decoupe=doc.createElement("decoupe");

            client=doc.createElement("client");
            client.setAttribute("id", d.client.id.toString());
            decoupe.appendChild(client);

            fournisseur=doc.createElement("fournisseur");
            fournisseur.setAttribute("id", d.fournisseur.id.toString());
            decoupe.appendChild(fournisseur);

            position=doc.createElement("position");
            position.setAttribute("x", d.x.toString());
            position.setAttribute("y", d.y.toString());
            decoupe.appendChild(position);

            firstElement.appendChild(decoupe);
        }

        doc.appendChild(firstElement);

        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(filename)));
    }
}
