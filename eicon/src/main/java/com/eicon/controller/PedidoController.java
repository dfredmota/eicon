package com.eicon.controller;

import java.util.ArrayList;
import java.util.List;

import com.eicon.domain.Pedido;
import com.eicon.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.eicon.util.ApiError;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/list/{observacoes}", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<List<Pedido>> listAll(@PathVariable("observacoes") String descricao) {

		List<Pedido> todos = pedidoService.searchByFilters(descricao.replaceAll("descricao=", ""));

		if (todos.isEmpty()) {
			return new ResponseEntity<List<Pedido>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Pedido>>(todos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/byid/{id}", method = RequestMethod.GET)
	@CrossOrigin
	public ResponseEntity<Pedido> getById(@PathVariable("id") String id) {

		Pedido todos = pedidoService.getById(Long.valueOf(id.replaceAll("id=", "")));

		if (todos == null) {
			return new ResponseEntity<Pedido>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Pedido>(todos, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save")
	@CrossOrigin
	public ResponseEntity<Object> atualizaPedido(@RequestParam("id") String id, @RequestParam("status") String status) {

		Pedido pedido = pedidoService.getById(Long.valueOf(id));
		
		List<String> erros = new ArrayList<String>();
		
		if(status == null || status.isEmpty())
			erros.add("Status do Pedido é Inválido");		

		if (!erros.isEmpty()) {

			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Erros", erros);
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

		} else {

			pedido.setStatus(status);
			
			pedidoService.update(pedido);

			return new ResponseEntity<Object>(pedido, HttpStatus.CREATED);

		}

	}

}
