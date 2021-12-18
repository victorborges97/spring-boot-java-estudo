package com.eventos.services.event;


import com.eventos.models.Event;

import java.util.List;

public interface IEventService {
    List<Event> getAll();
    Event getById(Long id);
    void remove(Long id);
    void save(Event event);
}
