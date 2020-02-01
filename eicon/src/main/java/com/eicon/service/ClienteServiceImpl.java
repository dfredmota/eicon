package com.eicon.service;

import java.util.List;

import com.eicon.domain.Cliente;
import com.eicon.repository.ClienteRepository;
import com.eicon.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("clienteAppService")
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteAppRepository;


	@Override
	public List<Cliente> all() {
		return clienteAppRepository.findAll();
	}

	@Override
	public Cliente getById(Long id) {
		return clienteAppRepository.findById(id).get();
	}

	@Override
	public Cliente create(Cliente entity) {
		return clienteAppRepository.save(entity);
	}

	@Override
	public Cliente update(Cliente entity) {
		return clienteAppRepository.saveAndFlush(entity);
	}

	@Override
	public void delete(Long id) {
		clienteAppRepository.deleteById(id);		
	}

	@Override
	public List<Cliente> searchByFilters(String descricao) {
		return clienteAppRepository.findAll();
	}


	

}
