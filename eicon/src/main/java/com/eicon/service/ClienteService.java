package com.eicon.service;

import java.util.List;
import com.eicon.service.GenericService;
import com.eicon.domain.Cliente;

public interface ClienteService extends GenericService<Cliente> {
	
	List<Cliente> searchByFilters(String descricao);

}
