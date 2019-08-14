package br.com.caelum.financas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String numero;

	private String banco;

	private String agencia;

	@OneToOne(mappedBy = "conta", orphanRemoval = true) // TODO: how to do lazy fetching in this case
	private Cliente cliente;
	
	@OneToMany(mappedBy = "conta", orphanRemoval = true)
	private List<Movimentacao> movimentacoes;

	@Deprecated
	public Conta() {
	}

	public Conta(String numero, String banco, String agencia) {
		this.numero = numero;
		this.banco = banco;
		this.agencia = agencia;
	}

	public Conta(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

}
