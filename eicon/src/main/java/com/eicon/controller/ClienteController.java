package com.eicon.controller;

import com.eicon.util.ApiError;
import com.eicon.domain.Cliente;
import com.eicon.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@RequestMapping(value = "/list/{nome}", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List<Cliente>> listAll(@PathVariable("nome") String descricao) {

		List<Cliente> todos = service.searchByFilters(descricao.replaceAll("descricao=", ""));

		if (todos.isEmpty())
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Cliente>>(todos, HttpStatus.OK);
	}


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Object> salvar(@RequestBody Cliente todo, UriComponentsBuilder ucBuilder) {

		List<String> erros = new ArrayList<String>();

		if (todo != null) {

			if (todo.getNome() == null || todo.getNome().trim().isEmpty()) {

				erros.add("A descrição é obrigatória.");
			}

		}

		if (!erros.isEmpty()) {

			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Erros", erros);
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
			
		} else {

			service.create(todo);

			HttpHeaders headers = new HttpHeaders();

			headers.setLocation(ucBuilder.path("/clienteApp/{id}").buildAndExpand(todo.getId()).toUri());

			return new ResponseEntity<Object>(headers, HttpStatus.CREATED);

		}

	}

}
