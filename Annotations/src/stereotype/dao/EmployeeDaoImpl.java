package stereotype.dao;

import org.springframework.stereotype.Repository;

import stereotype.model.Employee;

@Repository(value = "employeeDaoImpl")
public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void saveEmployee(Employee employee) {
		System.out.println("employee dao �al���yor");
		
	}

}
