package entity;


import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Pesquisa {

  @Id
  @Column
  @SequenceGenerator(name="pesq_id_seq", sequenceName="pesq_id_seq")
  @GeneratedValue(generator="pesq_id_seq",strategy = GenerationType.AUTO)
  private Integer idPesquisa;
  @Column
  private String nome;
  @Column
  private String cargo;
  @Column
  private Date data;
  @Column
  private Boolean resp1;
  @Column
  private String obs_resp1;

  @ManyToOne
  @JoinColumn(name = "id_funcionario")
  private Funcionario funcionario;

  @OneToOne
  @JoinColumn(name = "cod_cli")
  private Clientes clientes;

  public Pesquisa() {

  }

  public Pesquisa(Integer idPesquisa, String nome, String cargo, Date data, Boolean resp1, String obs_resp1,
    Funcionario funcionario, Clientes clientes) {

   this.idPesquisa = idPesquisa;
   this.nome = nome;
   this.cargo = cargo;
   this.data = data;
   this.resp1 = resp1;
   this.obs_resp1 = obs_resp1;
   this.funcionario = funcionario;
   this.clientes = clientes;
  }

  public Integer getIdPesquisa() {
   return idPesquisa;
  }

  public void setIdPesquisa(Integer idPesquisa) {
   this.idPesquisa = idPesquisa;
  }

  public String getNome() {
   return nome;
  }

  public void setNome(String nome) {
   this.nome = nome;
  }

  public String getCargo() {
   return cargo;
  }

  public void setCargo(String cargo) {
   this.cargo = cargo;
  }

  public Date getData() {
   return data;
  }

  public void setData(Date data) {
   this.data = data;
  }

  public Boolean getResp1() {
   return resp1;
  }

  public void setResp1(Boolean resp1) {
   this.resp1 = resp1;
  }

  public String getObs_resp1() {
   return obs_resp1;
  }

  public void setObs_resp1(String obs_resp1) {
   this.obs_resp1 = obs_resp1;
  }

  public Funcionario getFuncionario() {
   return funcionario;
  }

  public Clientes getClientes() {
   return clientes;
  }

  public void setClientes(Clientes clientes) {
   this.clientes = clientes;
  }

  public void setFuncionario(Funcionario funcionario) {
   this.funcionario = funcionario;
  }

}

