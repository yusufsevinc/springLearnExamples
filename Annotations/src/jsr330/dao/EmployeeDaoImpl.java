package jsr330.dao;

import javax.inject.Named;

import jsr330.model.Employee;

@Named
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void saveEmployee(Employee employee) {
		
		System.out.println("jsr 330 dao çalýþýyor");
		
	}

}
