package com.eicon.service;

import com.eicon.service.GenericService;
import com.eicon.domain.ItemPedido;

import java.util.List;

public interface ItemPedidoService extends GenericService<ItemPedido> {
	
	List<ItemPedido> searchByFilters(String description);

}
