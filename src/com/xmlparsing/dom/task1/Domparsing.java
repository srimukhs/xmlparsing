package com.xmlparsing.dom.task1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
  
public class Domparsing {
     
    public static void main(String argv[]) {
        try {
            File xmlFile = new File("books.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);
            doc.getDocumentElement().normalize();
 
            System.out.println("List of the books" );
            NodeList nl = doc.getElementsByTagName("book");
            System.out.println("------------------------------------");
 
                for (int n = 0; n < nl.getLength(); n++) {
                    Node node = nl.item(n);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element e = (Element) node;
                        System.out.println();
                        System.out.println("Title : "  + getTagValue("title",e));
                        System.out.println("Author : "  + getTagValue("author",e));
                        System.out.println("Year : "  + getTagValue("year",e));
                        System.out.println("Price : "  + getTagValue("price",e));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
        }
    }
  
    private static String getTagValue(String sTag, Element e)
    {
    NodeList nlList= e.getElementsByTagName(sTag).item(0).getChildNodes();
    Node nValue = (Node) nlList.item(0); 
    return nValue.getNodeValue();
    }
}
 