package com.spring.orm.dao;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//save student
	@Transactional
	public int insert(Student student) {
		//insert
		Integer i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}
   //get single data obj
	public Student getStudent(int studentId) {
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
   // get multi data obj
	public List<Student> getAllStudent(){
		List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	//delete data
	@Transactional
	public void deleteStudent(int studentId) {
	 Student student=this.hibernateTemplate.get(Student.class,studentId);
	 this.hibernateTemplate.delete(student);
	}
	
	//update data
	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}
	//
}
