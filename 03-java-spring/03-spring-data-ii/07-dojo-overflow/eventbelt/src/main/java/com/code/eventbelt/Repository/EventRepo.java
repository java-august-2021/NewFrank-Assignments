package com.code.eventbelt.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.code.eventbelt.Models.Event;

@Repository
public interface EventRepo extends CrudRepository<Event,Long> {
	List<Event> findAll();
}
