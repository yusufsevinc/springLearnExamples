package com.intership.internshipmanagement.results;

public class SuccessDataResult<T> extends DataResult<T>{

	public SuccessDataResult(T data,  String messsage) {
		super(data, true, messsage);
		
	}
	
	public SuccessDataResult( String messsage) {
		super(null, true, messsage);
		
	}
	
	public SuccessDataResult(T data) {
		super(data, true);
		
	}
	
	public SuccessDataResult() {
		super(null,true);
		
	}
	
	

}
