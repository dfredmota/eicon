package com.eicon.controller;

import com.eicon.util.ApiError;
import com.eicon.domain.Cliente;
import com.eicon.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Clientes")
@RestController
@RequestMapping(value = "clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@ApiOperation(value = "Retorna todos os clientes" , response = Cliente.class , tags = "getClientes")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List<Cliente>> listAll() {

		List<Cliente> todos = service.all();

		if (todos.isEmpty())
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Cliente>>(todos, HttpStatus.OK);
	}

	@ApiOperation(value = "Retorna um cliente especifíco passando o id como parametro", response = Cliente.class)
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<Cliente> getCliente(@PathVariable("id") String id) {

		Cliente cliente = service.getById(Long.valueOf(id));

		if (cliente == null)
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}


	@ApiOperation(value = "Cadastra um Cliente")
	@RequestMapping(value = "/save", method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Object> salvar(@RequestBody Cliente cliRequest, UriComponentsBuilder ucBuilder) {

		List<String> erros = new ArrayList<String>();

		if (cliRequest != null) {

			if (cliRequest.getNome() == null || cliRequest.getNome().trim().isEmpty()) {

				erros.add("O Nome é obrigatório.");
			}

		}

		if (!erros.isEmpty()) {

			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Erros", erros);
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
			
		} else {

			service.create(cliRequest);

			HttpHeaders headers = new HttpHeaders();

			headers.setLocation(ucBuilder.path("/clienteApp/{id}").buildAndExpand(cliRequest.getId()).toUri());

			return new ResponseEntity<Object>(headers, HttpStatus.CREATED);

		}

	}

	@ApiOperation(value = "Atualiza os dados de um cliente")
	@RequestMapping(value = "/update", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Object> atualizar(@ApiParam(name = "cliRequest", value = "Cliente") @RequestBody Cliente cliRequest, UriComponentsBuilder ucBuilder) {

		List<String> erros = new ArrayList<String>();

		if (cliRequest != null) {

			if (cliRequest.getNome() == null || cliRequest.getNome().trim().isEmpty()) {

				erros.add("A descrição é obrigatória.");
			}

		}

		if (!erros.isEmpty()) {

			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Erros", erros);
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

		} else {

			Cliente cliDB = service.getById(cliRequest.getId());

			cliDB.setNome(cliRequest.getNome());
			cliDB.setCpf(cliRequest.getCpf());
			cliDB.setTelefone(cliRequest.getTelefone());
			cliDB.setEndereco(cliRequest.getEndereco());

			service.update(cliDB);

			HttpHeaders headers = new HttpHeaders();

			headers.setLocation(ucBuilder.path("/clientes/{id}").buildAndExpand(cliRequest.getId()).toUri());

			return new ResponseEntity<Object>(headers, HttpStatus.CREATED);

		}

	}

	@ApiOperation(value = "Realiza a exclusão de um cliente")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@CrossOrigin
	public ResponseEntity<?> delete(@ApiParam(name = "id", value = "id para exclusão") @PathVariable("id") String id) {

		service.delete(Long.valueOf(id));

		HttpHeaders headers = new HttpHeaders();

		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);

	}

}
