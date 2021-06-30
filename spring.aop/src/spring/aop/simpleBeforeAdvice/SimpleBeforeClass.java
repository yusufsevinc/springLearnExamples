package spring.aop.simpleBeforeAdvice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeClass implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("Simple method before advice >>>>  " + method.getName() );
		
	}

	


	
	

}
