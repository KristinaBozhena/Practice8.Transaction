package com.anna;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.anna.TeachersDao;
import com.anna.Teacher;


@Repository
public class HibernateTeacherDao implements TeachersDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addTeacher(Teacher teacher) {
		currentSession().save(teacher);
	}

	public Teacher getTeacherById(int id) {
		return (Teacher) currentSession().get(Teacher.class, id);
	}

	public void saveTacher(Teacher teacher) {
		currentSession().update(teacher);
	}
}
