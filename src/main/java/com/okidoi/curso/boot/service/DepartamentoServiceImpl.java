package com.okidoi.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okidoi.curso.boot.dao.DepartamentoDao;
import com.okidoi.curso.boot.domain.Departamento;


/**
 * 
 * OBS: Aqui faremos uma abordagem diferente de Transação. 
 * Enquanto na CargoServiceImpl a transacao era na classe (RECOMENDADO), aqui será nos métodos. 
 * Somente a titulo de demonstração que é possível
 */

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;
	
	
	@Transactional
	@Override
	public void salvar(Departamento departamento) {
		dao.save(departamento);
	}

	@Override
	public void editar(Departamento departamento) {
		dao.update(departamento);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Departamento buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Departamento> buscarTodos() {
		return dao.findAll();
	}

}
