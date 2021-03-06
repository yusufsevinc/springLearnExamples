package jsr330.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jsr330.dao.EmployeeDao;


@Named
public class EmployeeServiceImpl implements EmployeeService {
	
	@Inject
	private EmployeeDao employeeDao;
	
	

	@Override
	public void saveEmployee(jsr330.model.Employee employee) {
		System.out.println("employee service save");
		employeeDao.saveEmployee(employee);
		
	}

}
