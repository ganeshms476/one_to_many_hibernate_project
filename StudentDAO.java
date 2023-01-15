package com.ty_one_to_many_uni_school_student_teachers.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_school_student_teachers.dto.Student;

public class StudentDAO {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveStudent(List<Student> slist) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for (Student student : slist) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
		}
	}

	public void updateStudent(Student student, int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student1 = entityManager.find(Student.class, id);
		entityTransaction.begin();
		student1.setId(id);
		student1.setAddress(student.getAddress());
		entityManager.merge(student1);
		entityTransaction.commit();

	}

	public void removeStudent(int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Student student2 = entityManager.find(Student.class, id);

		entityTransaction.begin();
		student2.setId(id);
		entityManager.remove(student2);
		entityTransaction.commit();
	}

	public void getAllStudent() {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("Select s from Student s");
		List<Student> list = query.getResultList();
		System.out.println(list);
	}

}
