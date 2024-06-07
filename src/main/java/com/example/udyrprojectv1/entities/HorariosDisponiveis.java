package com.example.udyrprojectv1.entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HorariosDisponiveis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer id_funcionario;
	private Date data;
	private Time hora;
	private String disponibilidade;

	public HorariosDisponiveis(Integer id, Integer id_funcionario, Date data, Time hora, String disponibilidade) {
		super();
		this.id = id;
		this.id_funcionario = id_funcionario;
		this.data = data;
		this.hora = hora;
		this.disponibilidade = disponibilidade;
	}

	public HorariosDisponiveis() {
		super();
	}

	@Override
	public String toString() {
		return "HorariosDisponiveis []";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Integer id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

}
