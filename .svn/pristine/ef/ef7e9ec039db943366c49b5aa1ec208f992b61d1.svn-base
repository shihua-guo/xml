package com.briup.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.briup.domProj.Student;

public class SAXpa {
	
	public void parser(String path) {
		// new sax parser
		SAXParserFactory parser = SAXParserFactory.newInstance();
		SAXParser sax = null;
		try {
			MyHandler mh = new MyHandler();
			sax = parser.newSAXParser();
			//band event for the element 
			sax.parse(path, mh);//default handler
			List<Student> stuList = mh.getStuList();
			for(Student stu:stuList){
				System.out.println(stu.toString());
			}
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
		new SAXpa().parser("src/com/briup/xml/Student.xml");
	}
}
class MyHandler extends DefaultHandler{
	private List<Student> stuList = new ArrayList<Student>();
	private Student student;
	private boolean stuF;//how it works?
	private boolean nameF;
	private boolean ageF;
	@Override
	public void startDocument() throws SAXException {
		System.out.println(" doc start");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println(" doc end");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName+" element start");
		if("stu".equals(qName)){//when read the stu tag 
			stuF = true;
			student = new Student();
			String id = attributes.getValue("id");//get the id value
			student.setId(Long.parseLong(id));
		}
		if("name".equals(qName)){
			nameF = true;
		}
	}
	

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName+" element end");
		if("stu".equals(qName)){//when read the stu tag 
			stuF = false;
			stuList.add(student);
		}
		if("stu".equals(qName)){//when read the stu tag 
			stuF = false;
			stuList.add(student);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("deal the empty");
		String str = new String(ch,start,length);
		/*if(str.trim().length()!=0){
			System.out.println("text value:"+str);
		}
		else{
			System.out.println("**********");
		}*/
		if(nameF==true){
			student.setName(str);
			nameF = false;
		}
		if(ageF==true){
			student.setAge(Integer.parseInt(str));
			ageF = false;
		}
	}

	public List<Student> getStuList() {
		return stuList;
	}

	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	
}