package com.ty_one_to_many_uni_school_student_teachers.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty_one_to_many_uni_school_student_teachers.dto.School;

public class SchoolDAO {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public boolean saveSchool(School school) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
//		int id = ;
		School school2 = entityManager.find(School.class, school.getId());
		if (school2 == null) {
			entityTransaction.begin();
			school.setId(school.getId());

			entityManager.merge(school);
			entityTransaction.commit();
		} else {
			System.out.println("Id already exists");
		}
		return school2 == null;
	}

	public void updateSchool(School school, int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		School school2 = entityManager.find(School.class, id);
		if (school2!=null) {
			school2.setId(id);
			school2.setName(school.getName());
			entityTransaction.begin();
			entityManager.merge(school2);
			entityTransaction.commit();
		} else {
			System.out.println("ID not exists");
		}

	}

	public void removeSchool(School school, int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		school = entityManager.find(School.class, id);
		entityTransaction.begin();

		entityManager.remove(school);
		entityTransaction.commit();
	}

	public void getById(int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		School school = entityManager.find(School.class, id);
		school.setId(id);
		System.out.println(school);
	}

}
