package com.miraclesoft.io.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.miraclesoft.io.model.Event;


@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	@Query("from Event e where not(e.end < :from and e.start > :to)")
	public List<Event> findBetween(@Param("from") LocalDateTime start, @Param("to") @DateTimeFormat(iso=ISO.DATE_TIME) LocalDateTime end);

	@Query("from Event e where e.resource_id= ?1")
	public List<Event> findUserByResourceId(Long resource_id);
	
//	@Query("FROM Event e INNER JOIN Resource r ON e.resource_id = r.resource_id AND r.resource_id= ?1")
//	public List<EventResource> findUserByResourceId(Long resource_id);

}