package com.miraclesoft.io.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miraclesoft.io.ExceptionHandler.RecordNotFoundException;
import com.miraclesoft.io.model.Event;
import com.miraclesoft.io.repository.EventRepository;



@Service
public class EventService {
	
	@Autowired
	EventRepository er;
	@Autowired
	EntityManager entityManager;
	

	public Event getEvent(Long id) {
		// TODO Auto-generated method stub
		return er.findById(id).orElseThrow(RecordNotFoundException::new);
	}

//
//	public Optional<Event> getEventsByResource(Long resource_id) {
//		
//		String querys = "select name, start, end, text from motion_app.event, motion_app.resource "
//				+ "where motion_app.event.resource_id = motion_app.resource.resource_id AND motion_app.event.resource_id=?";
////		try {
////		List<Object[]> result = query.getResultList();
////		res = Long.parseLong(String.valueOf(result.get(0)[0]));
////		}catch(Exception ex) {
////		ex.printStackTrace();
////		}
//		return er.findById(resource_id);
//		// TODO Auto-generated method stub
////		
//	}
	
	public List<Event> getEventsByResource(Long resource_id) {
		
		System.out.println(""+resource_id);
		List<Event> elist=er.findUserByResourceId(resource_id);
		System.out.println("getting result"+elist);
		return elist;
		
	}

}
