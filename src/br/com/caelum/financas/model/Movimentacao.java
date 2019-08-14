package br.com.caelum.financas.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ 
	@NamedQuery(query = "select avg(m.valor) from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo group by m.data",
				name = "Movimentacao.MediasPorDiaETipo")
})
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private BigDecimal valor;

	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipo;

	@Temporal(TemporalType.DATE)
	// @ColumnDefault(value = "now()") // Note: Hibernate-dependent annotation, Database-dependent value. Tip: Use @PrePersist instead.
	private Calendar data;

	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY) // 'ToOne' mappings are EAGER by default.
	private Conta conta;

	@ManyToMany//(fetch = FetchType.EAGER) // 'ToMany' mappings are defaulted as LAZY.
	private List<Categoria> categorias;

	@Deprecated
	public Movimentacao() {
	}
	
	public Movimentacao(String valor, TipoMovimentacao tipo, Calendar data, String descricao, Integer contaId, List<Integer> categoriasIds) {
		this.valor = new BigDecimal(valor);
		this.tipo = tipo;
		this.data = data;
		this.descricao = descricao;
		conta = new Conta(contaId); // Only an existing entity can be added.
		categorias = categoriasIds.stream().map(id -> new Categoria(id)).collect(Collectors.toList()); // Only existing entities can be added.
	}

	public Movimentacao(String valor, TipoMovimentacao tipo, String descricao, Integer contaId, List<Integer> categoriasIds) {
		this.valor = new BigDecimal(valor);
		this.tipo = tipo;
		this.descricao = descricao;
		conta = new Conta(contaId); // Only an existing entity can be added.
		categorias = categoriasIds.stream().map(id -> new Categoria(id)).collect(Collectors.toList()); // Only existing entities can be added.
	}
	
	//Teste
//	public Movimentacao(String valor, TipoMovimentacao tipo, String descricao, Integer contaId) {
//		this.valor = new BigDecimal(valor);
//		this.tipo = tipo;
//		this.descricao = descricao;
//		conta = new Conta(contaId); // Only an existing entity can be added.
//	}
	
	@PrePersist
	protected void prePersist() {
		if (Objects.isNull(data))
			data = Calendar.getInstance();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
}

