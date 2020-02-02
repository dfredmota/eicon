package com.eicon.repository;

import com.eicon.domain.FiltroConsultaPedido;
import com.eicon.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Query("Select p from Pedido p where 1=1 and (:clienteId is null or p.cliente.id  = :clienteId) and  (:numeroPedido is null or p.id = :numeroPedido) " +
            " and (:dataCadastro is null or (substring(p.createdDate, 1,10) = substring(:dataCadastro, 1,10))) ")
    List<Pedido> findPedidoByFilters(@Param("clienteId") Long clienteId, @Param("numeroPedido") Long numeroPedido,
                                     @Param("dataCadastro")Date dataCadastro);

}
