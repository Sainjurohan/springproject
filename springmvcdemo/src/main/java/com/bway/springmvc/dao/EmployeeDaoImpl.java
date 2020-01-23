package com.bway.springmvc.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bway.springmvc.model.Employee;

@Repository
@Transactional

public class EmployeeDaoImpl implements EmployeeDao {
	
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		sess.save(emp);
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		Employee emp = (Employee) sess.get(Employee.class, id);
		sess.delete(emp);
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		sess.update(emp);
		
	}

	@Override
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		Employee emp = (Employee) sess.get(Employee.class, id);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		Session sess = sessionFactory.getCurrentSession();
		Criteria crt = sess.createCriteria(Employee.class);
		return crt.list();
		
		
	}
	

}
