package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import config.HibernateUtil;
import entity.Cliente;

public class ClienteDao {
	
	Session session;
	  Transaction transaction;
	  Query query;
	  Criteria criteria;
	  
	  public List<Cliente>findAll(){
	   
		  List<Cliente> lista = null;
	  
	   try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    query = session.createQuery("from Cliente");
	    lista = query.list();
	    } catch (Exception e) {
	    e.printStackTrace();
	   } finally {
	    HibernateUtil.fechar_conexao(session);
	   }
	   return lista;

	  }
	  
	  public static void main(String[] args) {
			
			  List<Cliente> f = new ArrayList<>();
			  
			  f = new ClienteDao().findAll();
			  
			  System.out.println(f);
		}

}
