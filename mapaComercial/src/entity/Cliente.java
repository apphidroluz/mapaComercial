package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cliente {

	@Id
	@Column
	@SequenceGenerator(name = "cli_id_seq", sequenceName = "cli_id_seq")
	@GeneratedValue(generator = "cli_id_seq", strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String nome;

	@Column
	private String logradouro;

	@Column
	private String bairro;

	@Column
	private String cidade;

	@Column
	private Integer numero;

	@Column
	private Integer cep;

	@Column
	private String uf;

	@Column
	private Integer tipo_Edifica;

	@Column
	private Integer qtd_Unidades;

	@Column
	private Integer tipo_contrato;

	@Column
	private String longitude;

	@Column
	private String latitude;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String logradouro, String bairro, String cidade, Integer numero,
			Integer cep, String uf, Integer tipo_Edifica, Integer qtd_Unidades, Integer tipo_contrato, String longitude,
			String latitude) {
		this.id = id;
		this.nome = nome;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.numero = numero;
		this.cep = cep;
		this.uf = uf;
		this.tipo_Edifica = tipo_Edifica;
		this.qtd_Unidades = qtd_Unidades;
		this.tipo_contrato = tipo_contrato;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", numero=" + numero + ", cep=" + cep + ", uf=" + uf + ", tipo_Edifica="
				+ tipo_Edifica + ", qtd_Unidades=" + qtd_Unidades + ", tipo_contrato=" + tipo_contrato + ", longitude="
				+ longitude + ", latitude=" + latitude + "]";
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getTipo_Edifica() {
		return tipo_Edifica;
	}

	public void setTipo_Edifica(Integer tipo_Edifica) {
		this.tipo_Edifica = tipo_Edifica;
	}

	public Integer getQtd_Unidades() {
		return qtd_Unidades;
	}

	public void setQtd_Unidades(Integer qtd_Unidades) {
		this.qtd_Unidades = qtd_Unidades;
	}

	public Integer getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(Integer tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

}
