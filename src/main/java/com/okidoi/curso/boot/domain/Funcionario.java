package com.okidoi.curso.boot.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "Funcionarios")
public class Funcionario extends AbstractEntity<Long> {

	@Column(nullable = false, unique = true)
	private String nome;
	
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00") 
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00") //para MySQL
	private BigDecimal salario;

	@PastOrPresent(message = "{PastOrPresent.funcionario.dataEntrada}") //Mensagem de erro em caso de data futura.
	@DateTimeFormat(iso = ISO.DATE) //Informa se vai ter apenas a data, ou data e hora..etc
	@Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE) //Informa se vai ter apenas a data, ou data e hora..etc
	@Column(name = "data_saida", nullable = true, columnDefinition = "DATE") //padrao de nullable é true, podemos remover aqui
	private LocalDate dataSaida;	

	@Valid  //esse objeto endereço deve ser validado conforme as instruçoes que constam na classe de endereço
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public LocalDate getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	public Cargo getCargo() {
		return cargo;
	}


	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	
	
		
}
