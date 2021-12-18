package com.eventos.controllers;

import javax.validation.Valid;

import com.eventos.services.event.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eventos.models.Event;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@Api(value="API Rest Eventos")
@RestController
@RequestMapping("/api/v1/event")
public class EventController {

	@Autowired
	private IEventService service;
	
	@ApiOperation(value="Retorna uma lista de Eventos.")
	@GetMapping()
	public List<Event> getAll(){
		return service.getAll();
	}

	@ApiOperation(value="Retorna o Evento do ID passado.")
	@GetMapping("/{id}")
	public Event getById(@PathVariable String id){
		return service.getById(Long.valueOf(id));
	}
	
	@ApiOperation(value="Cadastra um evento novo.")
	@PostMapping()
	public Event save(@RequestBody @Valid Event event){
		service.save(event);
		return event;
	}
	
	@ApiOperation(value="Deleta o evento passado.")
	@DeleteMapping("/{id}")
	public void remove(@PathVariable String id){
		service.remove(Long.valueOf(id));
	}
}
