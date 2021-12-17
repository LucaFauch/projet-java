package ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;

import commande.Dcoupe;

import org.w3c.dom.*;

public class XmlWrite {
    public static void writeXML(String dossier, ArrayList<Dcoupe> l){
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

            int clientCourant=l.get(0).idClient;
            int fournisseurCourant=l.get(0).idFournisseur;
            int compteurPlanche=0;
            int compteurPanneau=0;

            for (Dcoupe d : l) {
                if(d.idClient==clientCourant && d.x==0 && d.y==0){
                    compteurPanneau++;
                }else{
                    compteurPanneau=1;
                }
                if(d.idFournisseur==fournisseurCourant){
                    compteurPlanche++;
                }else{
                    compteurPlanche=1;
                }
                decoupe=doc.createElement("decoupe");

                client=doc.createElement("client");
                client.setAttribute("id", String.valueOf(d.idClient)); // Récupérer les infos de découpe
                client.setAttribute("planche", String.valueOf(d.idPlanche)+"."+String.valueOf(compteurPlanche));
                decoupe.appendChild(client);

                fournisseur=doc.createElement("fournisseur");
                fournisseur.setAttribute("id", String.valueOf(d.idFournisseur)); // Récupérer les infos de découpe
                fournisseur.setAttribute("panneau", String.valueOf(d.idPanneau)+"."+String.valueOf(compteurPanneau));
                decoupe.appendChild(fournisseur);

                position=doc.createElement("position");
                position.setAttribute("x", String.valueOf(d.x)); //Récupérer les infos de découpe
                position.setAttribute("y", String.valueOf(d.y)); //Récupérer les infos de découpe
                decoupe.appendChild(position);

                firstElement.appendChild(decoupe);

                clientCourant=d.idClient;
                fournisseurCourant=d.idFournisseur;
            }

            doc.appendChild(firstElement);
            try{
                Transformer t = TransformerFactory.newInstance().newTransformer();
                t.setOutputProperty(OutputKeys.INDENT, "yes");
                t.setOutputProperty(OutputKeys.METHOD, "xml");
                t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

                t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(dossier+"/decoupes.xml")));
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

    public static void writeSVG(String dossier, ArrayList<Dcoupe> l){
        Document doc = null;
        Element rectangle = null;
        Element firstElement = null;
        
        DocumentBuilder docBuilder;
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

        try{
            docBuilder = docBuilderFactory.newDocumentBuilder();
                
            doc = docBuilder.newDocument();
            
            firstElement = doc.createElement("svg");
            firstElement.setAttribute("version", "1.1");
            firstElement.setAttribute("xmlns", "http://www.w3.org/2000/svg");
            firstElement.setAttribute("width", String.valueOf(l.get(0).largeurPanneau*10));
            firstElement.setAttribute("height", String.valueOf(l.get(0).longueurPanneau*10));

            doc.appendChild(firstElement);
        }catch(ParserConfigurationException e){
            System.out.println("Error instantiating the DocumentBuilder "+e);
        }    

        int panneauCourant=l.get(0).idPanneau;

        for(Dcoupe d : l){
            try{
                if(d.idPanneau!=panneauCourant){
                    try{
                        Transformer t = TransformerFactory.newInstance().newTransformer();
                        t.setOutputProperty(OutputKeys.INDENT, "yes");
                        t.setOutputProperty(OutputKeys.METHOD, "xml");
                        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        
                        t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(dossier+"/panneau"+String.valueOf(panneauCourant)+".svg")));
                    }
                    catch(TransformerException e){
                        System.out.println(e.getMessage());
                    }
                    catch(IOException e){
                        System.out.println(e.getMessage());
                    }

                    docBuilder = docBuilderFactory.newDocumentBuilder();

                    doc = docBuilder.newDocument();

                    firstElement = doc.createElement("svg");
                    firstElement.setAttribute("version", "1.1");
                    firstElement.setAttribute("xmlns", "http://www.w3.org/2000/svg");
                    firstElement.setAttribute("width", String.valueOf(d.largeurPanneau*10));
                    firstElement.setAttribute("height", String.valueOf(d.longueurPanneau*10));

                    doc.appendChild(firstElement);
                }

                rectangle=doc.createElement("rect");
                rectangle.setAttribute("x", String.valueOf(d.x*10));
                rectangle.setAttribute("y", String.valueOf(d.y*10));
                firstElement.setAttribute("xmlns", "http://www.w3.org/2000/svg");
                rectangle.setAttribute("width", String.valueOf(d.largeurPlanche*10));
                rectangle.setAttribute("height", String.valueOf(d.longueurPlanche*10));
                Random rand = new Random();
                String r=String.valueOf(rand.nextInt(256));
                String g=String.valueOf(rand.nextInt(256));
                String b=String.valueOf(rand.nextInt(256));
                rectangle.setAttribute("fill", "rgb("+r+","+g+","+b+")");
                firstElement.appendChild(rectangle);

                panneauCourant=d.idPanneau;
            }
            catch(ParserConfigurationException e){
                System.out.println("Error instantiating the DocumentBuilder "+e);
            }            
        }
        try{
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty(OutputKeys.METHOD, "xml");
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            t.transform(new DOMSource(doc), new StreamResult(new FileOutputStream(dossier+"/panneau"+String.valueOf(panneauCourant)+".svg")));
        }
        catch(TransformerException e){
            System.out.println(e.getMessage());
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
