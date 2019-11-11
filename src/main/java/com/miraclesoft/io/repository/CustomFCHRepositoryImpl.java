package com.miraclesoft.io.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miraclesoft.io.model.AverageBloodPressureEntity;
import com.miraclesoft.io.model.AverageCholestrolEntity;
import com.miraclesoft.io.model.AverageEntity;
import com.miraclesoft.io.model.AverageGlucoseEntity;
import com.miraclesoft.io.model.MedPrescriptionDTO;



@Repository
@Transactional(readOnly=true)
public class CustomFCHRepositoryImpl implements CustomFCHRepository {

	@Autowired
	EntityManager entityManager;
	
	
	@Override
	public List<Object[]> findRecentValueByPid(long patientId, String sqlQuery) {
		//String sqlQuery="SELECT weight, to_char(w_date,'DD/MM/YYYY HH24:MI:SS') as w_date1 FROM fchealth_weight " +
			//				"WHERE pid = ? Order by w_date desc ";
		long res = 0l;
		 List<Object[]> result= null;
		Query query = entityManager.createNativeQuery(sqlQuery);
        query.setParameter(1, patientId );
        try {
        	 result = query.getResultList();
//        	res = Long.parseLong(String.valueOf(result.get(0)[0]));
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        return result;
	}

	@Override
	public List<AverageEntity> findAverageValues(long patientId, String avgQuery, int year) throws Exception{
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(avgQuery);
		query.setParameter(1, patientId );
		query.setParameter(2, year);
        	List<Object[]> result = query.getResultList();
        	List<AverageEntity> avgList =new ArrayList<AverageEntity>();
        	//List<Object[]> rows = query.list();
        	for(Object[] row : result){
        		AverageEntity avgent = new AverageEntity();
        		int x= Integer.parseInt(row[0].toString());
        		String str=Integer.toString((year%100));
        		switch(x) {
	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
	        		case 4:  avgent.setAvgMonth("APR"+str);break;
	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
	        		case 12: avgent.setAvgMonth("DEC"+str);break;
        		}
        		//avgent.setAvgMonth(Integer.parseInt(row[0].toString()));
        		avgent.setAvgWeight(Double.parseDouble(row[1].toString()));
        		//System.out.println("Before Adding"+avgent);
        		avgList.add(avgent); 
        		//System.out.println("After adding:"+avgList);
        	}
        	//System.out.println(ent);
        			//getResultList();
        	return avgList;
	}

	@Override
	public List<AverageCholestrolEntity> findCholestrolAverageValues(long patientId, String avgCL, int year)
			throws Exception {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(avgCL);
		query.setParameter(1, patientId );
		query.setParameter(2, year);
        	List<Object[]> result = query.getResultList();
        	List<AverageCholestrolEntity> avgList =new ArrayList<AverageCholestrolEntity>();
        	//List<Object[]> rows = query.list();
        	for(Object[] row : result){
        		AverageCholestrolEntity avgent = new AverageCholestrolEntity();
        		int x= Integer.parseInt(row[0].toString());
        		String str=Integer.toString((year%100));
        		switch(x) {
	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
	        		case 4:  avgent.setAvgMonth("APR"+str);break;
	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
	        		case 12: avgent.setAvgMonth("DEC"+str);break;
        		}
        		//avgent.setAvgMonth(Integer.parseInt(row[0].toString()));
        		avgent.setAvgCL(Double.parseDouble(row[1].toString()));
        		//System.out.println("Before Adding"+avgent);
        		avgList.add(avgent); 
        		//System.out.println("After adding:"+avgList);
        	}
        	//System.out.println(ent);
        			//getResultList();
        	return avgList;
}

	@Override
	public List<AverageGlucoseEntity> findGlucoseAverageValues(long patientId, String avgGL, int year)
			throws Exception {
		Query query = entityManager.createNativeQuery(avgGL);
		query.setParameter(1, patientId );
		query.setParameter(2, year);
        	List<Object[]> result = query.getResultList();
        	List<AverageGlucoseEntity> avgList =new ArrayList<AverageGlucoseEntity>();
        	//List<Object[]> rows = query.list();
        	for(Object[] row : result){
        		AverageGlucoseEntity avgent = new AverageGlucoseEntity();
        		int x= Integer.parseInt(row[0].toString());
        		String str=Integer.toString((year%100));
        		switch(x) {
	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
	        		case 4:  avgent.setAvgMonth("APR"+str);break;
	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
	        		case 12: avgent.setAvgMonth("DEC"+str);break;
        		}
        		//avgent.setAvgMonth(Integer.parseInt(row[0].toString()));
        		avgent.setAvgGL(Double.parseDouble(row[1].toString()));
        		//System.out.println("Before Adding"+avgent);
        		avgList.add(avgent); 
        		//System.out.println("After adding:"+avgList);
        	}
        	//System.out.println(ent);
        			//getResultList();
        	return avgList;
	}

	@Override
	public List<AverageBloodPressureEntity> findAverageBPValues(long patientId, String avgHLBP,int year)
			throws Exception {
		
		Query query = entityManager.createNativeQuery(avgHLBP);
//		Query query1 = entityManager.createNativeQuery(avgHBP);
		query.setParameter(1, patientId );
		query.setParameter(2, year);
        	List<Object[]> result = query.getResultList();
//        	List<Object[]> result1 = query1.getResultList();
        	List<AverageBloodPressureEntity> avgList =new ArrayList<AverageBloodPressureEntity>();
        	//List<Object[]> rows = query.list();
        	for(Object[] row : result){
        		AverageBloodPressureEntity avgent = new AverageBloodPressureEntity();
        		int x= Integer.parseInt(row[0].toString());
        		String str=Integer.toString((year%100));
        		switch(x) {
	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
	        		case 4:  avgent.setAvgMonth("APR"+str);break;
	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
	        		case 12: avgent.setAvgMonth("DEC"+str);break;
        		}
//        		for(Object[] row1 : result1){
//            		AverageBloodPressureEntity avgent1 = new AverageBloodPressureEntity();
//            		int x1= Integer.parseInt(row[0].toString());
//            		String str1=Integer.toString((year%100));
//            		switch(x) {
//    	        		case 1:  avgent.setAvgMonth("JAN"+str);break;
//    	        		case 2:  avgent.setAvgMonth("FEB"+str);break;
//    	        		case 3:  avgent.setAvgMonth("MAR"+str);break;
//    	        		case 4:  avgent.setAvgMonth("APR"+str);break;
//    	        		case 5:  avgent.setAvgMonth("MAY"+str);break;
//    	        		case 6:  avgent.setAvgMonth("JUN"+str);break;
//    	        		case 7:  avgent.setAvgMonth("JUL"+str);break;
//    	        		case 8:  avgent.setAvgMonth("AUG"+str);break;
//    	        		case 9:  avgent.setAvgMonth("SEP"+str);break;
//    	        		case 10:  avgent.setAvgMonth("OCT"+str);break;
//    	        		case 11:  avgent.setAvgMonth("NOV"+str);break;
//    	        		case 12: avgent.setAvgMonth("DEC"+str);break;
//            		}
        		//avgent.setAvgMonth(Integer.parseInt(row[0].toString()));
        		avgent.setAvgLowBP(Double.parseDouble(row[1].toString()));
        		avgent.setAvgHighBP(Double.parseDouble(row[2].toString()));
        		//System.out.println("Before Adding"+avgent);
        		avgList.add(avgent); 
//        		avgList.add(avgent1);
        		//System.out.println("After adding:"+avgList);
        	}
        	//System.out.println(ent);
        			//getResultList();
        	return avgList;
	}

	@Override
	public List<Object[]> fetchMedications(String fetchall, long pid) throws Exception {
		// TODO Auto-generated method stub\\\\\
		Query query = entityManager.createNativeQuery(fetchall);
		query.setParameter(1, pid );
		List<Object[]> jh = query.getResultList();
		return jh;
	}

	@Override
	public List<Object[]> fetchMedicalconditions(String fetchall, long pid) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(fetchall);
		query.setParameter(1, pid );
		List<Object[]> conditions = query.getResultList();
		return conditions;
	}

	@Override
	public long fetchId(String fetchID, long id) {
		long res = 0l;
		 List<Object[]> result= null;
		// TODO Auto-generated method stub
		Query query = entityManager.createNativeQuery(fetchID);
		query.setParameter(1, id );
//		List<Object[]> value  = query.getResultList();
    	res = Long.parseLong(String.valueOf(result.get(0)[0]));

		return res;
	}
			

	

	
	
	

	
	
	
	
	
	
	
	
}
