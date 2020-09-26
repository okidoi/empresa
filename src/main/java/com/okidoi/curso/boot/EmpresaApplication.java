package com.okidoi.curso.boot;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;


@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		FixedLocaleResolver l = new FixedLocaleResolver();
		l.setDefaultLocale(new Locale("pt", "BR"));
		return l;
		
	}	
}
