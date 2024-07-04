package com.custom.service.persistence.impl;

import com.custom.model.Student;
import com.custom.model.impl.StudentImpl;
import com.custom.service.persistence.StudentFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component	
(service = StudentFinder.class)	

public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder{

@Reference
CustomSQL _customSql;

public List<Student> getStuByName(String studentName){
	System.out.println("Inside custom sql");
	 Session session=null;
	List<Student> studentList = Collections.EMPTY_LIST;
	 try {
		 session=openSession();
		 String sql= _customSql.get(getClass(),"getStudentByName");
		 System.out.println("sql------------->"+sql);
		 SQLQuery sqlQuery = session.createSQLQuery(sql);
				 sqlQuery.setCacheable(false);
         sqlQuery.addEntity("Student",StudentImpl.class);
         QueryPos queryPos = QueryPos.getInstance(sqlQuery);
         queryPos.add(studentName);
         studentList = (List<Student>)sqlQuery.list();
         return studentList;
 }catch(Exception e){
  
 }finally {
  closeSession(session);
 }
 return studentList;
		 
		 
} 
	 
}
