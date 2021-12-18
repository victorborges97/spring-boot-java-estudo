package com.eventos.services.event;

import com.eventos.models.Event;
import com.eventos.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService  {

    @Autowired
    private EventRepository repository;

    @Override
    public List<Event> getAll() {
        return (List<Event>) repository.findAll();
    }

    @Override
    public Event getById(Long id) {
        return (Event) repository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        repository.delete(id);
    }

    @Override
    public void save(Event event) {
        repository.save(event);
    }

}
