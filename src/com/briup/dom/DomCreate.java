package com.briup.dom;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class DomCreate {
	static public void domCreator() {
		// create a empty document initial the memory
		Document doc = DocumentHelper.createDocument();
		//doc is the father of the root node
		Element root = doc.addElement("student");
		//add attributes to the root
		root.addAttribute("id","test");
		//add the second tag (children)
		Element secondE = root.addElement("stu");
		//add the third tag
		Element thirdE = secondE.addElement("name");
		//add a content to the third tag
		thirdE.addText("briup");
		//set the output format
		OutputFormat outFor = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = null;
		try {
			xmlWriter = new XMLWriter(new FileOutputStream(
					new File("src/com/briup/xml/createDom.xml")),outFor);
			xmlWriter.write(doc);
			xmlWriter.flush();
			xmlWriter.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		domCreator();
	}
}
