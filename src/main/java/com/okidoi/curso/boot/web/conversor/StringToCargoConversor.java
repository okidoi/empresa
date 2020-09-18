package com.okidoi.curso.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.okidoi.curso.boot.domain.Cargo;
import com.okidoi.curso.boot.service.CargoSevice;

@Component
public class StringToCargoConversor implements Converter<String, Cargo> {

	@Autowired
	private CargoSevice service;
	
	@Override
	public Cargo convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}
}
