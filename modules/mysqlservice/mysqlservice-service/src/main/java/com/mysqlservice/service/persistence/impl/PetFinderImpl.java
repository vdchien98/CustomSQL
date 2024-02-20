package com.mysqlservice.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.mysqlservice.model.Pet;
import com.mysqlservice.model.impl.PetImpl;
import com.mysqlservice.service.persistence.PetFinder;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
@Component(service = PetFinder.class)
public class PetFinderImpl extends PetFinderBaseImpl implements PetFinder {
	   @Reference
	    private CustomSQL _customSQL;
		
		public List<Pet>  getPetsByName(String pName){
			System.out.println("Inside custom sql");
			 Session session=null;
			  try{
			          session=openSession();            
			          String sql=_customSQL.get(getClass(),PetFinder.class.getName() + ".getPetsByName");
			          System.out.println("Query==>"+sql);
			          System.out.println("");
			          SQLQuery sqlQuery=session.createSQLQuery(sql);
			          sqlQuery.setCacheable(false);
	                          sqlQuery.addEntity("Pet",PetImpl.class);
			          QueryPos queryPos=QueryPos.getInstance(sqlQuery);
			          queryPos.add(pName);
			          return (List<Pet>)sqlQuery.list();
			  }catch(Exception e){
			   
			  }finally {
			   closeSession(session);
			  }
			  return null;
			 }
}
