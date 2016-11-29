package com.briup.dom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomTest1 {
	public void parser(String path){
		//build the parser class factory
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		//create the parser factory
		DocumentBuilder db = null;
		try {
			db = factory.newDocumentBuilder();
			//read the xml file and store to the memory and trans to tree
			Document doc = db.parse(path);
			Element root = doc.getDocumentElement();
			System.out.println(Node.ELEMENT_NODE);
			System.out.println(root.getNodeName());
			System.out.println(root.getTagName());
			System.out.println(root.getLocalName());//also tag's name
			//get the empty node(document node)
			System.out.println(root.getLastChild());//get the next last child 
			
			//遍历dom的node
			NodeList list = root.getElementsByTagName(doc.getNodeName());
			for(int i=0;i<list.getLength();i++){
				Node node = list.item(i);
				if(node.getNodeType()==Node.ELEMENT_NODE){
					String name = node.getLocalName();
					
				}
			}
			//get all name is "name" tag
			NodeList nameList = root.getElementsByTagName("name");
			//get the second name is name's tag;
			Node nodeName = nameList.item(1);
			String name = nodeName.getTextContent();
			System.out.println(name);
			/*Element tempE = doc.getElementById("_123");
			System.out.println(tempE.getTagName());*/
			
			//get the tag's parents
			Node parent = nodeName.getParentNode();
			System.out.println(
					parent.getAttributes()
						.getNamedItem("id")
							.getNodeValue());
			//delete the child
			parent.removeChild(nodeName);
//			parent.replaceChild(newChild, oldChild);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DomTest1().parser("src/com/briup/xml/Student.xml");;
	}
}
