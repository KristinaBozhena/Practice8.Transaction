package com.anna;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		 WorkWithStudents worker = (WorkWithStudents)
		 context.getBean("worker");
		 new WorkWithStudents();
		 Student testStudent = new Student("Vlad Valt", 5);
		 worker.saveStudentToDb(testStudent);

		WorkWithTeacher workWithTeacher = (WorkWithTeacher) context.getBean("teachersWorker");
		Teacher teacher = new Teacher();
		teacher.setFirstname("Anna");
		teacher.setLastname("Mitsan");
		teacher.setCellphone("+380675");
		teacher.setBirthDate(new Date());
		teacher = workWithTeacher.addTeacher(teacher);

		workWithTeacher.saveTacher(teacher);
	}

}
