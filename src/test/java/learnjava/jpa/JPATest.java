package learnjava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class JPATest {

	@Test
	public void testSave() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Fruit apple = new Fruit();
		apple.setName("apple");
		apple.setColour("red");
		apple.setCalories(5);
		em.persist(apple);
		et.commit();
		System.out.println("Fruit record saved successfully");
		em.close();
		emf.close();
	}
	
	@Test
	public void testQuery() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PERSISTENCE");
		EntityManager em = emf.createEntityManager();
		TypedQuery<Fruit> query = em.createQuery("from Fruit",Fruit.class);
		List<Fruit> fruits = query.getResultList();
		System.out.println("Fruit table has "+fruits.size()+" records");
	}

}
