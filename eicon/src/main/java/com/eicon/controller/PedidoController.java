package com.eicon.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.eicon.domain.FiltroConsultaPedido;
import com.eicon.domain.Pedido;
import com.eicon.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.eicon.util.ApiError;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/list", method = RequestMethod.POST,
	consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<List<Pedido>> listAll(@RequestBody FiltroConsultaPedido filtroConsultaPedido) {

	    if(filtroConsultaPedido.getDataCadastro() != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(filtroConsultaPedido.getDataCadastro());
            c.add(Calendar.DATE, 1);
            filtroConsultaPedido.setDataCadastro(c.getTime());
        }

		List<Pedido> lista = pedidoService.findPedidoByFilters(filtroConsultaPedido);

		if (lista.isEmpty()) {
			return new ResponseEntity<List<Pedido>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Pedido>>(lista, HttpStatus.OK);
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

	@RequestMapping(value = "/save", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin
	public ResponseEntity<Object> salvar(@RequestBody Pedido pedido, UriComponentsBuilder ucBuilder) {

		List<String> erros = new ArrayList<String>();

		if (pedido != null) {

			if (pedido.getValorTotal() == null) {

				erros.add("O Valor é obrigatório.");
			}

		}

		if (!erros.isEmpty()) {

			ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Erros", erros);
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

		} else {

			pedidoService.create(pedido);

			HttpHeaders headers = new HttpHeaders();

			headers.setLocation(ucBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri());

			return new ResponseEntity<Object>(headers, HttpStatus.CREATED);

		}

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

			
			pedidoService.update(pedido);

			return new ResponseEntity<Object>(pedido, HttpStatus.CREATED);

		}

	}

}
