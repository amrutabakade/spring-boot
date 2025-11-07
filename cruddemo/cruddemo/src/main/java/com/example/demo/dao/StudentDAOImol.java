package com.example.demo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImol implements StudentDAO{

	private EntityManager entityManager;
	
	
	@Autowired
	public StudentDAOImol(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Transactional
	public void save(Student theStudent)
	{
		entityManager.persist(theStudent);
	}
	
	public Student findById(Integer id)
	{
		return entityManager.find(Student.class, id);
	}
	
	public List<Student> findAll()
	{
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student order by lastname desc", Student.class);
		
		return theQuery.getResultList();
	}
	
	public List<Student> findByLastName(String lN)
	{
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastname =:theData", Student.class);
		
		theQuery.setParameter("theData", lN);
		return theQuery.getResultList();
	}


	@Override
	@Transactional
	public void update(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.merge(theStudent);
		
	}


	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Student theStudent = entityManager.find(Student.class, id);
		
		entityManager.remove(theStudent);
	}


	@Override
	@Transactional
	public int deleteAll() {
		// TODO Auto-generated method stub
		int num = entityManager.createQuery("delete from Student").executeUpdate();
		
		return num;
	}
	
	
}
