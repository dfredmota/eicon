package com.eicon.service;

import com.eicon.service.GenericService;
import com.eicon.domain.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PedidoService extends GenericService<Pedido> {
	
	List<Pedido> searchByFilters(String descricao);


}
