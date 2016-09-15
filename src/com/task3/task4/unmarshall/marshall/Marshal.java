package com.task3.task4.unmarshall.marshall;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.task3.task4.unmarshall.marshall.PurchaseOrderType.BillTo;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.Items;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.ShipTo;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.Items.Item;


public class Marshal {
	
	
	public static void main(String argv[]) {
        try {
        	JAXBContext jaxbContext = JAXBContext.newInstance("com.task3.task4.unmarshall.marshall");
        	Marshaller marshaller = jaxbContext.createMarshaller();
        	PurchaseOrderType purchaseOrderType = new PurchaseOrderType();
        	ShipTo shipto = new ShipTo();
        	BillTo billto = new BillTo();
        	shipto.setName("harry");
        	shipto.setCity("NYC");
        	billto.setName("tom");
        	billto.setCity("NYC");

        	purchaseOrderType.setBillTo(billto);
        	purchaseOrderType.setShipTo(shipto);
        		
        	Item item = new Item();
        	item.setPartNum("688");
        	item.setProductName("mouse");
        	item.setQuantity(4);

        	Item item2 = new Item();
        	item2.setPartNum("689");
        	item2.setProductName("joystick");
        	item2.setQuantity(5);

        	Items items =  new Items();
        	items.getItem().add(item);
        	items.getItem().add(item2);

        	purchaseOrderType.setItems(items);

        	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);	//this is used to align data properly in the XML file
        	marshaller.marshal(purchaseOrderType, new File("marshal.xml"));
        	System.out.println("marshalling done check xml file");
        	}
        	
	
catch (Exception e) {
    e.printStackTrace();
}
 }
	}