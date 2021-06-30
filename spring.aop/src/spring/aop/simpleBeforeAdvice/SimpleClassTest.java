package spring.aop.simpleBeforeAdvice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class SimpleClassTest {
	
	public static void main(String[] arg) {
		
		PrintMessage pm = new PrintMessage();
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterClass());
		//pf.addAdvice(new SimpleBeforeClass());
	
		pf.setTarget(pm);
		

		PrintMessage pmGec = (PrintMessage) pf.getProxy();
		PrintMessage pmGeca = (PrintMessage) pf.getProxy();
		pmGec.log();
		
		//pmGec.log();
	}
	

}
