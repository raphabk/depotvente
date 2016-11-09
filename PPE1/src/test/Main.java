package test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modele.Action;
import modele.Role;
import modele.Utilisateur;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("depotvente");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		
		Utilisateur u01 = new Utilisateur("Durand", "Benoit", "durand.benoit@hotmail.fr", new Date(), "Operator: 15648");
		Utilisateur u02 = new Utilisateur("Chapuis", "Natalie", "chapnat@free.fr", new Date(), "Operator: 15600 (professionel)");
		Utilisateur u03 = new Utilisateur("St. Patrick", "James", "jamie.ghst@gmail.com", new Date(), "Operator: 15777");
		
		em.persist(u01);
		em.persist(u02);
		em.persist(u03);
		
		Action a01 = new Action("Modifier", new Date(), "Operator: 15648", "Modifier une anonce");
		Action a02 = new Action("Supprimer", new Date(), "Operator: 15648", "Supprimer une annonce");
		Action a03 = new Action("Rechercher", new Date(), "Operator: 15648", "Rechercher une guitare");
		Action a04 = new Action("Accepter", new Date(), "Operator: 15648", "Accepter une guitare en depot-vente");
		
		em.persist(a01);
		em.persist(a02);
		em.persist(a03);
		em.persist(a04);
		
		Role r01 = new Role("Anonceur", new Date(), "Operator: 15648", "Client depuis 0.1");
		Role r02 = new Role("Magasin", new Date(), "Operator: 15648", "Client depuis 155");
		Role r03 = new Role("Administrateur", new Date(), "Operator: 15648", "Client depuis 1085");
		
		em.persist(r01);
		em.persist(r02);
		em.persist(r03);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
