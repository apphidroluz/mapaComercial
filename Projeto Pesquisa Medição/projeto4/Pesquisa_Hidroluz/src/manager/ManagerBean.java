package manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Clientes;
import entity.Funcionario;
import entity.Pesquisa;
import persistence.ClienteDao;
import persistence.FuncionarioDao;
import persistence.PesquisaDao;

/*
 * Classe reponsável pela operações entre a tela e o servidor.
 */
@ManagedBean(name = "mb")
@SessionScoped
public class ManagerBean {

	private Clientes clientes;
	private Clientes buscado;
	private ClienteDataModel clientesPendentes;
	private List<Funcionario> funcionarios;
	private Funcionario func_selec;
	private Pesquisa pesquisa;
	private String nome;
	
	@PostConstruct
    public void init(){
		func_selec = new Funcionario();
		funcionarios = new ArrayList<Funcionario>();
		List<Pesquisa> p = new ArrayList<>();
		funcionarios.addAll(Arrays.asList(new Funcionario(null,"",p),new Funcionario(null,"",p)));
    }

    public String getClasseEscolhida(){
        return func_selec!=null && func_selec.getIdFuncionario()!=null ? func_selec.toString():"Classe não escolhida";
    }
	

	public void gravar() {
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
			//pesquisa.setClientes(buscado);
			
			pesquisa.setFuncionario(func_selec);
			new PesquisaDao().create(pesquisa);
			fc.addMessage(null, new FacesMessage("Pesquisa gravada com sucesso!"));

		} catch (Exception ex) {

		}
	}

	public List<Funcionario> getFuncionarios() {

		funcionarios = new FuncionarioDao().findAll();
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String BuscarPendentes() throws Exception {
		return "Perguntas.jsf";
	}

	public void retornarPendentes() throws Exception {

		try {
			clientesPendentes = new ClienteDataModel(new ClienteDao().findPendente());

		} catch (Exception e) {
			System.out.println("eroo");

		}
	}

	public ManagerBean() {
		clientes = new Clientes();
		pesquisa = new Pesquisa();
		funcionarios = new ArrayList<>();
		try {
			retornarPendentes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Clientes getClientes() {
		return clientes;
	}

	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}

	public Clientes getBuscado() {
		return buscado;
	}

	public void setBuscado(Clientes buscado) {
		this.buscado = buscado;
	}

	public ClienteDataModel getClientesPendentes() {
		return clientesPendentes;
	}

	public void setClientesPendentes(ClienteDataModel clientesPendentes) {
		this.clientesPendentes = clientesPendentes;
	}

	public Funcionario getFunc_selec() {
		return func_selec;
	}

	public void setFunc_selec(Funcionario func_selec) {
		this.func_selec = func_selec;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	

}
