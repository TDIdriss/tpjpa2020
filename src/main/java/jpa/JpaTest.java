package jpa;

import jpa.dao.FicheDao;
import jpa.dao.SectionDao;
import jpa.dao.TagDao;
import jpa.dao.UserDao;
import jpa.domain.Fiche;
import jpa.domain.Section;
import jpa.domain.Tags;
import jpa.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

public class JpaTest {


		/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		FicheDao ficheDao1 = new FicheDao(manager);
		UserDao userDao1 = new UserDao(manager);
		TagDao tagDao1 = new TagDao(manager);
		SectionDao sectionDao1 = new SectionDao(manager);

		List<Tags> tag1 = new ArrayList<>();


		tagDao1.createTag(new Tags("urgent"));
		tx.commit();

		tag1.add(tagDao1.chooseTag(1L));


		Fiche fi = new Fiche("fi1","rennes","vendredi 10","premiere fiche","10 minutes","fb.com",tag1);

		User util1 = new User("douhe","jean");

		Section sect1 = new Section("a faire");

        fi.setSect(sect1);

		try {
			userDao1.createUser(util1);
			sectionDao1.createSection(sect1);
			//tx.commit();

			fi.setSect(sectionDao1.chooseSection(1L));
			fi.setOwner(userDao1.chooseUser(1L));


			ficheDao1.createFiche(fi);


		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		   ficheDao1.listFiche();
		   userDao1.listUser();
		   tagDao1.listTags();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
		System.out.println(".. done");

	}





}
