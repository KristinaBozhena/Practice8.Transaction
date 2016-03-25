package com.anna;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class WorkWithTeacher {
	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private TeachersDao teachersDao;

	public Teacher addTeacher(final Teacher teacher) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					teachersDao.addTeacher(teacher);
					System.out.println("Teacher has been added " + teacher);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return teacher;
	}

	public Teacher getTeacherById(int id) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					//return teachersDao.getTeacherById(id);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return teachersDao.getTeacherById(id);
	}

	public void saveTacher(final Teacher teacher) {
		transactionTemplate.execute(new TransactionCallback<Void>() {
			public Void doInTransaction(TransactionStatus txStatus) {
				try {
					teachersDao.saveTacher(teacher);
					System.out.println("Teacher has been saved " + teacher);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
	}

}
