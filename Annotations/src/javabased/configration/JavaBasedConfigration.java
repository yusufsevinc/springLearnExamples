package javabased.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javabased.model.Employee;

@Configuration
@PropertySource(value = "classpath:employee.properties")
public class JavaBasedConfigration {
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public Employee createEmployee() {
		
		String name  = env.getProperty("empName");
		String surname = env.getProperty("empSurname");
		
		return new Employee(name,surname);
	}

}
