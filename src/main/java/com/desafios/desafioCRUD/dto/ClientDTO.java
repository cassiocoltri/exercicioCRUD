package com.desafios.desafioCRUD.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import com.desafios.desafioCRUD.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ClientDTO {
	
	private Long id;
	@Size(min = 3, max = 80, message = "Field must have at least 3 character and max of 80 character")
	@NotBlank(message = "Fild required")
	private String name;
	
	@CPF(message = "Invalid Brazilian Individual Taxpayer Registration (CPF) number")
	@NotBlank(message = "Fild required")
	private String cpf;
	
	@Positive(message = "Value must have positive")
	private Double income;
	
	@PastOrPresent(message = "Field must have past or present date")
	private LocalDate birthDate;
	
	private Integer children;
	
	public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}
	
	public ClientDTO(Client entity) {
		super();
		id = entity.getId();
		name = entity.getName();
		cpf = entity.getCpf();
		income = entity.getIncome();
		birthDate = entity.getBirthDate();
		children = entity.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}

}
