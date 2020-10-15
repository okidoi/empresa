package com.okidoi.curso.boot.service;

import java.util.List;

import com.okidoi.curso.boot.domain.Cargo;
import com.okidoi.curso.boot.util.PaginacaoUtil;

public interface CargoSevice {
	
	void salvar(Cargo cargo);
	
	void editar (Cargo cargo);
	
	void excluir (Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();
	
	boolean cargoTemFuncionarios(Long id);
	
	PaginacaoUtil<Cargo> buscaPagina(int pagina);

}
