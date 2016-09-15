package com.xmlparsing.sax.task2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler; 
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
 
public class XMLHandler extends DefaultHandler{
 
    public static void main(String...args) {
 
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
 
            XMLHandler xmlHandler = new XMLHandler(){
 
                boolean title = false;
                boolean author = false;
                boolean year = false;
                boolean price = false;
 
                public void startElement(String uri, String localName, String tag, Attributes attributes) throws SAXException {
 
                    System.out.print("\n<" + tag + ">");
 
                    if (tag.equalsIgnoreCase("title")) {
                        title = true;
                    }
 
                    if (tag.equalsIgnoreCase("author")) {
                        author = true;
                    }
 
                    if (tag.equalsIgnoreCase("year")) {
                        year = true;
                    }
 
                    if (tag.equalsIgnoreCase("price")) {
                        price = true;
                    }
                }
 
                public void endElement(String uri, String localName, String tag) throws SAXException {
                    if (tag.equalsIgnoreCase("book") || tag.equalsIgnoreCase("bookstore")){
                        System.out.print("\n");
                    }
                    System.out.print("<!--" + tag + "-->");
                }
 
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (title) {
                        System.out.print("Title: " + new String(ch, start, length));
                        title = false;
                    }
 
                    if (author) {
                        System.out.print("Author: " + new String(ch, start, length));
                        author = false;
                    }
 
                    if (year) {
                        System.out.print("Year: " + new String(ch, start, length));
                        year = false;
                    }
 
                    if (price) {
                        System.out.print("Price: " + new String(ch, start, length));
                        price = false;
                    }
                }
            };
 
            saxParser.parse("books.xml", xmlHandler);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}