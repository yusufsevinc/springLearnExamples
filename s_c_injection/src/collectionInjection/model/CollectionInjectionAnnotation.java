package collectionInjection.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
@Service("collectionInjectionAnnotation1")
public class CollectionInjectionAnnotation {
	
	
	@Resource(name = "utilAnnotationList")
	private List<String> myList;
	
	private List<Employee> employeeList;
	
	@Resource(name = "utilAnnotationSet")
	private Set<Integer> mySet;
	
	
	
	private Map<String,Object> myMap;
	private Properties myProperties;
	
	
	public List<String> getMyList() {
		return myList;
	}
	public void setMyList(List<String> myList) {
		this.myList = myList;
	}
	public Set<Integer> getMySet() {
		return mySet;
	}
	public void setMySet(Set<Integer> mySet) {
		this.mySet = mySet;
	}
	public Map<String, Object> getMyMap() {
		return myMap;
	}
	public void setMyMap(Map<String, Object> myMap) {
		this.myMap = myMap;
	}
	public Properties getMyProperties() {
		return myProperties;
	}
	public void setMyProperties(Properties myProperties) {
		this.myProperties = myProperties;
	}
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

}
