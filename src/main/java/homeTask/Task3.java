package homeTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) {
        File file = new File("src/main/java/homeTask/city.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element root = doc.createElement("catalog");

            doc.appendChild(root);
            Element city = doc.createElement("city");
            city.setAttribute("size", "big");
            city.appendChild(doc.createTextNode("Kyiv"));
            root.appendChild(city);


            Element street = doc.createElement("street");
            city.appendChild(street);

            Element house = doc.createElement("house");
            street.appendChild(house);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            DefaultHandler def = new DefaultHandler() {
                boolean city = false;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("city")) {
                        System.out.println("Attribute size: " + attributes.getValue("size"));
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    if (city) {
                        System.out.println("City: " + new String(ch, start, length));
                        city = false;
                    }
                }
            };
            saxParser.parse(file, def);

        } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
