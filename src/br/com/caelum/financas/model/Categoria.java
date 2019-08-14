package br.com.caelum.financas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
//	@ManyToMany(mappedBy = "categorias")
//	private List<Movimentacao> movimentacoes;
	
	@Deprecated
	public Categoria() {
	}
	
	public Categoria(Integer id) {
		this.id = id;
	}

	public Categoria(String nome) {
		this.nome = nome;
	}	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public List<Movimentacao> getMovimentacoes() {
//		return movimentacoes;
//	}

}
