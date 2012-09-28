package br.com.bruno;

import java.util.List;

import junit.framework.Assert;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;

import br.com.bruno.model.Produto;
import br.com.bruno.util.HibernateUtil;


public class StandardTest {

	@Before
	public void setUp(){
		Session session = HibernateUtil.getSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(new Produto("Mac","Caro"));
		session.save(new Produto("Carro","Util"));
		session.save(new Produto("Celular","Necessario"));
		session.save(new Produto("Microondas","Util"));
		session.save(new Produto("Tenis","Confortavel"));
		
		tx.commit();
		session.close();
		
	}

	@Test
	public void obterProdutosPelaDescricao(){

		Session session = HibernateUtil.getSession();

		Produto p = new Produto("carro", "");
		Example query = Example.create(p).ignoreCase().enableLike(MatchMode.ANYWHERE);
		List<Produto> produtos = session.createCriteria(Produto.class).add(query).list();
		Assert.assertNotNull(produtos);
		Assert.assertTrue(produtos.size() > 0);
		Assert.assertNotNull(produtos.get(0).getDescricao());
		
	}
	
}
