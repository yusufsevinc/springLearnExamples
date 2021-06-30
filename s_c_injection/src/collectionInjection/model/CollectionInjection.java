package collectionInjection.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
	
	private List<String> myListi;
	private List<Employee> employeeList;
	private Set<Integer> mySet;
	private Map<String,Object> myMap;
	private Properties myProperties;
	
	
	
	
	public List<String> getMyListi() {
		return myListi;
	}
	public void setMyListi(List<String> myListi) {
		this.myListi = myListi;
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
