package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalhador nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<HorasContrato> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalhador nivel, Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HorasContrato> getContratos() {
		return contratos;
	}

	public void adicionarContrato(HorasContrato contrato) {
		contratos.add(contrato);
	}
	
	public void removerContrato(HorasContrato contrato) {
		contratos.remove(contrato);
	}
	
	public Double renda(Integer mes, Integer ano) {
		Double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (HorasContrato c : contratos) {
			cal.setTime(c.getData());
			int c_mes = 1 + cal.get(Calendar.MONTH);
			int c_ano = cal.get(Calendar.YEAR);
			if (c_mes == mes && c_ano == ano) {
				soma += c.valorTotal();
			}
		}
		
		return soma;
	}

	
	
	
}
