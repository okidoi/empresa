package com.okidoi.curso.boot.dao;

import java.util.List;
import com.okidoi.curso.boot.domain.Cargo;
import com.okidoi.curso.boot.util.PaginacaoUtil;


public interface CargoDao {

    void save(Cargo cargo );

    void update(Cargo cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();
    
    PaginacaoUtil<Cargo> buscaPaginada(int paginaSolicitada, String direcao);
}
