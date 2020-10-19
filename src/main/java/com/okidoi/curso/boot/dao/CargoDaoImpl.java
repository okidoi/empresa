package com.okidoi.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.okidoi.curso.boot.domain.Cargo;
import com.okidoi.curso.boot.util.PaginacaoUtil;


@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {

	public PaginacaoUtil<Cargo> buscaPaginada(int paginaSolicitada, String direcao){
		
		int tamanho = 5;
		int inicio = (paginaSolicitada -1) * tamanho; // 0*5 = 0 , 1*5 = 5, 2*5 = 10 
		List<Cargo> cargos = getEntityManager()
				.createQuery("select c from Cargo c order by c.nome " + direcao, Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;
		
		return new PaginacaoUtil<>(tamanho, paginaSolicitada, totalDePaginas, direcao, cargos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("select count(*) from Cargo", Long.class)
				.getSingleResult();
	}
}
