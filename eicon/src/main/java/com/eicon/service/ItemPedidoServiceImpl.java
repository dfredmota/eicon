package com.eicon.service;

import java.util.List;

import com.eicon.domain.ItemPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eicon.repository.ItemPedidoRepository;

@Service("itemCardapioService")
public class ItemPedidoServiceImpl implements ItemPedidoService {

	
	
	@Autowired
	private ItemPedidoRepository repository;
	
	@Override
	public List<ItemPedido> all() {
		return repository.findAll();
	}

	@Override
	public ItemPedido getById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public ItemPedido create(ItemPedido entity) {
		return repository.save(entity);
	}

	@Override
	public ItemPedido update(ItemPedido entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public List<ItemPedido> searchByFilters(String description) {
		return repository.findAll();
	}

}
