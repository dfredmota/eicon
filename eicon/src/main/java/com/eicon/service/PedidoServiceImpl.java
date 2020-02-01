package com.eicon.service;

import java.util.List;

import com.eicon.domain.Pedido;
import com.eicon.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository repository;


	@Override
	public List<Pedido> all() {
		return repository.findAll();
	}

	@Override
	public Pedido getById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public Pedido create(Pedido entity) {
		return repository.save(entity);
	}

	@Override
	public Pedido update(Pedido entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<Pedido> searchByFilters(String descricao) {
		return repository.findAll();
	}

}
