package com.briup.domProj;

import java.util.List;
/**
 * for the ADUF XML
 * @author alan
 * @date Sep 9, 2016 3:41:25 PM
 */
public interface StudentSerive {
	List<Student> getStudent(String fileName);
	void addStudent(String fileName,Student stu);
	void delStudent(String fileName,Student stu);
	void updateStudent(String fileName,Student stu);
}
