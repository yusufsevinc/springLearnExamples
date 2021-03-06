package stereotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stereotype.dao.EmployeeDao;
import stereotype.model.Employee;

@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void saveEmployee(Employee employee) {
		
		System.out.println("employee service save");
		employeeDao.saveEmployee(employee);
	}

}
