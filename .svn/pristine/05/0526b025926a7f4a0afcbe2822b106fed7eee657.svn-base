package com.briup.domProj;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class StudentSeriveImpl implements StudentSerive {

	@Override
	public List<Student> getStudent(String fileName) {
		List<Student> stuList = new ArrayList<Student>();
		//construct the parser factory
		DocumentBuilderFactory factory = 
				DocumentBuilderFactory.newInstance();
		//if can use the name space default is false
		factory.setNamespaceAware(true);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			//load xml if dtd is exist 
			//then we just to do parse
			//so we can ignore the dtd(not read the dtd config)
			builder.setEntityResolver(new EntityResolver() {//忽略dtd
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					//zhaunyi ""
					byte[] b = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
							.getBytes();
					return new InputSource(
							new ByteArrayInputStream(b));
				}
			});
			
			
			
			
			
			Document doc = (Document) builder.parse(fileName);
			//through the tag's name no empty node
			NodeList list = doc.getElementsByTagName("stu");
			System.out.println(list.getLength());
			Node node = null;
			for(int i=0;i<list.getLength();i++){
				node = list.item(i);
				System.out.println(node.getNodeName());
				String id = node.getAttributes()
							.getNamedItem("id")
							.getNodeValue();
				Student stu = new Student();
				stu.setId(Long.parseLong(id));
				NodeList childNode = node.getChildNodes();
				for(int j=0;j<childNode.getLength();j++){
					Node nodeChild = childNode.item(j);//get the child
					//is the element node not the empty node
					if(nodeChild.getNodeType()==Node.ELEMENT_NODE){
						String name = nodeChild.getNodeName();
						String value = nodeChild.getTextContent();
						if("name".equals(name)){//is name
							stu.setName(value);//set name
						}
						if("age".equals(name)){//is age
							stu.setAge(Integer.parseInt(value));//set age
						}
					}
				}
				stuList.add(stu);
			}
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

	@Override
	public void addStudent(String fileName, Student stu) {

	}

	@Override
	public void delStudent(String fileName, Student stu) {

	}

	@Override
	public void updateStudent(String fileName, Student stu) {

	}
	public static void main(String[] args) {
		List<Student> list = new StudentSeriveImpl().getStudent("src/com/briup/xml/Student.xml");
		for(Student stu:list){
			System.out.println(stu.toString());
		}
	}
}
