package com.briup.dom;
import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
public class Dom4jTest {
	public Dom4jTest(){
		this("src/com/briup/xml/Dom4j.xml");
	}
	public Dom4jTest(String path){
		//1.construct the parse
		SAXReader reader = new  SAXReader();
		//2.read the xml file and trans to three document
		Document doc = null;
		try {
			doc = reader.read(new File(path));
			//3.get the root
			Element root = doc.getRootElement();
			//4.print the root name
			System.out.println(root.getName());
			//5.get root's children<the second tags>
//			System.out.println(root.elements());
			for(Object o1:root.elements()){
				Element e = (Element)o1;
				/*System.out.println(e.attributeValue("class"));
				//get all the attribute
				System.out.println(e.attributes());
				//6.get the second tag's name*/
				System.out.println("    "+e.getName());
				System.out.println("    "+e.getTextTrim());
				//7.get the third tags
				for(Object o2:e.elements()){
					Element e2 = (Element)o2;
					//get the tag's name
					System.out.println("\t"+e2.getName());
					//get the text content
					System.out.println("\t    "+e2.getTextTrim());
					//8.get the fourth tags 
					if(e2.getName().equals("adress")){
						for(Object o3:e2.elements()){
							Element e3 = (Element)o3;
							System.out.println("\t\t"+e3.getName());
							System.out.println("\t\t"+e3.getTextTrim());
						}
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new Dom4jTest("src/com/briup/xml/Dom4j.xml");
	}
	
}
