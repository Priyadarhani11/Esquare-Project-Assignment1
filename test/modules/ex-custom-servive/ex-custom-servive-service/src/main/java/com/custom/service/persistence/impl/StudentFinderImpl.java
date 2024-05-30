package com.custom.service.persistence.impl;

import com.custom.model.Student;
import com.custom.model.impl.StudentImpl;
import com.custom.service.persistence.StudentFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component	
(service = StudentFinder.class)	

public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder{

@Reference
CustomSQL _customSql;

public List<Student>  getStudentsByName(String sName){
	System.out.println("Inside custom sql");
	 Session session=null;
	
	 try {
		 session=openSession();
		 String sql=_customSql.get(getClass(),"getStudentsByName");
		 System.out.println("sql------------->"+sql);
		 SQLQuery sqlQuery=session.createSQLQuery(sql);
				 sqlQuery.setCacheable(false);
         sqlQuery.addEntity("Student",StudentImpl.class);
         QueryPos queryPos=QueryPos.getInstance(sqlQuery);
         queryPos.add(sName);
         return (List<Student>)sqlQuery.list();
 }catch(Exception e){
  
 }finally {
  closeSession(session);
 }
 return null;
		 
		 
} 
	 
}
