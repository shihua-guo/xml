package com.briup.domProj;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 解析文件，并且创建好对象，初始化对象（工厂）
 * 
 * @author alan
 * @date Sep 9, 2016 2:27:13 PM
 */
public class UserDOM4j {
	private Map<String, User> map = new HashMap<String, User>();

	public UserDOM4j() {
	}

	public UserDOM4j(String path) {
		// pro store all the flexible parameter
		Properties pro = new Properties();
		// 构建解析器
		SAXReader reader = new SAXReader();
		// 装载xml文件
		File file = new File(path);
		Document doc = null;
		try {
			if (!file.exists() && !file.canRead()) {
				throw new Exception("file not exists or no permission");
			}
			doc = reader.read(file);
			Element eP = doc.getRootElement();
			for (Object o1 : eP.elements()) {
				Element eSe = (Element) o1;
				String name = eSe.getName();
				String className = eSe.attributeValue("class");
				User u = (User) Class.forName(className).newInstance();
				for (Object o2 : eSe.elements()) {
					Element eTh = (Element) o2;
					String key = eTh.getName();
					String value = eTh.getText();
					pro.setProperty(key, value);
				}
				if(u instanceof User){
					u.init(pro);
					//name is the second tag's name
					map.put(name, u);
				}
				//clear the pro
				pro.clear();
			}

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Tea getTea() {
		return (Tea)map.get("Tea");
	}

	public Sta getSta() {
		return (Sta)map.get("Sta");
	}

	public DoT getDoT() {
		return (DoT)map.get("DoT");
	}
	public static void main(String[] args) {
		UserDOM4j user = new UserDOM4j("src/com/briup/xml/User.xml");
		DoT d = user.getDoT();
		System.out.println(d.getPort());
		Sta s = user.getSta();
		System.out.println(s.getId());
		Tea t = user.getTea();
		System.out.println(t.getPort());
	}
}
