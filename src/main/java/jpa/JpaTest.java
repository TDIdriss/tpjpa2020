package jpa;

import jpa.domain.Fiche;
import jpa.domain.Section;
import jpa.domain.Tags;
import jpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {

	private EntityManager manager ;//= EntityManagerHelper.getEntityManager();


	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

		/**
	 * @param args
	 */
	public static void main(String[] args) {
		//EntityManagerFactory factory =
			//	Persistence.createEntityManagerFactory("example");

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest jpa = new JpaTest(manager);
		EntityTransaction tx =manager.getTransaction();

		tx.begin();

		try {
				jpa.createUser();
				jpa.createFiche();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		jpa.listSection();
		jpa.listFiche();
		jpa.listUser();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
		System.out.println(".. done");

	}

	private void createUser(){
  			manager.persist(new User("traore","idriss"));
	}

	private void listUser(){
		List<User> resultList = manager.createQuery("Select u From User u", User.class).getResultList();
		System.out.println("num of user:" + resultList.size());
		for (User next : resultList) {
			System.out.println("next user: " + next);
		}
	}

	private void listSection(){
		List<Section> resultList = manager.createQuery("Select s From Section s", Section.class).getResultList();
		System.out.println("num of section:" + resultList.size());
		for (Section next : resultList) {
			System.out.println("next section: " + next);
		}
	}

	private Section chooseSection(Long id){

		return manager.createQuery("Select s From Tags s Where s.id = :id ", Section.class).setParameter("id",id).getSingleResult();
	}

	private void createFiche(){

		int numOfFiche = manager.createQuery("Select f From Fiche f", Fiche.class).getResultList().size();
		if (numOfFiche == 0) {
			User user = new User("Douhé","Jean-yves");
			Section section = new Section("a faire");
			Tags tag = new Tags("Urgent");
			manager.persist(user);
			manager.persist(section);
			manager.persist(tag);

			List<Tags> tags = new ArrayList<>();
			tags.add(tag);

			manager.persist(new Fiche("fi-1","rennes","vendredi 10","premiere fiche","10 minutes","fb.com", section, user, tags));

		}
	}

	private void listFiche(){
		List<Fiche> resultList = manager.createQuery("Select f From Fiche f", Fiche.class).getResultList();
		System.out.println("num of fiche:" + resultList.size());
		for (Fiche next : resultList) {
			System.out.println("next fiche: " + next);
		}
	}



}
