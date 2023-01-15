package com.ty_one_to_many_uni_school_student_teachers.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty_one_to_many_uni_school_student_teachers.dto.Student;
import com.ty_one_to_many_uni_school_student_teachers.dto.Teacher;

public class TeacherDAO {
	public EntityManager geEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}

	public void saveTeacher(List<Teacher> tlist) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		for(Teacher teacher:tlist) {
		entityTransaction.begin();
		entityManager.persist(teacher);
		entityTransaction.commit();
		}
	}
	
	public void updateTeacher(Teacher teacher, int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Teacher teacher1=entityManager.find(Teacher.class,id);
		entityTransaction.begin();
		teacher1.setId(id);
		teacher1.setAddress(teacher.getAddress());
		entityManager.merge(teacher);
		entityTransaction.commit();
		}
	
	public void removeTeacher(int id) {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Teacher teacher2=entityManager.find(Teacher.class, id);
		
		entityTransaction.begin();
		teacher2.setId(id);
		entityManager.remove(teacher2);
		entityTransaction.commit();
	}
	public void getAllTeacher() {
		EntityManager entityManager = geEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Query query=entityManager.createQuery("Select s from Teacher s");
		List< Teacher> list = query.getResultList();
		System.out.println(list);
	}
}
