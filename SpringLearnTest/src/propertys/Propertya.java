package propertys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
@PropertySource("classpath:test.properties")
public class Propertya {
	
	@Value("${name}")
	private String name;
	
	@Value("${intValue}")
	private int intValuea;
	
	
	
	public int getIntValuea() {
		return intValuea;
	}

	public void setIntValuea(int intValuea) {
		this.intValuea = intValuea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Property [name=" + name + " " + "intValua =  " + intValuea + " ]";
	}
	
	
	
	

}
