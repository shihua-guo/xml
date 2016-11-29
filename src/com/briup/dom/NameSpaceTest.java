package com.briup.dom;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class NameSpaceTest {
	public static void parser(){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			//get document
			doc = reader.read(new File("src/com/briup/xml/nameSpace.xml"));
			//get the root
			Element root = doc.getRootElement();
			//get the second tag
			for(Object o:root.elements()){
				Element e1 = (Element)o;
				//print the tag'name (Local Name)
				System.out.println(e1.getName());
				//get the name-space name
					//format:name-space's name tag's name
				System.out.println(e1.getQName());
				//get the name-space
				System.out.println(e1.getNamespaceURI());
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		parser();
	}
}
