package com.okidoi.curso.boot.service;

import java.util.List;

import com.okidoi.curso.boot.domain.Cargo;

public interface CargoSevice {
	
	void salvar(Cargo cargo);
	
	void editar (Cargo cargo);
	
	void excluir (Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

}
