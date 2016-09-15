package com.task3.task4.unmarshall.marshall;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.task3.task4.unmarshall.marshall.PurchaseOrderType.BillTo;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.Items;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.ShipTo;
import com.task3.task4.unmarshall.marshall.PurchaseOrderType.Items.Item;


public class Unmarshal {
	
	
	public static void main(String argv[]) {
        try {
        	JAXBContext jaxbContext = JAXBContext.newInstance("com.task3.task4.unmarshall.marshall");
        	Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        	JAXBElement<PurchaseOrderType> jaxbElement = (JAXBElement<PurchaseOrderType>)unmarshaller.unmarshal(new StreamSource(new File("sample.xml")),PurchaseOrderType.class);
        	PurchaseOrderType purchaseOrderType = jaxbElement.getValue();
        	ShipTo shipTo = purchaseOrderType.getShipTo();
        	BillTo billTo = purchaseOrderType.getBillTo();
        	Items items = purchaseOrderType.getItems();
        	
        	
        	
        	System.out.println("ShipTo Details: "+shipTo.getName());
        		
        		
        	for(Item item:items.getItem() ){
        		System.out.println("ProductName :"+item.getProductName());
        		System.out.println("PartNumber :"+item.getPartNum());
        	}
        	
	
}catch (Exception e) {
    e.printStackTrace();
}
 }
	}