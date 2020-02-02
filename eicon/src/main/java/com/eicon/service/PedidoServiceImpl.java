package com.eicon.service;

import java.util.List;

import com.eicon.domain.Cliente;
import com.eicon.domain.FiltroConsultaPedido;
import com.eicon.domain.ItemPedido;
import com.eicon.domain.Pedido;
import com.eicon.repository.ClienteRepository;
import com.eicon.repository.ItemPedidoRepository;
import com.eicon.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository repository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ClienteRepository    clienteRepository;


	@Override
	public List<Pedido> all() {
		return repository.findAll();
	}

	@Override
	public Pedido getById(Long id) {
		return repository.getOne(id);
	}

	@Override
	@Transactional
	public Pedido create(Pedido entity) {

		Cliente cli = clienteRepository.getOne(entity.getClienteId());

		entity.setCliente(cli);

		entity = repository.save(entity);

		for(ItemPedido item : entity.getItens()) {

			item.setPedido(entity);
			itemPedidoRepository.save(item);

		}

		return entity;
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

	@Override
	public List<Pedido> findPedidoByFilters(FiltroConsultaPedido filtroConsultaPedido) {
		return repository.findPedidoByFilters(filtroConsultaPedido.getClienteId(),filtroConsultaPedido.getNumeroPedido()
		, filtroConsultaPedido.getDataCadastro());
	}


}
