package com.intership.internshipmanagement.results;

public class ErrorResult extends Result{

	public ErrorResult() {
		super(false);
		
	}
	
	public ErrorResult(String messsage) {
		super(false, messsage);
		
	}

}
